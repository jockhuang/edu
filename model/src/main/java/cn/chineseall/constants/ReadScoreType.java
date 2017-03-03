package cn.chineseall.constants;

public enum ReadScoreType {
    
    ONLINE_READ("在线阅读图书"), RECOMMEND_BOOK("推荐图书"),SCORE_BOOK("给图书打分"),WRITE_COMMENT("写书评"),MANAGER_DELETE_COMMENT("删除书评");
    
    private String title = null;
    
    ReadScoreType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static String getTitle(int index) {
        for (ReadScoreType obj : ReadScoreType.values()) {
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
