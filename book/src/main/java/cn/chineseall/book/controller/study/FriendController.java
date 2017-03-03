/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Lv15
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
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.model.user.UserConcern;
import cn.chineseall.model.user.vo.UserInfo;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.JsonUtil;

/**
 * 
 * @author Lv15
 */
@Controller
@RequestMapping("/user")
public class FriendController extends StudyController {

    @RequestMapping("concernme")
    public ModelAndView concernme(
            @RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        ModelMap map = mav.getModelMap();
        UserInfo loginUser = getLoginUser();

        HashMap<Object, Object> params = new HashMap<Object, Object>();
        params.put("userId", loginUser.getUserId());
        params.put("pageSize", 12);
        params.put("currentPage", currentPage);

        String json = ClientUtil.getStringClient(ClientURL.LIST_CONCERN_ME_USER, params);
        map.put("list", JsonUtil.jsonToList(json, "list", UserInfo.class));
        map.put("count", JsonUtil.getLong(json, "count"));
        map.put("currentPage", currentPage);
        mav.setViewName("/user/friend/concernme");
        return mav;
    }

    @RequestMapping("meconcern")
    public ModelAndView meconcern(
            @RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        ModelMap map = mav.getModelMap();
        UserInfo loginUser = getLoginUser();

        HashMap<Object, Object> params = new HashMap<Object, Object>();
        params.put("userId", loginUser.getUserId());
        params.put("pageSize", 12);
        params.put("currentPage", currentPage);

        String json = ClientUtil.getStringClient(ClientURL.LIST_ME_CONCERN_USER, params);
        map.put("list", JsonUtil.jsonToList(json, "list", UserInfo.class));
        map.put("count", JsonUtil.getLong(json, "count"));
        map.put("currentPage", currentPage);
        mav.setViewName("/user/friend/meconcern");
        return mav;
    }

    @RequestMapping("concernlog")
    public ModelAndView concernlog(
            @RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        ModelMap map = mav.getModelMap();
        UserInfo loginUser = getLoginUser();

        HashMap<Object, Object> params = new HashMap<Object, Object>();
        params.put("userId", loginUser.getUserId());
        params.put("pageSize", 12);
        params.put("currentPage", currentPage);

        String json = ClientUtil.getStringClient(ClientURL.LIST_USER_CONCERN_LOG, params);
        map.put("list", JsonUtil.jsonToList(json, "list", UserConcern.class));
        map.put("count", JsonUtil.getLong(json, "count"));
        map.put("currentPage", currentPage);

        List<UserInfo> listUserInfo = JsonUtil.jsonToList(json, "listUserInfo", UserInfo.class);
        HashMap<String, UserInfo> mapUserInfo = new HashMap<String, UserInfo>();
        for (UserInfo userInfo : listUserInfo) {
            mapUserInfo.put(userInfo.getUserId().toString(), userInfo);
        }
        map.put("mapUserInfo", mapUserInfo);

        mav.setViewName("/user/friend/concernlog");
        return mav;
    }
    
    @RequestMapping(value = {"addConcern" , "deleteConcern"})
	public void addConcern(@RequestParam Long concernUserId, ModelMap model,
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
		params.put("concernUserId", concernUserId);
		params.put("userId", userId);
		
		String json = ClientUtil
				.getStringClient(request.getRequestURI().indexOf("deleteConcern.action") > -1 ? ClientURL.DELETE_USER_CONCERN : ClientURL.ADD_USER_CONCERN , params);

		res.put("success", JsonUtil.getBoolean(json, "success"));
		res.put("msg", JsonUtil.getString(json, "msg"));

		response.getWriter().print(res.toString());
		response.getWriter().flush();
	}

    @RequestMapping("visitme")
    public ModelAndView visitme(
            @RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        ModelMap map = mav.getModelMap();
        UserInfo loginUser = getLoginUser();

        HashMap<Object, Object> params = new HashMap<Object, Object>();
        params.put("userId", loginUser.getUserId());
        params.put("pageSize", 12);
        params.put("currentPage", currentPage);

        String json = ClientUtil.getStringClient(ClientURL.LIST_VISIT_ME_USER, params);
        map.put("list", JsonUtil.jsonToList(json, "list", UserInfo.class));
        map.put("count", JsonUtil.getLong(json, "count"));
        map.put("currentPage", currentPage);
        mav.setViewName("/user/friend/visitme");
        return mav;
    }

}
