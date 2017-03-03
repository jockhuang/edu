package cn.chineseall.model.book;

import cn.chineseall.model.BaseEntity;

public class BookIntro extends BaseEntity {
    
    private static final long serialVersionUID = 4841115868036096231L;
    private Long bookId;
    private String intro;
    private String nameother;
    private String authorother;
    private Integer isPublication;
    private Integer sort01;
    private Integer sort02;
    private String backcoverPath;
    private Integer pageCount;
    private Integer wordCount;
    private Integer jpgWidth;
    private Integer jpgHeight;
    private String catalog;
    private Integer authorizationType;
    private String creationTime;
    private String authorizationNo;
    private Integer showNameOther;
    
    @Override
    public String getKeyword() {
        return this.getClass().getName()+"."+getBookId();
    }
    public Long getBookId() {
        return bookId;
    }
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    public String getIntro() {
        return intro;
    }
    public void setIntro(String intro) {
        this.intro = intro;
    }
    public String getNameother() {
        return nameother;
    }
    public void setNameother(String nameother) {
        this.nameother = nameother;
    }
    public String getAuthorother() {
        return authorother;
    }
    public void setAuthorother(String authorother) {
        this.authorother = authorother;
    }
    public Integer getIsPublication() {
        return isPublication;
    }
    public void setIsPublication(Integer isPublication) {
        this.isPublication = isPublication;
    }
    public Integer getSort01() {
        return sort01;
    }
    public void setSort01(Integer sort01) {
        this.sort01 = sort01;
    }
    public Integer getSort02() {
        return sort02;
    }
    public void setSort02(Integer sort02) {
        this.sort02 = sort02;
    }
    public String getBackcoverPath() {
        return backcoverPath;
    }
    public void setBackcoverPath(String backcoverPath) {
        this.backcoverPath = backcoverPath;
    }
    public Integer getPageCount() {
        return pageCount;
    }
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
    public Integer getWordCount() {
        return wordCount;
    }
    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }
    public Integer getJpgWidth() {
        return jpgWidth;
    }
    public void setJpgWidth(Integer jpgWidth) {
        this.jpgWidth = jpgWidth;
    }
    public Integer getJpgHeight() {
        return jpgHeight;
    }
    public void setJpgHeight(Integer jpgHeight) {
        this.jpgHeight = jpgHeight;
    }
    public String getCatalog() {
        return catalog;
    }
    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }
    public Integer getAuthorizationType() {
        return authorizationType;
    }
    public void setAuthorizationType(Integer authorizationType) {
        this.authorizationType = authorizationType;
    }
    public String getCreationTime() {
        return creationTime;
    }
    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
    public String getAuthorizationNo() {
        return authorizationNo;
    }
    public void setAuthorizationNo(String authorizationNo) {
        this.authorizationNo = authorizationNo;
    } 
    public Integer getShowNameOther() {
        return showNameOther;
    }
    public void setShowNameOther(Integer showNameOther) {
        this.showNameOther = showNameOther;
    }
}
