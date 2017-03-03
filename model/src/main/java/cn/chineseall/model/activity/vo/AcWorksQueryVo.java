package cn.chineseall.model.activity.vo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 运营后台活动查询条件
 * 
 * @author zhouyongchao
 */
public class AcWorksQueryVo {
	private Long activityId;
	private String title;
	private String author;
	private Long orgTreeId1;    //管理员所属机构
	private Long orgTreeId2;    //要查询的机构
    private String orgTreeName;
    private Long groupId;
    private String groupName;
    private Date creationTime;
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	private Integer auditState;
    private Integer scoreState; //作品分配打分状态
    private String juryName;
    private Long juryId;
    private Integer orderby;
    private Integer lowestScore;
    private Integer highestScore;
    private Integer currentPage;
    private Integer start;
	private Integer pageSize;
    private Long totalCount;
    @SuppressWarnings("rawtypes")
    private List<HashMap> data;
    private Integer type;   //1:所有作品  2:下级推荐作品  3:本机构用户作品 4:评委打分的作品 5:推荐给上级的作品
    private Long userId;
    private Integer isSpecialist;
    
	public Integer getIsSpecialist() {
		return isSpecialist;
	}
	public void setIsSpecialist(Integer isSpecialist) {
		this.isSpecialist = isSpecialist;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
    public Long getJuryId() {
		return juryId;
	}
	public void setJuryId(Long juryId) {
		this.juryId = juryId;
	}
    @SuppressWarnings("rawtypes")
    public List<HashMap> getData() {
		return data;
	}
	@SuppressWarnings("rawtypes")
    public void setData(List<HashMap> data) {
		this.data = data;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getOrgTreeName() {
		return orgTreeName;
	}
	public void setOrgTreeName(String orgTreeName) {
		this.orgTreeName = orgTreeName;
	}
	
	public Long getOrgTreeId1() {
		return orgTreeId1;
	}
	public void setOrgTreeId1(Long orgTreeId1) {
		this.orgTreeId1 = orgTreeId1;
	}
	public Long getOrgTreeId2() {
		return orgTreeId2;
	}
	public void setOrgTreeId2(Long orgTreeId2) {
		this.orgTreeId2 = orgTreeId2;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public Integer getAuditState() {
		return auditState;
	}
	public void setAuditState(Integer auditState) {
		this.auditState = auditState;
	}
	public Integer getScoreState() {
		return scoreState;
	}
	public void setScoreState(Integer scoreState) {
		this.scoreState = scoreState;
	}
	public String getJuryName() {
		return juryName;
	}
	public void setJuryName(String juryName) {
		this.juryName = juryName;
	}
	public Integer getOrderby() {
		return orderby;
	}
	public void setOrderby(Integer orderby) {
		this.orderby = orderby;
	}
	public Integer getLowestScore() {
		return lowestScore;
	}
	public void setLowestScore(Integer lowestScore) {
		this.lowestScore = lowestScore;
	}
	public Integer getHighestScore() {
		return highestScore;
	}
	public void setHighestScore(Integer highestScore) {
		this.highestScore = highestScore;
	}

}
