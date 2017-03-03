package cn.chineseall.model.userhomepage;

import cn.chineseall.model.user.UserReadGroup;

public class Group {
	public Group() {
	}

	public Group(UserReadGroup group) {
		groupId = group.getGroupId();
		groupName = group.getGroupName();
	}

	private Long groupId;

	private String groupName;

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
