package cn.chineseall.model.org;

import cn.chineseall.model.BaseEntity;

// Generated 2013-4-10 17:00:54 by Hibernate Tools 3.6.0

/**
 * OrgTree generated by hbm2java
 */
public class OrgTree extends BaseEntity {

    private static final long serialVersionUID = -4442780659419169628L;

    private Long id;
    private Long orgId;
    private Long tableIndex;
    private String code;
    private Integer nodeId;
    private Long parentId;
    private String viewName;
    private Integer styleTemplateId;
    private String domainName;
    private String parentName;
    private Integer state;
    private String orgCode;

    public OrgTree() {
    }

    public OrgTree(Long orgId, Integer state) {
        this.orgId = orgId;
        this.state = state;
    }

    public OrgTree(Long orgId, String code, Integer nodeId, String viewName, Integer styleTemplateId,
            String domainName, int state) {
        this.orgId = orgId;
        this.code = code;
        this.nodeId = nodeId;
        this.viewName = viewName;
        this.styleTemplateId = styleTemplateId;
        this.domainName = domainName;
        this.state = state;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrgId() {
        return this.orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getNodeId() {
        return this.nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public String getViewName() {
        return this.viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public String getDomainName() {
        return this.domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * @see cn.chineseall.model.BaseEntity#getKeyword()
     */
    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Integer getStyleTemplateId() {
        return styleTemplateId;
    }

    public void setStyleTemplateId(Integer styleTemplateId) {
        this.styleTemplateId = styleTemplateId;
    }

    public Long getTableIndex() {
        return tableIndex;
    }

    public void setTableIndex(Long tableIndex) {
        this.tableIndex = tableIndex;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }
}
