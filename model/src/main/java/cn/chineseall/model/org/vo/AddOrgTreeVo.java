package cn.chineseall.model.org.vo;

public class AddOrgTreeVo {
    
    private Long id;
    
    private String orgName;
    //域名
    private String domainName;
    // 父机构id
    private Long[] parentIds;
    //单个机构父id
    private Long parentId;
    // 地域id
    private Integer regionId;
    // 机构类型
    private Integer orgType;
    // 服务有效期
    private String startTime;
    
    private String endTime;
    // 成员上限
    private Integer maxMember;
    // 机构点数
    private Integer points;
    // 管理员帐号
    private String managerName;
    // 管理员密码
    private String password;
    // 管理员身份
    private Integer userType;
    // 联系人
    private String contactName;
    // 联系电话
    private String telephone;
    // 邮箱
    private String email;
    // 联系地址//地域信息
    private String address;
    // 邮编
    private String postCode;
    // 系统logo
    private Integer sysLogo;
    //系统模板
    private Integer templateId;
    //页脚
    private String footerContent;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Long[] getParentIds() {
        return parentIds;
    }

    public void setParentIds(Long[] parentIds) {
        this.parentIds = parentIds;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getOrgType() {
        return orgType;
    }

    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getMaxMember() {
        return maxMember;
    }

    public void setMaxMember(Integer maxMember) {
        this.maxMember = maxMember;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Integer getSysLogo() {
        return sysLogo;
    }

    public void setSysLogo(Integer sysLogo) {
        this.sysLogo = sysLogo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public String getFooterContent() {
        return footerContent;
    }

    public void setFooterContent(String footerContent) {
        this.footerContent = footerContent;
    }

}
