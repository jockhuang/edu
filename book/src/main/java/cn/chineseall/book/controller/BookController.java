/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Lv15
 */
package cn.chineseall.book.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.model.SearchVo;
import cn.chineseall.book.service.APIService;
import cn.chineseall.book.service.BookService;
import cn.chineseall.book.service.ReadService;
import cn.chineseall.book.service.SearchService;
import cn.chineseall.constants.ReadConstants;
import cn.chineseall.model.book.Book;
import cn.chineseall.model.book.vo.BookDetail;
import cn.chineseall.model.book.vo.BookSelfSortDetail;
import cn.chineseall.model.eduyun.EduBookPackage;
import cn.chineseall.model.user.UserReadGroup;
import cn.chineseall.model.user.vo.UserInfo;
import cn.chineseall.model.user.vo.UserReadingDetail;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.ImageUtils;
import cn.chineseall.utils.JsonUtil;
import cn.chineseall.utils.PageUtil;

/**
 * 
 * @author Jock,Lv15
 */
@Controller
@RequestMapping("/book")
public class BookController extends BaseController {

	@Resource(name = "apiConfig")
	private PropertiesConfiguration apiConfig;

	@Resource
	private APIService apiService;

	@RequestMapping("/room")
	public ModelAndView room(
			@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage,
			@RequestParam(required = false, value = "order") String order,
			@RequestParam(required = false, value = "selfSortId") Long selfSortId,
			@RequestParam(required = false) String sname,
			@RequestParam(required = false) String selfSortName,
			HttpServletRequest request) throws Exception {

		setStaticModel(ImageUtils.class, request);

		getOrgTreeId(request);
		ModelAndView mav = new ModelAndView();
		ModelMap modelMap = mav.getModelMap();

		modelMap.put("currentPage", currentPage);
		modelMap.put("order", order);
		modelMap.put("selfSortId", selfSortId);
		modelMap.put("sname", sname);
		modelMap.put("selfSortName", selfSortName);

		/**
		 * 图书id集合，获取图书简介时使用
		 */
		Set<Long> bookIds = new HashSet<Long>();
		/**
		 * 自定义分类下图书列表
		 */
		List<Book> listSelfSortBook = null;
		/**
		 * 查看用户是否登录
		 */
		UserInfo userInfo = getUserInfo(request);
		if (userInfo != null) {
			modelMap.put("user", userInfo);
			/**
			 * 用户阅读记录
			 */
			List<UserReadingDetail> listUserReadingDetail = service
					.listUserReadingDetail(userInfo.getUserId(), orgTreeId, 1,
							3);
			bookIds.addAll(service.getBookIds(listUserReadingDetail));
			modelMap.put("listUserReadingDetail", listUserReadingDetail);

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("orgTreeId", orgTreeId);
			/**
			 * 获取分类图书
			 */
			params.put("selfSortId", selfSortId);
			params.put("userId", userInfo.getUserId());
			params.put("pageSize", 10);
			params.put("currentPage", currentPage);

			String returnStr = ClientUtil
					.getStringClient(
							order != null && order.equals("score") ? ClientURL.LIST_ORG_SCORE_TOP_BOOK
									: ClientURL.LIST_ORG_NEW_TOP_BOOK, params);
			listSelfSortBook = JsonUtil.jsonToList(returnStr, "list",
					Book.class);

			PageUtil pageUtil = new PageUtil(listSelfSortBook, JsonUtil
					.getLong(returnStr, "count").intValue(), 10, currentPage);
			modelMap.put("pageUtil", pageUtil);

			modelMap.put("listCollectionBookId", JsonUtil.jsonToObject(
					returnStr, "listCollectionBookId", Collection.class));
			modelMap.put("listRecommendBookId", JsonUtil.jsonToObject(
					returnStr, "listRecommendBookId", Collection.class));
		} else {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("orgTreeId", orgTreeId);
			params.put("selfSortId", selfSortId);
			params.put("pageSize", 10);
			params.put("currentPage", currentPage);

			String returnStr = ClientUtil
					.getStringClient(
							order != null && order.equals("score") ? ClientURL.LIST_ORG_SCORE_TOP_BOOK
									: ClientURL.LIST_ORG_NEW_TOP_BOOK, params);
			listSelfSortBook = JsonUtil.jsonToList(returnStr, "list",
					Book.class);

			PageUtil pageUtil = new PageUtil(listSelfSortBook, JsonUtil
					.getLong(returnStr, "count").intValue(), 10, currentPage);
			modelMap.put("pageUtil", pageUtil);

			modelMap.put("listCollectionBookId", new ArrayList<Long>());
			modelMap.put("listRecommendBookId", new ArrayList<Long>());
		}

		bookIds.addAll(service.getBookIds(listSelfSortBook));

		/**
		 * 获取阅读榜
		 */
		List<Book> listOrgReadingTopBook = service.listOrgReadingTopBook(
				orgTreeId, 1, 10);
		modelMap.put("listOrgReadingTopBook", listOrgReadingTopBook);
		if (listOrgReadingTopBook.size() > 0) {
			bookIds.add(listOrgReadingTopBook.get(0).getId());
		}

		/**
		 * 获取收藏榜
		 */
		List<Book> listOrgCollectionTopBook = service.listOrgCollectionTopBook(
				orgTreeId, 1, 10);
		modelMap.put("listOrgCollectionTopBook", listOrgCollectionTopBook);
		if (listOrgCollectionTopBook.size() > 0) {
			bookIds.add(listOrgCollectionTopBook.get(0).getId());
		}

		/**
		 * 系统推荐阅读
		 */
		modelMap.put("listRecommendUserBook",
				service.listRecommendUserBook(orgTreeId, 3));

		/**
		 * 获取机构图书自定义分类
		 */
		List<BookSelfSortDetail> listOrgSelfSortDetail = service
				.listOrgSelfSortDetail(orgTreeId);
		if (listOrgSelfSortDetail.size() > 10) {
			listOrgSelfSortDetail = listOrgSelfSortDetail.subList(0, 10);
		}
		modelMap.put("listOrgSelfSortDetail", listOrgSelfSortDetail);

		/**
		 * 放置界面所需图书简介
		 */
		modelMap.put("intros", service.getIntros(bookIds));
		
		/**
		 * 查看用户是否购买图书
		 */
		modelMap.put("buyInfos", service.getBuyInfo(bookIds, userInfo.getUserId()));

		mav.setViewName("/book/room");
		return mav;
	}

