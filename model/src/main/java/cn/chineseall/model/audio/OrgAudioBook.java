package cn.chineseall.model.audio;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class OrgAudioBook extends BaseEntity {
	private Long id;
	private Long orgTreeId;
	private String bookId;
	private Date creationTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrgTreeId() {
		return orgTreeId;
	}

	public void setOrgTreeId(Long orgTreeId) {
		this.orgTreeId = orgTreeId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	@Override
	public String getKeyword() {
		return null;
	}
}