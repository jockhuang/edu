package cn.chineseall.book.controller.manage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.controller.BaseController;
import cn.chineseall.model.activity.AcBaseinfo;
import cn.chineseall.model.activity.AcRecommend;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.ImageUtils;
import cn.chineseall.utils.JsonUtil;
import cn.chineseall.utils.PageUtil;
import cn.chineseall.utils.RequestUtil;

@Controller
@RequestMapping("/manage/content/")
public class ActivityRecommendController extends BaseController {
	
	@Resource(type=org.apache.commons.configuration.PropertiesConfiguration.class)
    private PropertiesConfiguration fileUploadConfig;

    /**
     * 活动推荐列表
     * 
     * @param request
     * @return
     * @throws Exception 
     */
    @RequestMapping("listActivityRecommend")
    public ModelAndView listActivityRecommend(HttpServletRequest request, String keywords,
    		@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage) throws Exception{
        ModelAndView mav = new ModelAndView();
        
        /**
         * 查询新闻
         */
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orgTreeId", orgTreeId);
    	params.put("pageSize", pageSize);
    	params.put("currentPage", currentPage);
    	params.put("state", 1);
		params.put("keywords", keywords);
		
        String returnStr = ClientUtil.getStringClient(ClientURL.GET_ACTIVITY_RECOMMEND, params);
        
        /**
         * 处理返回数据
         */
		Map<String, Object> returnMap = JsonUtil.fromJsonToObject(returnStr, HashMap.class);
		Map<String, Object> pageUtil = (Map<String, Object>) returnMap.get("pageUtil");
        
        String queryCondition = RequestUtil.getQueryCondition(request);
        mav.getModelMap().put("currentPage", currentPage);
        mav.getModelMap().put("pageUtil", pageUtil);
        mav.getModelMap().put("queryCondition", queryCondition);
        mav.getModelMap().put("keywords", keywords);
        
        mav.setViewName("/manage/content/listActivityRecommend");
        return mav;
    }
    
    /**
     * 添加活动推荐
     * 
     * @param request
     * @return
     * @throws Exception 
     */
    @RequestMapping("showAddActivityRecommend")
    public ModelAndView showAddActivityRecommend(HttpServletRequest request, String activityName, Integer activityState,
    		@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage) throws Exception{
        ModelAndView mav = new ModelAndView();
        
        /**
         * 获取该机构的活动
         */
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orgTreeId", orgTreeId);
    	params.put("pageSize", pageSize);
    	params.put("state", 1);
		params.put("currentPage", currentPage);
		params.put("activityName", activityName);
		params.put("activityState", activityState);
		
        String returnStr = ClientUtil.getStringClient(ClientURL.LIST_ORG_ACTIVITYS, params);
        
        /**
         * 处理返回数据
         */
		Integer totalCount = JsonUtil.getInt(returnStr, "count");
		List<AcBaseinfo> acBaseinfoList = JsonUtil.jsonToList(returnStr, "list", AcBaseinfo.class);
		PageUtil pageUtil = new PageUtil(acBaseinfoList, totalCount, pageSize, currentPage);
        
        String queryCondition = RequestUtil.getQueryCondition(request);
        mav.getModelMap().put("currentPage", currentPage);
        mav.getModelMap().put("pageUtil", pageUtil);
        mav.getModelMap().put("queryCondition", queryCondition);
        mav.getModelMap().put("activityName", activityName);
        mav.getModelMap().put("activityState", activityState);
        
        mav.setViewName("/manage/content/addActivityRecommend");
        return mav;
    }
    

    /**
     * 选用活动
     * 
     * @param request
     * @return
     * @throws Exception 
     */
    @RequestMapping("chooseActivity")
    public ModelAndView chooseActivity(HttpServletRequest request,Long activityId,
    		@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage) throws Exception{
        ModelAndView mav = new ModelAndView();
        
        /**
         * 获取该机构的活动
         */
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", getLoginUserId(request));
        params.put("orgTreeId", orgTreeId);
        params.put("activityId", activityId);
        String returnStr1 = ClientUtil.getStringClient(ClientURL.GET_USER_JOIN_LIMIT, params);
        Long treeId = JsonUtil.getLong(returnStr1, "treeId");
        if(treeId!=null){
        	String returnStr = ClientUtil.getStringClient(ClientURL.GET_ACTIVITY_DETAIL, params);
        	AcBaseinfo acBaseinfo = JsonUtil.jsonToObject(returnStr, "activity", AcBaseinfo.class);
        	mav.getModelMap().put("currentPage", currentPage);
        	mav.getModelMap().put("acBaseinfo", acBaseinfo);
        	mav.setViewName("/manage/content/chooseActivity");
        }else{
        	mav.setViewName("redirect:/error.action?errorCode=2002");
        }
        return mav;
    }
    
