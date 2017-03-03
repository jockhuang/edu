package cn.chineseall.model.userhomepage;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cn.chineseall.model.BaseEntity;
import cn.chineseall.model.study.UserTitle;

@Document(collection = "UserHomePageData")
public class PageData extends BaseEntity {

	public PageData() {
	}

	public PageData(Long userId) {
		this.userId = userId;
	}
	
	@Id
	private Long userId;

	/**
	 * Map<属性名 , 最后修改时间> 修改时间 当属性名获取不到最后修改时间，判定该属性需要更新
	 */
	private Map<String, Long> attributeLastUpdateTime; // 最后修改时间

	@Version(module = Module.BASIC)
	private String displayName; // 用户昵称

	@Version(module = { Module.BASIC, Module.SCORE })
	private Integer score; // 积分
	
	@Version(module = Module.BASIC)
	private Boolean vip;	//用户是否是vip身份
	
	@Version(module = Module.STYLE)
	private String pageName; // 页名

	@Version(module = Module.STYLE)
	private String banner; // banner图片地址

	@Version(module = Module.STYLE)
	private String style; // 书房样式
	
	@Version(module = Module.LETTER)
	private Integer notReadLetterCount;	//未阅读书信数

	@Version(module = Module.VISITOR)
	private List<User> visitor; // 访问者列表
	
	@Version(module = Module.VISITOR)
	private Long visitorCount;	//访问者数量

	@Version(module = Module.FRIEND, expireTime = 1000L * 60L * 60L * 24L
			* 7L)
	private List<User> friendScoreTop; // 书友积分排行榜列表

//	@Version(module = Module.BOOK)
//	private List<CollectionGroup> collectionGroup; // 收藏图书列表
	
	@Version(module = Module.BOOK)
	private List<Book> collectionBook; // 收藏图书列表

	@Version(module = Module.BOOK)
	private List<Book> readingBook; // 推荐图书
	
	@Version(module = Module.BOOK)
	private List<Book> recommendBook; // 推荐图书
	
	@Version(module = Module.BOOK)
	private Long readBookCount; // 阅读图书数量

	@Version(module = Module.BOOK)
	private Long collectionBookCount; // 收藏图书数量

	@Version(module = Module.READ_GROUP, expireTime = 1000L * 60L * 60L * 12L)
	private List<GroupTopic> groupTopic; // 小组话题

	@Version(module = Module.READ_GROUP)
	private Long groupTopicCount; // 小组作品数量

	@Version(module = Module.READ_GROUP)
	private List<Group> joinGroup; // 关联小组

	@Version(module = Module.READ_GROUP)
	private Long groupCount; // 关联小组数量

	@Version(module = Module.FRIEND)
	private Long friendCount; // 书友数量

	@Version(module = Module.ACTIVITY)
	private Long workCount; // 作品数量
	
	private UserTitle userTitle;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Map<String, Long> getAttributeLastUpdateTime() {
		return attributeLastUpdateTime;
	}

	public void setAttributeLastUpdateTime(Map<String, Long> attributeLastUpdateTime) {
		this.attributeLastUpdateTime = attributeLastUpdateTime;
	}

	public Integer getNotReadLetterCount() {
		return notReadLetterCount;
	}

	public void setNotReadLetterCount(Integer notReadLetterCount) {
		this.notReadLetterCount = notReadLetterCount;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public Boolean getVip() {
		return vip;
	}

	public void setVip(Boolean vip) {
		this.vip = vip;
	}

	public List<User> getVisitor() {
		return visitor;
	}

	public void setVisitor(List<User> visitor) {
		this.visitor = visitor;
	}

	public List<User> getFriendScoreTop() {
		return friendScoreTop;
	}

	public void setFriendScoreTop(List<User> friendScoreTop) {
		this.friendScoreTop = friendScoreTop;
	}

//	public List<CollectionGroup> getCollectionGroup() {
//		return collectionGroup;
//	}
//
//	public void setCollectionGroup(List<CollectionGroup> collectionGroup) {
//		this.collectionGroup = collectionGroup;
//	}
	
	public List<Book> getReadingBook() {
		return readingBook;
	}

	public List<Book> getCollectionBook() {
		return collectionBook;
	}

	public void setCollectionBook(List<Book> collectionBook) {
		this.collectionBook = collectionBook;
	}

	public void setReadingBook(List<Book> readingBook) {
		this.readingBook = readingBook;
	}

	public List<Book> getRecommendBook() {
		return recommendBook;
	}

	public void setRecommendBook(List<Book> recommendBook) {
		this.recommendBook = recommendBook;
	}

	public List<GroupTopic> getGroupTopic() {
		return groupTopic;
	}

	public void setGroupTopic(List<GroupTopic> groupTopic) {
		this.groupTopic = groupTopic;
	}

	public Long getGroupTopicCount() {
		return groupTopicCount;
	}

	public void setGroupTopicCount(Long groupTopicCount) {
		this.groupTopicCount = groupTopicCount;
	}

	public List<Group> getJoinGroup() {
		return joinGroup;
	}

	public void setJoinGroup(List<Group> joinGroup) {
		this.joinGroup = joinGroup;
	}

	public Long getGroupCount() {
		return groupCount;
	}

	public void setGroupCount(Long groupCount) {
		this.groupCount = groupCount;
	}

	public Long getReadBookCount() {
		return readBookCount;
	}

	public void setReadBookCount(Long readBookCount) {
		this.readBookCount = readBookCount;
	}

	public Long getCollectionBookCount() {
		return collectionBookCount;
	}

	public void setCollectionBookCount(Long collectionBookCount) {
		this.collectionBookCount = collectionBookCount;
	}

	public Long getFriendCount() {
		return friendCount;
	}

	public void setFriendCount(Long friendCount) {
		this.friendCount = friendCount;
	}

	public Long getWorkCount() {
		return workCount;
	}

	public void setWorkCount(Long workCount) {
		this.workCount = workCount;
	}
	
	public Long getVisitorCount() {
		return visitorCount;
	}

	public void setVisitorCount(Long visitorCount) {
		this.visitorCount = visitorCount;
	}

	public UserTitle getUserTitle() {
		return userTitle;
	}

	public void setUserTitle(UserTitle userTitle) {
		this.userTitle = userTitle;
	}

	/**
	 * 界面模块
	 */
	public enum Module {
		/**
		 * 阅读小组相关
		 */
		READ_GROUP,
		/**
		 * 书友相关
		 */
		FRIEND,
		/**
		 * 来访用户
		 */
		VISITOR,
		/**
		 * 基本信息(用户书房名)
		 */
		BASIC,
		/**
		 * 书信
		 */
		LETTER,
		/**
		 * 样式
		 */
		STYLE,
		/**
		 * 积分
		 */
		SCORE,
		/**
		 * 图书相关
		 */
		BOOK,
		/**
		 * 活动相关
		 */
		ACTIVITY;

	}

	@Retention(value = RetentionPolicy.RUNTIME)
	public @interface Version {

		Module[] module();

		long expireTime() default 0L;

	}

	@Override
	public String getKeyword() {
		// TODO Auto-generated method stub
		return null;
	}

}
