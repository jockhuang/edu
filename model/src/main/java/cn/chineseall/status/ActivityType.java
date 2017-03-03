package cn.chineseall.status;


public enum ActivityType {
    //活动的类型（1-读书活动、2-读书征文、3-摄影比赛、4-绘画比赛）
    NONE(""), READING("读书"),WRITING("征文"),PHOTO("摄影"),DRAWING("绘画");
    private String title = null;

    ActivityType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static String getTitle(int index) {
        for (ActivityType obj : ActivityType.values()) {
            if (obj.getIndex() == index) {
                return obj.title;
            }
        }
        return null;
    }

    public int getIndex() {
        return this.ordinal();
    }
}
