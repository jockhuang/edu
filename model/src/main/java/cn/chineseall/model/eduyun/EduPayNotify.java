package cn.chineseall.model.eduyun;

public class EduPayNotify {
    
    private Long id;
    
    //手机支付平台给商户分配的唯一标识
    String  providerid;
    //平台返回的交易流水号
    String  payNo;
    //返回码
    String  returnCode;
    //返回码提示信息
    String message;
    //只是MD5或RSA
    String signType;
    //订单金额，以分为单位, 如1元表示为100
    Integer amount;
    //版本号,现为1.0.0
    String version;
    //订单金额，以分为单位, 如1元表示为100
    //提供商订单号
    String orderid;
    //用户完成支付的时间
    String payDate;
    //保留字段1
    String reserved1;
    //保留字段2
    String reserved2;
    //保留字段3
    String reserved3;
    //支付结果 成功:success 失败:fail
    String status;
    //提供商发起请求的日期:yyyyMMdd
    String orderDate;
    //订单交易费用
    String fee;
    //以上请求参数生成的签名串,获得hmac的方法见签名算法,参数顺序按照表格中从上到下的顺序,但不包括证书公钥和本参数
    String hmac;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPayNo() {
        return payNo == null ? "":payNo;
    }
    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }
    public String getReturnCode() {
        return returnCode==null ? "":returnCode;
    }
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }
    public String getMessage() {
        return message == null? "" : message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getSignType() {
        return signType == null ? "" : signType;
    }
    public void setSignType(String signType) {
        this.signType = signType;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public String getVersion() {
        return version == null? "":version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public String getPayDate() {
        return payDate == null ? "" : payDate;
    }
    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }
    public String getReserved1() {
        return reserved1 == null ? "" : reserved1;
    }
    public void setReserved1(String reserved1) {
        this.reserved1 = reserved1;
    }
    public String getReserved2() {
        return reserved2 == null ? "" : reserved2;
    }
    public void setReserved2(String reserved2) {
        this.reserved2 = reserved2;
    }
    public String getReserved3() {
        return reserved3==null?"":reserved3;
    }
    public void setReserved3(String reserved3) {
        this.reserved3 = reserved3;
    }
    public String getStatus() {
        return status == null ? "" : status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getOrderDate() {
        return orderDate == null? "" :orderDate;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public String getFee() {
        return fee == null ? "" :fee;
    }
    public void setFee(String fee) {
        this.fee = fee;
    }
    public String getHmac() {
        return hmac == null? "" : hmac;
    }
    public void setHmac(String hmac) {
        this.hmac = hmac;
    }
    public String getProviderid() {
        return providerid;
    }
    public void setProviderid(String providerid) {
        this.providerid = providerid;
    }
    public String getOrderid() {
        return orderid;
    }
    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }
}
