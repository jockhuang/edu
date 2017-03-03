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
import cn.chineseall.constants.ReadConstants;
import cn.chineseall.model.org.OrgNews;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.JsonUtil;
import cn.chineseall.utils.RequestUtil;

@Controller
@RequestMapping("/manage/content/")
public class NewsController extends BaseController {

    /**
     * 新闻列表
     * 
     * @param request
     * @return
     * @throws Exception 
     */
    @RequestMapping("listNews")
    public ModelAndView listNews(HttpServletRequest request, String keywords,
    		@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage) throws Exception{
        ModelAndView mav = new ModelAndView();
        
        /**
         * 查询新闻
         */
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orgTreeId", orgTreeId);
    	params.put("pageSize", 10);
    	params.put("currentPage", currentPage);
    	params.put("state", 1);
		params.put("keywords", keywords);
		
        String returnStr = ClientUtil.getStringClient(ClientURL.GET_ORG_NEWS, params);
        
        /**
         * 处理返回数据
         */
		Map<String, Object> returnMap = JsonUtil.fromJsonToObject(returnStr, HashMap.class);
		Map<String, Object> pageUtil = (Map<String, Object>) returnMap.get("pageUtil");
        
        String queryCondition = RequestUtil.getQueryCondition(request);
        mav.getModelMap().put("currentPage", currentPage);
        mav.getModelMap().put("pageUtil", pageUtil);
        mav.getModelMap().put("queryCondition", queryCondition);
        mav.getModelMap().put("keywords", keywords);
        
        mav.setViewName("/manage/content/listNews");
        return mav;
    }
    
    /**
     * 添加新闻
     * 
     * @param request
     * @return
     */
    @RequestMapping("showAddNews")
    public ModelAndView showAddNews(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/manage/content/addNews");
        return mav;
    }
    
    /**
     * 添加新闻
     * 
     * @param request
     * @return
     */
    @RequestMapping("addNews")
    public String addNews(HttpServletRequest request, OrgNews orgNews){
    	if(orgNews!=null){
    		orgNews.setOrgTreeId(orgTreeId);
    		Map<String, Object> params = new HashMap<String, Object>();
            params.put("orgNews", orgNews);
            ClientUtil.getStringClient(ClientURL.ADD_ORG_NEWS, params);
    	}
        return "redirect:/manage/content/listNews.action";
    }
    
    /**
     * 修改新闻
     * 
     * @param request
     * @return
     * @throws Exception 
     */
    @RequestMapping("showUpdateNews")
    public ModelAndView showUpdateNews(HttpServletRequest request,
    		@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage,
    		@RequestParam(required = false, value = "id", defaultValue = "1") Long id) throws Exception{
    	
        ModelAndView mav = new ModelAndView();
        
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("orgTreeId", orgTreeId);
        String returnStr = ClientUtil.getStringClient(ClientURL.GET_ORG_NEWS_BY_ID, params);
        OrgNews orgNews = JsonUtil.jsonToObject(returnStr, "orgNews", OrgNews.class);
        
        if(orgNews!=null){
        	mav.getModelMap().put("currentPage", currentPage);
        	mav.getModelMap().put("orgNews", orgNews);
        	mav.setViewName("/manage/content/updateNews");
        }else{
        	String newsErrorCode = JsonUtil.getString(returnStr, "newsErrorCode");
        	mav.setViewName("redirect:/error.action?errorCode="+newsErrorCode);
        }
        return mav;
    }
    
    /**
     * 修改新闻
     * 
     * @param request
     * @return
     * @throws Exception 
     */
    @RequestMapping("updateNews")
    public String updateNews(HttpServletRequest request,
    		@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage,
    		OrgNews orgNews) throws Exception{
    	
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("orgNews", orgNews);
        params.put("orgTreeId", orgTreeId);
        String returnStr = ClientUtil.getStringClient(ClientURL.UPDATE_ORG_NEWS, params);
        Integer result = JsonUtil.getInt(returnStr, "result");
        if(result==0){
        	return "redirect:/manage/content/listNews.action?currentPage="+currentPage;
        }else{
        	String newsErrorCode = JsonUtil.getString(returnStr, "newsErrorCode");
        	return "redirect:/error.action?errorCode="+newsErrorCode;
        }
    }
    
    /**
     * 移动新闻位置
     * 
     * @param request
     * @return
     */
    @RequestMapping("moveNews")
    public String moveNews(HttpServletRequest request,String oper,
    		@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage,
    		Long id){
    	
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("orgTreeId", orgTreeId);
        params.put("id", id);
        params.put("oper", oper);
        ClientUtil.getStringClient(ClientURL.MOVE_ORG_NEWS, params);
    	
        return "redirect:/manage/content/listNews.action?currentPage="+currentPage;
    }
    
    /**
     * 删除新闻
     * 
     * @param request
     * @return
     */
    @RequestMapping("deleteNews")
    public String deleteNews(HttpServletRequest request,
    		@RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage,
    		Long[] ids){
    	
    	Map<String, Object> params = new HashMap<String, Object>();
        params.put("ids", ids);
        params.put("orgTreeId", orgTreeId);
        ClientUtil.getStringClient(ClientURL.DELETE_ORG_NEWS, params);
    	
        return "redirect:/manage/content/listNews.action?currentPage="+currentPage;
    }
}
