package cn.chineseall.constants;

public enum ScoreDetailType {
    
    ONLINE_READ("在线阅读图书"), RECOMMEND_BOOK("推荐图书"),SCORE_BOOK("给图书打分"),WRITE_COMMENT("写书评"),MANAGER_DELETE_BOOK_COMMENT("删除书评"),
    WRITE_WORK("发表作品"), COMMENT_WORK("评论作品"), LIKE_WORK("点赞"),DELETE_WORK_COMMENT("删除活动评论"),
    NEW_TOPIC("发表主题"), REPLAY_TOPIC("回复帖子"), TOP_TOPIC("帖子置顶"),HOT_TOPIC("帖子被推荐"),
    REGIST("注册"),LOGIN("登录"), UPLOAD_HEAD_IMG("上传头像"), COMPLETE_STUFF("完善个人资料");
    
    private String title = null;
    
    ScoreDetailType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static String getTitle(int index) {
        for (ScoreDetailType obj : ScoreDetailType.values()) {
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
