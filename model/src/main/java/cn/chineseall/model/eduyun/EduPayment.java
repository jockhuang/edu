package cn.chineseall.model.eduyun;

public class EduPayment {

    private String appid;
    private String callbackUrl;
    private String notifyUrl;
    private String providerId;
    private String requestId;
    private String hmac;
    private Integer amount;
    private String orderDate;
    private String orderId;
    private String merAcDate;
    private String productDesc;
    private String productId;
    private String productName;
    private Integer productNum;
    private String usercode;
    
    public String getCallbackUrl() {
        return callbackUrl;
    }
    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }
    public String getNotifyUrl() {
        return notifyUrl;
    }
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
    public String getProviderId() {
        return providerId;
    }
    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
    public String getRequestId() {
        return requestId;
    }
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
    public String getHmac() {
        return hmac;
    }
    public void setHmac(String hmac) {
        this.hmac = hmac;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getMerAcDate() {
        return merAcDate;
    }
    public void setMerAcDate(String merAcDate) {
        this.merAcDate = merAcDate;
    }
    public String getProductDesc() {
        return productDesc;
    }
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Integer getProductNum() {
        return productNum;
    }
    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }
    public String getUsercode() {
        return usercode;
    }
    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }
    public String getAppid() {
        return appid;
    }
    public void setAppid(String appid) {
        this.appid = appid;
    }
    
    
}
