/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Lv15
 */
package cn.chineseall.book.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.service.APIService;
import cn.chineseall.book.service.ReadService;
import cn.chineseall.constants.ReadConstants;
import cn.chineseall.model.book.Book;
import cn.chineseall.model.book.vo.ReadInfo;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.JsonUtil;

/**
 * 
 * @author Lv15
 */
@Controller
@RequestMapping("/book")
public class ReadController extends BaseController {

	@Resource
	private APIService apiService;

	@RequestMapping("read")
	public ModelAndView read(
			@RequestParam("bookId") Long bookId,
			@RequestParam(required = false) Integer mode,
			@RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "hide") String directory,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ModelAndView mav = new ModelAndView();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bookId", bookId);
		Long userId = getLoginUserId(request);
		if (userId != null) {
			params.put("userId", userId);
			mav.getModel().put("login", true);
		}
		params.put("mode", mode);
		params.put("page", page);
		params.put("orgTreeId", getOrgTreeId(request));

		String json = ClientUtil.getStringClient(ClientURL.GET_READ_INFO,
				params);
		ReadInfo readInfo = JsonUtil.jsonToObject(json, "readInfo",
				ReadInfo.class);
		Integer price = JsonUtil.getInt(json, "price");
		if (readInfo != null) {
			mav.getModelMap().put("readInfo", readInfo);
			mav.getModelMap().put("price", price);
			mav.getModelMap().put("totalPageNum",
					readInfo.getTotalPageNums().get(readInfo.getType()));
			mav.getModelMap()
					.put("resourcesPrefix", ClientURL.RESOURCES_PREFIX);

			if (readInfo.getType().equals(ReadConstants.READ_MODE_TXT)) {
				try {
					mav.getModelMap().put(
							"txtContent",
							service.getTxtContent(readInfo.getTokenKey(),
									readInfo.getTokenContent()));
				} catch (Exception e) {
					mav.getModelMap().put("txtContent", "加载内容失败，请稍后再试");
					logger.error("加载txt内容失败", e);
				}
			}
			mav.setViewName("/book/read");
		} else {
			Integer readErrorCode = JsonUtil.getInt(json, "readErrorCode");
			mav.getModelMap().put("readErrorCode", readErrorCode);

			if (readErrorCode == ReadConstants.READ_ERROR_CODE_NOT_FOUND) {
				mav.setViewName("redirect:/error.action?errorCode=b002");
				return mav;
			} else if (readErrorCode == ReadConstants.READ_ERROR_CODE_PENDING
					|| readErrorCode == ReadConstants.READ_ERROR_CODE_HIDDEN) {
				mav.setViewName("redirect:/error.action?errorCode=b001");
				return mav;
			} else if (readErrorCode == ReadConstants.READ_ERROR_CODE_RANGE) {
				mav.setViewName("redirect:/error.action?errorCode=b003");
				return mav;
			}
		}

		Book book = JsonUtil.jsonToObject(json, "book", Book.class);

		/**
		 * TODO: 添加消息
		 */
		String content = "您的好友阅读了<a href='http://eduyun.chineseall.cn/book/detail.action?bookId="
				+ book.getId() + "' target='_blank'>" + book.getName() + "</a>";
		apiService.sendMessage(getSessionId(request), content, "阅读图书",
				"remind", "true", null);

		setStaticModel(ReadConstants.class, request);
		mav.getModelMap().put("book", book);
		mav.getModelMap().put("directory", directory);
		return mav;
	}

	@RequestMapping("directory")
	public ModelAndView directory(@RequestParam("bookId") Long bookId,
			@RequestParam("mode") Integer mode, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		try {
			mav.getModelMap().put("directory",
					service.getDirectory(bookId, mode));
		} catch (Exception e) {
			logger.error("获取图书目录失败", e);
			mav.getModelMap().put("directory", new JSONArray());
		}
		mav.setViewName("/book/directory");
		return mav;
	}

	@Resource
	private ReadService service;

	private Logger logger = LoggerFactory.getLogger(ReadController.class);

}
