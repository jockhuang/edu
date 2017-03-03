package cn.chineseall.constants;

public enum UserInfoScoreType {
    
    REGIST("注册"),LOGIN("登录"), UPLOAD_HEAD_IMG("上传头像"), COMPLETE_STUFF("完善个人资料");
    
    private String title = null;
    
    UserInfoScoreType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static String getTitle(int index) {
        for (UserInfoScoreType obj : UserInfoScoreType.values()) {
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
