package wanzhi.gulu.community.enums;

//评论类型枚举
public enum CommentTypeEnum {
    QUESTION(1),
    COMMENT(2);

    private int type;

    CommentTypeEnum(int type) {
        this.type = type;
    }

    public static boolean isExist(int type) {
        for(CommentTypeEnum commentTypeEnum:CommentTypeEnum.values()){
            if(commentTypeEnum.getType()==type){
                return true;
            }
        }
        return false;
    }

    public int getType() {
        return type;
    }
}
