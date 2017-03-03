package cn.chineseall.book.controller.manage;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.controller.BaseController;
import cn.chineseall.model.activity.AcBaseinfo;
import cn.chineseall.model.activity.AcConfig;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.JsonUtil;
import cn.chineseall.utils.PageUtil;
import cn.chineseall.utils.RequestUtil;

@Controller
@RequestMapping("/manage/activity/works")
public class ActivityWorksRecommendController extends BaseController {

	/**
	 * 活动每日投稿数
	 * @param acWorksQueryVo
	 * @param request
	 * @return
	 * @throws Exception 
	 */
    @RequestMapping("/listAcWorksGroupByDay")
    public ModelAndView listAcWorksGroupByDay(@RequestParam(value="activityId") Long activityId,
			@RequestParam(value="startTime",required=false) String startTime,
			@RequestParam(value="endTime",required=false) String endTime,
			HttpServletRequest request) throws Exception {
        Map<String, Object> prameters = new HashMap<String, Object>();
        prameters.put("activityId", activityId);
        prameters.put("orgTreeId", getOrgTreeId(request));
        prameters.put("startTime", startTime);
        prameters.put("endTime", endTime);
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("startTime", startTime);
        mav.getModelMap().put("endTime", endTime);
        /**
         * 获取活动信息
         */
        String returnStr=ClientUtil.getStringClient(ClientURL.GET_ACTIVITY_DETAIL, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("activity", JsonUtil.jsonToObject(returnStr, "activity", AcBaseinfo.class));
        }
        /**
         * 获取活动配置信息
         */
        returnStr=ClientUtil.getStringClient(ClientURL.GET_AC_CONFIG, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("acconfig", JsonUtil.jsonToObject(returnStr, "acconfig", AcConfig.class));
        }
        /**
         * 获取用户参加权限
         */
        returnStr = ClientUtil.getStringClient(ClientURL.GET_USER_JOIN_LIMIT, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	Long userOrgTreeId=JsonUtil.jsonToObject(returnStr, "treeId", Long.class);
        	if(userOrgTreeId==null){
            	mav.setViewName("redirect:/error.action?errorCode=a0010");
        		return mav;
            }else{
            	mav.getModelMap().put("userOrgTreeId", userOrgTreeId);
            }
        }
        /**
         * 统计信息列表
         */
        prameters.put("currentPage", 1);
        prameters.put("pageSize", 10);
        returnStr=ClientUtil.getStringClient(ClientURL.LIST_AC_WORKS_GROUP_BY_DAY, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	String queryCondition = RequestUtil.getQueryCondition(request);
         	PageUtil pageUtil = new PageUtil(null, JsonUtil.jsonToObject(returnStr, "count", Integer.class),10, 1);
            mav.getModelMap().put("pageUtil", pageUtil);
            mav.getModelMap().put("queryCondition", queryCondition);
        	mav.getModelMap().put("works", JsonUtil.jsonToList(returnStr, "list", HashMap.class));
        }
        mav.getModelMap().put("activityId", activityId);
        mav.setViewName("/manage/activity/worksCountDay");
        return mav; 
    }
    
    /**
	 * 作品数统计
	 * @param acWorksQueryVo
	 * @param request
	 * @return
	 * @throws Exception 
	 */
    @RequestMapping("/listAcWorksGroupByOrgTreeId")
    public ModelAndView listAcWorksGroupByOrgTreeId(@RequestParam(value="activityId") Long activityId,
    		@RequestParam(value="treeId",required=false) Long treeId,
			@RequestParam(value="orgName",required=false) String orgName,
			@RequestParam(value="type") Integer type,
			HttpServletRequest request) throws Exception {
        Map<String, Object> prameters = new HashMap<String, Object>();
        prameters.put("activityId", activityId);
        prameters.put("orgTreeId", getOrgTreeId(request));
        if(treeId==null){
        	treeId=getOrgTreeId(request);
        }
        prameters.put("treeId", treeId);
        prameters.put("orgName", orgName);
        prameters.put("type", type);
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("orgName", orgName);
        mav.getModelMap().put("treeId", treeId);
        mav.getModelMap().put("type", type);
        /**
         * 获取活动信息
         */
        String returnStr=ClientUtil.getStringClient(ClientURL.GET_ACTIVITY_DETAIL, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("activity", JsonUtil.jsonToObject(returnStr, "activity", AcBaseinfo.class));
        }
        /**
         * 获取活动配置信息
         */
        returnStr=ClientUtil.getStringClient(ClientURL.GET_AC_CONFIG, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("acconfig", JsonUtil.jsonToObject(returnStr, "acconfig", AcConfig.class));
        }
        /**
         * 获取用户参加权限
         */
        returnStr = ClientUtil.getStringClient(ClientURL.GET_USER_JOIN_LIMIT, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	Long userOrgTreeId=JsonUtil.jsonToObject(returnStr, "treeId", Long.class);
        	if(userOrgTreeId==null){
            	mav.setViewName("redirect:/error.action?errorCode=a0010");
        		return mav;
            }else{
            	mav.getModelMap().put("userOrgTreeId", userOrgTreeId);
            }
        }
        /**
         * 获取活动作品统计信息列表
         */
        prameters.put("currentPage", 1);
        prameters.put("pageSize", 10);
        returnStr=ClientUtil.getStringClient(ClientURL.LIST_AC_WORKS_GROUP_BY_TREEID, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	String queryCondition = RequestUtil.getQueryCondition(request);
         	PageUtil pageUtil = new PageUtil(null, JsonUtil.jsonToObject(returnStr, "count", Integer.class),10, 1);
            mav.getModelMap().put("pageUtil", pageUtil);
            mav.getModelMap().put("queryCondition", queryCondition);
        	mav.getModelMap().put("works", JsonUtil.jsonToList(returnStr, "list", HashMap.class));
        }
        mav.getModelMap().put("activityId", activityId);
        if(type==1){
        	mav.setViewName("/manage/activity/worksCountEveryOrg");
        }else if(type==2){
        	mav.setViewName("/manage/activity/worksCountColl");
        }else if(type==3){
        	mav.setViewName("/manage/activity/worksCountOrg");
        }
        return mav; 
    }
}
