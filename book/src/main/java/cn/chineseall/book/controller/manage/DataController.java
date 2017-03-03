/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Lv15
 */
package cn.chineseall.book.controller.manage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.controller.BaseController;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.JsonUtil;

/**
 * 
 * @author zhaochengju
 */
@Controller
@RequestMapping("/manage/data")
public class DataController extends BaseController {

    @RequestMapping("/userData")
    public ModelAndView userData(HttpServletRequest request,
            @RequestParam(required = false, value = "oper", defaultValue = "0") Integer oper)
            throws Exception {
    	
    	switch (oper) {
		case 1:
			//TODO:
			
			break;
		case 2:
			//TODO:
					
			break;
		case 3:
			//TODO:
			
			break;
		default:
			//TODO:
			
			break;
		}
    	
    	ModelAndView mav = new ModelAndView();
    	mav.getModelMap().put("oper", oper);
        mav.setViewName("/manage/data/userData");
        return mav;
    }
    
    @RequestMapping("/bookData")
    public ModelAndView bookData(HttpServletRequest request,
            @RequestParam(required = false, value = "oper", defaultValue = "0") Integer oper)
            throws Exception {
    	
    	ModelAndView mav = new ModelAndView();
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("orgTreeId", orgTreeId);
    	switch (oper) {
		case 1:
			//TODO:阅读排行
			params.put("orderBy", "total_read_counts");
			break;
		case 2:
			//TODO:评分排行
			params.put("orderBy", "score_user_count");
			break;
		case 3:
			//TODO:书评排行
			params.put("orderBy", "comments");
			break;
		default:
			//TODO:收藏排行
			params.put("orderBy", "collections");
			break;
		}
    	
    	String returnStr = ClientUtil.getStringClient(ClientURL.GET_ORG_BOOK_RANDKING, params);
    	List<HashMap> data = JsonUtil.jsonToList(returnStr, "data", HashMap.class);
    	mav.getModelMap().put("data", data);
    	mav.getModelMap().put("oper", oper);
        mav.setViewName("/manage/data/bookData");
        return mav;
    }
    
}
