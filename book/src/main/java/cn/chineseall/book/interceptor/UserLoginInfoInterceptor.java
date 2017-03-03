package cn.chineseall.book.interceptor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.controller.LoginController;
import cn.chineseall.book.service.APIService;
import cn.chineseall.model.eduyun.EduUser;
import cn.chineseall.model.user.UserLoginLog;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.CookiesUtil;
import cn.chineseall.utils.DomainUtil;
import cn.chineseall.utils.EncodeUtil;
import cn.chineseall.utils.JsonUtil;
import cn.chineseall.utils.MD5;


public class UserLoginInfoInterceptor extends HandlerInterceptorAdapter {
    
    private static Logger logger = LoggerFactory.getLogger(UserLoginInfoInterceptor.class);
    
    @Resource
    private APIService aPIService;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        AttributePrincipal principal = (AttributePrincipal)request.getUserPrincipal();
        String usersessionId = "";//principal.getName();
        //获取token值
        String token = aPIService.getToken();        
        EduUser user = aPIService.getUserInfoBySessionId(usersessionId, token);
        request.setAttribute("sessionId", usersessionId);
        request.setAttribute("persionId", user.getPersonid());
        //根据用户名获取书香用户，设置用户id
        Long userId = getUserId(user);
        //验证用户cookie信息有效性
        String cookiesDomain = DomainUtil.getCommonDomain(request);
        String uidCookieValue = EncodeUtil.encode(userId);
        CookiesUtil.setCookie(response, cookiesDomain, LoginInterceptor.UID_COOKIE_KEY, uidCookieValue, null);
        CookiesUtil.setCookie(response, cookiesDomain, LoginInterceptor.UID_VALID_COOKIE_KEY, MD5.getMD5(userId.toString()+LoginInterceptor.UID_MD5_KEY), null);
        if(userId!=null){
            request.setAttribute("userId", userId);
            request.setAttribute("personId", user.getPersonid());
            //查看用户是否是再次登录
            String reOpen = CookiesUtil.getCookie(request, LoginController.LOGIN_EXPIRE_TAG);
            if(reOpen!=null){
                reOpen = EncodeUtil.decode(reOpen);
            }
            if(reOpen==null || !"LoginOK".equals(reOpen)){
                //发送获取系统消息的请求
                CookiesUtil.setCookie(response, cookiesDomain, LoginController.LOGIN_EXPIRE_TAG, EncodeUtil.encode("LoginOK"), null);
                try{
                    //记录登录日志
                    UserLoginLog userLoginLog = new UserLoginLog();
                    userLoginLog.setLoginIp(request.getRemoteAddr());
                    userLoginLog.setLoginTime(new Date());
                    userLoginLog.setOrgTreeId(getOrgTreeId(request));
                    userLoginLog.setUserId(userId);
                    
                    Map<String, Object> loginParams = new HashMap<String, Object>();
                    loginParams.put("userLoginLog", userLoginLog);
                    ClientUtil.getStringClient(ClientURL.Add_USER_LOGIN_LOG, loginParams);
                    
                    //发送更新系统站内信的消息
                    Map<String, Object> parameter = new HashMap<String, Object>();
                    parameter.put("userId", userId);
                    ClientUtil.getStringClient(ClientURL.FETCH_LETTER, parameter);
                }catch(Exception e){
                    logger.error("更新系统消息失败!", e);
                }
            }
        }
        return super.preHandle(request, response, handler);
    }
    
    private Long getUserId(EduUser user) throws Exception {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("user", user);
        String returnStr = ClientUtil.getStringClient(ClientURL.IMPORT_EDUYUN_USER, parameter);
        Integer result = JsonUtil.getInt(returnStr, "result");
        if(result != null && result.intValue()== 1){
            return JsonUtil.getLong(returnStr, "userId");
        }
        return null;
    }

    private Long getOrgTreeId(HttpServletRequest request){
        Long orgTreeId = Long.valueOf(request.getAttribute("orgTreeId").toString());
        return orgTreeId;
    }
}
