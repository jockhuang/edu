package cn.chineseall.model.user;

// Generated 2013-4-10 17:00:54 by Hibernate Tools 3.6.0

import java.util.Date;

import cn.chineseall.model.BaseEntity;

/**
 * UserSysLetter generated by hbm2java
 */
public class UserSysLetter extends BaseEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6361724471887499565L;
	private Long id;
    private String title;
    private String content;
    private Long sendUserId;
    private Long receiveUserId;
    private Date sendTime;
    private Date readTime;
    private Integer state;
    private Integer type;
    private Long sysLetterId;
    private Long orgTreeId;
    private Integer sendType;
    private Date creationTime;
    private Integer isRead;

    public Integer getIsRead() {
		return isRead;
	}

	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}

	public UserSysLetter() {
    }

    public UserSysLetter(String title, String content, Long sendUserId, Long receiveUserId, Date sendTime,
            Date readTime, Integer state, Integer type, Long sysLetterId, Long orgTreeId, Integer sendType,
            Date creationTime) {
        this.title = title;
        this.content = content;
        this.sendUserId = sendUserId;
        this.receiveUserId = receiveUserId;
        this.sendTime = sendTime;
        this.readTime = readTime;
        this.state = state;
        this.type = type;
        this.sysLetterId = sysLetterId;
        this.orgTreeId = orgTreeId;
        this.sendType = sendType;
        this.creationTime = creationTime;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getSendUserId() {
        return this.sendUserId;
    }

    public void setSendUserId(Long sendUserId) {
        this.sendUserId = sendUserId;
    }

    public Long getReceiveUserId() {
        return this.receiveUserId;
    }

    public void setReceiveUserId(Long receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    public Date getSendTime() {
        return this.sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getReadTime() {
        return this.readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getSysLetterId() {
        return this.sysLetterId;
    }

    public void setSysLetterId(Long sysLetterId) {
        this.sysLetterId = sysLetterId;
    }

    public Long getOrgTreeId() {
        return this.orgTreeId;
    }

    public void setOrgTreeId(Long orgTreeId) {
        this.orgTreeId = orgTreeId;
    }

    public Integer getSendType() {
        return this.sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }

    public Date getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    /**
     * @see cn.chineseall.model.BaseEntity#getKeyword()
     */
    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

}
