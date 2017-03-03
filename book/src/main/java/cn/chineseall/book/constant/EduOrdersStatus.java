package cn.chineseall.book.constant;

public enum EduOrdersStatus {
    //0:不存在 1:已支付
    NEW("未支付"), PAY("已支付");
    
    private String title = null;

    EduOrdersStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static String getTitle(int index) {
        for (EduOrdersStatus obj : EduOrdersStatus.values()) {
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
