package cn.chineseall.model.book;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

public class BookNoteComment extends BaseEntity {
	/**
	 * @author MR-ZHAO
	 */
	private static final long serialVersionUID = -3905959343216954425L;
	private Long id;
	private Long userId;
	private Long noteId;
	private String content;
	private Date createTime;
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


}