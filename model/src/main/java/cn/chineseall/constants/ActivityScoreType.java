package cn.chineseall.constants;

public enum ActivityScoreType {
    
    WRITE_WORK("发表作品"), COMMENT_WORK("评论作品"), LIKE_WORK("点赞"),MANAGER_DELETE_COMMENT("删除评论");
    
    private String title = null;
    
    ActivityScoreType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static String getTitle(int index) {
        for (ActivityScoreType obj : ActivityScoreType.values()) {
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
