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
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.controller.BaseController;
import cn.chineseall.model.activity.AcBaseinfo;
import cn.chineseall.model.activity.AcConfig;
import cn.chineseall.model.activity.AcFriendLink;
import cn.chineseall.model.activity.AcWorksGroup;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.JsonUtil;

@Controller
@RequestMapping("/manage/activity/group")
public class ActivityGroupController extends BaseController {
    
	@Resource(type=org.apache.commons.configuration.PropertiesConfiguration.class)
    private PropertiesConfiguration fileUploadConfig;
	
    /**
	 * 获取分组列表
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
    @RequestMapping("/listGroup")
	public ModelAndView listGroup(@RequestParam(value="activityId") Long activityId,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("activityId", activityId);
    	params.put("orgTreeId", getOrgTreeId(request));
       	params.put("userId", getLoginUserId(request));

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
        /**
         * 获取活动配置信息
         */
        returnStr=ClientUtil.getStringClient(ClientURL.GET_AC_CONFIG, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("acconfig", JsonUtil.jsonToObject(returnStr, "acconfig", AcConfig.class));
        }
        /**
         * 获取分组列表
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_AC_GROUP, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("groups", JsonUtil.jsonToList(returnStr, "groups", AcWorksGroup.class));
        }
        mav.getModelMap().put("activityId", activityId);
        mav.setViewName("/manage/activity/listGroups");
        return mav;
	}
   /**
	 * 修改分组信息
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
    @RequestMapping("/updateAcGroups")
	public ModelAndView updateAcFriendLink(@RequestParam(value="activityId") Long activityId,
			@RequestParam(value="id",required = false) Long[] id,
			@RequestParam(value="sort",required = false) Integer[] sort,
			@RequestParam(value="groupName") String[] groupName,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("activityId", activityId);
    	params.put("orgTreeId", getOrgTreeId(request));
       	params.put("userId", getLoginUserId(request));
        params.put("id", id);
        params.put("sort", sort);
        params.put("groupName", groupName);
        /**
         * 修改分组信息
         */
        ClientUtil.getStringClient(ClientURL.UPDATE_AC_GROUPS, params);
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("activityId", activityId);
        mav.setViewName("redirect:/manage/activity/group/listGroup.action");
        return mav;
	}
    
    /**
	 * 删除作品分组
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/delAcGroup")
	public void delAcGroup(@RequestParam(value="activityId",required=false) Long activityId,
			@RequestParam(value="groupId",required=false) Long groupId,ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
        try{
        	Map<String, Object> params = new HashMap<String, Object>();
        	params.put("activityId", activityId);
            params.put("groupId", groupId);
            params.put("userId", getLoginUserId(request));
    		String result=ClientUtil.getStringClient(ClientURL.DEL_AC_GROUPS, params);
            PrintWriter out;
    		out = response.getWriter();
    		out.print(JsonUtil.jsonToObject(result, "result", String.class));
        } catch (IOException e){
            e.printStackTrace();
        }
	}
}
