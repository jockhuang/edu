/**
 * 
 */
package cn.chineseall.book.controller.study;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.model.activity.vo.AcWorks;
import cn.chineseall.model.user.vo.UserInfo;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.JsonUtil;

/**
 * @author Lv15
 * 
 */
@RequestMapping("/user")
@Controller("workController")
public class WorkController extends StudyController {

	@RequestMapping("work")
	public String mework(
			@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserInfo loginUser = getLoginUser();

		HashMap<Object, Object> params = new HashMap<Object, Object>();
		params.put("userId", loginUser.getUserId());
		params.put("pageSize", 10);
		params.put("currentPage", currentPage);

		String json = ClientUtil.getStringClient(ClientURL.LIST_USER_WORKS,
				params);
		model.put("list", JsonUtil.jsonToList(json, "list", AcWorks.class));
		model.put("count", JsonUtil.getLong(json, "count"));
		model.put("currentPage", currentPage);

		return "/user/work/work";
	}

	@RequestMapping("fwork")
	public String fwork(
			@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		UserInfo loginUser = getLoginUser();

		HashMap<Object, Object> params = new HashMap<Object, Object>();
		params.put("userId", loginUser.getUserId());
		params.put("pageSize", 10);
		params.put("currentPage", currentPage);

		String json = ClientUtil.getStringClient(ClientURL.LIST_USER_CONCERN_WORKS,
				params);
		model.put("list", JsonUtil.jsonToList(json, "list", AcWorks.class));
		model.put("count", JsonUtil.getLong(json, "count"));
		model.put("currentPage", currentPage);

		List<UserInfo> listUserInfo = JsonUtil.jsonToList(json, "listUserInfo",
				UserInfo.class);
		HashMap<String, UserInfo> mapUserInfo = new HashMap<String, UserInfo>();
		for (UserInfo userInfo : listUserInfo) {
			mapUserInfo.put(userInfo.getUserId().toString(), userInfo);
		}
		model.put("mapUserInfo", mapUserInfo);

		return "/user/work/fwork";
	}

}
