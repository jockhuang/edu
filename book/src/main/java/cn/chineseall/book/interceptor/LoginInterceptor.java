package cn.chineseall.book.interceptor;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


import cn.chineseall.utils.DomainUtil;


public class LoginInterceptor extends HandlerInterceptorAdapter {
	
    public static final String NAME = "bookchina";
    public static final String UID_COOKIE_KEY = "bookchina_uid";
    public static final String USERTYPE_COOKIE_KEY = "bookchina_utype";
    public static final String UID_VALID_COOKIE_KEY = "bookchina_info_vid";
    public static final String UID_MD5_KEY = "bookchina!@#$%^&*()_+";
    public Set<String> filterControllerSet = new HashSet<String>();
    
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
	    
	    String controllerName = request.getRequestURI();
        if(filterControllerSet.contains(controllerName)){
                return true;
        }else{
            for(String fileterName:filterControllerSet){
                if(controllerName.matches(fileterName)){
                    return true;
                }
            }
        }
        
        //TODO:获取当前用户信息,设置到request范围内，不再使用cookies检查用户信息      
        String cookiesDomain = DomainUtil.getCommonDomain(request);
        Long userId = getUserId(request);
	    if(userId != null){
	        request.setAttribute("userId", userId);
	        return super.preHandle(request, response, handler);
	    }
	    
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,	HttpServletResponse response, Object handler, Exception ex)	throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
	
	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,	ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
	
    public void setFilterControllerSet(Set<String> filterControllerSet) {
        this.filterControllerSet = filterControllerSet;
    }
    
    private Long getUserId(HttpServletRequest request){
        Object userIdObj = request.getAttribute("userId");
        Long userId = null;
        if(userIdObj != null){
            userId = Long.valueOf(userIdObj.toString());
        }
        return userId;
    }
}