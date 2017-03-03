/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Jock
 */
package cn.chineseall.book.controller.manage;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.controller.BaseController;
import cn.chineseall.model.activity.AcBaseinfo;
import cn.chineseall.model.book.vo.BookSelfSortDetail;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.ImageUtils;
import cn.chineseall.utils.JsonUtil;
import cn.chineseall.utils.PageUtil;
import cn.chineseall.utils.RequestUtil;

/**
 * 
 * @author Jock
 */
@Controller
@RequestMapping("/manage")
public class OrgActivityBookController extends BaseController {
    
	@Resource(type=org.apache.commons.configuration.PropertiesConfiguration.class)
    private PropertiesConfiguration fileUploadConfig;
	
	@RequestMapping("/activity/book")
    public ModelAndView books(@RequestParam("activityId") Long activityId,
    		@RequestParam(required = false, value = "type") Integer type,
    		@RequestParam(required = false, value = "bookName") String bookName,
    		@RequestParam(required = false, value = "author") String author,
    		@RequestParam(required = false, value = "publisher") String publisher,
    		@RequestParam(required = false, value = "bookIds") String bookIds,
    		@RequestParam(required = false, value = "currentPage") Integer currentPage,
            HttpServletRequest request)
            throws Exception {

		if(currentPage==null || currentPage<=0){
			currentPage=1;
		}
		int pageSize=10;
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("activityId", activityId);
        mav.getModelMap().put("type", type);
        mav.getModelMap().put("bookName", bookName);
        mav.getModelMap().put("author", author);
        mav.getModelMap().put("publisher", publisher);
        mav.getModelMap().put("bookIds", bookIds);
        mav.getModelMap().put("currentPage", currentPage);
        mav.getModelMap().put("orgTreeId", getOrgTreeId(request));

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orgTreeId", getOrgTreeId(request));
        params.put("userId", getLoginUserId(request));
        params.put("activityId", activityId);
        params.put("bookName", bookName);
        params.put("author", author);
        params.put("publisher", publisher);
        params.put("type", type);
        params.put("publisher", publisher);
        params.put("bookIds", bookIds);
        params.put("currentPage", currentPage);
        params.put("pageSize", pageSize);

        /**
         * 获取活动信息
         */
        String returnStr=ClientUtil.getStringClient(ClientURL.GET_ACTIVITY_DETAIL, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	AcBaseinfo activity=JsonUtil.jsonToObject(returnStr, "activity", AcBaseinfo.class);
        	if(activity==null){
        		mav.setViewName("redirect:/error.action?errorCode=a0004");
        		return mav;
        	}else if(activity.getOrgTreeId().longValue()!=getOrgTreeId(request).longValue()){
        		mav.setViewName("redirect:/error.action?errorCode=a0010");
        		return mav;
        	}
        	mav.getModelMap().put("activity", activity);
        }
        /**
         * 获取活动书单列表
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_AC_BOOKS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	String queryCondition = RequestUtil.getQueryCondition(request);
         	PageUtil pageUtil = new PageUtil(null, JsonUtil.jsonToObject(returnStr, "count", Integer.class), pageSize, currentPage);
            mav.getModelMap().put("pageUtil", pageUtil);
            mav.getModelMap().put("queryCondition", queryCondition);
        	mav.getModelMap().put("books", JsonUtil.jsonToList(returnStr, "list", HashMap.class));
        }

        request.setAttribute("imgDomainName", fileUploadConfig.getString("img_domain"));
        setStaticModel(ImageUtils.class, request);
        if(type==null){
        	mav.setViewName("/manage/activity/listBook");
        }else{
        	mav.setViewName("/manage/activity/addBook");
        }
        return mav;
    }
	/**
	 * 添加推荐书单
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
    @RequestMapping("/activity/book/add")
	public ModelAndView addAcBook(@RequestParam(value="activityId") Long activityId,
			@RequestParam(value="ids") Long[] ids,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("orgTreeId", getOrgTreeId(request));
        params.put("userId", getLoginUserId(request));
        params.put("activityId", activityId);
        params.put("ids", ids);

        /**
         * 添加推荐书单
         */
        ClientUtil.getStringClient(ClientURL.ADD_AC_BOOK, params);
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("activityId", activityId);
        mav.getModelMap().put("orgTreeId", getOrgTreeId(request));
        mav.setViewName("redirect:/manage/activity/book.action");
        return mav;
	}
   /**
	 * 删除活动书单
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
    @RequestMapping("/activity/book/del")
	public ModelAndView delAcBook(@RequestParam(value="activityId") Long activityId,
			@RequestParam(value="ids") Long[] ids,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("activityId", activityId);
    	params.put("orgTreeId", getOrgTreeId(request));
        params.put("userId", getLoginUserId(request));
        params.put("ids", ids);

        /**
         * 删除活动书单
         */
        ClientUtil.getStringClient(ClientURL.DEL_AC_BOOK, params);
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("activityId", activityId);
        mav.setViewName("redirect:/manage/activity/book.action");
        return mav;
	}
}
