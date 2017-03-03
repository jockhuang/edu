package cn.chineseall.book.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.model.ErrorCode;
import cn.chineseall.utils.ClientUtil;

@Controller
@RequestMapping("/")
public class ErrorController extends BaseController {

    /**
     * 根据错误码展示错误信息
     * 
     * @param errorCode
     * @return
     */
    @RequestMapping("/error")
    public ModelAndView error(String errorCode){
        //根据错误码展示错误信息
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("code", errorCode);
        ErrorCode errCode = ClientUtil.getObjectClient(ClientURL.GET_ERROR_BY_CODE, parameters, ErrorCode.class);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/error");
        mav.getModelMap().put("errorCode", errCode);
        return mav;
    }
    
}
