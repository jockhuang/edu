/**
 * 
 */
package cn.chineseall.book.controller.study;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.model.user.UserLetter;
import cn.chineseall.model.user.UserLetterGroup;
import cn.chineseall.model.user.UserSysLetter;
import cn.chineseall.model.user.vo.UserInfo;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.JsonUtil;

/**
 * @author Lv15
 * 
 */
@Controller("letterController")
@RequestMapping("/user")
public class LetterController extends StudyController {

	@RequestMapping("dialogue")
	public String dialogue(
			@RequestParam(required = false, defaultValue = "1") Integer currentPage,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserInfo loginUser = getLoginUser();

		HashMap<Object, Object> params = new HashMap<Object, Object>();
		params.put("userId", loginUser.getUserId());
		params.put("currentPage", currentPage);
		params.put("pageSize", 10);
		String json = ClientUtil.getStringClient(ClientURL.LIST_LETTER_GROUP,
				params);
		model.put("list",
				JsonUtil.jsonToList(json, "list", UserLetterGroup.class));
		model.put("count", JsonUtil.getLong(json, "count"));
		model.put("currentPage", currentPage);

		List<UserInfo> listUserInfo = JsonUtil.jsonToList(json, "listUserInfo",
				UserInfo.class);
		HashMap<String, UserInfo> mapUserInfo = new HashMap<String, UserInfo>();
		for (UserInfo userInfo : listUserInfo) {
			mapUserInfo.put(userInfo.getUserId().toString(), userInfo);
		}
		model.put("mapUserInfo", mapUserInfo);

		return "/user/letter/dialogue";
	}

	@RequestMapping("letter")
	public String letter(
			Long groupId,
			@RequestParam(required = false, defaultValue = "1") Integer currentPage,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		UserInfo loginUser = getLoginUser();

		HashMap<Object, Object> params = new HashMap<Object, Object>();
		params.put("letterGroupId", groupId);
		params.put("userId", loginUser.getUserId());
		params.put("currentPage", currentPage);
		params.put("pageSize", 10);

		String json = ClientUtil.getStringClient(ClientURL.LIST_GROUP_LETTER,
				params);
		model.put("list", JsonUtil.jsonToList(json, "list", UserLetter.class));
		model.put("count", JsonUtil.getLong(json, "count"));
		model.put("currentPage", currentPage);
		model.put("groupId", groupId);

		List<UserInfo> listUserInfo = JsonUtil.jsonToList(json, "listUserInfo",
				UserInfo.class);
		for (UserInfo userInfo : listUserInfo) {
			if (!userInfo.getUserId().equals(loginUser.getUserId())) {
				model.put("groupUserInfo", userInfo);
				break;
			}
		}

		return "/user/letter/letter";
	}

	@RequestMapping("sysletter")
	public String sysletter(
			@RequestParam(required = false, defaultValue = "1") Integer currentPage,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserInfo loginUser = getLoginUser();

		HashMap<Object, Object> params = new HashMap<Object, Object>();
		params.put("currentPage", currentPage);
		params.put("pageSize", 10);
		params.put("userId", loginUser.getUserId());

		String json = ClientUtil.getStringClient(ClientURL.LIST_SYS_LETTER,
				params);
		model.put("list",
				JsonUtil.jsonToList(json, "list", UserSysLetter.class));
		model.put("count", JsonUtil.getLong(json, "count"));

		return "/user/letter/sysletter";
	}

	@RequestMapping("sendLetter")
	public void sendLetter(@RequestParam(required = false) String title,
			@RequestParam String content, @RequestParam Long receiveUserId,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JSONObject res = new JSONObject();
		Long userId = getLoginUserId(request);
		if (userId == null) {
			res.put("msg", "登录后进行操作");
			res.put("success", false);
			return;
		}

		HashMap<Object, Object> params = new HashMap<Object, Object>();
		params.put("title", title);
		params.put("content", content);
		params.put("sendUserId", userId);
		params.put("receiveUserId", receiveUserId);

		String json = ClientUtil.getStringClient(ClientURL.SEND_LETTER, params);

		res.put("success", JsonUtil.getBoolean(json, "success"));
		res.put("msg", JsonUtil.getString(json, "msg"));

		response.getWriter().print(res.toString());
		response.getWriter().flush();

	}

	@RequestMapping("replyLetter")
	public void replyLetter(@RequestParam Long letterId,
			@RequestParam(required = false) String title,
			@RequestParam String content, ModelMap model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JSONObject res = new JSONObject();
		Long userId = getLoginUserId(request);
		if (userId == null) {
			res.put("msg", "登录后进行操作");
			res.put("success", false);
			return;
		}

		HashMap<Object, Object> params = new HashMap<Object, Object>();
		params.put("title", title);
		params.put("content", content);
		params.put("sendUserId", userId);
		params.put("letterId", letterId);

		String json = ClientUtil
				.getStringClient(ClientURL.REPLY_LETTER, params);

		res.put("success", JsonUtil.getBoolean(json, "success"));
		res.put("msg", JsonUtil.getString(json, "msg"));

		response.getWriter().print(res.toString());
		response.getWriter().flush();
	}

	@RequestMapping("deleteLetter")
	public void deleteLetter(@RequestParam Long letterId, ModelMap model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JSONObject res = new JSONObject();
		Long userId = getLoginUserId(request);
		if (userId == null) {
			res.put("msg", "登录后进行操作");
			res.put("success", false);
			return;
		}

		HashMap<Object, Object> params = new HashMap<Object, Object>();
		params.put("letterId", letterId);
		params.put("userId", userId);

		String json = ClientUtil
				.getStringClient(ClientURL.DELETE_LETTER, params);

		res.put("success", JsonUtil.getBoolean(json, "success"));
		res.put("msg", JsonUtil.getString(json, "msg"));

		response.getWriter().print(res.toString());
		response.getWriter().flush();
	}

}
