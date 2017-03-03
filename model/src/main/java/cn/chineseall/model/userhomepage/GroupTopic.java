package cn.chineseall.model.userhomepage;

import cn.chineseall.model.user.UserReadGroupTopic;

public class GroupTopic {
	
	private Long topicId;

	private String name;

	private String content;
	
	private String groupName;
	
	private Long groupId;
	
	public GroupTopic(){}
	
	public GroupTopic(UserReadGroupTopic topic){
		topicId = topic.getId();
		name = topic.getTitle();
		groupId = topic.getGroupId();
	}
	
	public GroupTopic(UserReadGroupTopic topic, String groupName) {
		this(topic);
		this.groupName = groupName;
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	
}
