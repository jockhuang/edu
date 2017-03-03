/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Jock
 */
package cn.chineseall.book.controller.activity;
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
import cn.chineseall.model.activity.AcWorksGroup;
import cn.chineseall.model.activity.AcWorksRecommend;
import cn.chineseall.model.activity.vo.AcWorks;
import cn.chineseall.model.activity.vo.AcWorksQueryVo;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.JsonUtil;
import cn.chineseall.utils.PageUtil;
import cn.chineseall.utils.RequestUtil;

/**
 * 
 * @author Jock
 */
@Controller
@RequestMapping("/jury/activity")
public class ActivityJuryController extends BaseController {
    
	@RequestMapping("/listJuryActivity")
    public ModelAndView listJuryActivity(@RequestParam(required = false, value = "currentPage") Integer currentPage,
            HttpServletRequest request)
            throws Exception {

		if(currentPage==null || currentPage<=0){
			currentPage=1;
		}
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("orgTreeId", getOrgTreeId(request));
        mav.getModelMap().put("userId", getLoginUserId(request));
        mav.getModelMap().put("currentPage", currentPage);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orgTreeId", getOrgTreeId(request));
        params.put("userId", getLoginUserId(request));
        params.put("currentPage", currentPage);
        params.put("pageSize", 10);
        /**
         * 获取评委活动列表
         */
        String returnStr = ClientUtil.getStringClient(ClientURL.LIST_JURY_ACTIVITY, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	String queryCondition = RequestUtil.getQueryCondition(request);
        	PageUtil pageUtil = new PageUtil(null, JsonUtil.jsonToObject(returnStr, "count", Integer.class), 10, currentPage);
            mav.getModelMap().put("pageUtil", pageUtil);
            mav.getModelMap().put("queryCondition", queryCondition);
        	mav.getModelMap().put("activitys", JsonUtil.jsonToList(returnStr, "list", AcBaseinfo.class));
        }

        mav.setViewName("/activity/jury/listJuryActivity");
        return mav;
    }
	
	/**
	 * 评委作品
	 * @param acWorksQueryVo
	 * @param request
	 * @return
     * @throws Exception 
	 */
    @RequestMapping("/works")
    public ModelAndView listJuryWorks(AcWorksQueryVo acWorksQueryVo, HttpServletRequest request) throws Exception {
        if(acWorksQueryVo.getCurrentPage()==null || acWorksQueryVo.getCurrentPage().intValue() == 0){
        	acWorksQueryVo.setCurrentPage(1);
        }
        if(acWorksQueryVo.getScoreState()==null){
        	acWorksQueryVo.setScoreState(0);
        }
        if(acWorksQueryVo.getOrderby()==null || acWorksQueryVo.getOrderby().intValue() == 0){
        	acWorksQueryVo.setOrderby(1);
        }
        acWorksQueryVo.setPageSize(10);
        acWorksQueryVo.setOrgTreeId1(getOrgTreeId(request));
        Map<String, Object> prameters = new HashMap<String, Object>();
        prameters.put("queryVo", acWorksQueryVo);
        acWorksQueryVo = ClientUtil.getObjectClient(ClientURL.LIST_SCORE_AC_WORKS, prameters, AcWorksQueryVo.class);
        PageUtil pageUtil = new PageUtil(null,acWorksQueryVo.getTotalCount().intValue(),acWorksQueryVo.getPageSize(), acWorksQueryVo.getCurrentPage());
        ModelAndView mav = new ModelAndView();
        prameters.put("activityId", acWorksQueryVo.getActivityId());
        /**
         * 获取活动信息
         */
        String returnStr = ClientUtil.getStringClient(ClientURL.GET_ACTIVITY_DETAIL, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	AcBaseinfo activity=JsonUtil.jsonToObject(returnStr, "activity", AcBaseinfo.class);
        	if(activity==null){
        		mav.setViewName("redirect:/error.action?errorCode=a0004");
        		return mav;
        	}
        	mav.getModelMap().put("activity", activity);
        }
        /**
         * 获取自定义分组列表
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_GROUPS, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("groups", JsonUtil.jsonToList(returnStr, "list", AcWorksGroup.class));
        }
        mav.setViewName("/activity/jury/listJuryWorks");
        mav.getModelMap().put("queryVo", acWorksQueryVo);
        mav.getModelMap().put("activityId", acWorksQueryVo.getActivityId());
        mav.getModelMap().put("pageUtil", pageUtil);
        mav.getModelMap().put("queryCondition", RequestUtil.getQueryCondition(request));
        return mav; 
    }
    
    /**
	 * 查看单个作品
	 * @param acWorksQueryVo
	 * @param request
	 * @return
	 * @throws Exception 
	 */
    @RequestMapping("/work")
    public ModelAndView listAllWorks(@RequestParam(value="activityId") Long activityId,
  			@RequestParam(value="worksId") Long worksId
  			, HttpServletRequest request) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("activityId", activityId);
		params.put("orgTreeId", getOrgTreeId(request));
        params.put("userId", getLoginUserId(request));
        params.put("worksId", worksId);

        ModelAndView mav = new ModelAndView();
        /**
         * 获取活动信息
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
        	mav.getModelMap().put("work", JsonUtil.jsonToObject(returnStr, "work", AcWorks.class));
        }
        /**
         * 获取评委列表
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_AC_JURYS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("jurys", JsonUtil.jsonToList(returnStr, "list", AcJury.class));
        }
        /**
         * 获取作品评语信息
         */
        returnStr = ClientUtil.getStringClient(ClientURL.GET_AC_WORKS_SCOR, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("acWorksRecommend", JsonUtil.jsonToObject(returnStr, "result", AcWorksRecommend.class));
        }
	    mav.getModelMap().put("activityId", activityId);
	    mav.getModelMap().put("worksId", worksId);
	    mav.setViewName("/activity/jury/work");
	    return mav;
    }
    
