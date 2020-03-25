package wanzhi.gulu.community.enums;

public enum PraiseTypeEnum {
    QUESTION(1),
    COMMENT(2);

    private int type;

    PraiseTypeEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    /*public static boolean isExist(int type) {
        for(PraiseTypeEnum praiseTypeEnum:PraiseTypeEnum.values()){
            if(praiseTypeEnum.getType()==type){
                return true;
            }
        }
        return false;
    }*/

}
