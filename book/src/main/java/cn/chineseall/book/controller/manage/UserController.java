/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Lv15
 */
package cn.chineseall.book.controller.manage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.controller.BaseController;
import cn.chineseall.model.SUser;
import cn.chineseall.model.org.OrgBaseinfo;
import cn.chineseall.model.org.OrgTree;
import cn.chineseall.model.user.User;
import cn.chineseall.model.user.UserBaseinfo;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.JsonUtil;
import cn.chineseall.utils.PageUtil;
import cn.chineseall.utils.RequestUtil;

/**
 * 
 * @author zhaochengju
 */
@Controller
@RequestMapping("/manage/user")
public class UserController extends BaseController {

    @RequestMapping("/listNormalUser")
    public ModelAndView listNormalUser(@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage, HttpServletRequest request,
            @RequestParam(required = false, value = "userName") String userName)
            throws Exception {

        /**
         * 获取正常用户
         */
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orgTreeId", orgTreeId);
    	params.put("pageSize", pageSize);
    	params.put("currentPage", currentPage);
		params.put("userName", userName);
		
        String returnStr = ClientUtil.getStringClient(ClientURL.LIST_NORMAL_USER, params);
        
        /**
         * 返回数据
         */
		Map<String, Object> returnMap = JsonUtil.fromJsonToObject(returnStr, HashMap.class);
		Map<String, Object> pageUtil = (Map<String, Object>) returnMap.get("pageUtil");
        
        String queryCondition = RequestUtil.getQueryCondition(request);
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("currentPage", currentPage);
        mav.getModelMap().put("pageUtil", pageUtil);
        mav.getModelMap().put("queryCondition", queryCondition);
        mav.getModelMap().put("userName", userName);
        mav.setViewName("/manage/user/normalUser");
        return mav;
    }
    
    @RequestMapping("/kickoutUser")
    public ModelAndView kickoutUser(@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(required = false, value = "userIds") Long[] userIds)
            throws Exception {

        /**
         * 踢出用户
         */
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orgTreeId", orgTreeId);
    	params.put("userIds", userIds);
    	if(userIds!=null && orgTreeId!=null){
    		 ClientUtil.getStringClient(ClientURL.KICKOUT_USER, params);
    	}
		
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("currentPage", currentPage);
        mav.setViewName("redirect:/manage/user/listNormalUser.action");
        return mav;
    }
    
    
    @RequestMapping("/joinSettings")
    public ModelAndView joinSettings()
            throws Exception {

        /**
         * 获取用户加入设置
         */
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", orgTreeId);
        String returnStr = ClientUtil.getStringClient(ClientURL.GET_USER_JOIN_SETTINGS, params);
        
        /**
         * 返回数据
         */
        OrgBaseinfo orgBaseinfo = JsonUtil.jsonToObject(returnStr, "orgBaseinfo", OrgBaseinfo.class);
        ModelAndView mav = new ModelAndView();
    	mav.getModelMap().put("orgBaseinfo", orgBaseinfo);
        mav.setViewName("/manage/user/joinSettings");
        return mav;
    }
    
    @RequestMapping("/changeJoinSettings")
    public ModelAndView changeJoinSettings(@RequestParam(required = false, value = "userAudit", defaultValue = "1") Integer userAudit)
            throws Exception {

        /**
         * 获取原有的用户加入设置
         */
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", orgTreeId);
        String returnStr = ClientUtil.getStringClient(ClientURL.GET_USER_JOIN_SETTINGS, params);
        
        /**
         * 修改数据
         */
        OrgBaseinfo orgBaseinfo = JsonUtil.jsonToObject(returnStr, "orgBaseinfo", OrgBaseinfo.class);
        orgBaseinfo.setUserAudit(userAudit);
        
        /**
         * 更新到数据库
         */
        Map<String, Object> updateParams = new HashMap<String, Object>();
        updateParams.put("orgBaseinfo", orgBaseinfo);
        ClientUtil.getStringClient(ClientURL.UPDATE_USER_JOIN_SETTINGS, updateParams);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/manage/user/joinSettings.action");
        return mav;
    }
    
