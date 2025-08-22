package cn.xa.eyre.medrec.service;

import cn.xa.eyre.common.constant.Constants;
import cn.xa.eyre.common.utils.DateUtils;
import cn.xa.eyre.common.utils.http.HttpClientUtils;
import cn.xa.eyre.medrec.config.KafkaProperties;
import cn.xa.eyre.common.core.kafka.DBMessage;
import com.alibaba.fastjson.JSON;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class KafkaConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);


    @Resource
    private KafkaProperties kafkaProperties;

    // 监听多个主题（用逗号分隔）
    @KafkaListener(
            topics = "#{kafkaProperties.topics.toArray(new String[0])}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume(ConsumerRecord<GenericRecord, GenericRecord> record, Acknowledgment ack) {
        try {
            DBMessage msg = processDebeziumRecord(record);
            if (msg == null) return;
            if ("INSERT".equalsIgnoreCase(msg.getOperation()) ||
                    "UPDATE".equalsIgnoreCase(msg.getOperation()) ||
                    "DELETE".equalsIgnoreCase(msg.getOperation())) {
                logger.info("处理消息: {}", JSON.toJSONString(msg));
                String sent = HttpClientUtils.sendHttpClientPost(Constants.CONVERT_URL + "/convert/receiveKafkaData", JSON.toJSONString(msg));
                logger.info("发送结果: {}", sent);
            }
            // 手动提交偏移量
            ack.acknowledge();
        } catch (Exception e) {
            logger.error("处理消息失败: {}", record, e);
        }
    }

    private DBMessage processDebeziumRecord(ConsumerRecord<GenericRecord, GenericRecord> record) {
        // 获取消息键（通常包含表结构和主键）
        GenericRecord keyRecord = record.key();
        // 获取消息值（包含实际数据变更）
        GenericRecord valueRecord = record.value();
        DBMessage msg = new DBMessage();

        // 解析操作类型
        String op = valueRecord.get("op") != null ?
                valueRecord.get("op").toString() : "unknown";

        // 解析源信息（数据库、表等）
        GenericRecord sourceRecord = (GenericRecord) valueRecord.get("source");
        String db = sourceRecord.get("db").toString();
        String schema = sourceRecord.get("schema").toString();
        String table = sourceRecord.get("table").toString();
        Long tsMs = (Long) sourceRecord.get("ts_ms");

        logger.info("收到变更事件:");
        String operationName = getOperationName(op);
        msg.setOperation(operationName);
        msg.setTable(table);
        msg.setSchema(schema);
        logger.info("  操作类型: {}", operationName);
        logger.info("  来源: {}.{}.{}", db, schema, table);
        logger.info("  时间戳: {}", tsMs);
        Date operateDate = new Date(tsMs);
        Date targetDate = DateUtils.parseDate("2025-08-13 16:00:00");
        if (targetDate.after(operateDate)){
            return null;
        }
        // 解析变更数据
        GenericRecord before = (GenericRecord) valueRecord.get("before");
        GenericRecord after = (GenericRecord) valueRecord.get("after");

        if (before != null) {
//            logger.info("  变更前数据:");
            Map<String, String> beforeMap = printGenericRecord(before);
            msg.setBeforeData(beforeMap);
        }

        if (after != null) {
//            logger.info("  变更后数据:");
            Map<String, String> afterMap = printGenericRecord(after);
            msg.setAfterData(afterMap);
        }

        if (keyRecord != null) {
//            logger.info("  主键信息:");
            Map<String, String> keyMap = printGenericRecord(keyRecord);
            msg.setKey(keyMap);
        }
        return msg;
    }

    private Map<String, String> printGenericRecord(GenericRecord record) {
        Map<String, String> values = new HashMap<>();
        record.getSchema().getFields().forEach(field -> {
            String name = field.name();
            Object value = record.get(name);
            Object valObj = value != null ? value : "null";
            String valStr = String.valueOf(valObj);
            values.put(underLineToCamelCase(name), valStr);
//            logger.info("    {} = {}", name, valObj);
        });
        return values;
    }

    private String getOperationName(String opCode) {
        switch (opCode) {
            case "c": return "INSERT";
            case "u": return "UPDATE";
            case "d": return "DELETE";
            case "r": return "READ";
//            default: return "UNKNOWN (" + opCode + ")";
            default: return "UNKNOWN";
        }
    }

    public String underLineToCamelCase(String underLineName) {
        if (underLineName == null || "".equals(underLineName)) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        boolean nextUpperCase = false;
        for (int i = 0; i < underLineName.length(); i++) {
            char ch = underLineName.charAt(i);
            if (ch == '_') {
                nextUpperCase = true;
            } else {
                if (nextUpperCase) {
                    result.append(Character.toUpperCase(ch));
                    nextUpperCase = false;
                } else {
                    result.append(Character.toLowerCase(ch));
                }
            }
        }
        return result.toString();
    }



}
