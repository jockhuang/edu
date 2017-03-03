package cn.chineseall.book.interceptor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.model.org.OrgAppendModel;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.CookiesUtil;
import cn.chineseall.utils.EncodeUtil;

public class DomainInterceptor extends HandlerInterceptorAdapter {
    
    public final static String ORG_DOMAIN_COOKIE_NAME = "bookchina_domain_cookie";
    public final static String ORG_TREE_ID_COOKIE_NAME = "bookchina_otid";
    private Set<String> filterControllerSet = new HashSet<String>();
    
    @Resource(name = "eduyunConfig")
    private PropertiesConfiguration eduyunConfig;
    
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
	    
	    Long orgTreeId = eduyunConfig.getLong("ORG_TREE_ID");
	    //不需要拦截的URL
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

        //获取当前域名
        String currentDomain = request.getServerName();
        //cookie保存域
        String cookieDomain = "";
        int index = currentDomain.indexOf(".");
        if(index!=-1){
            cookieDomain = currentDomain.substring(index);
        }
        
	    //验证当前域名是否存在
	    Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("domain", currentDomain);
        parameters.put("orgTreeId", orgTreeId);
        parameters.put("fromCookie", false);
        Map<String, Object> currentOrgTree = ClientUtil.getObjectClient(ClientURL.GET_ORG_TREE_By_DOMAIN_AND_ID, parameters, HashMap.class);
	    if(currentOrgTree!=null){
	        List<OrgAppendModel> appendModelList = ClientUtil.getListClient(ClientURL.GET_ORG_TREE_APPEND_MODEL_ID, parameters, OrgAppendModel.class);
	        request.setAttribute("appendModelList", appendModelList);
	        request.setAttribute("currentOrgTree", currentOrgTree);
	        request.setAttribute("orgTreeId", currentOrgTree.get("id"));
	        CookiesUtil.setCookie(response, cookieDomain, ORG_TREE_ID_COOKIE_NAME, EncodeUtil.encode(currentOrgTree.get("id").toString()), 30);
            CookiesUtil.setCookie(response, cookieDomain, ORG_DOMAIN_COOKIE_NAME, EncodeUtil.encode(currentDomain.toString()), 30);
	    }else{
	        //跳转到报错页面!
	        response.sendRedirect("/error.action?errorCode=0001");
	        return false;
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
}