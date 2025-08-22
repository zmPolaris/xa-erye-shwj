package cn.xa.eyre.common.core.kafka;

import com.google.common.base.MoreObjects;

import java.util.Map;

public class DBMessage {

    /**
     * 操作类型（INSERT，UPDATE，DELETE，READ (快照)，UNKNOWN）
     */
    public String operation;
    /**
     * 表名
     */
    public String table;
    /**
     * 库名
     */
    public String schema;
    /**
     * 主键数据
     */
    public Map<String, String> key;
    /**
     * 变更前数据
     */
    public Map<String, String> beforeData;
    /**
     * 变更后数据
     */
    public Map<String, String> afterData;


    public DBMessage() {
    }


    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public Map<String, String> getKey() {
        return key;
    }

    public void setKey(Map<String, String> key) {
        this.key = key;
    }

    public Map<String, String> getBeforeData() {
        return beforeData;
    }

    public void setBeforeData(Map<String, String> beforeData) {
        this.beforeData = beforeData;
    }

    public Map<String, String> getAfterData() {
        return afterData;
    }

    public void setAfterData(Map<String, String> afterData) {
        this.afterData = afterData;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("operation", operation)
                .add("table", table)
                .add("schema", schema)
                .add("key", key)
                .add("beforeData", beforeData)
                .add("afterData", afterData)
                .toString();
    }
}
