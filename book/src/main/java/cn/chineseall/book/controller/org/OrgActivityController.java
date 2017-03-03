/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Jock
 */
package cn.chineseall.book.controller.org;

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
import cn.chineseall.model.activity.vo.AcWorks;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.JsonUtil;

/**
 * 
 * @author Jock
 */
@Controller
@RequestMapping("/org")
public class OrgActivityController extends BaseController {
    
	@RequestMapping("/activity")
    public ModelAndView orgActivity(@RequestParam(required = false, value = "activityType") Integer activityType,
            HttpServletRequest request)
            throws Exception {

		if(activityType==null){
			activityType=0;
		}
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("orgTreeId", getOrgTreeId(request));
        mav.getModelMap().put("activityType", activityType);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orgTreeId",  getOrgTreeId(request));
        params.put("activityType", activityType);

        /**
         * 获取最新活动
         */
        String returnStr = ClientUtil.getStringClient(ClientURL.LIST_EDUYUN_NEW_ACTIVITY, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("newActivitys", JsonUtil.jsonToList(returnStr, "list", AcBaseinfo.class));
        }
        /**
         * 获取最热门活动
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_EDUYUN_HOT_ACTIVITY, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("hotActivitys", JsonUtil.jsonToList(returnStr, "list", AcBaseinfo.class));
        }
        /**
         * 获取经典回顾活动
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_EDUYUN_FINISH_ACTIVITY, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("finishActivitys", JsonUtil.jsonToList(returnStr, "list", AcBaseinfo.class));
        }
        /**
         * 获取最新作品
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_EDUYUN_NEW_WORKS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("works", JsonUtil.jsonToList(returnStr, "list", AcWorks.class));
        }

        mav.setViewName("/org/orgActivity");
        return mav;
    }
}