	@RequestMapping("/selfsortindex")
	public ModelAndView selfSortIndex(HttpServletRequest request)
			throws Exception {

		getOrgTreeId(request);

		ModelAndView mav = new ModelAndView();
		mav.getModelMap().put("listOrgSelfSortDetail",
				service.listOrgSelfSortDetail(orgTreeId));
		mav.getModelMap().put("orgTreeId", orgTreeId);

		mav.setViewName("/book/selfSortIndex");
		return mav;
	}

	@RequestMapping("/sortindex")
	public ModelAndView sortindex(HttpServletRequest request) throws Exception {

		getOrgTreeId(request);
		ModelAndView mav = new ModelAndView();

		SearchVo search = new SearchVo();
		search.getPageUtil().setCurrentPage(1);
		search.getPageUtil().setPageSize(1);

		search = searchService.search(search);

		mav.getModelMap().put("listSort", search.getCategory0());
		mav.getModelMap().put("childSort", search.getCategory1());
		mav.getModelMap().put("orgTreeId", orgTreeId);

		mav.setViewName("/book/sortIndex");
		return mav;
	}

	@RequestMapping("/detail")
	public ModelAndView detail(Long bookId, HttpServletRequest request)
			throws Exception {

		ModelAndView mav = new ModelAndView();
		if (bookId == null) {
			mav.setViewName("redirect:/error.action?errorCode=b002");
			return mav;
		}
		setStaticModel(ImageUtils.class, request);
		setStaticModel(ReadConstants.class, request);
		getOrgTreeId(request);

		ModelMap model = mav.getModelMap();

		UserInfo userInfo = getUserInfo(request);
		List<BookDetail> detail = null;

		if (userInfo != null) {
			model.put("listUserReadingDetail", service.listUserReadingDetail(
					userInfo.getUserId(), orgTreeId, 1, 3));

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("orgTreeId", orgTreeId);
			params.put("bookId", bookId);
			params.put("userId", userInfo.getUserId());
			String returnStr = ClientUtil.getStringClient(
					ClientURL.GET_BOOK_DETAIL, params);
			detail = JsonUtil.jsonToList(returnStr, "list", BookDetail.class);

			model.put("listCollectionBookId", JsonUtil.jsonToObject(returnStr,
					"listCollectionBookId", Collection.class));
			model.put("listRecommendBookId", JsonUtil.jsonToObject(returnStr,
					"listRecommendBookId", Collection.class));
			model.put("loginUserInfo", userInfo);
		} else {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("orgTreeId", orgTreeId);
			params.put("bookId", bookId);
			String returnStr = ClientUtil.getStringClient(
					ClientURL.GET_BOOK_DETAIL, params);
			detail = JsonUtil.jsonToList(returnStr, "list", BookDetail.class);

			model.put("listCollectionBookId", new ArrayList<Long>());
			model.put("listRecommendBookId", new ArrayList<Long>());
		}

		if (detail.size() == 0) {
			mav.setViewName("redirect:/error.action?errorCode=b001&returnUrl=/book/room.action");
			return mav;
		} else {
			switch (detail.get(0).getBook().getState()) {
			case ReadConstants.BOOK_STATE_HIDDEN:
				mav.setViewName("redirect:/error.action?errorCode=b001&returnUrl=/book/room.action");
				return mav;
			case ReadConstants.BOOK_STATE_PENDING:
				ArrayList<Long> listCollectionBookId = (ArrayList<Long>) model
						.get("listCollectionBookId");
				if (listCollectionBookId == null
						|| !listCollectionBookId.contains(bookId)) {
					mav.setViewName("redirect:/error.action?errorCode=b001&returnUrl=/book/room.action");
					return mav;
				}
			default:
				break;
			}
		}

		/**
		 * 获取图书标签
		 */
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bookId", bookId);
		String returnStr = ClientUtil.getStringClient(
				ClientURL.LIST_BOOK_LABEL, params);
		model.put("listBookLabel",
				JsonUtil.jsonToList(returnStr, "list", String.class));

		/**
		 * 图书详细
		 */
		model.put("detail", detail.get(0));
		/**
		 * 推荐图书
		 */
		model.put("listRecommendUserBook",
				service.listRecommendUserBook(orgTreeId, 3));
		/**
		 * 24小时阅读榜
		 */
		model.put("listOrgDayReadTopBook",
				service.listOrgDayReadTopBook(orgTreeId, currentPage, 10));
		/**
		 * 阅读过本书阅读其他图书
		 */
		model.put("listOtherUserReadingBook",
				service.listOtherUserReadingBook(orgTreeId, bookId, 15));
		/**
		 * 阅读本书的书友
		 */
		model.put("listReadBookUser",
				service.listReadBookUser(orgTreeId, bookId, 8));

		/**
		 * 获取机构图书自定义分类
		 */
		List<BookSelfSortDetail> listOrgSelfSortDetail = service
				.listOrgSelfSortDetail(orgTreeId);
		if (listOrgSelfSortDetail.size() > 10) {
			listOrgSelfSortDetail = listOrgSelfSortDetail.subList(0, 10);
		}
		mav.getModelMap().put("listOrgSelfSortDetail", listOrgSelfSortDetail);

		/**
		 * 获取图书目录
		 */
		Book book = detail.get(0).getBook();
		JSONArray directory = null;
		try {
			if (book.getTxtPages() != null && book.getTxtPages() > 0) {
				directory = readService.getDirectory(bookId,
						ReadConstants.READ_MODE_TXT);
				model.put("readMode", ReadConstants.READ_MODE_TXT);
			} else if (book.getJpgPages() != null && book.getJpgPages() > 0) {
				directory = readService.getDirectory(bookId,
						ReadConstants.READ_MODE_IMG);
				model.put("readMode", ReadConstants.READ_MODE_IMG);
			} else if (book.getPdfPages() != null && book.getPdfPages() > 0) {
				directory = readService.getDirectory(bookId,
						ReadConstants.READ_MODE_PDF);
				model.put("readMode", ReadConstants.READ_MODE_PDF);
			}
			if (directory != null) {
				model.put("directory",
						directory.size() > 3 ? directory.subList(0, 3)
								: directory);
			}
		} catch (Exception e) {
			logger.error("获取目录失败，检查阅读服务是否启动", e);
		}

		/**
		 * 获取包含该图书的图书专辑
		 */
		params.put("bookId", bookId);
		params.put("limits", 4);
		params.put("userId", getLoginUserId(request));
		returnStr = ClientUtil.getStringClient(
				ClientURL.GET_BOOK_PACKAGE_BY_BOOKID, params);
		List<EduBookPackage> eduBookPackageList = JsonUtil.jsonToList(
				returnStr, "data", EduBookPackage.class);
		mav.getModelMap().put("eduBookPackageList", eduBookPackageList);
		mav.getModelMap().put("buy", JsonUtil.getInt(returnStr, "buy"));
		mav.getModelMap().put("price", JsonUtil.getInt(returnStr, "price"));
		
		mav.setViewName("/book/detail");
		return mav;
	}

