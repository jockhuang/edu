package cn.chineseall.book.controller.manage;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.controller.BaseController;
import cn.chineseall.model.org.vo.OrgBookQueryVo;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.ImageUtils;
import cn.chineseall.utils.JsonUtil;
import cn.chineseall.utils.PageUtil;
import cn.chineseall.utils.RequestUtil;

@Controller
@RequestMapping("/manage/orgbook")
public class OrgBookRecommendController extends BaseController {
    
    @RequestMapping("/listOrgBookRecommend")
    public ModelAndView listOrgtreeBooks(@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage,
    		HttpServletRequest request) throws Exception {
        Map<String, Object> prameters = new HashMap<String, Object>();
        prameters.put("pageSize", pageSize);
        prameters.put("currentPage", currentPage);
        prameters.put("orgTreeId", orgTreeId);
        String returnStr = ClientUtil.getStringClient(ClientURL.LIST_ORG_BOOK_RECOMMEND, prameters);
        OrgBookQueryVo bookQueryVo = JsonUtil.jsonToObject(returnStr, "data", OrgBookQueryVo.class);
        PageUtil pageUtil = new PageUtil(bookQueryVo.getData(),bookQueryVo.getTotalCount().intValue(), pageSize, currentPage);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/manage/orgbook/listOrgBookRecommend");
        mav.getModelMap().put("pageUtil", pageUtil);
        mav.getModelMap().put("queryCondition", RequestUtil.getQueryCondition(request));
        setStaticModel(ImageUtils.class, request);
        return mav;        
    }
    
}
