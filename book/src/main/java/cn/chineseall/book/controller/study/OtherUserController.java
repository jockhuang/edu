/**
 * 
 */
package cn.chineseall.book.controller.study;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.service.BookService;
import cn.chineseall.book.service.UserService;
import cn.chineseall.model.activity.vo.AcWorks;
import cn.chineseall.model.book.Book;
import cn.chineseall.model.book.BookComment;
import cn.chineseall.model.user.UserStudy;
import cn.chineseall.model.user.vo.UserInfo;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.JsonUtil;
import cn.chineseall.utils.PageUtil;
import cn.chineseall.utils.RequestUtil;

/**
 * @author Lv15
 * 
 */
@Controller
@RequestMapping("/user")
public class OtherUserController extends StudyController {

	@RequestMapping("{userId}/i")
	public String index(@PathVariable Long userId, ModelMap model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		try {
			if(putVisitUser(userId, model, request, response) == null){
				return "redirect:/error.action";
			}
		} catch (Exception e) {
//			model.put("msg", e.getMessage());
			return "redirect:/error.action?errorCode=" + e.getMessage();
		}

		UserInfo loginUser = getLoginUser();
		if (loginUser != null) {
			if (loginUser.getUserId().equals(userId)) {
				response.sendRedirect("/user/i.action");
				return null;
			}
			model.put("isConcern",
					service.haveConcernUserId(loginUser.getUserId(), userId));
			HashMap<Object, Object> params = new HashMap<Object, Object>();
			params.put("userId", loginUser.getUserId());
			params.put("beVisitUserId", userId);
			ClientUtil.getStringClient(ClientURL.ADD_VISIT_USER_LOG, params);
		}

		Map<String, Object> data = service.getUserIndexPageData(userId);

		/**
		 * 获取用户已购买图书和图书包
		 */
		HashMap<Object, Object> params = new HashMap<Object, Object>();
		params.put("userId", userId);
        params.put("currentPage", currentPage);
        params.put("pageSize", 4);
		params.put("orgTreeId", orgTreeId);
		PageUtil pageUtil = null;
		String json = ClientUtil.getStringClient(ClientURL.GET_USER_BUY_BOOK,params);
		Map<String, Object> data1 = JsonUtil.jsonToObject(json, "data", HashMap.class);
		if(data1.get("bookList")!=null && data1.get("count")!=null){
			pageUtil = new PageUtil((List) data1.get("bookList"), (Integer)data1.get("count"), pageSize, currentPage);
		}
		model.put("pageUtil", pageUtil);
		
		json = ClientUtil.getStringClient(ClientURL.GET_USER_BUY_PACKAGE,params);
		Map<String, Object> data2 = JsonUtil.jsonToObject(json, "data", HashMap.class);
		if(data2.get("packageList")!=null && data2.get("count")!=null){
			pageUtil = new PageUtil((List) data2.get("packageList"), (Integer)data2.get("count"), pageSize, currentPage);
		}
		model.put("pageUtil1", pageUtil);

		/**
		 * 获取用户书评
		 */
		params.put("pageSize", 10);
		json = ClientUtil.getStringClient(ClientURL.LIST_BOOK_COMMENT, params);
		List<BookComment> listBookComment = JsonUtil.jsonToList(json, "list",
				BookComment.class);
		data.put("listBookComment", listBookComment);

		params.clear();
		params.put("bookIds", bookService.getBookIds(listBookComment));
		json = ClientUtil.getStringClient(ClientURL.GET_BOOKS, params);
		List<Book> listBook = JsonUtil.jsonToList(json, "list", Book.class);
		HashMap<String, Book> mapBook = new HashMap<String, Book>();
		for (Book book : listBook) {
			mapBook.put(book.getId().toString(), book);
		}
		model.put("mapBook", mapBook);

		model.put("userIndexPageData", data);
		return "/user/v/index";
	}

	@RequestMapping("{userId}/collection")
	public String collection(
			@PathVariable Long userId,
			@RequestParam(required = false, defaultValue = "1") Integer currentPage,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserInfo loginUser = getLoginUser();
		if (loginUser != null && loginUser.getUserId().equals(userId)) {
			response.sendRedirect("/user/i.action");
			return null;
		}

		try {
			if(putVisitUser(userId, model, request, response) == null){
				return "redirect:/error.action";
			}
		} catch (Exception e) {
//			model.put("msg", e.getMessage());
			return "redirect:/error.action?errorCode=" + e.getMessage();
		}

		HashMap<Object, Object> params = new HashMap<Object, Object>();
		params.put("userId", userId);
		params.put("pageSize", 12);
		params.put("currentPage", currentPage);

		String json = ClientUtil
				.getStringClient(
						request.getRequestURI().indexOf("collection.action") > -1 ? ClientURL.LIST_USER_COLLECTION_BOOK
								: ClientURL.LIST_USER_RECOMMEND_BOOK, params);

		List<Book> list = JsonUtil.jsonToList(json, "list", Book.class);
		model.put("list", list);
		model.put("count", JsonUtil.getLong(json, "count"));
		model.put("mapBookId", bookService.mapHaveCollectionBookId(
				loginUser != null ? loginUser.getUserId() : null,
				bookService.getBookIds(list)));
		model.put("currentPage", currentPage);

		return "/user/v/"
				+ (request.getRequestURI().indexOf("collection.action") > -1 ? "collection"
						: "recommended");
	}
	
