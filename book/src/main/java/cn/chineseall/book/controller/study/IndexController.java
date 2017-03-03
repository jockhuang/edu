/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Lv15
 */
package cn.chineseall.book.controller.study;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.service.UserService;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.JsonUtil;
import cn.chineseall.utils.PageUtil;
import cn.chineseall.utils.RequestUtil;

/**
 * 
 * @author Lv15
 */
@Controller("userIndexController")
@RequestMapping("/user")
public class IndexController extends StudyController {

	@RequestMapping("i")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage) throws Exception {
	    Long userId = getLoginUserId(request);
		ModelAndView mav = new ModelAndView();
		ModelMap map = mav.getModelMap();
		map.put("userIndexPageData",service.getUserIndexPageData(userId));

		HashMap<Object, Object> params = new HashMap<Object, Object>();
		params.put("userId", userId);
        params.put("currentPage", currentPage);
        params.put("pageSize", 4);
		params.put("orgTreeId", orgTreeId);
		PageUtil pageUtil = null;
		String json = ClientUtil.getStringClient(ClientURL.GET_USER_BUY_BOOK,params);
		Map<String, Object> data = JsonUtil.jsonToObject(json, "data", HashMap.class);
		if(data.get("bookList")!=null && data.get("count")!=null){
			pageUtil = new PageUtil((List) data.get("bookList"), (Integer)data.get("count"), pageSize, currentPage);
		}
		mav.getModelMap().put("pageUtil", pageUtil);
		mav.getModelMap().put("queryCondition", RequestUtil.getQueryCondition(request));

		params.clear();
		json = ClientUtil.getStringClient(ClientURL.LIST_USER_PAGE_DYNAMIC_INFO, params);
		mav.getModelMap().put("listUserPageDynamicInfo", JsonUtil.jsonToList(json, "list", String[].class));

		mav.setViewName("/user/index");
		return mav;
	}
	
	@RequestMapping("i2")
	public ModelAndView index2(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage) throws Exception {
	    Long userId = getLoginUserId(request);
		ModelAndView mav = new ModelAndView();
		ModelMap map = mav.getModelMap();
		map.put("userIndexPageData",service.getUserIndexPageData(userId));

		HashMap<Object, Object> params = new HashMap<Object, Object>();
		params.put("userId", userId);
        params.put("currentPage", currentPage);
        params.put("pageSize", 4);
		params.put("orgTreeId", orgTreeId);
		PageUtil pageUtil = null;
		String json = ClientUtil.getStringClient(ClientURL.GET_USER_BUY_PACKAGE,params);
		Map<String, Object> data = JsonUtil.jsonToObject(json, "data", HashMap.class);
		if(data.get("packageList")!=null && data.get("count")!=null){
			pageUtil = new PageUtil((List) data.get("packageList"), (Integer)data.get("count"), pageSize, currentPage);
		}
		mav.getModelMap().put("pageUtil", pageUtil);
		mav.getModelMap().put("queryCondition", RequestUtil.getQueryCondition(request));

		params.clear();
		json = ClientUtil.getStringClient(ClientURL.LIST_USER_PAGE_DYNAMIC_INFO, params);
		mav.getModelMap().put("listUserPageDynamicInfo", JsonUtil.jsonToList(json, "list", String[].class));

		mav.setViewName("/user/index2");
		return mav;
	}

	@Resource
	private UserService service;

}
