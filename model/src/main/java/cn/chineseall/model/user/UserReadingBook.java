/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Lv15
 */
package cn.chineseall.model.user;

import java.util.Date;

import cn.chineseall.model.BaseEntity;

/**
 * 
 * @author Lv15
 */
public class UserReadingBook extends BaseEntity {

    private Long id;
    private Long bookId; // 图书id
    private Long userId; // 用户id
    private Long orgTreeId; // 用户机构编码
    private Date firstReadTime; // 第一次阅读时间
    private Date lastReadTime; // 最后一次阅读时间
    private Integer lastReadType; // 最后一次阅读模式
    private Integer lastReadPage; // 最后一次阅读页
    private Integer pdfPage = 1; // PDF阅读模式下 阅读到第几页
    private Integer jpgPage = 1; // JPG阅读模式下 阅读到第几页
    private Integer txtPage = 1; // TXT阅读模式下 阅读到第几页
    private Integer pdfReadPageCount = 0; // PDF阅读模式下 已经阅读页数
    private Integer jpgReadPageCount = 0; // JPG阅读模式下 已经阅读页数
    private Integer txtReadPageCount = 0; // TXT阅读模式下 已经阅读页数
    private String pdfRadingPages; // 存储36进制编码 需要转换2进制标识在pdf阅读模式下 有多少页已被阅读
    private String jpgRadingPages; // 存储36进制编码 需要转换2进制标识在jpg阅读模式下 有多少页已被阅读
    private String txtRadingPages; // 存储36进制编码 需要转换2进制标识在jpg阅读模式下 有多少页已被阅读

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrgTreeId() {
        return orgTreeId;
    }

    public void setOrgTreeId(Long orgTreeId) {
        this.orgTreeId = orgTreeId;
    }

    public Date getFirstReadTime() {
        return firstReadTime;
    }

    public void setFirstReadTime(Date firstReadTime) {
        this.firstReadTime = firstReadTime;
    }

    public Date getLastReadTime() {
        return lastReadTime;
    }

    public void setLastReadTime(Date lastReadTime) {
        this.lastReadTime = lastReadTime;
    }

    public Integer getLastReadType() {
        return lastReadType;
    }

    public void setLastReadType(Integer lastReadType) {
        this.lastReadType = lastReadType;
    }

    public Integer getLastReadPage() {
        return lastReadPage;
    }

    public void setLastReadPage(Integer lastReadPage) {
        this.lastReadPage = lastReadPage;
    }

    public Integer getPdfPage() {
        return pdfPage;
    }

    public void setPdfPage(Integer pdfPage) {
        this.pdfPage = pdfPage;
    }

    public Integer getJpgPage() {
        return jpgPage;
    }

    public void setJpgPage(Integer jpgPage) {
        this.jpgPage = jpgPage;
    }

    public Integer getTxtPage() {
        return txtPage;
    }

    public void setTxtPage(Integer txtPage) {
        this.txtPage = txtPage;
    }

    public Integer getPdfReadPageCount() {
        return pdfReadPageCount;
    }

    public void setPdfReadPageCount(Integer pdfReadPageCount) {
        this.pdfReadPageCount = pdfReadPageCount;
    }

    public Integer getJpgReadPageCount() {
        return jpgReadPageCount;
    }

    public void setJpgReadPageCount(Integer jpgReadPageCount) {
        this.jpgReadPageCount = jpgReadPageCount;
    }

    public Integer getTxtReadPageCount() {
        return txtReadPageCount;
    }

    public void setTxtReadPageCount(Integer txtReadPageCount) {
        this.txtReadPageCount = txtReadPageCount;
    }

    public String getPdfRadingPages() {
        return pdfRadingPages;
    }

    public void setPdfRadingPages(String pdfRadingPages) {
        this.pdfRadingPages = pdfRadingPages;
    }

    public String getJpgRadingPages() {
        return jpgRadingPages;
    }

    public void setJpgRadingPages(String jpgRadingPages) {
        this.jpgRadingPages = jpgRadingPages;
    }

    public String getTxtRadingPages() {
        return txtRadingPages;
    }

    public void setTxtRadingPages(String txtRadingPages) {
        this.txtRadingPages = txtRadingPages;
    }

    @Override
    public String getKeyword() {
        // TODO Auto-generated method stub
        return this.getClass().getName()+"_"+userId+"_"+orgTreeId;
    }

    private static final long serialVersionUID = -3228268153971533714L;

}
