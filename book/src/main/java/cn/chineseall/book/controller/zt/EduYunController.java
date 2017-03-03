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
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.ImageUtils;
import cn.chineseall.utils.JsonUtil;
import cn.chineseall.utils.PageUtil;

/**
 * 
 * @author MR-ZHAO
 * @see 央管专题接口
 */
public class EduYunController extends HttpServlet {
	private static final long serialVersionUID = 3555273616239067585L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		JSONObject jo = new JSONObject();
		Map<String, Object> param = new HashMap<String, Object>();
		String currentPageStr = request.getParameter("currentPage");
		Integer currentPage = 1;
		if(currentPageStr!=null && !"".equals(currentPageStr)){
			currentPage = Integer.valueOf(currentPageStr);
		}
		param.put("currentPage", currentPage);
		param.put("pageSize", 20);
		param.put("name", request.getParameter("name"));
		String returnStr = ClientUtil.getStringClient(ClientURL.GET_BOOK_LIST_BY_NAME, param);
		Integer result;
		try {
			result = JsonUtil.getInt(returnStr, "result");
			if(result!=null && result!=0){
				List<Map> bookList = JsonUtil.jsonToList(returnStr, "items", Map.class);
				List<Map> newBookList = new ArrayList<Map>();
				for (Map map : bookList) {
					String bookImg = ImageUtils.getBookImgUrl(Long.valueOf(map.get("bookId").toString()));
					map.put("bookImg", "http://img3.chineseall.cn" + bookImg);
					newBookList.add(map);
				}
				jo.put("name", request.getParameter("name"));
				jo.put("items", newBookList);
				PageUtil pageUtil = new PageUtil(newBookList, JsonUtil.getInt(returnStr, "count"), 20, currentPage);
				jo.put("pageUtil", pageUtil);
			}else{
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/plain");
    	response.setCharacterEncoding("UTF-8");
    	PrintWriter out = response.getWriter();
		out.print("callback("+jo.toString()+")");
		out.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

	/**
	 * 获取图书列表（根据图书包名称）
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 *//*
	@ResponseBody
	@RequestMapping("/getBookListByName")
	public JSONPObject getBookListByName(HttpServletRequest request,
			HttpServletResponse response, String name, Integer currentPage)
			throws Exception {
		JSONPObject jp = null;
		ModelMap modelMap = new ModelMap();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("currentPage", 1);
		param.put("pageSize", pageSize);
		param.put("name", "语文");
		String returnStr = ClientUtil.getStringClient(ClientURL.GET_BOOK_LIST_BY_NAME, param);
		Integer result = JsonUtil.getInt(returnStr, "result");
		if(result!=null && result!=0){
			modelMap.put("items", JsonUtil.jsonToList(returnStr, "items", Map.class));
			modelMap.put("count", JsonUtil.getInt(returnStr, "count"));
			jp = new JSONPObject("fun", modelMap);
		}else{
			
		}
		return jp;
		
	}*/

}
