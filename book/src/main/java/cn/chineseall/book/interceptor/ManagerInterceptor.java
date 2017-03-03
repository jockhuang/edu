package cn.chineseall.book.interceptor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.JsonUtil;

public class ManagerInterceptor  extends HandlerInterceptorAdapter {
    
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
	    Long userId = getUserId(request);
	    //尚未登录
	    if(userId==null){
	        return false;
	    }
	    //获取当前用户拥有的权限树列表
	    Map<String, Object> parameters = new HashMap<String,Object>();
        parameters.put("userId", userId);
        List<HashMap> inchargeTreeList = ClientUtil.getListClient(ClientURL.GET_ORG_TREE_INCHARGE, parameters, HashMap.class);
	    request.setAttribute("inchargeTreeList", inchargeTreeList);
	   
	    //检查用户是否拥有此机构树管理权限
	    boolean flag = false;
	    Object orgTreeIdStr = request.getAttribute("orgTreeId");
	    if(orgTreeIdStr!=null){
	        long orgTreeId = Long.valueOf(orgTreeIdStr.toString());
	        for(HashMap inchargeTree : inchargeTreeList){
	            long id = Long.valueOf(inchargeTree.get("id").toString());
	            if(id==orgTreeId){
	                request.setAttribute("currentOrgTree", inchargeTree); 
	                flag = true;
	                break;
	            }
	        }
	    }else{
	        if(inchargeTreeList!=null && inchargeTreeList.size()>0){
	            request.setAttribute("currentOrgTree", inchargeTreeList.get(0)); 
                request.setAttribute("orgTreeId", inchargeTreeList.get(0).get("id")); 
                flag = true;
            }
	    }
	    if(!flag){
	        if(inchargeTreeList!=null && inchargeTreeList.size()>0){
	            HashMap currentOrgTree = inchargeTreeList.get(0);
                request.setAttribute("currentOrgTree", currentOrgTree); 
                request.setAttribute("orgTreeId", currentOrgTree.get("id")); 
                //跳转到权限管理页
                if(currentOrgTree.get("domainName")!=null && !"".equals(currentOrgTree.get("domainName").toString().trim()) && inchargeTreeList.size() > 1){
                    response.sendRedirect("http://"+currentOrgTree.get("domainName")+"/manage/tree/selectTree.action?orgTreeId="+currentOrgTree.get("id"));
                }else if(currentOrgTree.get("domainName")!=null && !"".equals(currentOrgTree.get("domainName").toString().trim()) && inchargeTreeList.size() ==1){
                    response.sendRedirect("http://"+currentOrgTree.get("domainName")+"/manage/tree/showUpdate.action?orgTreeId="+currentOrgTree.get("id"));
                }else if((currentOrgTree.get("domainName")==null || "".equals(currentOrgTree.get("domainName").toString().trim())) && inchargeTreeList.size() > 1){
                    response.sendRedirect("http://"+currentOrgTree.get("nodeDomainName")+"/manage/tree/selectTree.action?orgTreeId="+currentOrgTree.get("id"));
                }else if((currentOrgTree.get("domainName")==null || "".equals(currentOrgTree.get("domainName").toString().trim())) && inchargeTreeList.size() ==1){
                    response.sendRedirect("http://"+currentOrgTree.get("nodeDomainName")+"/manage/tree/showUpdate.action?orgTreeId="+currentOrgTree.get("id"));
                }
            }else{
    	        response.sendRedirect("/error.action?errorCode=0003");
    	        return false;
            }
	    }
	    
	    //检查用户是否有管理员设置模块权限
	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put("userId", getUserId(request));
	    params.put("orgTreeId", orgTreeIdStr);
	    Integer result = JsonUtil.getInt(ClientUtil.getStringClient(ClientURL.IS_ORG_MANAGER, params), "result");
	    if(result==0){
	    	request.setAttribute("isOrgManager", 0); 
	    }else{
	    	request.setAttribute("isOrgManager", 1); 
	    }
	    Map<String, Object> urlMap = new HashMap<String, Object>();
	    urlMap.put("/manage/user/showADManager.action", 1);
	    urlMap.put("/manage/user/addManager.action", 1);
	    urlMap.put("/manage/user/listManager.action", 1);
	    urlMap.put("/manage/user/showUPManager.action", 1);
	    urlMap.put("/manage/user/updateManager.action", 1);
	    urlMap.put("/manage/user/removePermission.action", 1);
	    if(urlMap.get(request.getRequestURI())!=null){
	         if(result!=0){
	        	 response.sendRedirect("/error.action?errorCode=0002");
	        	 return false;
	         }
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
	
	private Long getUserId(HttpServletRequest request){
        Object userIdObj = request.getAttribute("userId");
        Long userId = null;
        if(userIdObj != null){
            userId = Long.valueOf(userIdObj.toString());
        }
        return userId;
    }
}
