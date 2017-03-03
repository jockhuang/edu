package cn.chineseall.book.controller.search;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.controller.BaseController;
import cn.chineseall.book.model.SearchBook;
import cn.chineseall.book.model.SearchVo;
import cn.chineseall.book.service.BookService;
import cn.chineseall.book.service.SearchService;
import cn.chineseall.utils.ImageUtils;
import cn.chineseall.utils.PageUtil;
import cn.chineseall.utils.RequestUtil;

@Controller
@RequestMapping("/search")
public class SearchController extends BaseController {
    @Resource
    SearchService bookSearchService;
    
    @Resource
	private BookService service;

    @RequestMapping("/book")
    public ModelAndView book(Integer currentPage, Integer pageSize, SearchVo s, HttpServletRequest request) throws Exception {
        currentPage = currentPage == null ? 1 : currentPage;
        pageSize = pageSize == null ? 20 : pageSize;
        s.getPageUtil().setCurrentPage(currentPage);
        s.getPageUtil().setPageSize(pageSize);
        ModelAndView mav = new ModelAndView();
        s = bookSearchService.search(s);
        PageUtil pageUtil = s.getPageUtil();
        /**
		 * 查看用户是否购买图书
		 */
        Set<Long> bookIds = new HashSet<Long>();
        if(s.getResult()!=null){
        	for (Object obj : s.getResult()) {
        		SearchBook book = (SearchBook) obj;
        		bookIds.add(book.getId());
        	}
        }
        mav.getModelMap().put("buyInfos", service.getBuyInfo(bookIds, getLoginUserId(request)));
        String queryCondition = RequestUtil.getQueryCondition(request);
        setStaticModel(ImageUtils.class, request);
        mav.getModelMap().put("search", s);
        mav.getModelMap().put("pageUtil", pageUtil);
        mav.getModelMap().put("queryCondition", queryCondition);
        mav.setViewName("/search/book");
        return mav;
    }
}
