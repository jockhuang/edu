package cn.chineseall.constants;

public enum FeedType {
    
    AC_WORKS("发活动作品"), BOOK_COMMENT("发表书评"),GROUP_TOPIC("发小组帖子"),RECOMMEND_BOOK("推荐图书");
    
    private String title = null;
    
    FeedType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static String getTitle(int index) {
        for (FeedType obj : FeedType.values()) {
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