	@RequestMapping("{userId}/recommended")
	public String recommended(
			@PathVariable Long userId,
			@RequestParam(required = false, defaultValue = "1") Integer currentPage,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserInfo loginUser = getLoginUser();
		if (loginUser != null && loginUser.getUserId().equals(userId)) {
			response.sendRedirect("/user/i.action");
			return null;
		}

		try {
			if(putVisitUser(userId, model, request, response) == null){
				return "redirect:/error.action";
			}
		} catch (Exception e) {
//			model.put("msg", e.getMessage());
			return "redirect:/error.action?errorCode=" + e.getMessage();
		}

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
		model.put("pageUtil", pageUtil);
		model.put("queryCondition", RequestUtil.getQueryCondition(request));

		return "/user/v/recommended";
	}
	
	@RequestMapping("{userId}/merecommended")
	public String merecommended(
			@PathVariable Long userId,
			@RequestParam(required = false, defaultValue = "1") Integer currentPage,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserInfo loginUser = getLoginUser();
		if (loginUser != null && loginUser.getUserId().equals(userId)) {
			response.sendRedirect("/user/i.action");
			return null;
		}

		try {
			if(putVisitUser(userId, model, request, response) == null){
				return "redirect:/error.action";
			}
		} catch (Exception e) {
//			model.put("msg", e.getMessage());
			return "redirect:/error.action?errorCode=" + e.getMessage();
		}

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
		model.put("pageUtil", pageUtil);
		model.put("queryCondition", RequestUtil.getQueryCondition(request));

		return "/user/v/merecommended";
	}

	@RequestMapping("{userId}/comment")
	public String comment(
			@PathVariable Long userId,
			@RequestParam(required = false, defaultValue = "1") Integer currentPage,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserInfo loginUser = getLoginUser();
		if (loginUser != null && loginUser.getUserId().equals(userId)) {
			response.sendRedirect("/user/i.action");
			return null;
		}
		try {
			if(putVisitUser(userId, model, request, response) == null){
				return "redirect:/error.action";
			}
		} catch (Exception e) {
//			model.put("msg", e.getMessage());
			return "redirect:/error.action?errorCode=" + e.getMessage();
		}

		HashMap<Object, Object> params = new HashMap<Object, Object>();
		params.put("userId", userId);
		params.put("pageSize", 10);
		params.put("currentPage", currentPage);
		String json = ClientUtil.getStringClient(ClientURL.LIST_BOOK_COMMENT,
				params);

		List<BookComment> listComment = JsonUtil.jsonToList(json, "list",
				BookComment.class);
		model.put("list", listComment);
		model.put("count", JsonUtil.getLong(json, "count"));
		model.put("currentPage", currentPage);
		model.put("mapBook",
				bookService.mapBook(bookService.getBookIds(listComment)));

		return "/user/v/comment";
	}

	@RequestMapping("{userId}/work")
	public String work(
			@PathVariable Long userId,
			@RequestParam(required = false, defaultValue = "1") Integer currentPage,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserInfo loginUser = getLoginUser();
		if (loginUser != null && loginUser.getUserId().equals(userId)) {
			response.sendRedirect("/user/i.action");
			return null;
		}
		try {
			if(putVisitUser(userId, model, request, response) == null){
				return "redirect:/error.action";
			}
		} catch (Exception e) {
//			model.put("msg", e.getMessage());
			return "redirect:/error.action?errorCode=" + e.getMessage();
		}

		HashMap<Object, Object> params = new HashMap<Object, Object>();
		params.put("userId", userId);
		params.put("pageSize", 10);
		params.put("currentPage", currentPage);
		String json = ClientUtil.getStringClient(ClientURL.LIST_USER_WORKS,
				params);

		model.put("list", JsonUtil.jsonToList(json, "list", AcWorks.class));
		model.put("count", JsonUtil.getLong(json, "count"));
		model.put("currentPage", currentPage);

		return "/user/v/work";
	}

	@RequestMapping(value = { "{userId}/concern", "{userId}/concernhere" })
	public String concern(
			@PathVariable Long userId,
			@RequestParam(required = false, defaultValue = "1") Integer currentPage,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserInfo loginUser = getLoginUser();
		if (loginUser != null && loginUser.getUserId().equals(userId)) {
			response.sendRedirect("/user/i.action");
			return null;
		}
		try {
			putVisitUser(userId, model, request, response);
		} catch (Exception e) {
			model.put("msg", e.getMessage());
			return "/user/error";
		}

		HashMap<Object, Object> params = new HashMap<Object, Object>();
		params.put("userId", userId);
		params.put("pageSize", 12);
		params.put("currentPage", currentPage);

		String json = ClientUtil
				.getStringClient(
						request.getRequestURI().indexOf("concern.action") > -1 ? ClientURL.LIST_ME_CONCERN_USER
								: ClientURL.LIST_CONCERN_ME_USER, params);

		List<UserInfo> listUserInfo = JsonUtil.jsonToList(json, "list",
				UserInfo.class);
		model.put("list", listUserInfo);
		model.put("count", JsonUtil.getLong(json, "count"));
		model.put("currentPage", currentPage);

		HashSet<Long> setUserId = new HashSet<Long>();
		for (UserInfo info : listUserInfo) {
			setUserId.add(info.getUserId());
		}

		model.put("mapUserId", service.mapHaveConcernUserId(
				loginUser != null ? loginUser.getUserId() : null, setUserId));

		return request.getRequestURI().indexOf("concern.action") > -1 ? "/user/v/concern"
				: "/user/v/concernhere";
	}

	private UserInfo putVisitUser(Long userId, ModelMap model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserInfo visitUser = getUserInfo(userId);
		if (visitUser == null) {
			return null;
		}
		model.put("visitUser", visitUser);
		UserStudy study = service.getUserStudy(userId);
		if (study == null || study.getIsCanVisitPage().equals(2)) {
			throw new Exception("u002");
		}
		model.put("userStudy", study);
		return visitUser;
	}

	@Resource
	private UserService service;

	@Resource
	private BookService bookService;

}
