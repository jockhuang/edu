package cn.chineseall.model.activity;

import cn.chineseall.model.BaseEntity;

public class AcOrgSetting extends BaseEntity {

    private static final long serialVersionUID = -5735351543941972997L;
    private Long id;
    private Long activityId;
    private Long orgTreeId;
    private Integer allowRecommend;
    
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
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
	public Long getOrgTreeId() {
		return orgTreeId;
	}
	public void setOrgTreeId(Long orgTreeId) {
		this.orgTreeId = orgTreeId;
	}
	public Integer getAllowRecommend() {
		return allowRecommend;
	}
	public void setAllowRecommend(Integer allowRecommend) {
		this.allowRecommend = allowRecommend;
	}
}