	@RequestMapping("/collectionbook")
	public void collectionBook(@RequestParam("bookId") Long bookId,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Long userId = getLoginUserId(request);
		JSONObject object = new JSONObject();
		if (userId != null) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("bookId", bookId);
			params.put("userId", userId);
			String returnStr = ClientUtil.getStringClient(
					ClientURL.COLLECTION_BOOK, params);

			object.put("success", JsonUtil.getBoolean(returnStr, "success"));
			object.put("msg", JsonUtil.getString(returnStr, "msg"));
			if(JsonUtil.getBoolean(returnStr, "success")){
				/**
				 * TODO: 添加消息
				 */
				if (JsonUtil.getBoolean(returnStr, "success")) {
					String content = "你的好友收藏了<a href='http://eduyun.chineseall.cn/book/detail.action?bookId="
							+ bookId + "' target='_blank'>" +JsonUtil.getString(returnStr, "bookName")+ "</a>";
					apiService.sendMessage(getSessionId(request), content,
							"收藏图书", "remind", "true", null);
				}
			}
		} else {
			object.put("success", false);
			object.put("msg", "登录后才能进行收藏操作");
		}
		response.setContentType("text/plain");
		response.getWriter().print(object.toString());
		response.getWriter().flush();
	}

	@RequestMapping("/deletecollectionbook")
	public void deleteCollectionBook(@RequestParam("bookId") Long bookId,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Long userId = getLoginUserId(request);
		JSONObject object = new JSONObject();
		if (userId != null) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("bookId", bookId);
			params.put("userId", userId);
			String returnStr = ClientUtil.getStringClient(
					ClientURL.DELETE_COLLECTION_BOOK, params);

			object.put("success", JsonUtil.getBoolean(returnStr, "success"));
			object.put("msg", JsonUtil.getString(returnStr, "msg"));
		} else {
			object.put("success", false);
			object.put("msg", "登录后才能进行删除收藏操作");
		}
		response.setContentType("text/plain");
		response.getWriter().print(object.toString());
		response.getWriter().flush();
	}

	@RequestMapping("/vote")
	public void vote(@RequestParam("bookId") Long bookId,
			@RequestParam("score") Integer score, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JSONObject object = new JSONObject();
		Long userId = getLoginUserId(request);
		if (userId != null) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("bookId", bookId);
			params.put("userId", userId);
			params.put("score", score);
			String returnStr = ClientUtil.getStringClient(
					ClientURL.TO_BOOK_SCORE, params);

			object.put("success", JsonUtil.getBoolean(returnStr, "success"));
			object.put("msg", JsonUtil.getString(returnStr, "msg"));
		} else {
			object.put("success", false);
			object.put("msg", "登录后才能进行收藏操作");
		}
		response.setContentType("text/plain");
		response.getWriter().print(object.toString());
		response.getWriter().flush();
	}

	@RequestMapping("/showrecommendbook")
	public ModelAndView showrecommendbook(@RequestParam("bookId") Long bookId,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		setStaticModel(ImageUtils.class, request);

		ModelAndView mav = new ModelAndView();
		UserInfo userInfo = getUserInfo(request);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bookId", bookId);

		String returnStr = ClientUtil.getStringClient(
				ClientURL.GET_BOOK_DETAIL, params);
		List<BookDetail> detail = JsonUtil.jsonToList(returnStr, "list",
				BookDetail.class);
		if (detail == null || detail.size() == 0) {
		}

		/**
		 * 图书详细
		 */
		mav.getModel().put("book", detail.get(0).getBook());
		mav.getModel().put("intro", detail.get(0).getIntro());

		params.clear();
		params.put("userId", userInfo.getUserId());
		returnStr = ClientUtil.getStringClient(
				ClientURL.LIST_USER_RELATED_GROUP, params);
		mav.getModel().put("listGroup",
				JsonUtil.jsonToList(returnStr, "list", UserReadGroup.class));

		mav.setViewName("/book/recommend");
		return mav;
	}

	@RequestMapping("/recommendbook")
	public void recommendBook(
			@RequestParam("bookId") Long bookId,
			@RequestParam(value = "recommendToFriends", required = false, defaultValue = "0") Integer recommendToFriends,
			@RequestParam(value = "recommendToMyOrg", required = false, defaultValue = "0") Integer recommendToMyOrg,
			@RequestParam(value = "recommendToMyClass", required = false, defaultValue = "0") Integer recommendToMyClass,
			@RequestParam(value = "comment", required = false) String comment,
			@RequestParam(value = "groupId", required = false) Long[] groupId,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Long userId = getLoginUserId(request);
		JSONObject object = new JSONObject();
		if (userId != null) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("bookId", bookId);
			params.put("userId", userId);
			params.put("recommendToFriends", recommendToFriends);
			params.put("recommendToMyOrg", recommendToMyOrg);
			params.put("recommendToMyClass", recommendToMyClass);
			params.put("comment", comment);
			List<Long> listGroupId = new ArrayList<Long>();
			if (groupId != null && groupId.length > 0) {
				for (Long id : groupId) {
					listGroupId.add(id);
				}
			}
			params.put("groupId", listGroupId);
			String returnStr = ClientUtil.getStringClient(
					ClientURL.RECOMMEND_BOOK, params);

			object.put("success", JsonUtil.getBoolean(returnStr, "success"));
			object.put("msg", JsonUtil.getString(returnStr, "msg"));
		} else {
			object.put("success", false);
			object.put("msg", "登录后才能进行收藏操作");
		}
		response.setContentType("text/plain");
		response.getWriter().print(object.toString());
		response.getWriter().flush();
	}

	@Resource
	private BookService service;

	@Resource
	private ReadService readService;

	@Resource(name = "bookSearchService")
	private SearchService searchService;

	private Logger logger = Logger.getLogger(BookController.class);

}
