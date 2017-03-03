/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Jock
 */
package cn.chineseall.book.controller.activity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
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
import cn.chineseall.book.service.APIService;
import cn.chineseall.model.activity.AcBaseinfo;
import cn.chineseall.model.activity.AcBulletin;
import cn.chineseall.model.activity.AcConfig;
import cn.chineseall.model.activity.AcWorksGroup;
import cn.chineseall.model.activity.AcWorksReview;
import cn.chineseall.model.activity.vo.AcWorks;
import cn.chineseall.model.book.Book;
import cn.chineseall.model.org.OrgTree;
import cn.chineseall.model.org.vo.OrganizationView;
import cn.chineseall.model.user.UserBaseinfo;
import cn.chineseall.model.user.vo.UserInfo;
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
@RequestMapping("/activity")
public class ActivityController extends BaseController {
	
	@Resource(name = "apiConfig")
	private PropertiesConfiguration apiConfig;
    
    @Resource
    private APIService apiService;
    
	@Resource(type=org.apache.commons.configuration.PropertiesConfiguration.class)
    private PropertiesConfiguration fileUploadConfig;
	
	@RequestMapping("/index")
    public ModelAndView index(@RequestParam("activityId") Long activityId,
    		@RequestParam(required = false, value = "currentPage") Integer currentPage,
            HttpServletRequest request)
            throws Exception {

		if(currentPage==null || currentPage<=0){
			currentPage=1;
		}
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("activityId", activityId);
        mav.getModelMap().put("orgTreeId", getOrgTreeId(request));

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("activityId", activityId);

        /**
         * 获取活动内容
         */
        String returnStr = ClientUtil.getStringClient(ClientURL.GET_ACTIVITY_DETAIL, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	AcBaseinfo activity=JsonUtil.jsonToObject(returnStr, "activity", AcBaseinfo.class);
        	if(activity==null){
        		mav.setViewName("redirect:/error.action?errorCode=a0004");
        		return mav;
        	}
        	mav.getModelMap().put("activity", activity);
        }
        
        /**
         * 获取活动书单
         */
        params.put("pageSize", 15);
        params.put("currentPage", 1);
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_BOOKS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("books", JsonUtil.jsonToList(returnStr, "list", Book.class));
        }
        /**
         * 获取作品列表
         */
        params.put("pageSize", 20);
        params.put("currentPage", 1);
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_WORKS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("works", JsonUtil.jsonToList(returnStr, "list", AcWorks.class));
        }
        /**
         * 获取公告列表
         */
        params.put("pageSize", 6);
        params.put("currentPage", 1);
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_BULLETIN, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("bulletins", JsonUtil.jsonToList(returnStr, "list", AcBulletin.class));
        	mav.getModelMap().put("bulletinsCount", JsonUtil.jsonToObject(returnStr, "count", Integer.class));
        }
        /**
         * 获取主办机构和协办机构
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_ORGS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("orgs", JsonUtil.jsonToList(returnStr, "list", OrganizationView.class));
        }
        /**
         * 获取活动参与人
         */
        params.put("pageSize", 8);
        params.put("currentPage", 1);
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_JOIN_USERS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("users", JsonUtil.jsonToList(returnStr, "list", UserInfo.class));
        }
        /**
         * 获取赞最多的作品
         */
        params.put("pageSize", 10);
        params.put("currentPage", 1);
        params.put("orderBy", "flowers_count");
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_WORKS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("flowerWorks", JsonUtil.jsonToList(returnStr, "list", AcWorks.class));
        }
        /**
         * 获取评论最多的作品
         */
        params.put("pageSize", 10);
        params.put("currentPage", 1);
        params.put("orderBy", "review_count");
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_WORKS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("reviewWorks", JsonUtil.jsonToList(returnStr, "list", AcWorks.class));
        }
        request.setAttribute("imgDomainName", fileUploadConfig.getString("img_domain"));
        setStaticModel(ImageUtils.class, request);
        mav.setViewName("/activity/index");
        return mav;
    }
	
	@RequestMapping("/bulletin")
    public ModelAndView bulletin(@RequestParam("activityId") Long activityId,
    		@RequestParam("bulletinId") Long bulletinId,
            HttpServletRequest request)
            throws Exception {

        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("activityId", activityId);
        mav.getModelMap().put("orgTreeId", getOrgTreeId(request));

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("activityId", activityId);
        params.put("bulletinId", bulletinId);

        /**
         * 获取活动内容
         */
        String returnStr = ClientUtil.getStringClient(ClientURL.GET_ACTIVITY_DETAIL, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	AcBaseinfo activity=JsonUtil.jsonToObject(returnStr, "activity", AcBaseinfo.class);
        	if(activity==null){
        		mav.setViewName("redirect:/error.action?errorCode=a0004");
        		return mav;
        	}
        	mav.getModelMap().put("activity", activity);
        }
        
        /**
         * 获取活动公告详情
         */
        returnStr = ClientUtil.getStringClient(ClientURL.GET_AC_BULLETIN, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("bulletin", JsonUtil.jsonToObject(returnStr, "bulletin", AcBulletin.class));
        }
        /**
         * 获取作品列表
         */
        params.put("pageSize", 20);
        params.put("currentPage", 1);
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_WORKS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("works", JsonUtil.jsonToList(returnStr, "list", AcWorks.class));
        }
        /**
         * 获取公告列表
         */
        params.put("pageSize", 6);
        params.put("currentPage", 1);
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_BULLETIN, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("bulletins", JsonUtil.jsonToList(returnStr, "list", AcBulletin.class));
        	mav.getModelMap().put("bulletinsCount", JsonUtil.jsonToObject(returnStr, "count", Integer.class));
        }
        /**
         * 获取主办机构和协办机构
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_ORGS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("orgs", JsonUtil.jsonToList(returnStr, "list", OrganizationView.class));
        }
        
        /**
         * 获取活动参与人
         */
        params.put("pageSize", 8);
        params.put("currentPage", 1);
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_JOIN_USERS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("users", JsonUtil.jsonToList(returnStr, "list", UserInfo.class));
        }
        /**
         * 获取赞最多的作品
         */
        params.put("pageSize", 10);
        params.put("currentPage", 1);
        params.put("orderBy", "flowers_count");
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_WORKS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("flowerWorks", JsonUtil.jsonToList(returnStr, "list", AcWorks.class));
        }
        /**
         * 获取评论最多的作品
         */
        params.put("pageSize", 10);
        params.put("currentPage", 1);
        params.put("orderBy", "review_count");
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_WORKS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("reviewWorks", JsonUtil.jsonToList(returnStr, "list", AcWorks.class));
        }
        
        request.setAttribute("imgDomainName", fileUploadConfig.getString("img_domain"));
        setStaticModel(ImageUtils.class, request);
        mav.setViewName("/activity/bulletin");
        return mav;
    }
	
	@RequestMapping("/book")
    public ModelAndView acBooks(@RequestParam("activityId") Long activityId,
    		@RequestParam(required = false, value = "currentPage") Integer currentPage,
            HttpServletRequest request)
            throws Exception {

		if(currentPage==null || currentPage<=0){
			currentPage=1;
		}
        
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("activityId", activityId);
        mav.getModelMap().put("currentPage", currentPage);
        mav.getModelMap().put("orgTreeId", getOrgTreeId(request));
        
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("activityId", activityId);

        /**
         * 获取活动内容
         */
        String returnStr = ClientUtil.getStringClient(ClientURL.GET_ACTIVITY_DETAIL, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	AcBaseinfo activity=JsonUtil.jsonToObject(returnStr, "activity", AcBaseinfo.class);
        	if(activity==null){
        		mav.setViewName("redirect:/error.action?errorCode=a0004");
        		return mav;
        	}
        	mav.getModelMap().put("activity", activity);
        }
        
        /**
         * 获取活动书单
         */
        params.put("pageSize", 20);
        params.put("currentPage", currentPage);
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_BOOKS, params);
        if(returnStr!=null && !"".equals(returnStr)){
            String queryCondition = RequestUtil.getQueryCondition(request);
        	PageUtil pageUtil = new PageUtil(JsonUtil.jsonToList(returnStr, "list", Book.class), JsonUtil.jsonToObject(returnStr, "count", Integer.class), 20, currentPage);
            mav.getModelMap().put("pageUtil", pageUtil);
            mav.getModelMap().put("queryCondition", queryCondition);
            
        	mav.getModelMap().put("books", JsonUtil.jsonToList(returnStr, "list", Book.class));
        	mav.getModelMap().put("currentPage", currentPage);
        	mav.getModelMap().put("pageSize", 20);
        	mav.getModelMap().put("count", JsonUtil.jsonToObject(returnStr, "count", Integer.class));
        }
        /**
         * 获取公告列表
         */
        params.put("pageSize", 6);
        params.put("currentPage", 1);
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_BULLETIN, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("bulletins", JsonUtil.jsonToList(returnStr, "list", AcBulletin.class));
        }
        /**
         * 获取主办机构和协办机构
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_ORGS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("orgs", JsonUtil.jsonToList(returnStr, "list", OrganizationView.class));
        }
        
        /**
         * 获取活动参与人
         */
        params.put("pageSize", 8);
        params.put("currentPage", 1);
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_JOIN_USERS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("users", JsonUtil.jsonToList(returnStr, "list", UserInfo.class));
        }

        request.setAttribute("imgDomainName", fileUploadConfig.getString("img_domain"));
        setStaticModel(ImageUtils.class, request);
        mav.setViewName("/activity/books");
        return mav;
    }
	
	@RequestMapping("/joinusers")
    public ModelAndView joinUsers(@RequestParam("activityId") Long activityId,
    		@RequestParam(required = false, value = "currentPage") Integer currentPage,
            HttpServletRequest request)
            throws Exception {

		if(currentPage==null || currentPage<=0){
			currentPage=1;
		}
		
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("activityId", activityId);
        mav.getModelMap().put("currentPage", currentPage);
        mav.getModelMap().put("orgTreeId", getOrgTreeId(request));
        
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("activityId", activityId);

        /**
         * 获取活动内容
         */
        String returnStr = ClientUtil.getStringClient(ClientURL.GET_ACTIVITY_DETAIL, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	AcBaseinfo activity=JsonUtil.jsonToObject(returnStr, "activity", AcBaseinfo.class);
        	if(activity==null){
        		mav.setViewName("redirect:/error.action?errorCode=a0004");
        		return mav;
        	}
        	mav.getModelMap().put("activity", activity);
        }
        
        /**
         * 获取活动参与人
         */
        params.put("pageSize", 30);
        params.put("currentPage", currentPage);
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_JOIN_USERS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	String queryCondition = RequestUtil.getQueryCondition(request);
         	PageUtil pageUtil = new PageUtil(null, JsonUtil.jsonToObject(returnStr, "count", Integer.class), 8, currentPage);
            mav.getModelMap().put("pageUtil", pageUtil);
            mav.getModelMap().put("queryCondition", queryCondition);
             
        	mav.getModelMap().put("users", JsonUtil.jsonToList(returnStr, "list", UserInfo.class));
        	mav.getModelMap().put("currentPage", currentPage);
        	mav.getModelMap().put("pageSize", 8);
        	mav.getModelMap().put("count", JsonUtil.jsonToObject(returnStr, "count", Integer.class));
        }
        /**
         * 获取赞最多的作品
         */
        params.put("pageSize", 10);
        params.put("currentPage", 1);
        params.put("orderBy", "flowers_count");
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_WORKS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("flowerWorks", JsonUtil.jsonToList(returnStr, "list", AcWorks.class));
        }
        /**
         * 获取评论最多的作品
         */
        params.put("pageSize", 10);
        params.put("currentPage", 1);
        params.put("orderBy", "review_count");
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_WORKS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("reviewWorks", JsonUtil.jsonToList(returnStr, "list", AcWorks.class));
        }

        request.setAttribute("imgDomainName", fileUploadConfig.getString("img_domain"));
        setStaticModel(ImageUtils.class, request);
        mav.setViewName("/activity/joinUsers");
        return mav;
    }
	
	@RequestMapping("/works")
    public ModelAndView works(@RequestParam("activityId") Long activityId,
    		@RequestParam(required = false, value = "orgTreeId") String orgTreeId,
    		@RequestParam(required = false, value = "groupId") Long groupId,
    		@RequestParam(required = false, value = "type") Integer type,
    		@RequestParam(required = false, value = "currentPage") Integer currentPage,
            HttpServletRequest request)
            throws Exception {

		if(currentPage==null || currentPage<=0){
			currentPage=1;
		}
		
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("activityId", activityId);
        mav.getModelMap().put("orgTreeId", orgTreeId);
        mav.getModelMap().put("groupId", groupId);
        mav.getModelMap().put("currentPage", currentPage);
        mav.getModelMap().put("type", type);
        
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("activityId", activityId);
        params.put("groupId", groupId);
        params.put("orgTreeId", orgTreeId);
        
        /**
         * 获取活动内容
         */
        AcBaseinfo activity=null;
        String returnStr = ClientUtil.getStringClient(ClientURL.GET_ACTIVITY_DETAIL, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	activity=JsonUtil.jsonToObject(returnStr, "activity", AcBaseinfo.class);
        	if(activity==null){
        		mav.setViewName("redirect:/error.action?errorCode=a0004");
        		return mav;
        	}
        	mav.getModelMap().put("activity", activity);
        }
        /**
         * 获取当前所选机构列表信息
         */
        params.put("parentOrgTreeId", activity.getOrgTreeId());
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_PARENTS_ORG_TREE, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("parentOrgTrees", JsonUtil.jsonToList(returnStr, "list", OrgTree.class));
        }
        /**
         * 获取下级机构列表
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_SUB_ORGS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("subOrgs", JsonUtil.jsonToList(returnStr, "list", OrgTree.class));
        }
        /**
         * 获取自定义分组列表
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_GROUPS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("groups", JsonUtil.jsonToList(returnStr, "list", AcWorksGroup.class));
        }
        /**
         * 获取作品列表
         */
        params.put("pageSize", 20);
        params.put("currentPage", currentPage);
        if(type!=null && type==2){
        	params.put("orderBy", "flowers_count");
        }else if(type!=null && type==3){
        	params.put("orderBy", "review_count");
        }else{
        	params.put("orderBy", "works_id");
        }
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_WORKS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	String queryCondition = RequestUtil.getQueryCondition(request);
         	PageUtil pageUtil = new PageUtil(null, JsonUtil.jsonToObject(returnStr, "count", Integer.class),20, currentPage);
            mav.getModelMap().put("pageUtil", pageUtil);
            mav.getModelMap().put("queryCondition", queryCondition);
             
        	mav.getModelMap().put("works", JsonUtil.jsonToList(returnStr, "list", AcWorks.class));
        	mav.getModelMap().put("worksCount", JsonUtil.jsonToObject(returnStr, "count", Integer.class));
        	mav.getModelMap().put("currentPage", currentPage);
        	mav.getModelMap().put("pageSize", 20);
        }
        
        /**
         * 获取赞最多的作品
         */
        params.put("pageSize", 10);
        params.put("currentPage", 1);
        params.put("orderBy", "flowers_count");
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_WORKS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("flowerWorks", JsonUtil.jsonToList(returnStr, "list", AcWorks.class));
        }
        /**
         * 获取评论最多的作品
         */
        params.put("pageSize", 10);
        params.put("currentPage", 1);
        params.put("orderBy", "review_count");
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_WORKS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("reviewWorks", JsonUtil.jsonToList(returnStr, "list", AcWorks.class));
        }

        request.setAttribute("imgDomainName", fileUploadConfig.getString("img_domain"));
        setStaticModel(ImageUtils.class, request);
        mav.setViewName("/activity/works");
        return mav;
    }
	
	@RequestMapping("/work")
    public ModelAndView work(@RequestParam("activityId") Long activityId,
    		@RequestParam("worksId") Long worksId,
    		@RequestParam(required = false, value = "currentPage") Integer currentPage,
            HttpServletRequest request)
            throws Exception {

		if(currentPage==null || currentPage<=0){
			currentPage=1;
		}
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("activityId", activityId);
        mav.getModelMap().put("worksId", worksId);
        mav.getModelMap().put("currentPage", currentPage);
        mav.getModelMap().put("orgTreeId", getOrgTreeId(request));
        
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("activityId", activityId);
        params.put("worksId", worksId);

        /**
         * 获取活动内容
         */
        String returnStr = ClientUtil.getStringClient(ClientURL.GET_ACTIVITY_DETAIL, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	AcBaseinfo activity=JsonUtil.jsonToObject(returnStr, "activity", AcBaseinfo.class);
        	if(activity==null){
        		mav.setViewName("redirect:/error.action?errorCode=a0004");
        		return mav;
        	}
        	mav.getModelMap().put("activity", activity);
        }
        /**
         * 获取作品信息
         */
        returnStr = ClientUtil.getStringClient(ClientURL.GET_ACTIVITY_WORK, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	Long userId=getLoginUserId(request);
        	AcWorks acWorks=JsonUtil.jsonToObject(returnStr, "work", AcWorks.class);
        	if(acWorks!=null && acWorks.getAuditState()!=1){
        		if(userId==null || userId.longValue()!=acWorks.getUserId()){
        			mav.setViewName("redirect:/error.action?errorCode=a0011");
            		return mav;
        		}
        	}
        	mav.getModelMap().put("work",acWorks);
        }
        /**
         * 获取作品评论信息
         */
        params.put("currentPage", currentPage);
        params.put("pageSize", 10);
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_WORK_REVIEWS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	String queryCondition = RequestUtil.getQueryCondition(request);
         	PageUtil pageUtil = new PageUtil(JsonUtil.jsonToList(returnStr, "list", AcWorksReview.class), JsonUtil.jsonToObject(returnStr, "count", Integer.class), 10, currentPage);
            mav.getModelMap().put("pageUtil", pageUtil);
            mav.getModelMap().put("queryCondition", queryCondition);
            
        	mav.getModelMap().put("workReviews", JsonUtil.jsonToList(returnStr, "list", AcWorksReview.class));
        	mav.getModelMap().put("workReviewsCount", JsonUtil.jsonToObject(returnStr, "count", Integer.class));
        	mav.getModelMap().put("currentPage", currentPage);
        	mav.getModelMap().put("pageSize", 10);
        }
        /**
         * 获取赞最多的作品
         */
        params.put("pageSize", 10);
        params.put("currentPage", 1);
        params.put("orderBy", "flowers_count");
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_WORKS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("flowerWorks", JsonUtil.jsonToList(returnStr, "list", AcWorks.class));
        }
        /**
         * 获取评论最多的作品
         */
        params.put("pageSize", 10);
        params.put("currentPage", 1);
        params.put("orderBy", "review_count");
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_WORKS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("reviewWorks", JsonUtil.jsonToList(returnStr, "list", AcWorks.class));
        }

        request.setAttribute("imgDomainName", fileUploadConfig.getString("img_domain"));
        setStaticModel(ImageUtils.class, request);
        mav.setViewName("/activity/work");
        return mav;
    }
	
	@RequestMapping("/upload/work")
    public ModelAndView uploadWork(@RequestParam("activityId") Long activityId,
            HttpServletRequest request)
            throws Exception {

        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("activityId", activityId);
        mav.getModelMap().put("orgTreeId", getOrgTreeId(request));
        
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("activityId", activityId);
        params.put("userId", getLoginUserId(request));

        /**
         * 获取活动内容
         */
        String returnStr = ClientUtil.getStringClient(ClientURL.GET_ACTIVITY_DETAIL, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	AcBaseinfo activity=JsonUtil.jsonToObject(returnStr, "activity", AcBaseinfo.class);
        	if(activity==null){
        		mav.setViewName("redirect:/error.action?errorCode=a0004");
        		return mav;
        	}else if(activity.getActivityState()==1){
        		mav.setViewName("redirect:/error.action?errorCode=a0006");
        		return mav;
        	}else if(activity.getActivityState()==3){
        		mav.setViewName("redirect:/error.action?errorCode=a0007");
        		return mav;
        	}else if(activity.getActivityState()==4){
        		mav.setViewName("redirect:/error.action?errorCode=a0008");
        		return mav;
        	}
        	mav.getModelMap().put("activity", activity);
        }
        /**
         * 获取活动配置信息
         */
        returnStr=ClientUtil.getStringClient(ClientURL.GET_AC_CONFIG, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	AcConfig acconfig=JsonUtil.jsonToObject(returnStr, "acconfig", AcConfig.class);
        	if(acconfig==null){
        		mav.setViewName("redirect:/error.action?errorCode=a0004");
        		return mav;
        	}else if(acconfig.getJoinLimit()!=3){
        		/**
                 * 获取用户审核状态
                 */
                returnStr = ClientUtil.getStringClient(ClientURL.GET_USER_AUDIT, params);
                if(returnStr!=null && !"".equals(returnStr)){
                	Integer audit=JsonUtil.jsonToObject(returnStr, "audit", Integer.class);
                	if(audit==0){
                		mav.setViewName("redirect:/error.action?errorCode=a0009");
                		return mav;
                	}
                }
        	}
        	mav.getModelMap().put("acconfig", acconfig);
        }
        /**
         * 获取用户信息
         */
        returnStr = ClientUtil.getStringClient(ClientURL.GET_USER_BASE_INFO, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	List<UserBaseinfo> userList=JsonUtil.jsonToList(returnStr, "list", UserBaseinfo.class);
        	if(userList!=null && userList.size()>0){
        		mav.getModelMap().put("user", userList.get(0));
        	}
        }
        /**
         * 获取用户参加权限
         */
        returnStr = ClientUtil.getStringClient(ClientURL.GET_USER_JOIN_LIMIT, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	Long userOrgTreeId=JsonUtil.jsonToObject(returnStr, "treeId", Long.class);
        	if(userOrgTreeId==null){
            	mav.setViewName("redirect:/error.action?errorCode=a0009");
        		return mav;
            }else{
            	mav.getModelMap().put("userOrgTreeId", userOrgTreeId);
            }
        }
        /**
         * 获取机构信息
         */
        returnStr = ClientUtil.getStringClient(ClientURL.GET_ORG_TREE, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	OrgTree orgTree=JsonUtil.jsonToObject(returnStr, "list", OrgTree.class);
        	if(orgTree!=null){
        		mav.getModelMap().put("orgTree", orgTree);
        	}
        }
        /**
         * 获取自定义分组列表
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_GROUPS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("groups", JsonUtil.jsonToList(returnStr, "list", AcWorksGroup.class));
        }
        /**
         * 获取活动内容
         */
        returnStr = ClientUtil.getStringClient(ClientURL.GET_ACTIVITY_DETAIL, params);
        String viewName="/activity/uploadWork";
        if(returnStr!=null && !"".equals(returnStr)){
        	AcBaseinfo activity=JsonUtil.jsonToObject(returnStr, "activity", AcBaseinfo.class);
        	if(activity==null){
        		mav.setViewName("redirect:/error.action?errorCode=a0004");
        		return mav;
        	}else if(activity.getActivityType()==3 || activity.getActivityType()==4){
            		viewName="/activity/uploadPicWork";
        	}
        	mav.getModelMap().put("activity", activity);
        }
        /**
         * 获取公告列表
         */
        params.put("pageSize", 6);
        params.put("currentPage", 1);
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_BULLETIN, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("bulletins", JsonUtil.jsonToList(returnStr, "list", AcBulletin.class));
        	mav.getModelMap().put("bulletinsCount", JsonUtil.jsonToObject(returnStr, "count", Integer.class));
        }
        /**
         * 获取主办机构和协办机构
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_ORGS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("orgs", JsonUtil.jsonToList(returnStr, "list", OrganizationView.class));
        }
        
        /**
         * 获取活动参与人
         */
        params.put("pageSize", 8);
        params.put("currentPage", 1);
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_JOIN_USERS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("users", JsonUtil.jsonToList(returnStr, "list", UserInfo.class));
        }

        request.setAttribute("imgDomainName", fileUploadConfig.getString("img_domain"));
        setStaticModel(ImageUtils.class, request);
        mav.setViewName(viewName);
        return mav;
    }
	/**
	 * 添加作品
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/add/work")
	public ModelAndView addWork(@RequestParam(value = "activityId" , required = false)Long activityId,
			@RequestParam(value = "groupId" , required = false)Long groupId,
			@RequestParam(value = "worksName" , required = false)String worksName,
			@RequestParam(value = "worksContent" , required = false)String worksContent,
			@RequestParam(value = "realName")String realName,
			@RequestParam(value = "guide" , required = false)String guide,
			@RequestParam(value = "description" , required = false)String description,
			@RequestParam(value = "picPath" , required = false)String picPath,
			@RequestParam(value = "className")String className,
			@RequestParam(value = "phone" , required = false)String phone,
			@RequestParam(value = "address" , required = false)String address,
			@RequestParam(value = "email" , required = false)String email,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("activityId", activityId);
        params.put("groupId", groupId);
        params.put("worksName", worksName);
        params.put("worksContent", worksContent);
        params.put("realName", realName);
        params.put("guide", guide);
        params.put("description", description);
        params.put("picPath", picPath);
        params.put("className", className);
        params.put("phone", phone);
        params.put("address", address);
        params.put("email", email);
        params.put("userId", getLoginUserId(request));
        params.put("orgTreeId", getOrgTreeId(request));
        
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("activityId", activityId);
        /**
         * 获取活动内容
         */
        String returnStr = ClientUtil.getStringClient(ClientURL.GET_ACTIVITY_DETAIL, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	AcBaseinfo activity=JsonUtil.jsonToObject(returnStr, "activity", AcBaseinfo.class);
        	if(activity==null){
        		mav.setViewName("redirect:/error.action?errorCode=a0004");
        		return mav;
        	}else if(activity.getActivityState()==1){
        		mav.setViewName("redirect:/error.action?errorCode=a0006");
        		return mav;
        	}else if(activity.getActivityState()==3){
        		mav.setViewName("redirect:/error.action?errorCode=a0007");
        		return mav;
        	}else if(activity.getActivityState()==4){
        		mav.setViewName("redirect:/error.action?errorCode=a0008");
        		return mav;
        	}
        	mav.getModelMap().put("activity", activity);
        }
        /**
         * 获取用户参加权限
         */
        params.remove("orgTreeId");
        Long userOrgTreeId=null;
        returnStr = ClientUtil.getStringClient(ClientURL.GET_USER_JOIN_LIMIT, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	userOrgTreeId=JsonUtil.jsonToObject(returnStr, "treeId", Long.class);
        	if(userOrgTreeId==null){
            	mav.setViewName("redirect:/error.action?errorCode=a0009");
        		return mav;
            }else{
            	mav.getModelMap().put("userOrgTreeId", userOrgTreeId);
            }
        }
        /**
         * 保存作品内容
         */
        params.put("orgTreeId", userOrgTreeId);
        returnStr = ClientUtil.getStringClient(ClientURL.ADD_WORK, params);
        Long worksId=null;
        if(returnStr!=null && !"".equals(returnStr)){
        	worksId=JsonUtil.jsonToObject(returnStr, "id", Long.class);
        	/**
			 * TODO: 添加消息
			 */
			String content2 = "提交了作品<a href='http://eduyun.chineseall.cn/activity/work.action?activityId="+activityId+"&worksId="
					+worksId+ "' target='_blank'>" +worksName+ "</a>";
			apiService.sendMessage(getSessionId(request), content2,
					"提交作品", "remind", "true", null);
        }
        mav.getModelMap().put("worksId", worksId);
        mav.setViewName("redirect:/activity/work.action");
        return mav;
	}
	/**
	 * 上传作品中的图片
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/add/pic")
	public void addWorksPicture(@RequestParam(value="workFile",required=false) MultipartFile multipartFile,ModelMap model,
			@RequestParam(value="type",required=false) Integer type,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
        try{
        	String srcPath="";
        	String imgFileFileName="";
        	if(multipartFile!=null && multipartFile.getSize()!=0){
        		if(type==1){
	        		//取得文件名字
		            imgFileFileName=System.currentTimeMillis()+"."+multipartFile.getOriginalFilename().split("\\.")[1];
		            srcPath="/activity/zhengwen/"+getLoginUserId(request)+"/";
	        	}else{
	        		//取得文件名字
		            imgFileFileName=System.currentTimeMillis()+"."+multipartFile.getOriginalFilename().split("\\.")[1];
		            srcPath="/activity/pic/"+getLoginUserId(request)+"/";
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
	 * 送花
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/send/flower")
	public void addFlower(@RequestParam(value="activityId",required=false) Long activityId,
			@RequestParam(value="worksId",required=false) Long worksId,ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
        try{
        	Map<String, Object> params = new HashMap<String, Object>();
        	params.put("activityId", activityId);
            params.put("worksId", worksId);
            params.put("userId", getLoginUserId(request));
    		String result=ClientUtil.getStringClient(ClientURL.ADD_WORK_FLOWER, params);
            PrintWriter out;
    		out = response.getWriter();
    		out.print(JsonUtil.jsonToObject(result, "result", String.class));
        } catch (IOException e){
            e.printStackTrace();
        }
	}
	/**
	 * 判断作品上传资格
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getUploadWorksLimit")
	public void getReviewLimit(@RequestParam(value="activityId",required=false) Long activityId,ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
        try{
        	Map<String, Object> params = new HashMap<String, Object>();
        	params.put("activityId", activityId);
            params.put("userId", getLoginUserId(request));
            /**
             * 获取用户参加权限
             */
            String returnStr = ClientUtil.getStringClient(ClientURL.GET_USER_JOIN_LIMIT, params);
            Long userOrgTreeId=null;
            if(returnStr!=null && !"".equals(returnStr)){
            	userOrgTreeId=JsonUtil.jsonToObject(returnStr, "treeId", Long.class);
            }
            PrintWriter out;
    		out = response.getWriter();
    		if(userOrgTreeId==null){
    			out.print("false");
    		}else{
    			out.print("true");
    		}
        } catch (IOException e){
            e.printStackTrace();
        }
	}
	/**
	 * 判断评论提交资格
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getReviewLimit")
	public void getReviewLimit(@RequestParam(value="activityId",required=false) Long activityId,
			@RequestParam(value="worksId",required=false) Long worksId,ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
        try{
        	Map<String, Object> params = new HashMap<String, Object>();
        	params.put("activityId", activityId);
            params.put("worksId", worksId);
            params.put("userId", getLoginUserId(request));
    		String result=ClientUtil.getStringClient(ClientURL.GET_REVIEW_LIMIT, params);
            PrintWriter out;
    		out = response.getWriter();
    		out.print(JsonUtil.jsonToObject(result, "result", String.class));
        } catch (IOException e){
            e.printStackTrace();
        }
	}
	
	 /**
     * 判断留言和评论,作品内容和标题是否有敏感词
     * @param model
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/judgeKeys")
    public void judgeKeys(@RequestParam(value="type",required=false) Long type,
			@RequestParam(value="content",required=false) String content,ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("content",java.net.URLDecoder.decode(content,"UTF-8"));
        params.put("type", type);
		String result=ClientUtil.getStringClient(ClientURL.LIST_WORD_UNIT, params);
        PrintWriter out;
		out = response.getWriter();
		out.print(JsonUtil.jsonToObject(result, "result", String.class));
    }
	/**
	 * 增加作品评论
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
    @RequestMapping("/add/review")
	public ModelAndView addWorksMessage(@RequestParam(value = "activityId" , required = false)String activityId,
			@RequestParam(value = "content" , required = false)String content,
			@RequestParam(value = "worksId" , required = false)String worksId,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String, Object> params = new HashMap<String, Object>();
        params.put("content", content);
        params.put("worksId", worksId);
        params.put("userId", getLoginUserId(request));

        /**
         * 保存作品评论
         */
        ClientUtil.getStringClient(ClientURL.ADD_WORK_REVIEW, params);
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("activityId", activityId);
        mav.getModelMap().put("worksId", worksId);
        mav.setViewName("redirect:/activity/work.action");
        return mav;
	}
}
