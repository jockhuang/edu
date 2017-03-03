package cn.chineseall.model.audio;

import cn.chineseall.model.BaseEntity;

public class AudioReadLog extends BaseEntity {

    private Long id;
    private String bookId;
    private String chapterNo;
    private Long userId;
    private String orgCode;
    private String fileAddress;
    private String creationTime;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getChapterNo() {
        return chapterNo;
    }

    public void setChapterNo(String chapterNo) {
        this.chapterNo = chapterNo;
    }

    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return null;
    }

    private static final long serialVersionUID = 5318270791544152779L;

}
