package cn.chineseall.model.admin;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cn.chineseall.model.BaseEntity;

public class SecurityUser extends BaseEntity implements UserDetails {

    private static final long serialVersionUID = 8545274529248793742L;

    private Integer id;

    private Integer nonExpire;

    private Integer nonLock;

    private Integer credentialNoExpire;

    private String realName;

    private String loginName;

    private String password;

    private Integer status;

    private Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();

    public SecurityUser() {
    }

    public String getLoginName() {
        return this.loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getNonExpire() {
        return nonExpire;
    }

    public void setNonExpire(Integer nonExpire) {
        this.nonExpire = nonExpire;
    }

    public Integer getNonLock() {
        return nonLock;
    }

    public void setNonLock(Integer nonLock) {
        this.nonLock = nonLock;
    }

    public Integer getCredentialNoExpire() {
        return credentialNoExpire;
    }

    public void setCredentialNoExpire(Integer credentialNoExpire) {
        this.credentialNoExpire = credentialNoExpire;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Collection<GrantedAuthority> getAuths() {
        return auths;
    }

    public void setAuths(Collection<GrantedAuthority> auths) {
        this.auths = auths;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuths();
    }

    @Override
    public String getUsername() {
        return getLoginName();
    }

    @Override
    public boolean isAccountNonExpired() {
        if (getNonExpire() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isAccountNonLocked() {
        if (getNonLock() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isCredentialsNonExpired() {
        if (credentialNoExpire == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isEnabled() {
        return getStatus() == 0 ? true : false;
    }

    @Override
    public String getKeyword() {
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