    @RequestMapping("/listAuditingUser")
    public ModelAndView listAuditingUser(@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage, HttpServletRequest request,
            @RequestParam(required = false, value = "userName") String userName)
            throws Exception {

        /**
         * 获取需要审核的用户
         */
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orgTreeId", orgTreeId);
    	params.put("pageSize", pageSize);
    	params.put("currentPage", currentPage);
		params.put("userName", userName);
		
        String returnStr = ClientUtil.getStringClient(ClientURL.LIST_AUDITING_USER, params);
        
        /**
         * 返回数据
         */
		Map<String, Object> returnMap = JsonUtil.fromJsonToObject(returnStr, HashMap.class);
		Map<String, Object> pageUtil = (Map<String, Object>) returnMap.get("pageUtil");
        
        String queryCondition = RequestUtil.getQueryCondition(request);
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("currentPage", currentPage);
        mav.getModelMap().put("pageUtil", pageUtil);
        mav.getModelMap().put("queryCondition", queryCondition);
        mav.getModelMap().put("userName", userName);
        mav.setViewName("/manage/user/auditingUser");
        return mav;
    }
    
    @RequestMapping("/refuseJoin")
    public ModelAndView refuseJoin(@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage,
    		@RequestParam(required = false, value = "userIds") Long[] userIds)
            throws Exception {

    	 /**
         * 拒绝加入（其实他的操作跟踢出完全一样）
         */
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orgTreeId", orgTreeId);
    	params.put("userIds", userIds);
    	if(userIds!=null && orgTreeId!=null){
    		ClientUtil.getStringClient(ClientURL.KICKOUT_USER, params);
    	}
		
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("currentPage", currentPage);
        mav.setViewName("redirect:/manage/user/listAuditingUser.action");
        return mav;
    }
    
    @RequestMapping("/agreeJoin")
    public ModelAndView agreeJoin(@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(required = false, value = "userIds") Long[] userIds)
            throws Exception {

        /**
         * 同意加入
         */
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orgTreeId", orgTreeId);
    	params.put("userIds", userIds);
    	if(userIds!=null && orgTreeId!=null){
    		ClientUtil.getStringClient(ClientURL.AGREE_JOIN, params);
    	}
		
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("currentPage", currentPage);
        mav.setViewName("redirect:/manage/user/listAuditingUser.action");
        return mav;
    }
    
    @RequestMapping("/updatePassword")
    public ModelAndView updatePassword(@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage,
    		@RequestParam(required = false, value = "userIds") Long[] userIds,
            @RequestParam(required = false, value = "password") String password)
            throws Exception {

        /**
         * 修改密码
         */
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("password", password);
    	params.put("userIds", userIds);
    	params.put("orgTreeId", orgTreeId);
		ClientUtil.getStringClient(ClientURL.UPDATE_PASSWORD, params);
		
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("currentPage", currentPage);
        mav.setViewName("redirect:/manage/user/listNormalUser.action");
        return mav;
    }
    
    @RequestMapping("/listManager")
    public ModelAndView listManager(@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage, HttpServletRequest request,
            @RequestParam(required = false, value = "userName") String userName)
            throws Exception {

        /**
         * 管理员列表
         */
    	Map<String, Object> params = new HashMap<String, Object>();
        params.put("orgTreeId", orgTreeId);
    	params.put("pageSize", 10);
    	params.put("currentPage", currentPage);
		params.put("userName", userName);
		
        String returnStr = ClientUtil.getStringClient(ClientURL.LIST_MANAGER, params);
        
        /**
         * 返回数据
         */
        PageUtil pageUtil = null;
        Integer result = JsonUtil.getInt(returnStr, "result");
        if(result.intValue() == 1){
            Integer totalCount = JsonUtil.getInt(returnStr, "totalCount");
            Integer pSize = JsonUtil.getInt(returnStr, "pageSize");
            Integer cPage = JsonUtil.getInt(returnStr, "currentPage");
            List<HashMap> userList = JsonUtil.jsonToList(returnStr,"items", HashMap.class);
            pageUtil = new PageUtil(userList, totalCount, pSize, cPage);
        }
        
        String queryCondition = RequestUtil.getQueryCondition(request);
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("pageUtil", pageUtil);
        mav.getModelMap().put("currentPage", currentPage);
        mav.getModelMap().put("queryCondition", queryCondition);
        mav.getModelMap().put("userName", userName);
        mav.setViewName("/manage/user/listManager");
        return mav;
    }
    
    @RequestMapping("/showADManager")
    public ModelAndView showADManager() throws Exception {
        /**
         * 获取该机构下的所有机构树
         */
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orgTreeId", orgTreeId);
		String returnStr = ClientUtil.getStringClient(ClientURL.GET_ORGTREES, params);
		HashMap[] orgTreeList = JsonUtil.jsonToArray(returnStr, "orgTreeList", HashMap.class);
        ModelAndView mav = new ModelAndView();
    	mav.getModelMap().put("orgTreeId", orgTreeId);
    	mav.getModelMap().put("orgTreeList", orgTreeList);
        mav.setViewName("/manage/user/addManager");
        return mav;
    }
    
