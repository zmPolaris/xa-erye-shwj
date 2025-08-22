package cn.xa.eyre.system.log.domain;


public class LogSynchroApiWithBLOBs extends LogSynchroApi {
    private String inputParams;

    private String outputParams;

    public String getInputParams() {
        return inputParams;
    }

    public void setInputParams(String inputParams) {
        this.inputParams = inputParams == null ? null : inputParams.trim();
    }

    public String getOutputParams() {
        return outputParams;
    }

    public void setOutputParams(String outputParams) {
        this.outputParams = outputParams == null ? null : outputParams.trim();
    }
}