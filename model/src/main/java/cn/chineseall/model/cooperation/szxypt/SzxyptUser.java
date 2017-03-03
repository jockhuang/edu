package cn.chineseall.model.cooperation.szxypt;

public class SzxyptUser {
    //用户帐号
    private String useraccount;
    
    //用户手机号
    private String username;
    
    //用户性别,使用男女
    private String sex;
    
    //用户身份证号(未提供)
    private String idcard;
    
    //数字校园用户唯一标识
    private String token;
    
    //用户所属单位(未提供)
    private String userdeptno;
    
    //用户角色(未提供)
    private String userrole;
    
    //MD5(“szxypt”+”三方子平台系统名字字母”+yyyy-MM-dd)
    private String keycode;

    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserdeptno() {
        return userdeptno;
    }

    public void setUserdeptno(String userdeptno) {
        this.userdeptno = userdeptno;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    public String getKeycode() {
        return keycode;
    }

    public void setKeycode(String keycode) {
        this.keycode = keycode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
}
