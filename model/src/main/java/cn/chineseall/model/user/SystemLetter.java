package cn.chineseall.model.user;

import java.util.Date;
import java.util.List;

import cn.chineseall.model.BaseEntity;

public class SystemLetter extends BaseEntity {
	private Long id;
	private String title;
	private String content;
	private Integer sendType;
	private Integer sendUserId;
	private Date sendTime;
	private Date creationTime;
	private Integer state;

	private List<SystemLetterOrg> systemLetterOrgList;

	private List<SystemLetterOrgType> systemLetterOrgTypeList;

	private List<SystemLetterUserIdentity> systemLetterUserIdentitieList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getSendType() {
		return sendType;
	}

	public void setSendType(Integer sendType) {
		this.sendType = sendType;
	}

	public Integer getSendUserId() {
		return sendUserId;
	}

	public void setSendUserId(Integer sendUserId) {
		this.sendUserId = sendUserId;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public List<SystemLetterOrg> getSystemLetterOrgList() {
		return systemLetterOrgList;
	}

	public void setSystemLetterOrgList(List<SystemLetterOrg> systemLetterOrgList) {
		this.systemLetterOrgList = systemLetterOrgList;
	}

	public List<SystemLetterOrgType> getSystemLetterOrgTypeList() {
		return systemLetterOrgTypeList;
	}

	public void setSystemLetterOrgTypeList(
			List<SystemLetterOrgType> systemLetterOrgTypeList) {
		this.systemLetterOrgTypeList = systemLetterOrgTypeList;
	}

	public List<SystemLetterUserIdentity> getSystemLetterUserIdentitieList() {
		return systemLetterUserIdentitieList;
	}

	public void setSystemLetterUserIdentitieList(
			List<SystemLetterUserIdentity> systemLetterUserIdentitieList) {
		this.systemLetterUserIdentitieList = systemLetterUserIdentitieList;
	}

	@Override
	public String getKeyword() {
		// TODO Auto-generated method stub
		return null;
	}
}