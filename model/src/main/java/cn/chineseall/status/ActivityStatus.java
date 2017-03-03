package cn.chineseall.status;


public enum ActivityStatus {
    //0:不存在 1:未开始2：投稿中 3：禁止投稿 3：结束 
    CREATE(""), NOTSTART("未开始"),NORMAL("正常"),REVIEW("评审中"),CLOSED("关闭");
    private String title = null;

    ActivityStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static String getTitle(int index) {
        for (ActivityStatus obj : ActivityStatus.values()) {
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
