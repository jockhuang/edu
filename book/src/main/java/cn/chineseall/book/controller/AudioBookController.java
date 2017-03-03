/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Lv15
 */
package cn.chineseall.book.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.constants.AudioConstants;
import cn.chineseall.model.audio.AudioBookInfo;
import cn.chineseall.model.audio.AudioInfo;
import cn.chineseall.model.audio.vo.AudioBookDetail;
import cn.chineseall.model.audio.vo.AudioClassDetail;
import cn.chineseall.model.audio.vo.AudioReadLogDetail;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.JsonUtil;
import cn.chineseall.utils.PageUtil;

/**
 * 
 * @author Lv15
 */
@Controller
@RequestMapping("/audio")
public class AudioBookController extends BaseController {

	@RequestMapping("/room")
	public ModelAndView room(
			@RequestParam(required = false, value = "currentPage" , defaultValue = "1" ) Integer currentPage,
			@RequestParam(required = false, value = "classId") String classId,
			@RequestParam(required = false, value = "typeId") String typeId,
			@RequestParam(required = false) String cname,
			@RequestParam(required = false) String tname,
			HttpServletRequest request) throws Exception {

        getOrgTreeId(request);
        
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("orgTreeId", orgTreeId);
        mav.getModelMap().put("currentPage", currentPage);
        mav.getModelMap().put("classId", classId);
        mav.getModelMap().put("typeId", typeId);
        mav.getModelMap().put("cname", cname);
        mav.getModelMap().put("tname", tname);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orgTreeId", orgTreeId);
        params.put("typeId", typeId);
        params.put("classId", classId);

        /**
         * 获取分类下听书图书
         */
        params.put("pageSize", pageSize);
        params.put("currentPage", currentPage);

        String returnStr = ClientUtil.getStringClient(ClientURL.LIST_AUDIO_BOOK_DETAIL, params);

//        mav.getModelMap().put("rightList", JsonUtil.jsonToList(returnStr, "list", AudioBookDetail.class));
//        mav.getModelMap().put("rightListCount", JsonUtil.getLong(returnStr, "count"));
        
        mav.getModelMap().put("pageUtil", new PageUtil(JsonUtil.jsonToList(returnStr, "list", 
        		AudioBookDetail.class), JsonUtil.getLong(returnStr, "count").intValue() , 10 , currentPage));

        /**
         * 获取分类
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_AUDIO_CLASS_DETAIL, params);
        mav.getModelMap().put("classes", JsonUtil.jsonToList(returnStr, "list", AudioClassDetail.class));
        
        /**
         * 获取听书播放记录
         */
        Long userId = getLoginUserId(request);
        if(userId != null){
        	params.clear();
            params.put("userId", userId);
            params.put("pageSize", 3);
            returnStr = ClientUtil.getStringClient(ClientURL.LIST_AUDIO_READ_LOG_DETAIL, params);
            mav.getModelMap().put("listAudioReadLogDetail", JsonUtil.jsonToList(returnStr, "list", AudioReadLogDetail.class));
        }
        
        /**
         * 获取推荐听书
         */
        params.clear();
        params.put("pageSize", 3);
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_RANDOM_GET_AUDIO_BOOK_INFO, params);
        mav.getModelMap().put("listRandomGetAudioBookInfo", JsonUtil.jsonToList(returnStr, "list", AudioBookInfo.class));
        
        mav.setViewName("/audio/room");
        return mav;
    }

    @RequestMapping("/detail")
	public ModelAndView detail(@RequestParam("bookId") String bookId,
			@RequestParam(required = false) String cname,
			@RequestParam(required = false) String tname,
			HttpServletRequest request) throws Exception {
    	ModelAndView mav = new ModelAndView();
    	
        getOrgTreeId(request);
        mav.getModelMap().put("orgTreeId", orgTreeId);
        mav.getModelMap().put("cname", cname);
        mav.getModelMap().put("tname", tname);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orgTreeId", orgTreeId);
        params.put("bookIds", new String[] { bookId });

        /**
         * 获取听书信息
         */
        String returnStr = ClientUtil.getStringClient(ClientURL.LIST_AUDIO_BOOK_DETAIL, params);
        List<AudioBookDetail> detail = JsonUtil.jsonToList(returnStr, "list", AudioBookDetail.class);
        
        if(detail.size() == 0 || !detail.get(0).getBookInfo().getShelves().equals(1)){
        	mav.setViewName("redirect:/error.action?errorCode=b001&returnUrl=/audio/room.action");
    		return mav;
        }
        
        mav.getModelMap().put("detail", detail.get(0));

        /**
         * 放入听书分类列表
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_AUDIO_CLASS_DETAIL, params);
        mav.getModelMap().put("classes", JsonUtil.jsonToList(returnStr, "list", AudioClassDetail.class));

        /**
         * 放入听书音频列表
         */
        params.clear();
        params.put("bookId", bookId);
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_AUDIO, params);
        mav.getModelMap().put("audioes", JsonUtil.jsonToList(returnStr, "list", AudioInfo.class));
        
        Long userId = getLoginUserId(request);
        if(userId != null){
        	/**
             * 获取听书播放记录
             */
        	params.clear();
            params.put("userId", userId);
            params.put("pageSize", 3);
            returnStr = ClientUtil.getStringClient(ClientURL.LIST_AUDIO_READ_LOG_DETAIL, params);
            mav.getModelMap().put("listAudioReadLogDetail", JsonUtil.jsonToList(returnStr, "list", AudioReadLogDetail.class));
        }
        
        /**
         * 获取音频播放权限
         */
		params.put("userId", userId);
		returnStr = ClientUtil.getStringClient(ClientURL.GET_AUDIO_PLAYER_FUNC,
				params);
		mav.getModelMap().put("playerFunc", JsonUtil.getInt(returnStr, "func"));
        
        /**
         * 获取推荐听书
         */
        params.clear();
        params.put("pageSize", 3);
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_RANDOM_GET_AUDIO_BOOK_INFO, params);
        mav.getModelMap().put("listRandomGetAudioBookInfo", JsonUtil.jsonToList(returnStr, "list", AudioBookInfo.class));
        
        mav.setViewName("/audio/detail");
        
        setStaticModel(AudioConstants.class, request);

        return mav;
    }

    @RequestMapping("/getAudioData")
    public void getAudioData(@RequestParam("chapterNo") String chapterNo, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("chapterNo", chapterNo);
        params.put("userId", getLoginUserId(request));

        /**
         * 获取听书信息
         */
        String json = ClientUtil.getStringClient(ClientURL.GET_AUDIO_TOKEN, params);
        JSONObject token = JSONObject.fromObject(json).getJSONObject("token");
        if (token != null && token.containsKey("key")) {
            response.sendRedirect(ClientURL.RESOURCES_PREFIX + "/player.action?m=" + token.getString("key") + "&c=" + token.getString("content"));
        }
//        response.sendRedirect("/2.mp3");
    }

    @RequestMapping("/typeindex")
    public ModelAndView typeIndex(HttpServletRequest request) throws Exception {
        
        getOrgTreeId(request);
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("orgTreeId", orgTreeId);
        String returnStr = ClientUtil.getStringClient(ClientURL.LIST_AUDIO_CLASS_DETAIL, new HashMap<String, Object>());
        mav.getModelMap().put("classes", JsonUtil.jsonToList(returnStr, "list", AudioClassDetail.class));
        mav.setViewName("/audio/typeIndex");
        return mav;
    }

}
