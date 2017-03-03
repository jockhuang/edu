package cn.chineseall.book.controller.manage;

import java.io.File;
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
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.controller.BaseController;
import cn.chineseall.model.activity.AcBaseinfo;
import cn.chineseall.model.activity.AcConfig;
import cn.chineseall.model.activity.AcFriendLink;
import cn.chineseall.model.activity.AcJury;
import cn.chineseall.model.activity.AcOrgSetting;
import cn.chineseall.model.activity.AcWorksGroup;
import cn.chineseall.model.activity.vo.AcWorks;
import cn.chineseall.model.activity.vo.AcWorksQueryVo;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.JsonUtil;
import cn.chineseall.utils.PageUtil;
import cn.chineseall.utils.RequestUtil;

@Controller
@RequestMapping("/manage/activity/works")
public class ActivityFriendLinkController extends BaseController {
    
	@Resource(type=org.apache.commons.configuration.PropertiesConfiguration.class)
    private PropertiesConfiguration fileUploadConfig;
	
    /**
	 * 获取友情链接列表
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
    @RequestMapping("/listAcFriendLink")
	public ModelAndView listAcFriendLink(@RequestParam(value="activityId") Long activityId,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("activityId", activityId);
    	params.put("orgTreeId", getOrgTreeId(request));
       	params.put("userId", getLoginUserId(request));

       	ModelAndView mav = new ModelAndView();
        /**
         * 获取友情链接列表
         */
        String returnStr = ClientUtil.getStringClient(ClientURL.LIST_AC_FRIEND_LINK, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("friends", JsonUtil.jsonToList(returnStr, "friends", AcFriendLink.class));
        }
        /**
         * 获取活动信息
         */
        returnStr=ClientUtil.getStringClient(ClientURL.GET_ACTIVITY_DETAIL, params);
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
        mav.getModelMap().put("activityId", activityId);
        mav.setViewName("/manage/activity/listFriendLink");
        return mav;
	}
   /**
	 * 修改友情链接信息
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
    @RequestMapping("/updateAcFriendLink")
	public ModelAndView updateAcFriendLink(@RequestParam(value="activityId") Long activityId,
			@RequestParam(value="id",required = false) Long[] id,
			@RequestParam(value="sort",required = false) Integer[] sort,
			@RequestParam(value="friendName") String[] name,
			@RequestParam(value="linkFile",required=false) MultipartFile[] multipartFile,
			@RequestParam(value="url",required = false) String[] url,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("activityId", activityId);
    	params.put("orgTreeId", getOrgTreeId(request));
       	params.put("userId", getLoginUserId(request));
        params.put("id", id);
        params.put("sort", sort);
        params.put("name", name);
        params.put("url", url);
        String[] imgUrl=null;
        if(multipartFile!=null){
        	imgUrl=new String[multipartFile.length];
        	MultipartFile file=null;
        	for(int i=0;i<multipartFile.length;i++){
        		file=multipartFile[i];
        		if(file!=null && file.getSize()!=0){
        			String srcPath="/activity/pic/"+getLoginUserId(request)+"/";
        			String imgFileFileName=null;
        			if(file!=null && file.getSize()!=0){
        	        	//取得文件名字
        	            imgFileFileName=System.currentTimeMillis()+"";
        	            String baseDir = fileUploadConfig.getString("image_upload_base_dir");
        	            imgUrl[i]=uploadImg(baseDir, srcPath,imgFileFileName, file);
        	        }
        		}
        	}
        }else{
        	imgUrl=new String[name.length];
        }
        params.put("imgUrl", imgUrl);
        /**
         * 修改友情链接信息
         */
        ClientUtil.getStringClient(ClientURL.UPDATE_AC_FRIEND_LINK, params);
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("activityId", activityId);
        mav.setViewName("redirect:/manage/activity/works/listAcFriendLink.action");
        return mav;
	}
}
