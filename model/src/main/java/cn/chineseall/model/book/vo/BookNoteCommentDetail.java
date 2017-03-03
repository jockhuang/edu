package cn.chineseall.model.book.vo;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class BookNoteCommentDetail extends BaseEntity {
	/**
	 * @author MR-ZHAO
	 */
	private static final long serialVersionUID = -1027918163403371997L;
	private Long id;
	private Long userId;
	private Long noteId;
	private String content;
	private Date createTime;
	private String userName;
	private String createTimeStr;
	@Override
	public String getKeyword() {
		return null;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getNoteId() {
		return noteId;
	}
	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCreateTimeStr() {
		return createTimeStr;
	}
	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}


}