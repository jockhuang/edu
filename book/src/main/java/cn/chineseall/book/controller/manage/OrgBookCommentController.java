package cn.chineseall.book.controller.manage;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.controller.BaseController;
import cn.chineseall.model.org.vo.OrgBookCommentQueryVo;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.PageUtil;
import cn.chineseall.utils.RequestUtil;

@Controller
@RequestMapping("/manage/bookcomment/")
public class OrgBookCommentController extends BaseController {
    
    @RequestMapping("listOrgBookComment")
    public ModelAndView  listOrgBookComment(OrgBookCommentQueryVo bookCommentQueryVo, HttpServletRequest request) throws Exception{
        if(bookCommentQueryVo.getCurrentPage()==null || bookCommentQueryVo.getCurrentPage().intValue() == 0){
            bookCommentQueryVo.setCurrentPage(1);
        }
        bookCommentQueryVo.setPageSize(pageSize);
        bookCommentQueryVo.setOrgTreeId(orgTreeId);
        Map<String, Object> prameters = new HashMap<String, Object>();
        prameters.put("queryVo", bookCommentQueryVo);
        bookCommentQueryVo = ClientUtil.getObjectClient(ClientURL.LIST_ORG_BOOK_COMMENT, prameters, OrgBookCommentQueryVo.class);
        PageUtil pageUtil = new PageUtil(null,bookCommentQueryVo.getTotalCount().intValue(),bookCommentQueryVo.getPageSize(), bookCommentQueryVo.getCurrentPage());
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/manage/bookcomment/listOrgBookComment");
        mav.getModelMap().put("bookCommentQueryVo", bookCommentQueryVo);
        mav.getModelMap().put("pageUtil", pageUtil);
        mav.getModelMap().put("queryCondition", RequestUtil.getQueryCondition(request));
        return mav;        
    }
    
    @RequestMapping("deleteOrgBookComment")
    public String  deleteOrgBookComment(Long[] commentIds) throws Exception{
        Map<String, Object> prameters = new HashMap<String, Object>();
        prameters.put("orgTreeId", orgTreeId);
        prameters.put("commentIds", commentIds);
        ClientUtil.getStringClient(ClientURL.DELETE_ORG_BOOK_COMMENT, prameters);
        return "redirect:/manage/bookcomment/listOrgBookComment.action";        
    }
}
