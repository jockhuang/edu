package cn.chineseall.model;

public class ErrorCode extends BaseEntity {
    
    private static final long serialVersionUID = 8981346747129200078L;
    
    private Integer id;
    private String code;
    private String message;
    private String returnUrl;

    @Override
    public String getKeyword() {
        return this.getClass().getName()+this.getCode().toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }
}
