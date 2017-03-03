package cn.chineseall.constants;

public enum UserGroupScoreType {
    
    NEW_TOPIC("发表主题"), REPLAY_TOPIC("回复帖子"), TOP_TOPIC("帖子置顶"),HOT_TOPIC("帖子被推荐");
    
    private String title = null;
    
    UserGroupScoreType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static String getTitle(int index) {
        for (UserGroupScoreType obj : UserGroupScoreType.values()) {
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
