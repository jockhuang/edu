/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Jock
 */
package cn.chineseall.book.controller.manage;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.controller.BaseController;
import cn.chineseall.model.activity.AcBaseinfo;
import cn.chineseall.model.activity.AcBulletin;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.JsonUtil;
import cn.chineseall.utils.PageUtil;
import cn.chineseall.utils.RequestUtil;

/**
 * 
 * @author Jock
 */
@Controller
@RequestMapping("/manage")
public class OrgActivityBulletinController extends BaseController {
    
	/**
	 * 活动公告列表页
	 * @param activityId
	 * @param activityName
	 * @param activityState
	 * @param currentPage
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/activity/bulletin/list")
    public ModelAndView acBulletins(@RequestParam("activityId") Long activityId,
    		@RequestParam(required = false, value = "currentPage") Integer currentPage,
            HttpServletRequest request)
            throws Exception {

		if(currentPage==null || currentPage<=0){
			currentPage=1;
		}
		int pageSize=10;
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("activityId", activityId);
        mav.getModelMap().put("currentPage", currentPage);
        mav.getModelMap().put("orgTreeId", getOrgTreeId(request));
        mav.getModelMap().put("userId", getLoginUserId(request));
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("activityId", activityId);

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
         * 获取公告列表
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_BULLETIN, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	String queryCondition = RequestUtil.getQueryCondition(request);
        	PageUtil pageUtil = new PageUtil(null, JsonUtil.jsonToObject(returnStr, "count", Integer.class), pageSize, currentPage);
            mav.getModelMap().put("pageUtil", pageUtil);
            mav.getModelMap().put("queryCondition", queryCondition);
            
        	mav.getModelMap().put("bulletins", JsonUtil.jsonToList(returnStr, "list", AcBulletin.class));
        	mav.getModelMap().put("bulletinsCount", JsonUtil.jsonToObject(returnStr, "count", Integer.class));
        }

        mav.setViewName("/manage/activity/listBulletin");
        return mav;
    }
	/**
	 * 删除活动公告
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/activity/bulletin/del")
	public ModelAndView delAcBulletin(@RequestParam(value="activityId") Long activityId,
			@RequestParam(value="bulletinId") Long bulletinId,ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
        	Map<String, Object> params = new HashMap<String, Object>();
            params.put("activityId", activityId);
            params.put("bulletinId", bulletinId);
    		ClientUtil.getStringClient(ClientURL.DEL_AC_BULLETIN, params);
    		ModelAndView mav = new ModelAndView();
            mav.getModelMap().put("activityId", activityId);
    		mav.setViewName("redirect:/manage/activity/bulletin/list.action");
    		return mav;
	}
    @RequestMapping("/activity/bulletin")
	public ModelAndView bulletin(@RequestParam(value="activityId") Long activityId,
			@RequestParam(value="bulletinId",required=false) String bulletinId,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String, Object> params = new HashMap<String, Object>();
        params.put("bulletinId", bulletinId);
        params.put("orgTreeId", getOrgTreeId(request));
        params.put("activityId", activityId);
        
        ModelAndView mav = new ModelAndView();
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
    	if(bulletinId!=null && !"".equals(bulletinId)){
    		/**
             * 获取公告信息
             */
            returnStr = ClientUtil.getStringClient(ClientURL.GET_AC_BULLETIN, params);
            if(returnStr!=null && !"".equals(returnStr)){
            	mav.getModelMap().put("bulletin", JsonUtil.jsonToObject(returnStr, "bulletin", AcBulletin.class));
            }
    	}
        mav.getModelMap().put("activityId", activityId);
        mav.getModelMap().put("orgTreeId", getOrgTreeId(request));
        mav.setViewName("/manage/activity/bulletin");
        return mav;
	}
	/**
	 * 增加活动
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
    @RequestMapping("/activity/bulletin/add")
	public ModelAndView addAcBulletin(@RequestParam(value="activityId") Long activityId,
			@RequestParam(value="title",required=false) String title,
			@RequestParam(value="content",required=false) String content,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("orgTreeId", getOrgTreeId(request));
        params.put("userId", getLoginUserId(request));
        params.put("activityId", activityId);
        params.put("title", title);
        params.put("content", content);

        /**
         * 添加活动信息
         */
        ClientUtil.getStringClient(ClientURL.ADD_AC_BULLETIN, params);
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("activityId", activityId);
		mav.setViewName("redirect:/manage/activity/bulletin/list.action");
        return mav;
	}
   /**
	 * 修改活动信息
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
    @RequestMapping("/activity/bulletin/update")
	public ModelAndView updateAcBulletin(@RequestParam(value="activityId") Long activityId,
			@RequestParam(value="title",required=false) String title,
			@RequestParam(value="content",required=false) String content,
			@RequestParam(value="bulletinId") String bulletinId,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("activityId", activityId);
    	params.put("orgTreeId", getOrgTreeId(request));
        params.put("userId", getLoginUserId(request));
        params.put("title", title);
        params.put("content", content);
        params.put("bulletinId", bulletinId);

        /**
         * 修改活动公告信息
         */
        ClientUtil.getStringClient(ClientURL.UPDATE_AC_BULLETIN, params);
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("activityId", activityId);
		mav.setViewName("redirect:/manage/activity/bulletin/list.action");
        return mav;
	}
}
