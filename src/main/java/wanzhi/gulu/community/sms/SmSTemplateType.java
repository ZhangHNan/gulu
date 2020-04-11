package wanzhi.gulu.community.sms;

public enum SmSTemplateType {
    LOGIN("SMS_187740468"),
    REGISTER("SMS_187755449");

    private String templateCode;

    SmSTemplateType(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getTemplateCode() {
        return templateCode;
    }
}
