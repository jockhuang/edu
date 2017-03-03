/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Jock
 */
package cn.chineseall.model;

/**
 * 
 * @author Jock
 */
public class OAuthClient extends BaseEntity {
    /**  */
    private static final long serialVersionUID = -8263894718342356838L;

    private Integer id;
    private String appname;
    private String secret;
    private String description;
    private String callback;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    /**
     * @see cn.chineseall.model.BaseEntity#getKeyword()
     */
    @Override
    public String getKeyword() {
        return "OAuthClient.APPNAME.KEY." + appname;
    }
}
