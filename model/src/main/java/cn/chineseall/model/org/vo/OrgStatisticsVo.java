package cn.chineseall.model.org.vo;

public class OrgStatisticsVo {
	
	private String accessCount; // 本机构人次访问量（页面刷新）
	private String userCount; // 本机构书房数量 user
	private Integer orgCount; // 下级机构数量 org
	private Integer activityCount; // 本机构活动数 ac_baseinfo
	private String bookCount; // 本机构图书数量 org_book
	public String getAccessCount() {
		return accessCount;
	}
	public void setAccessCount(String accessCount) {
		this.accessCount = accessCount;
	}
	public String getUserCount() {
		return userCount;
	}
	public void setUserCount(String userCount) {
		this.userCount = userCount;
	}
	public Integer getOrgCount() {
		return orgCount;
	}
	public void setOrgCount(Integer orgCount) {
		this.orgCount = orgCount;
	}
	public Integer getActivityCount() {
		return activityCount;
	}
	public void setActivityCount(Integer activityCount) {
		this.activityCount = activityCount;
	}
	public String getBookCount() {
		return bookCount;
	}
	public void setBookCount(String bookCount) {
		this.bookCount = bookCount;
	}

}
