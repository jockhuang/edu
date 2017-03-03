package cn.chineseall.model.activity;

import cn.chineseall.model.BaseEntity;

public class AcStatics extends BaseEntity {

    private static final long serialVersionUID = -5735351543941972997L;
    private Long activityId;
	private Integer worksCount;
    private Integer partinCount;
    private Integer bookCount;
	public Integer getBookCount() {
		return bookCount;
	}
	public void setBookCount(Integer bookCount) {
		this.bookCount = bookCount;
	}
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
	public Integer getWorksCount() {
		return worksCount;
	}
	public void setWorksCount(Integer worksCount) {
		this.worksCount = worksCount;
	}
	public Integer getPartinCount() {
		return partinCount;
	}
	public void setPartinCount(Integer partinCount) {
		this.partinCount = partinCount;
	}
	@Override
	public String getKeyword() {
		// TODO Auto-generated method stub
		return null;
	}

}