    @RequestMapping("/addManager")
    public ModelAndView addManager(User user, Long[] orgTreeIds, 
    		@RequestParam(required = false, value = "realName") String realName,
    		@RequestParam(required = false, value = "confirmPassword") String confirmPassword)
            throws Exception {

    	/**
    	 * 添加管理管理员
    	 */
    	if(user!=null && orgTreeIds!=null){
    		Map<String, Object> params = new HashMap<String, Object>();
    		params.put("user", user);
    		params.put("orgTreeIds", orgTreeIds);
    		params.put("realName", realName);
    		ClientUtil.getStringClient(ClientURL.ADD_MANAGER, params);
    		
    	}
    	
    	ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/manage/user/listManager.action");
        return mav;
    }
    
    @RequestMapping("/showUPManager")
    public ModelAndView showUPManager(
            @RequestParam(required = false, value = "userId", defaultValue = "1") Long userId)
            throws Exception {
        /**
         * 获取机构下的所有树
         */
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orgTreeId", orgTreeId);
		String returnStr = ClientUtil.getStringClient(ClientURL.GET_ORGTREES, params);
		OrgTree[] orgTreeList = JsonUtil.jsonToArray(returnStr, "orgTreeList", OrgTree.class);
        
		/**
		 * 获取用户信息
		 */
		params.put("userId", userId);
		String returnStr2 = ClientUtil.getStringClient(ClientURL.GET_MANAGER, params);
		Integer result = JsonUtil.getInt(returnStr2, "result");
		ModelAndView mav = new ModelAndView();
		if(result==0){
			User user = JsonUtil.jsonToObject(returnStr2, "user", User.class);
			UserBaseinfo userBaseinfo = JsonUtil.jsonToObject(returnStr2, "userBaseinfo", UserBaseinfo.class);
			SUser[] sUserList = JsonUtil.jsonToArray(returnStr2, "sUserList", SUser.class);
			mav.getModelMap().put("orgTreeList", orgTreeList);
			mav.getModelMap().put("user", user);
			mav.getModelMap().put("userBaseinfo", userBaseinfo);
			mav.getModelMap().put("sUserList", sUserList);
			mav.setViewName("/manage/user/updateManager");
		}else{
			String errorCode = JsonUtil.getString(returnStr2, "errorCode");
			mav.setViewName("redirect:/error.action?errorCode="+errorCode);
		}
        return mav;
    }
    
    @RequestMapping("/updateManager")
    public ModelAndView updateManager(User user, Long[] orgTreeIds, 
    		@RequestParam(required = false, value = "realName") String realName,
    		@RequestParam(required = false, value = "confirmPassword") String confirmPassword)
            throws Exception {

    	/**
    	 * 更新管理管理员
    	 */
    	if(user!=null && orgTreeIds!=null){
    		Map<String, Object> params = new HashMap<String, Object>();
    		params.put("user", user);
    		params.put("orgTreeIds", orgTreeIds);
    		params.put("realName", realName);
    		ClientUtil.getStringClient(ClientURL.UPDATE_MANAGER, params);
    	}
    	ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/manage/user/listManager.action");
        return mav;
    }
    
    @RequestMapping("/removePermission")
    public ModelAndView removePermission(Long userId) throws Exception {
    	/**
    	 * 解除管理员权限
    	 */
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("orgTreeId", orgTreeId);
		String returnStr = ClientUtil.getStringClient(ClientURL.REMOVE_PERMISSION, params);
		Integer result = JsonUtil.getInt(returnStr, "result");
    	ModelAndView mav = new ModelAndView();
		if(result==0){
			mav.setViewName("redirect:/manage/user/listManager.action");
		}else{
			String errorCode = JsonUtil.getString(returnStr, "errorCode");
			mav.setViewName("redirect:/error.action?errorCode="+errorCode);
		}
    	return mav;
    }
    
    @ResponseBody
    @RequestMapping("/checkUserName")
    public Boolean checkUserName(@RequestParam(required = false, value = "userId", defaultValue = "0") Long userId,
            @RequestParam(required = false, value = "userName") String userName)
            throws Exception {

        /**
         * 检查用户名是否存在
         */
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", userId);
    	params.put("userName", userName);
        String returnStr = ClientUtil.getStringClient(ClientURL.CHECK_USERNAME, params);
        /**
         * 返回数据
         */
        Boolean flag = JsonUtil.jsonToObject(returnStr, "flag", Boolean.class);
        
        return flag;
    }
    

}
