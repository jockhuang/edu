package cn.chineseall.book.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.model.user.UserBaseinfo;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.CookiesUtil;
import cn.chineseall.utils.DomainUtil;
import cn.chineseall.utils.EncodeUtil;

@Controller
@RequestMapping("/password")
public class FindPasswordController extends BaseController {

    private static final String FIND_PASS_UNAME_KEY = "find_pass_email_cookies_key";
    
    private static final String FIND_PASS_EMAIL_KEY = "find_pass_email_cookies_key";
    
    @RequestMapping("/showFindPass")
    public ModelAndView showFindPass(String msg){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/findPass");
        mav.getModelMap().put("msg", msg);
        return mav;
    }
    
    @RequestMapping("/findPassword")
    public ModelAndView findPassword(String userName, HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/findPass");
        if(userName == null || "".equals(userName.trim())){
            mav.getModelMap().put("msg", "请输入用户名!");
            return mav;
        }
        //根据用户名获取用户userBaseinfo信息
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("userName", userName);
        HashMap userInfoMap = ClientUtil.getObjectClient(ClientURL.GET_USER_PASS_INFO_BY_USERNAME, parameters, HashMap.class);
        if(userInfoMap!=null){
            mav.getModelMap().put("userInfoMap", userInfoMap);
            CookiesUtil.setCookie(response, DomainUtil.getCommonDomain(request), FIND_PASS_UNAME_KEY, EncodeUtil.encode(userName), null);
        }else{
            mav.getModelMap().put("用户名不存在!", "请输入用户名!");
        }
        return mav;
    }
    
    @RequestMapping("/sendMail")
    public ModelAndView sendMail(Integer type1,Integer type2, HttpServletRequest request){
        
        ModelAndView mav = new ModelAndView("/findPass");
        String referer = request.getHeader("referer");
        //判断跳转信息
        if(referer==null || !referer.contains("findPassword.action")){
            return showFindPass("请输入用户名!");
        }
        String userName = null;
        String userNameEncode = CookiesUtil.getCookie(request,FIND_PASS_UNAME_KEY);
        if(userNameEncode != null && !"".equals(userNameEncode)){
           userName = EncodeUtil.decode(userNameEncode); 
        }
        if(userName == null || "".equals(userName.trim())){
            mav.getModelMap().put("msg", "请输入用户名!");
            return mav;
        }
        
        //根据用户名获取用户userBaseinfo信息
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("userName", userName);
        HashMap<String, Object> userInfoMap = ClientUtil.getObjectClient(ClientURL.GET_USER_PASS_INFO_BY_USERNAME, parameters, HashMap.class);
        
        
        if(userInfoMap!=null && userInfoMap.get("email")!=null  && type1!=null && type1.intValue() == 1){
            //发送邮件
            Map<String, Object> emailParam = new HashMap<String, Object>();
            emailParam.put("from", "dushu@chineseall.com");
            emailParam.put("to", userInfoMap.get("email").toString());
            emailParam.put("title", "书香中国密码找回邮件");
            emailParam.put("content", "亲爱的用户,您的密码是:"+userInfoMap.get("userPass"));
            ClientUtil.getStringClient(ClientURL.SEND_EMAIL, emailParam);
            mav.getModelMap().put("msg", "邮件已发送,请查看您的邮箱!");
            mav.getModelMap().put("result", "1");
        }
        if(userInfoMap!=null && userInfoMap.get("qq")!=null  && type2!=null && type2.intValue() == 2){
            Map<String, Object> emailParam = new HashMap<String, Object>();
            emailParam.put("from", "dushu@chineseall.com");
            emailParam.put("to", userInfoMap.get("qq").toString());
            emailParam.put("title", "书香中国密码找回邮件");
            emailParam.put("content", "亲爱的用户,您的密码是:"+userInfoMap.get("userPass"));
            ClientUtil.getStringClient(ClientURL.SEND_EMAIL, emailParam);
            mav.getModelMap().put("msg", "邮件已发送,请查看您的邮箱");
            mav.getModelMap().put("result", "1");
        }
        
        if(userInfoMap == null ||  (userInfoMap.get("email") == null && userInfoMap.get("qq")==null)){
        	mav.getModelMap().put("msg", "该用户名未设置邮箱，无法使用邮箱找回密码功能!");
            mav.getModelMap().put("result", "0");
        }
        return mav;
    }
    
}
