package cn.chineseall.book.controller.org;

import java.util.HashMap;
import java.util.List;
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
import cn.chineseall.model.eduyun.EduBookPackage;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.ImageUtils;
import cn.chineseall.utils.JsonUtil;
@Controller
@RequestMapping("/eduyun/package/")
public class BookPackagesController extends BaseController{
	
	 @Resource
	 private BookService bookService;
	 
	/**
	 * 图书专辑
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/listBookPackages")
	public ModelAndView listBookPackages(HttpServletRequest request, 
			@RequestParam(required = true, value = "categoryId" , defaultValue="2") Long categoryId) throws Exception{
		
		ModelAndView mav = new ModelAndView();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("categoryId", categoryId);
        params.put("userId", getLoginUserId(request));
        /**
         * 按类别获取专辑推荐
         */
        String returnStr = ClientUtil.getStringClient(ClientURL.LIST_BOOK_PACKAGES_BY_CATEGORY, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	Map<String,Object> bookPackages = JsonUtil.jsonToObject(returnStr, "data", HashMap.class);
        	List<Map> categorieList = JsonUtil.jsonToList(returnStr, "categorieList", Map.class);
        	mav.getModelMap().put("bookPackages", bookPackages);
        	mav.getModelMap().put("categorieList", categorieList);
        }
        setStaticModel(ImageUtils.class, request);
        mav.setViewName("/org/package");
        mav.getModelMap().put("categoryId", categoryId);
		return mav;
		
	}
	/**
	 * 专辑推荐详情页
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/detail")
	public ModelAndView detail(Long id,HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String , Object>  params = new HashMap<String , Object>();
		params.put("id", id);
		params.put("userId", getLoginUserId(request));
        String returnStr = ClientUtil.getStringClient(ClientURL.GET_BOOK_PACKAGE_BY_ID, params);
        if(returnStr != null && !"".equals(returnStr)){
        	Map<String, Object> bookPackages = JsonUtil.jsonToObject(returnStr, "data", HashMap.class);
        	mav.getModelMap().put("bookPackages", bookPackages);
        	mav.getModelMap().put("buy", JsonUtil.getInt(returnStr, "buy"));
        	mav.getModelMap().put("count", JsonUtil.getLong(returnStr, "count"));
        	EduBookPackage eduBookPackage = JsonUtil.jsonToObject(returnStr,"data", "package",EduBookPackage.class);
        	params.put("categoryId", eduBookPackage.getCategoryId());
            params.put("limits", 6);
            returnStr = ClientUtil.getStringClient(ClientURL.LIST_OTHER_BOOK_PACKAGES, params);
            if(returnStr!=null && !"".equals(returnStr)){
            	mav.getModelMap().put("bookPackageList", JsonUtil.jsonToList(returnStr, "data", HashMap.class));
            }
        }
        
        setStaticModel(ImageUtils.class, request);
		mav.setViewName("/org/detail");
		return mav;
	}

}