    /**
  	 * 跳转到修改密码页面
  	 * @param model
  	 * @param request
  	 * @param response
  	 * @throws Exception
  	 */
    @RequestMapping("/updatePassword")
  	public ModelAndView updatePassword(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", getLoginUserId(request));
    	ModelAndView mav = new ModelAndView();
    	mav.getModelMap().put("user", getUserInfo(getLoginUserId(request)));
    	mav.getModelMap().put("msg", "");
        mav.setViewName("/activity/jury/updatePass");
        return mav;
  	}
    
    /**
  	 * 修改密码
  	 * @param model
  	 * @param request
  	 * @param response
  	 * @throws Exception
  	 */
    @RequestMapping("/savePassword")
  	public ModelAndView savePassword(@RequestParam(value="userName") String userName,
  			@RequestParam(value="oldPassword") String oldPassword,
  			@RequestParam(value="newPassword") String newPassword,
  			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("oldPassword", oldPassword);
        params.put("newPassword", newPassword);
        params.put("userName", userName);
    	
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("userName", userName);
    	String json = ClientUtil.getStringClient(ClientURL.SETTING_USER_PASSWORD,
				params);
		Boolean success = JsonUtil.getBoolean(json, "success");
		if (success != null && success) {
			mav.getModelMap().put("msg", "修改成功");
		} else {
			String msg = JsonUtil.getString(json, "msg");
			mav.getModelMap().put("msg", msg != null ? msg : "修改失败");
		}
        mav.setViewName("/activity/jury/updatePass");
        return mav;
  	}
    
    /**
  	 * 给作品打分
  	 * @param model
  	 * @param request
  	 * @param response
  	 * @throws Exception
  	 */
    @RequestMapping("/addAcWorksScore")
  	public ModelAndView addAcWorksScore(@RequestParam(value="activityId") Long activityId,
  			@RequestParam(value="worksId") Long worksId,
  			@RequestParam(value="score") Double score,
  			@RequestParam(value="content",required = false) String content,
  			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
      	  Map<String, Object> params = new HashMap<String, Object>();
      	  params.put("activityId", activityId);
          params.put("orgTreeId", getOrgTreeId(request));
          params.put("userId", getLoginUserId(request));
          params.put("worksId", worksId);
          params.put("score", score);
          params.put("content", content);

	      /**
	       * 给作品打分
	       */
	      ClientUtil.getStringClient(ClientURL.ADD_AC_WORKS_SCOR, params);
	      ModelAndView mav = new ModelAndView();
	      mav.getModelMap().put("activityId", activityId);
	      mav.getModelMap().put("worksId", worksId);
	      mav.setViewName("redirect:/jury/activity/work.action");
	      return mav;
  	}
}
