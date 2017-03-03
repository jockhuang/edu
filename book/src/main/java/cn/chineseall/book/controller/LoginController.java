package cn.chineseall.book.controller;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.interceptor.LoginInterceptor;
import cn.chineseall.model.user.User;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.CookiesUtil;
import cn.chineseall.utils.DomainUtil;
import cn.chineseall.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class LoginController extends BaseController {
    
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    
    public static final String LOGIN_EXPIRE_TAG = "bookchina_expire_tag";
    
    @RequestMapping("/showLogin")
    public ModelAndView showLogin(String returnUrl, HttpServletRequest request, HttpServletResponse response){   
        logout(request, response);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/logon");
        mav.getModelMap().put("returnUrl", returnUrl);
        return mav;
    }
    

    /**
     * 弹层登录程序
     * 
     * @param type
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/login")
    public ModelAndView login(Integer type,HttpServletRequest request, HttpServletResponse response) throws Exception{
       
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/login");
        mav.getModelMap().put("type", type);
        
        //先从cookie里获取用户id,若用户id存在则直接跳转,否则执行登录操作   
        User user = getUser(request);
        if(user!=null){
            mav.getModelMap().put("user", user);
            return mav;
        }
        //跳转到登录页面进行登录验证
        String cookieDomain = DomainUtil.getCommonDomain(request);
        User loginUser = null;//oauthLogin(cookieDomain, request, response);
        if(loginUser == null){
            return null;
        }else{
            if(loginUser.getType()!=null && loginUser.getType().intValue() == 1){
                mav.getModelMap().put("returnUrl", "/jury/activity/listJuryActivity.action");
            }
        }
        return mav;
    }
    
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        
        String domain = DomainUtil.getCommonDomain(request);
        String accessTokenKey = "bookchina.accessToken";
        String uidKey = "bookchina_uid";
        
        String accessTokenCookie = CookiesUtil.getCookie(request, accessTokenKey);
        CookiesUtil.delCookie(response, domain, "/", accessTokenKey, accessTokenCookie);
        
        String uid = CookiesUtil.getCookie(request, uidKey);
        CookiesUtil.delCookie(response, domain, "/", uidKey, uid);
        
        String encodeVlid = CookiesUtil.getCookie(request, LoginInterceptor.UID_VALID_COOKIE_KEY);
        CookiesUtil.delCookie(response, domain,"/", LoginInterceptor.UID_VALID_COOKIE_KEY, encodeVlid);
        
        String encodeUserType = CookiesUtil.getCookie(request, LoginInterceptor.USERTYPE_COOKIE_KEY);
        CookiesUtil.delCookie(response, domain,"/", LoginInterceptor.USERTYPE_COOKIE_KEY, encodeUserType);
        
        return "redirect:/org/index.action";
    }
    

    
    @ResponseBody
    @RequestMapping("/getLoginInfo")
    public Map<String, Object> getLoginInfo(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Long userId = super.getLoginUserId(request);
        HashMap<String, Object> loginUserInfo = null;
        if(userId !=null){
           Map<String, Object> parameters = new HashMap<String, Object>();
           parameters.put("userId", userId);
           String resultStr = ClientUtil.getStringClient(ClientURL.GET_LOGIN_USER_INFO, parameters);
           loginUserInfo = JsonUtil.fromJsonToObject(resultStr, HashMap.class);
        }else{
            loginUserInfo = new HashMap<String, Object>();
            loginUserInfo.put("result", 0);
        }
        return loginUserInfo;
    }
    

}