    /**
     * 添加活动推荐
     * 
     * @param request
     * @return
     */
    @RequestMapping("addActivityRecommend")
    public String addActivityRecommend(HttpServletRequest request, AcRecommend acRecommend){
    	if(acRecommend!=null){
    		acRecommend.setOrgTreeId(orgTreeId);
    		acRecommend.setState(1);
    		Map<String, Object> params = new HashMap<String, Object>();
            params.put("acRecommend", acRecommend);
            ClientUtil.getStringClient(ClientURL.ADD_ACTIVITY_RECOMMEND, params);
    	}
        return "redirect:/manage/content/listActivityRecommend.action";
    }
    
    /**
     * 修改活动推荐
     * 
     * @param request
     * @return
     * @throws Exception 
     */
    @RequestMapping("showUpdateActivityRecommend")
    public ModelAndView showUpdateActivityRecommend(HttpServletRequest request,
    		@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage,
    		@RequestParam(required = false, value = "id", defaultValue = "1") Long id) throws Exception{
    	
        ModelAndView mav = new ModelAndView();
        
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("orgTreeId", orgTreeId);
        String returnStr = ClientUtil.getStringClient(ClientURL.GET_ACRECOMMEND_BY_ID, params);
        Integer result = JsonUtil.getInt(returnStr, "result");
        if(result==0){
        	AcRecommend acRecommend = JsonUtil.jsonToObject(returnStr, "acRecommend", AcRecommend.class);
        	mav.getModelMap().put("currentPage", currentPage);
        	mav.getModelMap().put("acRecommend", acRecommend);
        	mav.setViewName("/manage/content/updateActivityRecommend");
        }else{
        	String errorCode = JsonUtil.getString(returnStr, "errorCode");
        	mav.setViewName("redirect:/error.action?errorCode="+errorCode);
        }
        return mav;
    }
    
    /**
     * 修改活动推荐
     * 
     * @param request
     * @return
     */
    @RequestMapping("updateActivityRecommend")
    public String updateActivityRecommend(HttpServletRequest request,
    		@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage,
    		AcRecommend acRecommend){
    	
    	if(acRecommend!=null){
    		Map<String, Object> params = new HashMap<String, Object>();
	        params.put("acRecommend", acRecommend);
	        params.put("orgTreeId", orgTreeId);
	        ClientUtil.getStringClient(ClientURL.UPDATE_ACRECOMMEND, params);
    	}
    	
        return "redirect:/manage/content/listActivityRecommend.action?currentPage="+currentPage;
    }
    
    /**
     * 移动活动推荐
     * 
     * @param request
     * @return
     */
    @RequestMapping("moveActivityRecommend")
    public String moveActivityRecommend(HttpServletRequest request,String oper,
    		@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage,
    		Long id){
    	
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("orgTreeId", orgTreeId);
        params.put("id", id);
        params.put("oper", oper);
        ClientUtil.getStringClient(ClientURL.MOVE_ACTIVITY_RECOMMEND, params);
    	
        return "redirect:/manage/content/listActivityRecommend.action?currentPage="+currentPage;
    }
    
    /**
     * 删除新闻
     * 
     * @param request
     * @return
     */
    @RequestMapping("deleteActivityRecommend")
    public String deleteActivityRecommend(HttpServletRequest request,
    		@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage,
    		Long[] ids){
    	
    	Map<String, Object> params = new HashMap<String, Object>();
        params.put("ids", ids);
        params.put("orgTreeId", orgTreeId);
        ClientUtil.getStringClient(ClientURL.DELETE_ACTIVITY_RECOMMEND, params);
    	
        return "redirect:/manage/content/listActivityRecommend.action?currentPage="+currentPage;
    }
    
    
    /**
     * 上传活动logo
     * 
     * @param request
     * @return
     * @throws IOException 
     */
    @ResponseBody
    @RequestMapping("uploadActivityLogo")
    public ModelMap uploadActivityLogo(HttpServletRequest request,
    		@RequestParam("logo") MultipartFile logo) throws IOException{
    	
    	ModelMap modelMap = new ModelMap();
    	String baseDir = fileUploadConfig.getString("image_upload_base_dir");
        String logoUrl = "/activity/logo/";
        logoUrl = uploadImg(baseDir, logoUrl,"activityLogo_", logo);
        Calendar.getInstance().getTime().toString();
        modelMap.put("logo", fileUploadConfig.getString("img_domain")+logoUrl+"?"+(Calendar.getInstance().getTime().toString()));
        return modelMap;
    }
}
