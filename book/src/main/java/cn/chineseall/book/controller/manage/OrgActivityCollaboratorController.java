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
import cn.chineseall.model.activity.AcCollaborator;
import cn.chineseall.model.org.OrgTree;
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
public class OrgActivityCollaboratorController extends BaseController {
    
	/**
	 * 活动协办者管理
	 * @param activityId
	 * @param type
	 * @param key
	 * @param currentPage
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/activity/collaborator/list")
    public ModelAndView acCollaborators(@RequestParam("activityId") Long activityId,
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
        params.put("key", key);
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
        if(type==null){
        	 /**
             * 获取协办者列表
             */
            returnStr = ClientUtil.getStringClient(ClientURL.LIST_AC_COLLABORATOR, params);
            if(returnStr!=null && !"".equals(returnStr)){
            	String queryCondition = RequestUtil.getQueryCondition(request);
            	PageUtil pageUtil = new PageUtil(JsonUtil.jsonToList(returnStr, "list", AcCollaborator.class), JsonUtil.jsonToObject(returnStr, "count", Integer.class), pageSize, currentPage);
                mav.getModelMap().put("pageUtil", pageUtil);
                mav.getModelMap().put("queryCondition", queryCondition);
                
            	mav.getModelMap().put("collabortors", JsonUtil.jsonToList(returnStr, "list", AcCollaborator.class));
            	mav.getModelMap().put("collabortorsCount", JsonUtil.jsonToObject(returnStr, "count", Integer.class));
            }
            mav.setViewName("/manage/activity/listCollaborator");
        }else{
        	 /**
             * 查询机构列表
             */
            returnStr = ClientUtil.getStringClient(ClientURL.LIST_ORGS_BYKEY, params);
            if(returnStr!=null && !"".equals(returnStr)){
            	String queryCondition = RequestUtil.getQueryCondition(request);
            	PageUtil pageUtil = new PageUtil(JsonUtil.jsonToList(returnStr, "list", OrgTree.class), JsonUtil.jsonToObject(returnStr, "count", Integer.class), pageSize, currentPage);
                mav.getModelMap().put("pageUtil", pageUtil);
                mav.getModelMap().put("queryCondition", queryCondition);
                
            	mav.getModelMap().put("orgs", JsonUtil.jsonToList(returnStr, "list", OrgTree.class));
            	mav.getModelMap().put("orgsCount", JsonUtil.jsonToObject(returnStr, "count", Integer.class));
            }
            mav.setViewName("/manage/activity/addCollaborator");
        }

        return mav;
    }
	/**
	 * 删除活动协办者
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/activity/collaborator/del")
	public ModelAndView delAcCollaborators(@RequestParam(value="activityId") Long activityId,
			@RequestParam(value="collaboratorId") Long[] collaboratorId,ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
        	Map<String, Object> params = new HashMap<String, Object>();
            params.put("activityId", activityId);
            params.put("collaboratorId", collaboratorId);
    		ClientUtil.getStringClient(ClientURL.DEL_AC_COLLABORATORS, params);
    		ModelAndView mav = new ModelAndView();
            mav.getModelMap().put("activityId", activityId);
    		mav.setViewName("redirect:/manage/activity/collaborator/list.action");
    		return mav;
	}
	/**
	 * 增加活动协办者信息
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
    @RequestMapping("/activity/collaborator/add")
	public ModelAndView addAcCollaborators(@RequestParam(value="activityId") Long activityId,
			@RequestParam(value="orgCollTreeId",required=false) Long[] orgCollTreeId,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("orgTreeId", orgCollTreeId);
        params.put("userId", getLoginUserId(request));
        params.put("activityId", activityId);

        /**
         * 添加活动信息
         */
        ClientUtil.getStringClient(ClientURL.ADD_AC_COLLABORATORS, params);
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("activityId", activityId);
		mav.setViewName("redirect:/manage/activity/collaborator/list.action");
        return mav;
	}
}
