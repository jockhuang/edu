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
import cn.chineseall.model.activity.AcJury;
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
public class OrgActivityJuryController extends BaseController {
    
	/**
	 * 活动评委管理
	 * @param activityId
	 * @param type
	 * @param key
	 * @param currentPage
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/activity/jury/list")
    public ModelAndView acJurys(@RequestParam("activityId") Long activityId,
    		@RequestParam(required = false, value = "type") Integer type,
    		@RequestParam(required = false, value = "key") String key,
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
        mav.getModelMap().put("key", key);
        mav.getModelMap().put("type", type);
        
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("activityId", activityId);
        params.put("currentPage", currentPage);
        params.put("pageSize", pageSize);
        params.put("orgTreeId", getOrgTreeId(request));
        params.put("userId", getLoginUserId(request));

        /**
         * 获取活动信息
         */
        String returnStr=ClientUtil.getStringClient(ClientURL.GET_ACTIVITY_DETAIL, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("activity", JsonUtil.jsonToObject(returnStr, "activity", AcBaseinfo.class));
        }
        /**
         * 获取用户参加权限
         */
        returnStr = ClientUtil.getStringClient(ClientURL.GET_USER_JOIN_LIMIT, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	Long userOrgTreeId=JsonUtil.jsonToObject(returnStr, "treeId", Long.class);
        	if(userOrgTreeId==null){
            	mav.setViewName("redirect:/error.action?errorCode=a0010");
        		return mav;
            }else{
            	mav.getModelMap().put("userOrgTreeId", userOrgTreeId);
            }
        }
        if(type==null){
        	 /**
             * 获取已设评委列表
             */
            returnStr = ClientUtil.getStringClient(ClientURL.LIST_AC_JURYS, params);
            if(returnStr!=null && !"".equals(returnStr)){
            	mav.getModelMap().put("jurys", JsonUtil.jsonToList(returnStr, "list", AcJury.class));
            }
            mav.setViewName("/manage/activity/listJury");
        }else{
        	 /**
             * 获取历史活动评委列表
             */
            returnStr = ClientUtil.getStringClient(ClientURL.LIST_AC_HISTORY_JURYS, params);
            if(returnStr!=null && !"".equals(returnStr)){
            	String queryCondition = RequestUtil.getQueryCondition(request);
            	PageUtil pageUtil = new PageUtil(JsonUtil.jsonToList(returnStr, "list", AcJury.class), JsonUtil.jsonToObject(returnStr, "count", Integer.class), pageSize, currentPage);
                mav.getModelMap().put("pageUtil", pageUtil);
                mav.getModelMap().put("queryCondition", queryCondition);
                
            	mav.getModelMap().put("jurys", JsonUtil.jsonToList(returnStr, "list", AcJury.class));
            	mav.getModelMap().put("jurysCount", JsonUtil.jsonToObject(returnStr, "count", Integer.class));
            }
            mav.setViewName("/manage/activity/addJury");
        }

        return mav;
    }
	/**
	 * 删除活动评委
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/activity/jury/del")
	public ModelAndView delAcJury(@RequestParam(value="activityId") Long activityId,
			@RequestParam(value="id") Long id,ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
        	Map<String, Object> params = new HashMap<String, Object>();
            params.put("id", id);
    		ClientUtil.getStringClient(ClientURL.DEL_AC_JURY, params);
    		ModelAndView mav = new ModelAndView();
            mav.getModelMap().put("activityId", activityId);
    		mav.setViewName("redirect:/manage/activity/jury/list.action");
    		return mav;
	}
	/**
	 * 增加活动评委
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
    @RequestMapping("/activity/jury/add")
	public ModelAndView addAcCollaborators(@RequestParam(value="activityId") Long activityId,
			@RequestParam(value="juryId",required=false) Long juryId,
			@RequestParam(value="realName",required=false) String realName,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("orgTreeId", getOrgTreeId(request));
        params.put("userId", getLoginUserId(request));
        params.put("activityId", activityId);
        params.put("juryId", juryId);
        params.put("realName", realName);
        params.put("ip", request.getRemoteAddr());

        /**
         * 添加活动信息
         */
        ClientUtil.getStringClient(ClientURL.ADD_AC_JURY, params);
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("activityId", activityId);
		mav.setViewName("redirect:/manage/activity/jury/list.action");
        return mav;
	}
}
