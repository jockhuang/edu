package cn.chineseall.book.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.interceptor.LoginInterceptor;
import cn.chineseall.constants.OrgConstants;
import cn.chineseall.model.org.OrgTree;
import cn.chineseall.model.user.User;
import cn.chineseall.model.user.vo.UserInfo;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.CookiesUtil;
import cn.chineseall.utils.EncodeUtil;
import cn.chineseall.utils.JsonUtil;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateModelException;

public class BaseController extends BaseExceptionController{

    protected Integer pageSize = 10;

    protected Integer currentPage = 1;
    
    protected Long orgTreeId;

	public void setStaticModel(Class clazz, HttpServletRequest request) {
		setStaticModel(clazz.getSimpleName(), clazz, request);
	}

	public void setStaticModel(String name, Class clazz,
			HttpServletRequest request) {
		BeansWrapper wrapper = BeansWrapper.getDefaultInstance();
		Object model = null;
		try {
			model = wrapper.getStaticModels().get(clazz.getName());
		} catch (TemplateModelException e) {
			e.printStackTrace();
		}
		if (model != null) {
			request.setAttribute(name, model);
		}
	}

    /**
     * 获取当前登录用户信息
     * 并且对用户信息进行一次验证
     * @param request
     * @return
     */
    public Long getLoginUserId(HttpServletRequest request) {
        Object userIdObj = request.getAttribute("userId");
        Long userId = null;
        if(userIdObj != null){
            userId = Long.valueOf(userIdObj.toString());
        }
        return userId;
    }
    
    /**
     * 获取当前登录用户JsessionId
     * 并且对用户信息进行一次验证
     * @param request
     * @return
     */
    public String getSessionId(HttpServletRequest request) {
    	Object sessionIdObj = request.getAttribute("sessionId");
        String sessionId = null;
        if(sessionIdObj != null){
        	sessionId = sessionIdObj.toString();
        }
        return sessionId;
    }

    /**
     * 获取当前访问orgTreeId
     * 
     * @param request
     * @return
     */
    @ModelAttribute("orgTreeId")
    protected Long getOrgTreeId(HttpServletRequest request) {
        Object orgTreeIdObj = request.getAttribute("orgTreeId");
        if (orgTreeIdObj != null) {
            orgTreeId = Long.valueOf(orgTreeIdObj.toString());
            return orgTreeId;
        }
        orgTreeId = OrgConstants.DEFAULT_ORG_TREE_ID;
        return OrgConstants.DEFAULT_ORG_TREE_ID;
    }

    protected User getUser(HttpServletRequest request) throws Exception {
        User user = getUser(getLoginUserId(request));
        String encodeUserType = CookiesUtil.getCookie(request, LoginInterceptor.USERTYPE_COOKIE_KEY);
        String userType = null;
        if(encodeUserType!=null && !"".equals(encodeUserType)){
            userType = EncodeUtil.decode(encodeUserType);
        }
        if(userType!=null && !"".equals(userType)){
            user.setType(Integer.valueOf(userType));
        }
        return user;
    }

    protected User getUser(Long userId) throws Exception {
        if (userId != null) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("userId", userId);
            String returnStr = ClientUtil.getStringClient(ClientURL.GET_USER, params);
            List<User> user = JsonUtil.jsonToList(returnStr, "list", User.class);
            return user.size() > 0 ? user.get(0) : null;
        }
        return null;
    }
    
    protected OrgTree getOrgTree(HttpServletRequest request) throws Exception{
    	if(getOrgTreeId(request) != null && getOrgTreeId(request) >0L){
    		Map<String , Object> params = new HashMap<String , Object>();
    		params.put("orgTreeId", getOrgTreeId(request));
    		String returnStr = ClientUtil.getStringClient(ClientURL.GET_ORG_ORGTREE, params);
    	    OrgTree orgTree = JsonUtil.jsonToObject(returnStr,  OrgTree.class);
    	    
    	    return orgTree != null ? orgTree : null;
    	}
    	return null;
    }
    public UserInfo getUserInfo(HttpServletRequest request) throws Exception {
        return getUserInfo(getLoginUserId(request));
    }

    public UserInfo getUserInfo(Long userId) throws Exception {
        if (userId != null) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("userId", userId);
            String returnStr = ClientUtil.getStringClient(ClientURL.GET_USER_INFO, params);
            List<UserInfo> userInfo = JsonUtil.jsonToList(returnStr, "list", UserInfo.class);
            return userInfo.size() > 0 ? userInfo.get(0) : null;
        }
        return null;
    }

    protected String uploadImg(String baseDir, String url, String fileName, MultipartFile uploadImg) throws IOException {
        if (!uploadImg.isEmpty()) {
            byte[] bytes = uploadImg.getBytes();
            File distFile = new File(baseDir + url, fileName);
            if (!distFile.getParentFile().exists()) {
                distFile.getParentFile().mkdirs();
            }
            if (!distFile.exists()) {
                distFile.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(distFile);
            fos.write(bytes);
            fos.flush();
            fos.close();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            url = url + distFile.getName();
        } else {
            url = null;
        }
        return url;
    }
}
