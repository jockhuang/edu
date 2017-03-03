package cn.chineseall.book.controller.manage;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.controller.BaseController;
import cn.chineseall.model.content.WebBookContent;
import cn.chineseall.model.org.vo.OrgBookQueryVo;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.ImageUtils;
import cn.chineseall.utils.JsonUtil;
import cn.chineseall.utils.MD5;
import cn.chineseall.utils.PageUtil;
import cn.chineseall.utils.RequestUtil;

@Controller
@RequestMapping("/manage/content/")
public class BookRecommendController extends BaseController {
	
	@Resource(type=org.apache.commons.configuration.PropertiesConfiguration.class)
    private PropertiesConfiguration fileUploadConfig;

    /**
     * 图书推荐列表
     * 
     * @param request
     * @return
     * @throws Exception 
     */
    @RequestMapping("listBookRecommend")
    public ModelAndView listBookRecommend(HttpServletRequest request, String keywords,
    		@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage) throws Exception{
        ModelAndView mav = new ModelAndView();
        
        /**
         * 查询推荐的图书
         */
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orgTreeId", orgTreeId);
    	params.put("pageSize", pageSize);
    	params.put("currentPage", currentPage);
    	params.put("state", 1);
		params.put("keywords", keywords);
		
        String returnStr = ClientUtil.getStringClient(ClientURL.LIST_HOT_BOOK, params);
        
        /**
         * 处理返回数据
         */
        List<WebBookContent> items = JsonUtil.jsonToList(returnStr, "items", WebBookContent.class);
        Integer totalCount = JsonUtil.getInt(returnStr, "totalCount");
        PageUtil pageUtil = new PageUtil(items, totalCount, pageSize, currentPage);
        
        String queryCondition = RequestUtil.getQueryCondition(request);
        mav.getModelMap().put("currentPage", pageUtil.getCurrentPage());
        mav.getModelMap().put("pageUtil", pageUtil);
        mav.getModelMap().put("queryCondition", queryCondition);
        mav.getModelMap().put("keywords", keywords);
        
        mav.setViewName("/manage/content/listBookRecommend");
        return mav;
    }
    
    /**
     * 添加活动推荐
     * 
     * @param request
     * @return
     * @throws Exception 
     */
    @RequestMapping("listOrgBook")
    public ModelAndView listOrgBook(HttpServletRequest request, String name, String author, String publisher, Long bookId, Integer state,
    		@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage) throws Exception{
        ModelAndView mav = new ModelAndView();
        
        /**
         * 获取该机构的活动
         */
        OrgBookQueryVo queryVo = new OrgBookQueryVo();
        queryVo.setOrgTreeId(orgTreeId);
        queryVo.setName(name);
        queryVo.setAuthor(author);
        queryVo.setPublisher(publisher);
        queryVo.setBookId(bookId);
        queryVo.setState(state);
        queryVo.setPageSize(10);
        queryVo.setCurrentPage(currentPage);
        queryVo.setState(0);
        /**
         * 处理返回数据
         */
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("queryVo", queryVo);
        queryVo = ClientUtil.getObjectClient(ClientURL.LIST_ORG_BOOK, params, OrgBookQueryVo.class);
        PageUtil pageUtil = new PageUtil(queryVo.getData(),queryVo.getTotalCount().intValue(),queryVo.getPageSize(), queryVo.getCurrentPage());
        
        String queryCondition = RequestUtil.getQueryCondition(request);
        mav.getModelMap().put("currentPage", currentPage);
        mav.getModelMap().put("pageUtil", pageUtil);
        mav.getModelMap().put("queryCondition", queryCondition);
        mav.getModelMap().put("queryVo", queryVo);
        setStaticModel(ImageUtils.class, request);
        
        mav.setViewName("/manage/content/listOrgBook");
        return mav;
    }
    

    /**
     * 选用图书
     * 
     * @param request
     * @return
     * @throws Exception 
     */
    @RequestMapping("chooseBook")
    public ModelAndView chooseActivity(HttpServletRequest request,Long id,
    		@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage) throws Exception{
        ModelAndView mav = new ModelAndView();
        
        /**
         * 根据id获取图书
         */
        Map<String, Object> prameters = new HashMap<String, Object>();
        prameters.put("id", id);
        prameters.put("orgTreeId", orgTreeId);
        String returnStr = ClientUtil.getStringClient(ClientURL.GET_ORG_BOOK_DETAIL, prameters);
        Integer result = JsonUtil.getInt(returnStr, "result");
        /**
         * 处理返回数据
         */
        if(result==0){
        	HashMap<String, Object> resultMap = JsonUtil.jsonToObject(returnStr, "bookInfoMap", HashMap.class);
        	mav.getModelMap().put("currentPage", currentPage);
        	mav.getModelMap().put("bookMap", resultMap);
        	setStaticModel(ImageUtils.class, request);
        	mav.setViewName("/manage/content/chooseBook");
        }else{
        	String errorCode = JsonUtil.getString(returnStr, "errorCode");
        	mav.setViewName("redirect:/error.action?errorCode="+errorCode);
        }
        return mav;
    }
    
