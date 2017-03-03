package cn.chineseall.model.book.vo;

import java.util.Date;
import java.util.List;

import cn.chineseall.model.BaseEntity;

public class BookNoteDetail extends BaseEntity {

	/**
	 * @author MR-ZHAO
	 */
	private static final long serialVersionUID = 573877489517363212L;
	private Long id;
	private Long userId;
	private Long bookId;
	private Integer noteStart;
	private Integer noteEnd;
	private Integer privacy;
	private String section;
	private byte[] content;
	private Date createTime;
	private Integer totalCount;
	private List<BookNoteCommentDetail> bookNoteCommentList;
	private String contentStr;
	private String userName;
	private String createTimeStr;

	public Integer getTotalCount() {
		return totalCount;
	}

	public String getContentStr() {
		return contentStr;
	}

	public void setContentStr(String contentStr) {
		this.contentStr = contentStr;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public List<BookNoteCommentDetail> getBookNoteCommentList() {
		return bookNoteCommentList;
	}

	public void setBookNoteCommentList(List<BookNoteCommentDetail> bookNoteCommentList) {
		this.bookNoteCommentList = bookNoteCommentList;
	}

	public Integer getPrivacy() {
		return privacy;
	}

	public void setPrivacy(Integer privacy) {
		this.privacy = privacy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

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

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Integer getNoteStart() {
		return noteStart;
	}

	public void setNoteStart(Integer noteStart) {
		this.noteStart = noteStart;
	}

	public Integer getNoteEnd() {
		return noteEnd;
	}

	public void setNoteEnd(Integer noteEnd) {
		this.noteEnd = noteEnd;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
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