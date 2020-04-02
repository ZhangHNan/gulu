package wanzhi.gulu.community.enums;

//通知类型枚举
public enum NotificationTypeEnum {
    REPLY_QUESTION(1,"回复了问题"),
    REPLY_COMMENT(2,"回复了评论"),
    WATCH_FOR(3,"关注了您"),
    BAN(4,"涉嫌违规，请整改后"),
    FOREVER_BAN(5,"多次违规，现作永久封禁处罚！"),
    APPEAL_FAIL(6,"的申诉未通过管理员审核，现对该帖作永久封禁处罚!"),
    APPEAL_SUCCESS(7,"的申诉已通过管理员审核，已解除对该帖的封禁。"),
    ;
    private int type;
    private String name;

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    NotificationTypeEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }
}
