package cn.xa.eyre.medrec.config;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.util.backoff.FixedBackOff;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConsumerConfigs {

    Logger logger = org.slf4j.LoggerFactory.getLogger(KafkaConsumerConfigs.class);

    @Resource
    private Environment env;

    @Bean
    public ConsumerFactory<GenericRecord, GenericRecord> consumerFactory() {
        String bootstrap = env.getProperty("spring.kafka.bootstrap-servers",  "localhost:9092");
        String groupId = env.getProperty("spring.kafka.consumer.group-id",  "xa-eyre-his-service");
        String schemaUrl = env.getProperty("spring.kafka.properties.schema-registry-url",  "localhost:8081");

        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        props.put("schema.registry.url", schemaUrl);
        // 使用特定读取器策略（重要！）
        props.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, false);
        props.put(ErrorHandlingDeserializer.KEY_DESERIALIZER_CLASS, KafkaAvroDeserializer.class);
        props.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, KafkaAvroDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<GenericRecord, GenericRecord> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<GenericRecord, GenericRecord> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setBatchListener(false);
        // 设置手动提交偏移量
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        return factory;
    }

    @Bean
    public DefaultErrorHandler errorHandler() {
        // 定义一个异常恢复器，例如跳过无法反序列化的记录
        DefaultErrorHandler handler = new DefaultErrorHandler((record, exception) -> {
            // 记录跳过偏移量等信息，或者发送到死信队列
            logger.error("Skipping record due to exception: " + exception.getMessage());
        }, new FixedBackOff(0L, 0L)); // 不重试，立即跳过
        // 可以添加更多可重试的异常类型，但SerializationException通常不可重试
        return handler;
    }

}
