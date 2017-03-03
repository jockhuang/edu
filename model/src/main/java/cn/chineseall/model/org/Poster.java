package cn.chineseall.model.org;

import java.util.Date;
import java.util.List;

import cn.chineseall.model.BaseEntity;

public class Poster extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7991284393823453634L;
	private Long id;
	private String title;
	private String link;
	private String imgUrl;
	private Integer position;
	private Integer state;
	private Date sendTime;
	private Date creationTime;
	private Integer sendUserId;
	private Integer isSub;

	public Integer getIsSub() {
		return isSub;
	}

	public void setIsSub(Integer isSub) {
		this.isSub = isSub;
	}

	private List<PosterOrg> posterOrgList;

	private List<PosterOrgType> posterOrgTypeList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Integer getSendUserId() {
		return sendUserId;
	}

	public void setSendUserId(Integer sendUserId) {
		this.sendUserId = sendUserId;
	}

	public List<PosterOrg> getPosterOrgList() {
		return posterOrgList;
	}

	public void setPosterOrgList(List<PosterOrg> posterOrgList) {
		this.posterOrgList = posterOrgList;
	}

	public List<PosterOrgType> getPosterOrgTypeList() {
		return posterOrgTypeList;
	}

	public void setPosterOrgTypeList(List<PosterOrgType> posterOrgTypeList) {
		this.posterOrgTypeList = posterOrgTypeList;
	}

	@Override
	public String getKeyword() {
		return null;
	}

}