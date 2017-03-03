package cn.chineseall.book.controller.org;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.controller.BaseController;
import cn.chineseall.book.service.BookService;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.ImageUtils;
import cn.chineseall.utils.JsonUtil;
@Controller
@RequestMapping("/org")
public class OrgNewsController extends BaseController{
	
	 @Resource
	 private BookService bookService;
	 
	/**
	 * 机构新闻列表页
	 * @param orgTreeId
	 * @param currentPage
	 * @param sortType
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/news")
	public ModelAndView news() throws Exception{
		
		ModelAndView mav = new ModelAndView();
        Map<String, Object> params = new HashMap<String, Object>();
        /**
         * 获取文学专辑推荐
         */
        params.put("type", 0);
        params.put("limits", 2);
        String returnStr = ClientUtil.getStringClient(ClientURL.LIST_BOOK_PACKAGES_BY_TYPE, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("bookPackages0", JsonUtil.jsonToList(returnStr, "data", HashMap.class));
        }
        /**
         * 获取英语专辑推荐
         */
        params.put("type", 1);
        params.put("limits", 2);
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_BOOK_PACKAGES_BY_TYPE, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("bookPackages1", JsonUtil.jsonToList(returnStr, "data", HashMap.class));
        }
        
        /**
         * 按类别获取专辑推荐
         */
        Integer[] categoryIds = {1,2,3};
        params.put("categoryIds", categoryIds);
        params.put("limits", 6);
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_BOOK_PACKAGES_BY_CATEGORY, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("bookPackages2", JsonUtil.jsonToObject(JsonUtil.jsonToObject(returnStr, "data", String.class), HashMap.class));
        }
        
        
        mav.setViewName("/org/news");
		return mav;
		
	}
	/**
	 * 专辑推荐详情页
	 * @param orgTreeId
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/detail")
	public ModelAndView detail(@RequestParam("id") Long id,HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String , Object>  params = new HashMap<String , Object>();
		params.put("id", id);
        String returnStr = ClientUtil.getStringClient(ClientURL.GET_BOOK_PACKAGE_BY_ID, params);
        if(returnStr != null && !"".equals(returnStr)){
        	Map<String, Object> bookPackages = JsonUtil.jsonToObject(returnStr, "data", HashMap.class);
        	mav.getModelMap().put("bookPackages", bookPackages);
        }
        
        params.put("type", 0);
        params.put("limits", 2);
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_BOOK_PACKAGES_BY_TYPE, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("bookPackageList", JsonUtil.jsonToList(returnStr, "data", HashMap.class));
        }
        
        setStaticModel(ImageUtils.class, request);
		mav.setViewName("/org/detail");
		return mav;
	}

}
