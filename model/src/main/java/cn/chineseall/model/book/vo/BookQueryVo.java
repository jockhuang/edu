package cn.chineseall.model.book.vo;

import java.util.Date;
/**
 * 运营后台图书查询条件
 * 
 * @author huqilong
 */
public class BookQueryVo {
    private Integer idType;
    private String idValue;
    private String bookName;
    private String bookOtherName;
    private String authorName;
    private String authorOtherName;
    private Integer from;
    private Integer zhongtuCategory;
    private Long customCategory;
    private Integer levelId;
    private Integer levelSort;
    private Integer newCategory;
    private Integer period;
    private Integer dateType;
    private Date dateFrom;
    private Date dateTo;
    private String publisher;
    private String isbn;
    private Integer rangeType;
    private Integer rangFrom;
    private Integer rangTo;
    private Integer haveTxt;
    private Integer havePdf;
    private Integer haveJpg;
    private String authorizeNo;
    private Integer isNew;
    private Integer isRecommend;
    private Integer status;
    private String selfCode;
    private String newCode;
    public Integer getIdType() {
        return idType;
    }
    public void setIdType(Integer idType) {
        this.idType = idType;
    }
    public String getIdValue() {
        return idValue;
    }
    public void setIdValue(String idValue) {
        if("".equals(idValue)){
            this.idValue = null;
        }else{
            this.idValue = idValue;
        }
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        if("".equals(bookName)){
            this.bookName = null;
        }else{
            this.bookName = bookName;
        }
    }
    public String getBookOtherName() {
        return bookOtherName;
    }
    public void setBookOtherName(String bookOtherName) {
        if("".equals(bookOtherName)){
            this.bookOtherName = null;
        }else{
            this.bookOtherName = bookOtherName;
        }
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        if("".equals(authorName)){
            this.authorName = null;
        }else{
            this.authorName = authorName;
        }
    }
    public String getAuthorOtherName() {
        return authorOtherName;
    }
    public void setAuthorOtherName(String authorOtherName) {
        if("".equals(authorOtherName)){
            this.authorOtherName = null;
        }else{
            this.authorOtherName = authorOtherName;
        }
    }
    public Integer getFrom() {
        return from;
    }
    public void setFrom(Integer from) {
        if(from!=null && from == 0){
            from = null;
        }else{
            this.from = from;
        }
    }
    public Integer getZhongtuCategory() {
        return zhongtuCategory;
    }
    public void setZhongtuCategory(Integer zhongtuCategory) {
        if(zhongtuCategory!=null && zhongtuCategory == 0){
            zhongtuCategory = null;
        }else{
            this.zhongtuCategory = zhongtuCategory;
        }
    }
    public Long getCustomCategory() {
        return customCategory;
    }
    public void setCustomCategory(Long customCategory) {
        if(customCategory!=null && customCategory == 0){
            customCategory = null;
        }else{
            this.customCategory = customCategory;
        }
    }
    public Integer getNewCategory() {
        return newCategory;
    }
    public void setNewCategory(Integer newCategory) {
        if(newCategory!=null && newCategory == 0){
            newCategory = null;
        }else{
            this.newCategory = newCategory;
        }
    }
    public Integer getPeriod() {
        return period;
    }
    public void setPeriod(Integer period) {
        if(period!=null && period == 0){
            period = null;
        }else{
            this.period = period;
        }
    }
    public Integer getDateType() {
        return dateType;
    }
    public void setDateType(Integer dateType) {
        this.dateType = dateType;
    }
    public Date getDateFrom() {
        return dateFrom;
    }
    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }
    public Date getDateTo() {
        return dateTo;
    }
    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public Integer getRangeType() {
        return rangeType;
    }
    public void setRangeType(Integer rangeType) {
        this.rangeType = rangeType;
    }
    public Integer getRangFrom() {
        return rangFrom;
    }
    public void setRangFrom(Integer rangFrom) {
        this.rangFrom = rangFrom;
    }
    public Integer getRangTo() {
        return rangTo;
    }
    public void setRangTo(Integer rangTo) {
        this.rangTo = rangTo;
    }
    public Integer getHaveTxt() {
        return this.haveTxt;
    }
    public void setHaveTxt(Integer haveTxt) {
        if(haveTxt!=null && haveTxt <= 0){
            haveTxt = null;
        }else{
            this.haveTxt = haveTxt;
        }
    }
    public Integer getHavePdf() {
        return havePdf;
    }
    public void setHavePdf(Integer havePdf) {
        if(havePdf!=null && havePdf <= 0){
            havePdf = null;
        }else{
            this.havePdf = havePdf;
        }
    }
    public Integer getHaveJpg() {
        return haveJpg;
    }
    public void setHaveJpg(Integer haveJpg) {
        if(haveJpg!=null && haveJpg <= 0){
            haveJpg = null;
        }else{
            this.haveJpg = haveJpg;
        }
    }
    public String getAuthorizeNo() {
        return authorizeNo;
    }
    public void setAuthorizeNo(String authorizeNo) {
        this.authorizeNo = authorizeNo;
    }
    public Integer getIsNew() {
        return isNew;
    }
    public void setIsNew(Integer isNew) {
        if(isNew!=null && isNew <= 0){
            isNew = null;
        }else{
            this.isNew = isNew;
        }
    }
    public Integer getIsRecommend() {
        return isRecommend;
    }
    public void setIsRecommend(Integer isRecommend) {
        if(isRecommend!=null && isRecommend <= 0){
            isRecommend = null;
        }else{
            this.isRecommend = isRecommend;
        }
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
       this.status = status;
    }
    public Integer getLevelSort() {
        return levelSort;
    }
    public void setLevelSort(Integer levelSort) {
        this.levelSort = levelSort;
    }
    public Integer getLevelId() {
        return levelId;
    }
    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }
    public String getSelfCode() {
        return selfCode;
    }
    public void setSelfCode(String selfCode) {
        this.selfCode = selfCode;
    }
    public String getNewCode() {
        return newCode;
    }
    public void setNewCode(String newCode) {
        this.newCode = newCode;
    }

}
