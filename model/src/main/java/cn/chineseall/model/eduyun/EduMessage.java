package cn.chineseall.model.eduyun;

public class EduMessage {
    
    //应用id
    private String sid ;

    //信息内容
    private String c;
    
    //消息标题
    private String title;
    
    //固定remind
    private String type;
    
    //发送给关注我的人true(可选项)
    private String toFans;
    
    //发送给指定人(可选项和toFans只有有一个存在即可)    
    private String toUid;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToFans() {
        return toFans;
    }

    public void setToFans(String toFans) {
        this.toFans = toFans;
    }

    public String getToUid() {
        return toUid;
    }

    public void setToUid(String toUid) {
        this.toUid = toUid;
    }
    
    
}
