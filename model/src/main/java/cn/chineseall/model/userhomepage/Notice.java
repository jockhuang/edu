package cn.chineseall.model.userhomepage;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 用户书房消息通知
 * @author Lv15
 *
 */
@Document(collection = "UserHomePageNotice")
public class Notice {

	@Id
	private Long userId;
	
	/**
	 * 消息通知列表<JSON字符串 {visitorId , visitorName , event}>
	 */
	private List<String> listContent;
	
	/**
	 * 消息通知数量
	 */
	private Integer count;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<String> getListContent() {
		return listContent;
	}

	public void setListContent(List<String> listContent) {
		this.listContent = listContent;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public static final int EVENT_CONCERN = 0;
	
	public static final int EVENT_VISITOR = 1;
	
}
