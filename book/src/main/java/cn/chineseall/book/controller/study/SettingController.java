/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Lv15
 */
package cn.chineseall.book.controller.study;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.service.UserService;
import cn.chineseall.model.user.User;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.JsonUtil;

/**
 * 
 * @author Lv15
 */
@Controller
@RequestMapping("/user")
public class SettingController extends StudyController {

	@RequestMapping("setting")
	public String setting(
			@RequestParam(required = false, defaultValue = "basic") String t,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		if (t.equals("basic") || t.equals("password") || t.equals("portrait")
				|| t.equals("privacy") || t.equals("ui")) {
			return "/user/setting/" + t;
		} else {
			return "/user/404";
		}
	}

	@RequestMapping("savebasic")
	public String saveBasic(String displayName,
			@RequestParam(required = false) Integer gender,
			@RequestParam(required = false) String birthday,
			@RequestParam(required = false) String qq,
			@RequestParam(required = false) String email,
			@RequestParam(required = false) String province,
			@RequestParam(required = false) String city,
			@RequestParam(required = false) String county, ModelMap model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Long userId = getLoginUserId(request);
		if (userId == null) {
			return "/user/login";
		}
		HashMap<Object, Object> params = new HashMap<Object, Object>();

		params.put("userId", userId);
		params.put("displayName", displayName);
		params.put("gender", gender);
		try {
			params.put("birthday",
					new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
		} catch (Exception e) {
		}

		params.put("qq", qq);
		params.put("email", email);
		params.put("province", province);
		params.put("city", city);
		params.put("county", county);

		String json = ClientUtil.getStringClient(ClientURL.SETTING_USER_BASIC,
				params);
		Boolean success = JsonUtil.getBoolean(json, "success");
		if (success != null && success) {
			request.setAttribute("loginUser", service.getUserInfo(userId));
			model.put("msg", "保存成功");
			return setting("basic", model, request, response);
		} else {
			String msg = JsonUtil.getString(json, "msg");
			model.put("emsg", msg != null ? msg : "未知原因导致保存失败");
			return setting("basic", model, request, response);
		}

	}

	/**
	 * 将头像上传到缓存中
	 * 
	 * @param request
	 * @param response
	 * @param f
	 * @throws Exception
	 */
	@RequestMapping(value = "saveportrait", method = RequestMethod.POST)
	public String saveportrait(
			@RequestParam(value = "headImg", required = false) String headImg,
			@RequestParam(value = "width", required = false) Integer width,
			@RequestParam(value = "height", required = false) Integer height,
			@RequestParam(value = "x1", required = false) Integer x1,
			@RequestParam(value = "y1", required = false) Integer y1,
			@RequestParam(value = "x2", required = false) Integer x2,
			@RequestParam(value = "y2", required = false) Integer y2,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Long userId = getLoginUserId(request);
		if (userId == null) {
			return "/user/login";
		}
		String msg = service.settingHeadImg(userId, headImg, width, height, x1,
				y1, x2, y2);
		if (msg != null) {
			request.setAttribute("loginUser", service.getUserInfo(userId));
			model.put("emsg", msg);
			return setting("portrait", model, request, response);
		} else {
			return setting("portrait", model, request, response);
		}
	}

	/**
	 * 将头像上传到缓存中
	 * 
	 * @param request
	 * @param response
	 * @param f
	 * @throws Exception
	 */
	@RequestMapping(value = "savecacheportrait", method = RequestMethod.POST)
	public String savecacheportrait(
			@RequestParam("uploadIcon") MultipartFile uploadIcon,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Long userId = getLoginUserId(request);
		if (userId == null) {
			return "/user/login";
		}
		try{
			model.put("cacheImg", service.saveCacheHeadImg(userId, uploadIcon));
		}catch(Exception e){
			model.put("emsg", e.getMessage());
		}
		return setting("portrait", model, request, response);
	}

	@RequestMapping("savepassword")
	public String savePassword(String oldPassword, String userPass,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		User user = getUser(request);
		if (user == null) {
			return "/user/login";
		}
		HashMap<Object, Object> params = new HashMap<Object, Object>();

		if (!user.getUserPass().equals(oldPassword)) {
			model.put("emsg", "原密码不符，请重新输入！");
			return setting("password", model, request, response);
		}

		params.put("userName", user.getUserName());
		params.put("oldPassword", oldPassword);
		params.put("newPassword", userPass);

		String json = ClientUtil.getStringClient(
				ClientURL.SETTING_USER_PASSWORD, params);
		Boolean success = JsonUtil.getBoolean(json, "success");
		if (success != null && success) {
			model.put("msg", "保存成功");
			return setting("password", model, request, response);
		} else {
			String msg = JsonUtil.getString(json, "msg");
			model.put("emsg", msg != null ? msg : "未知原因导致保存失败");
			return setting("password", model, request, response);
		}
	}

	@RequestMapping("saveprivacy")
	public String savePrivacy(Integer isCanVisitPage, Integer isPassReadState,
			Integer isPassActivityState, Integer isPassOtherState,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Long userId = getLoginUserId(request);
		if (userId == null) {
			return "/user/login";
		}

		HashMap<Object, Object> params = new HashMap<Object, Object>();
		params.put("userId", userId);
		params.put("isCanVisitPage", isCanVisitPage);
		params.put("isPassReadState", isPassReadState);
		params.put("isPassActivityState", isPassActivityState);
		params.put("isPassOtherState", isPassOtherState);

		String json = ClientUtil.getStringClient(
				ClientURL.SETTING_USER_PRIVACY, params);
		Boolean success = JsonUtil.getBoolean(json, "success");
		if (success != null && success) {
			request.setAttribute("userStudy", service.getUserStudy(userId));
			model.put("msg", "保存成功");
			return setting("privacy", model, request, response);
		} else {
			String msg = JsonUtil.getString(json, "msg");
			model.put("emsg", msg != null ? msg : "未知原因导致保存失败");
			return setting("privacy", model, request, response);
		}
	}

	@RequestMapping("saveui")
	public String saveUI(@RequestParam(required = false) String pageName,
			@RequestParam(required = false) String studyStyleCss,
			@RequestParam(required = false) String curtainPicFileName,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Long userId = getLoginUserId(request);
		if (userId == null) {
			return "/user/login";
		}

		HashMap<Object, Object> params = new HashMap<Object, Object>();

		params.put("userId", userId);
		params.put("pageName", pageName);
		params.put("studyStyleCss", studyStyleCss);
		params.put("curtainPicFileName", curtainPicFileName);

		String json = ClientUtil.getStringClient(ClientURL.SETTING_USER_UI,
				params);
		Boolean success = JsonUtil.getBoolean(json, "success");
		if (success != null && success) {
			request.setAttribute("userStudy", service.getUserStudy(userId));
			model.put("msg", "保存成功");
			return setting("ui", model, request, response);
		} else {
			String msg = JsonUtil.getString(json, "msg");
			model.put("emsg", msg != null ? msg : "未知原因导致保存失败");
			return setting("ui", model, request, response);
		}
	}

	@Resource
	private UserService service;

}
