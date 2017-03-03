/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Lv15
 */
package cn.chineseall.book.controller.study;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.service.BookService;
import cn.chineseall.model.book.Book;
import cn.chineseall.model.user.vo.UserInfo;
import cn.chineseall.model.user.vo.UserReadingDetail;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.JsonUtil;
import cn.chineseall.utils.PageUtil;
import cn.chineseall.utils.RequestUtil;

/**
 * 
 * @author Lv15
 */
@Controller
@RequestMapping("/user")
public class CollectionController extends StudyController {

	@RequestMapping("collection")
	public ModelAndView collection(
			@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		ModelMap map = mav.getModelMap();
		UserInfo loginUser = getLoginUser();

		HashMap<Object, Object> params = new HashMap<Object, Object>();
		params.put("userId", loginUser.getUserId());
		params.put("pageSize", 12);
		params.put("currentPage", currentPage);
		String json = ClientUtil.getStringClient(
				ClientURL.LIST_USER_COLLECTION_BOOK, params);
		map.put("list", JsonUtil.jsonToList(json, "list", Book.class));
		map.put("count", JsonUtil.getLong(json, "count"));
		map.put("currentPage", currentPage);
		mav.setViewName("/user/collection/collection");
		return mav;
	}

	@RequestMapping("reading")
	public ModelAndView reading(
			@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		ModelMap map = mav.getModelMap();
		UserInfo loginUser = getLoginUser();

		HashMap<Object, Object> params = new HashMap<Object, Object>();

		params.put("orgTreeId", 1L);
		params.put("userId", loginUser.getUserId());
		params.put("pageSize", 10);
		params.put("currentPage", currentPage);
		String json = ClientUtil.getStringClient(
				ClientURL.LIST_USER_READING_DETAIL, params);

		List<UserReadingDetail> list = JsonUtil.jsonToList(json, "list",
				UserReadingDetail.class);

		map.put("list", list);
		map.put("count", JsonUtil.getLong(json, "count"));

		Set<Long> bookIds = bookService.getBookIds(list);

		map.put("intro", bookService.getIntros(bookIds));
		map.put("userScore",
				bookService.getUserToBookScore(loginUser.getUserId(), bookIds));
		map.put("currentPage", currentPage);

		mav.setViewName("/user/collection/reading");
		return mav;
	}

	@RequestMapping("recommended")
	public ModelAndView recommended(
			@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		HashMap<Object, Object> params = new HashMap<Object, Object>();
		params.put("userId", getLoginUserId(request));
		pageSize = 6;
        params.put("currentPage", currentPage);
        params.put("pageSize", pageSize);
		params.put("orgTreeId", orgTreeId);
		PageUtil pageUtil = null;
		String json = ClientUtil.getStringClient(ClientURL.GET_USER_BUY_BOOK,params);
		Map<String, Object> data = JsonUtil.jsonToObject(json, "data", HashMap.class);
		if(data.get("bookList")!=null && data.get("count")!=null){
			pageUtil = new PageUtil((List) data.get("bookList"), (Integer)data.get("count"), pageSize, currentPage);
		}
		mav.getModelMap().put("pageUtil", pageUtil);
		mav.getModelMap().put("queryCondition", RequestUtil.getQueryCondition(request));

		mav.setViewName("/user/vnet/recommended");
		return mav;
	}

	@RequestMapping("merecommended")
	public ModelAndView merecommended(
			@RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		HashMap<Object, Object> params = new HashMap<Object, Object>();
		params.put("userId", getLoginUserId(request));
		pageSize = 6;
        params.put("currentPage", currentPage);
        params.put("pageSize", pageSize);
		params.put("orgTreeId", orgTreeId);
		PageUtil pageUtil = null;
		String json = ClientUtil.getStringClient(ClientURL.GET_USER_BUY_PACKAGE,params);
		Map<String, Object> data = JsonUtil.jsonToObject(json, "data", HashMap.class);
		if(data.get("packageList")!=null && data.get("count")!=null){
			pageUtil = new PageUtil((List) data.get("packageList"), (Integer)data.get("count"), pageSize, currentPage);
		}
		mav.getModelMap().put("pageUtil", pageUtil);
		mav.getModelMap().put("queryCondition", RequestUtil.getQueryCondition(request));


		mav.setViewName("/user/vnet/merecommended");
		return mav;
	}

	@Resource
	private BookService bookService;

}
