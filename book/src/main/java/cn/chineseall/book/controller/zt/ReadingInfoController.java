/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author MR-ZHAO
 */
package cn.chineseall.book.controller.zt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.model.book.Book;
import cn.chineseall.model.book.BookIntro;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.ImageUtils;
import cn.chineseall.utils.JsonUtil;

/**
 * 
 * @author MR-ZHAO
 * @see 央管专题接口
 */
public class ReadingInfoController extends HttpServlet {
	private static final long serialVersionUID = 3555273616239067585L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		JSONObject jo = new JSONObject();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("currentPage", 1);
		params.put("pageSize", 10);
		params.put("orgTreeId", 4);
        String returnStr = null;
		returnStr = ClientUtil.getStringClient(ClientURL.LIST_ORG_READING_TOP_BOOK, params);
		List<Long> bookIds = new ArrayList<Long>();
		try {
			List<Book> bookList = JsonUtil.jsonToList(returnStr, "list", Book.class);
			List<Book> newBookList = new ArrayList<Book>();
			for (Book book : bookList) {
				bookIds.add(book.getId());
				book.setPicPath("http://img3.chineseall.cn" + ImageUtils.getBookImgUrl(book.getId()));
				newBookList.add(book);
			}
			jo.put("readingTop", newBookList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		returnStr = ClientUtil.getStringClient(ClientURL.LIST_ORG_COLLECTION_TOP_BOOK, params);
		try {
			
			List<Book> bookList = JsonUtil.jsonToList(returnStr, "list", Book.class);
			List<Book> newBookList = new ArrayList<Book>();
			for (Book book : bookList) {
				bookIds.add(book.getId());
				book.setPicPath("http://img3.chineseall.cn" + ImageUtils.getBookImgUrl(book.getId()));
				newBookList.add(book);
			}
			jo.put("collectionTop", newBookList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		params.put("bookIds", bookIds);

		returnStr = ClientUtil.getStringClient(ClientURL.GET_BOOK_INTROS, params);
		try {
			List<BookIntro> bookIntros = JsonUtil.jsonToList(returnStr, "list",
					BookIntro.class);
			jo.put("bookIntros", bookIntros);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.setContentType("text/plain");
    	response.setCharacterEncoding("UTF-8");
    	PrintWriter out = response.getWriter();
		out.print("bookcallback("+jo.toString()+")");
		out.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