    /**
     * 添加图书推荐
     * 
     * @param request
     * @return
     */
    @RequestMapping("addBookRecommend")
    public String addBookRecommend(HttpServletRequest request, WebBookContent webBookContent){
    	if(webBookContent!=null){
    		webBookContent.setOrgTreeId(orgTreeId);
    		webBookContent.setType(1);
    		webBookContent.setStatus(1);
    		Map<String, Object> params = new HashMap<String, Object>();
            params.put("webBookContent", webBookContent);
            ClientUtil.getStringClient(ClientURL.ADD_WEB_BOOK_CONTENT, params);
    	}
        return "redirect:/manage/content/listBookRecommend.action";
    }
    
    /**
     * 修改活动推荐
     * 
     * @param request
     * @return
     * @throws Exception 
     */
    @RequestMapping("showUpdateBookRecommend")
    public ModelAndView showUpdateBookRecommend(HttpServletRequest request,
    		@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage,
    		@RequestParam(required = false, value = "id", defaultValue = "1") Long id) throws Exception{
    	
        ModelAndView mav = new ModelAndView();
        
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("orgTreeId", orgTreeId);
        String returnStr = ClientUtil.getStringClient(ClientURL.GET_WEB_BOOK_CONTENT_BY_ID, params);
        Integer result = JsonUtil.getInt(returnStr, "result");
        /**
         * 处理返回数据
         */
        if(result==0){
        	WebBookContent webBookContent = JsonUtil.jsonToObject(returnStr, "webBookContent", WebBookContent.class);
        	mav.getModelMap().put("currentPage", currentPage);
        	mav.getModelMap().put("webBookContent", webBookContent);
        	mav.setViewName("/manage/content/updateBookRecommend");
        	setStaticModel(ImageUtils.class, request);
        }else{
        	String errorCode = JsonUtil.getString(returnStr, "errorCode");
        	mav.setViewName("redirect:/error.action?errorCode="+errorCode);
        }
        return mav;
    }
    
    /**
     * 修改图书推荐
     * 
     * @param request
     * @return
     */
    @RequestMapping("updateBookRecommend")
    public String updateBookRecommend(HttpServletRequest request,
    		@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage,
    		WebBookContent webBookContent){
    	
    	if(webBookContent!=null){
    		Map<String, Object> params = new HashMap<String, Object>();
	        params.put("webBookContent", webBookContent);
	        params.put("orgTreeId", orgTreeId);
	        ClientUtil.getStringClient(ClientURL.UPDATE_HOT_BOOK, params);
    	}
    	
        return "redirect:/manage/content/listBookRecommend.action?currentPage="+currentPage;
    }
    
    /**
     * 移动图书推荐
     * 
     * @param request
     * @return
     */
    @RequestMapping("moveBookRecommend")
    public String moveBookRecommend(HttpServletRequest request,String oper,
    		@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage,
    		Long id){
    	
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("orgTreeId", orgTreeId);
        params.put("id", id);
        params.put("oper", oper);
        ClientUtil.getStringClient(ClientURL.MOVE_BOOK_RECOMMEND, params);
    	
        return "redirect:/manage/content/listBookRecommend.action?currentPage="+currentPage;
    }
    
    /**
     * 删除图书推荐
     * 
     * @param request
     * @return
     */
    @RequestMapping("deleteBookRecommend")
    public String deleteBookRecommend(HttpServletRequest request,
    		@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage,
    		Long[] ids){
    	
    	Map<String, Object> params = new HashMap<String, Object>();
        params.put("ids", ids);
        params.put("orgTreeId", orgTreeId);
        ClientUtil.getStringClient(ClientURL.DELETE_BOOK_RECOMMEND, params);
    	
        return "redirect:/manage/content/listBookRecommend.action?currentPage="+currentPage;
    }
    
    /**
     * 上传图书封面图片
     * 
     * @param request
     * @return
     * @throws IOException 
     */
    @RequestMapping("uploadBookImg")
    public ModelAndView uploadBookImg(HttpServletRequest request,
    		@RequestParam("file") MultipartFile file) throws IOException{
    	
    	ModelAndView mav = new ModelAndView();
		String baseDir = fileUploadConfig.getString("image_upload_base_dir");
		String logoUrl =  MD5.getMD5(String.valueOf(Calendar.getInstance().getTimeInMillis()))+".jpg";
		logoUrl = uploadImg(baseDir,"/orgBook/",logoUrl, file);
		mav.getModelMap().put("logoUrl", "http://img3.chineseall.cn"+logoUrl);
		mav.getModelMap().put("upload", "succeed");
        mav.setViewName("/manage/content/uploadOrgBookImg");
        return mav;
    }
    
    /**
     * 上传图书封面图片
     * 
     * @param request
     * @return
     * @throws IOException 
     */
    @RequestMapping("showUploadBookImg")
    public ModelAndView showUploadBookImg(HttpServletRequest request){
    	ModelAndView mav = new ModelAndView();
        mav.setViewName("/manage/content/uploadOrgBookImg");
        return mav;
    }
    
}
