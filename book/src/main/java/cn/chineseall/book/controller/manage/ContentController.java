package cn.chineseall.book.controller.manage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.controller.BaseController;

@Controller
@RequestMapping("/manage/content/")
public class ContentController extends BaseController {

    @RequestMapping("showPosition")
    public ModelAndView showPosition(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/manage/content/showPosition");
        return mav;
    }
}
