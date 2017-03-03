/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Jock
 */
package cn.chineseall.book.controller.manage;

import java.io.IOException;
import java.io.PrintWriter;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.controller.BaseController;
import cn.chineseall.model.activity.AcBaseinfo;
import cn.chineseall.model.activity.AcConfig;
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
public class ActivityManageController extends BaseController {
    
	@Resource(type=org.apache.commons.configuration.PropertiesConfiguration.class)
    private PropertiesConfiguration fileUploadConfig;
	
	@RequestMapping("/activity/list")
    public ModelAndView orgActivity(@RequestParam(required = false, value = "activityName") String activityName,
    		@RequestParam(required = false, value = "activityState") Integer activityState,
    		@RequestParam(required = false, value = "activityType") Integer activityType,
    		@RequestParam(required = false, value = "currentPage") Integer currentPage,
            HttpServletRequest request)
            throws Exception {

		if(currentPage==null || currentPage<=0){
			currentPage=1;
		}
		int pageSize=4;
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("orgTreeId", getOrgTreeId(request));
        mav.getModelMap().put("activityState", activityState);
        mav.getModelMap().put("activityType", activityType);
        mav.getModelMap().put("activityName", activityName);
        mav.getModelMap().put("currentPage", currentPage);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orgTreeId", getOrgTreeId(request));
        params.put("activityName", activityName);
        params.put("activityType", activityType);
        params.put("activityState", activityState);
        params.put("currentPage", currentPage);
        params.put("pageSize", pageSize);

        /**
         * 获取机构活动列表
         */
        String returnStr = ClientUtil.getStringClient(ClientURL.LIST_ORG_ACTIVITYS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	String queryCondition = RequestUtil.getQueryCondition(request);
         	PageUtil pageUtil = new PageUtil(JsonUtil.jsonToList(returnStr, "list", AcBaseinfo.class), JsonUtil.jsonToObject(returnStr, "count", Integer.class), pageSize, currentPage);
            mav.getModelMap().put("pageUtil", pageUtil);
            mav.getModelMap().put("queryCondition", queryCondition);
        	mav.getModelMap().put("activitys", JsonUtil.jsonToList(returnStr, "list", AcBaseinfo.class));
        }

        mav.setViewName("/manage/activity/listActivity");
        return mav;
    }
	/**
	 * 跳转到活动基本信息页面
	 * @param orgTreeId
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/activity")
    public ModelAndView orgActivity(@RequestParam(value="activityId",required=false) Long activityId,
    		HttpServletRequest request)
            throws Exception {
		ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("orgTreeId", getOrgTreeId(request));
		if(activityId!=null){
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
	         * 获取活动配置信息
	         */
	        returnStr=ClientUtil.getStringClient(ClientURL.GET_AC_CONFIG, params);
	        if(returnStr!=null && !"".equals(returnStr)){
	        	mav.getModelMap().put("acconfig", JsonUtil.jsonToObject(returnStr, "acconfig", AcConfig.class));
	        }
	        mav.getModelMap().put("activityId", activityId);
			mav.setViewName("/manage/activity/updateActivity");
		}else{
			 mav.setViewName("/manage/activity/activity");
		}
        return mav;
    }
	/**
	 * 修改活动状态
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/activity/chanage/state")
	public void addWorksPicture(@RequestParam(value="activityId",required=false) Long activityId,
			@RequestParam(value="activityState",required=false) Integer activityState,ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
        try{
        	Map<String, Object> params = new HashMap<String, Object>();
            params.put("activityId", activityId);
            params.put("activityState", activityState);
    		String result=ClientUtil.getStringClient(ClientURL.UPDATE_ACTIVITY_STATE, params);
            PrintWriter out;
    		out = response.getWriter();
    		out.print(result);
        } catch (IOException e){
            e.printStackTrace();
        }
	}
	/**
	 * 增加活动
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
    @RequestMapping("/activity/add")
	public ModelAndView addActivity(@RequestParam(value="activityType",required=false) Integer activityType,
			@RequestParam(value="activityName",required=false) String activityName,
			@RequestParam(value="submitStart",required=false) String submitStart,
			@RequestParam(value="submitEnd",required=false) String submitEnd,
			@RequestParam(value="finishDate",required=false) String finishDate,
			@RequestParam(value="description",required=false) String description,
			@RequestParam(value="joinLimit",required=false) Integer joinLimit,
			@RequestParam(value="group",required=false) String[] groups,
			@RequestParam(value="worksModule",required=false) Integer worksModule,
			@RequestParam(value="evaluateModule",required=false) Integer evaluateModule,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String, Object> params = new HashMap<String, Object>();
        params.put("orgTreeId", getOrgTreeId(request));
        params.put("userId", getLoginUserId(request));
        params.put("activityType", activityType);
        params.put("activityName", activityName);
        params.put("submitStart", submitStart);
        params.put("submitEnd", submitEnd);
        params.put("finishDate", finishDate);
        params.put("description", description);
        params.put("joinLimit", joinLimit);
        params.put("groups", groups);
        params.put("worksModule", worksModule);
        params.put("evaluateModule", evaluateModule);
        params.put("userId", getLoginUserId(request));

        /**
         * 添加活动信息
         */
        Long activityId=null;
        String returnStr=ClientUtil.getStringClient(ClientURL.ADD_AC_BASEINFO, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	activityId=JsonUtil.jsonToObject(returnStr, "id", Long.class);
        }
        params.put("activityId",activityId);
        ModelAndView mav = new ModelAndView();
        /**
         * 获取活动信息
         */
        returnStr=ClientUtil.getStringClient(ClientURL.GET_ACTIVITY_DETAIL, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("activity", JsonUtil.jsonToObject(returnStr, "activity", AcBaseinfo.class));
        }
        mav.getModelMap().put("activityId", activityId);
        mav.getModelMap().put("orgTreeId", getOrgTreeId(request));
        mav.setViewName("/manage/activity/ok");
        return mav;
	}
   /**
	 * 修改活动信息
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
    @RequestMapping("/activity/update")
	public ModelAndView updateActivity(@RequestParam(value="activityId") Long activityId,
			@RequestParam(value="activityType") Integer activityType,
			@RequestParam(value="activityName") String activityName,
			@RequestParam(value="submitStart") String submitStart,
			@RequestParam(value="submitEnd") String submitEnd,
			@RequestParam(value="finishDate",required=false) String finishDate,
			@RequestParam(value="description") String description,
			@RequestParam(value="joinLimit") Integer joinLimit,
			@RequestParam(value="worksModule") Integer worksModule,
			@RequestParam(value="evaluateModule") Long evaluateModule,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("activityId", activityId);
    	params.put("orgTreeId", getOrgTreeId(request));
        params.put("userId", getLoginUserId(request));
        params.put("activityType", activityType);
        params.put("activityName", activityName);
        params.put("submitStart", submitStart);
        params.put("submitEnd", submitEnd);
        params.put("finishDate", finishDate);
        params.put("description", description);
        params.put("joinLimit", joinLimit);
        params.put("worksModule", worksModule);
        params.put("evaluateModule", evaluateModule);
        params.put("userId", "2");

        /**
         * 保存活动信息
         */
        ClientUtil.getStringClient(ClientURL.UPDATE_AC_BASEINFO, params);
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("activityId", activityId);
        mav.setViewName("redirect:/manage/activity.action");
        return mav;
	}
    
    /**
	 * 跳转到活动logo或banner设置页面
	 * @param activityId
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/activity/logo")
    public ModelAndView logoOrBanner(@RequestParam(value="activityId",required=false) Long activityId,
    		@RequestParam(value="type",required=false) Integer type,
    		HttpServletRequest request)
            throws Exception {
		ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("orgTreeId", getOrgTreeId(request));
        mav.getModelMap().put("activityId", activityId);
        mav.getModelMap().put("type", type);
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
         * 获取活动配置信息
         */
        returnStr=ClientUtil.getStringClient(ClientURL.GET_AC_CONFIG, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("acconfig", JsonUtil.jsonToObject(returnStr, "acconfig", AcConfig.class));
        }
		mav.setViewName("/manage/activity/logoOrBanner");
        return mav;
    }
    /**
	 * 上传活动logo或banner
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/activity/add/logo")
	public void addLogoOrBanner(@RequestParam(value="picFile",required=false) MultipartFile multipartFile,ModelMap model,
			@RequestParam(value="type",required=false) Integer type,
			@RequestParam(value="activityId",required=false) Integer activityId,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
        try{
        	String srcPath="";
        	String imgFileFileName="";
        	if(multipartFile!=null && multipartFile.getSize()!=0){
	        	if(type==null){
	        		//取得文件名字
		            imgFileFileName=System.currentTimeMillis()+"."+multipartFile.getOriginalFilename().split("\\.")[1];
		            srcPath="/activity/logo/"+activityId+"/";
	        	}else{
	        		//取得文件名字
		            imgFileFileName=System.currentTimeMillis()+"."+multipartFile.getOriginalFilename().split("\\.")[1];
		            srcPath="/activity/banner/"+activityId+"/";
	        	}
	            String baseDir = fileUploadConfig.getString("image_upload_base_dir");
	            uploadImg(baseDir, srcPath,imgFileFileName, multipartFile);
	        }
        	PrintWriter out;
    		out = response.getWriter();
    		out.print("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /></head><body><script type='text/javascript'>parent.callback('"+srcPath+imgFileFileName+"');</script></body></html>");
        } catch (IOException e){
            e.printStackTrace();
        }
	}
	
	 /**
	 * 保存活动logo或banner
	 * @param activityId
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/activity/save/logo")
    public ModelAndView saveLogoOrBanner(@RequestParam(value="activityId",required=false) Long activityId,
    		@RequestParam(value="type",required=false) Integer type,
    		@RequestParam(value="picSrc") String picSrc,
    		HttpServletRequest request)
            throws Exception {
		ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("activityId", activityId);
        mav.getModelMap().put("type", type);
        
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("activityId", activityId);
		params.put("type", type);
		params.put("picSrc", picSrc);
		
		/**
         * 修改活动logo或banner
         */
        ClientUtil.getStringClient(ClientURL.UPDATE_AC_LOGO_OR_BANNER, params);
		mav.setViewName("redirect:/manage/activity/logo.action");
        return mav;
    }
}
