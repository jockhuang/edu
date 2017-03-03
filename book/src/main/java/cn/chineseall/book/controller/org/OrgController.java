package cn.chineseall.book.controller.org;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.controller.BaseController;
import cn.chineseall.book.service.BookService;
import cn.chineseall.model.activity.AcBaseinfo;
import cn.chineseall.model.book.Book;
import cn.chineseall.model.book.vo.BookTypeDetail;
import cn.chineseall.model.org.OrgTree;
import cn.chineseall.model.org.vo.OrgNewsView;
import cn.chineseall.model.org.vo.OrganizationView;
import cn.chineseall.model.user.UserAccount;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.ImageUtils;
import cn.chineseall.utils.JsonUtil;
import cn.chineseall.utils.PageUtil;
import cn.chineseall.utils.RequestUtil;


@Controller
@RequestMapping("/org")
public class OrgController extends BaseController {
	
	private static Logger logger = Logger.getLogger(OrgController.class);
	
	@Resource
	private BookService  bookService;
	
	/**
	 * 机构首页
	 * @param request
	 * @param pageSize
	 * @param currentPage
	 * @return
	 * @throws Exception
	 */
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView();
        Long userId = getLoginUserId(request);
        /**
         * 图书id集合，获取图书简介时使用
         */
        Set<Long> bookIds = new HashSet<Long>();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orgTreeId", orgTreeId);
        params.put("userId", userId);
        params.put("size", 8);
        
        String returnStr = null;
       
        /**
         * 获取阅读榜
         */
        List<Book> listOrgReadingTopBook = bookService.listOrgReadingTopBook(orgTreeId, 1, 10);
        mav.getModelMap().put("listOrgReadingTopBook", listOrgReadingTopBook);
        if (listOrgReadingTopBook.size() > 0) {
            bookIds.add(listOrgReadingTopBook.get(0).getId());
        }
        /**
         * 获取收藏榜
         */
        List<Book> listOrgCollectionTopBook = bookService.listOrgCollectionTopBook(orgTreeId, 1, 10);
        mav.getModelMap().put("listOrgCollectionTopBook", listOrgCollectionTopBook);
        if (listOrgCollectionTopBook.size() > 0) {
            bookIds.add(listOrgCollectionTopBook.get(0).getId());
        }
        /**
         * 放置界面所需图书简介
         */
        mav.getModelMap().put("intros", bookService.getIntros(bookIds));
        /**
         * 获取热门图书
         */
        returnStr = ClientUtil.getStringClient(ClientURL.GET_ORG_HOT_BOOKS, params);
        if(returnStr != null && (returnStr = returnStr.trim()).length() >0){
        	List<BookTypeDetail>  hotBookList = JsonUtil.jsonToList(returnStr, "list", BookTypeDetail.class);
            mav.getModelMap().put("hotBookList", hotBookList);
        }
        
        /**
         * 获取机构首页活动信息
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ORG_HOT_ACTIVITY, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("hotActivitys", JsonUtil.jsonToList(returnStr, "list", AcBaseinfo.class));
        }
        
        /**
         * 获取机构首页年度新书模块信息
         */
        params.put("type", 1);
        params.put("limits", 18);
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_BOOK_RECOMMEND_BY_TYPE, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("recommendBookList", JsonUtil.jsonToList(returnStr, "bookList", HashMap.class));
        }
        
        /**
         * 获取学生专辑推荐信息
         */
        params.put("type", 1);
        params.put("limits", 4);
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_BOOK_PACKAGES_BY_TYPE, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("studentPackages", JsonUtil.jsonToList(returnStr, "data", HashMap.class));
        }
        
        /**
         * 获取家长专辑推荐信息
         */
        params.put("type", 2);
        params.put("limits", 2);
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_BOOK_PACKAGES_BY_TYPE, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("patriarchPackages", JsonUtil.jsonToList(returnStr, "data", HashMap.class));
        }
        
        /**
         * 获取老师专辑推荐信息
         */
        params.put("type", 3);
        params.put("limits", 2);
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_BOOK_PACKAGES_BY_TYPE, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("teacherPackages", JsonUtil.jsonToList(returnStr, "data", HashMap.class));
        }
        
        if(userId!=null){
            /**
             * 获取用户最后读取书本信息
             */
            params.put("userId", userId);
            HashMap<String, Object> userReadingBookMap = (HashMap<String, Object>)ClientUtil.getObjectClient(ClientURL.GET_USER_LAST_READ_BOOK, params, HashMap.class);
            mav.getModelMap().put("userReadingBookMap", userReadingBookMap);
            
            /**
             * 获取用户加入机构列表
             */
            List<HashMap<String, Object>> userOrgList = ClientUtil.getListClient(ClientURL.GET_USER_ORGS, params, HashMap.class);
            mav.getModelMap().put("userOrgList", userOrgList);
            returnStr = ClientUtil.getStringClient(ClientURL.GET_LOGIN_USER_INFO, params);
            Map<String, Object> ui = JsonUtil.jsonToObject(returnStr, HashMap.class);
            if(ui!=null){
                String displayName = ui.get("displayName").toString();
                mav.getModelMap().put("userName", (displayName == null || "".equals(displayName.trim()))?ui.get("userName"):displayName);
                Integer gender = (Integer) ui.get("gender");;
                mav.getModelMap().put("gender", (gender==null || gender.intValue() == 1));
            }
        }
        setStaticModel(ImageUtils.class, request);
        mav.setViewName( "/org/index");
        return mav;
    }
    
    @RequestMapping("/getNewUsers")
    public void getNewUsers(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	/**
         * 获取 活跃区 新注册用户
         */
    	JSONObject  json = new JSONObject();
    	Map<Object , Object> params = new HashMap<Object , Object>();
    	params.put("orgTreeId", orgTreeId);
        params.put("order", "newUser");
        String returnStr = ClientUtil.getStringClient(ClientURL.GET_ORG_HOME_PAGE_NewUSERS, params);
        if(returnStr != null && (returnStr = returnStr.trim()).length() >0){
        	json.put("newUserList", getJsonArray(JsonUtil.jsonToList(returnStr, "list", UserAccount.class)));
        }
        params.remove("order");
        params.put("order", "readBook");
        returnStr = ClientUtil.getStringClient(ClientURL.GET_ORG_HOME_PAGE_NewUSERS, params);
        if(returnStr != null && (returnStr = returnStr.trim()).length() >0){
        	json.put("readBookUserList", getJsonArray(JsonUtil.jsonToList(returnStr, "list", UserAccount.class)));
        }
        params.remove("order");
        params.put("order", "bookComment");
        returnStr = ClientUtil.getStringClient(ClientURL.GET_ORG_HOME_PAGE_NewUSERS, params);
        if(returnStr != null && (returnStr = returnStr.trim()).length() >0){
        	json.put("bookCommentUserList", getJsonArray(JsonUtil.jsonToList(returnStr, "list", UserAccount.class)));
        }
        params.remove("order");
        params.put("order", "works");
        returnStr = ClientUtil.getStringClient(ClientURL.GET_ORG_HOME_PAGE_NewUSERS, params);
        if(returnStr != null && (returnStr = returnStr.trim()).length() >0){
        	json.put("worksUserList", getJsonArray(JsonUtil.jsonToList(returnStr, "list", UserAccount.class)));
        }
        response.setContentType("text/plain");
        response.getWriter().print(json.toString());
        response.getWriter().flush();
    	
    }
    private JSONArray  getJsonArray(List<UserAccount> list){
    	JSONArray  array = new JSONArray();
    	if(list != null && list.size() >0){
    		for(UserAccount ua : list){
    			JSONObject object = new JSONObject();
    			object.put("userId", ua.getUserId());
    			object.put("displayName", ua.getDisplayName());
    			object.put("headImg", ua.getHeadImg());
    			object.put("orgId", ua.getOrgId());
    			array.add(object);
    		}
    	}
    	
		return array; 
    }

    /**
     * 获取  相关组织  界面数据
     * @param orgTreeId
     * @param currentPage
     * @param order
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/organization")
	public ModelAndView organization(
            @RequestParam(required = false, value = "currentPage") Integer currentPage,
            @RequestParam(required = false, value = "order") String order,HttpServletRequest request) throws Exception{
		currentPage = currentPage == null?1:currentPage;
		order = order == null ? "all" : order;
		ModelAndView  mav = new ModelAndView();
		mav.getModelMap().put("orgTreeId", orgTreeId);
        mav.getModelMap().put("currentPage", currentPage);
        mav.getModelMap().put("order", order);
        
        Map<String , Object>  params = new HashMap<String , Object>();
        params.put("orgTreeId", orgTreeId);
        params.put("order", order);
        params.put("pageSize", 12);
        params.put("currentPage", currentPage);
        
        /**
         * 获   相关组织   列表信息
         */
        String returnStr = ClientUtil.getStringClient(ClientURL.GET_ORG_ORGANIZATION, params);
        Integer totalCount = JsonUtil.getInt(returnStr, "count");
        List<OrganizationView>  organization = JsonUtil.jsonToList(returnStr, "list", OrganizationView.class);
        PageUtil pageUtil = new PageUtil(organization,totalCount,12,currentPage);
        mav.getModelMap().put("pageUtil", pageUtil);
        mav.getModelMap().put("queryCondition", RequestUtil.getQueryCondition(request));
        /**
		 * 右边 新闻
		 */
		returnStr = ClientUtil.getStringClient(ClientURL.GET_ORG_HOME_PAGE_NEWS, params);
		if(returnStr != null && (returnStr = returnStr.trim()).length() >0){
			List<OrgNewsView>  orgNewsList = JsonUtil.jsonToList(returnStr, "list", OrgNewsView.class);
	        mav.getModelMap().put("newsList", orgNewsList);
		}
		/**
         * 获取机构首页活动信息
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ORG_HOT_ACTIVITY, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("hotActivitys", JsonUtil.jsonToList(returnStr, "list", AcBaseinfo.class));
        }
        /**
         * 获取机构树对象
         */
        returnStr = ClientUtil.getStringClient(ClientURL.GET_ORG_ORGTREE, params);
        OrgTree orgTree = JsonUtil.jsonToObject(returnStr,  OrgTree.class);
        if(orgTree != null && orgTree.getViewName().trim().length() >0 ){
        	mav.getModelMap().put("viewName", orgTree.getViewName());
        }
        /**
         * 机构下属数量
         */
        mav.getModelMap().put("orgcount", totalCount);
        mav.setViewName("/org/organization");
		return mav;
    }	
    /**
     * 获取正在发生
     * @param orgTreeId
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/homepageDynamic")
    public void dynamicUserInfoAction(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	String strDynamic = "";
    	Map<String , Object> params = new HashMap<String , Object>();
    	params.put("orgTreeId", orgTreeId);
    	try{
    	  String returnStr = ClientUtil.getStringClient(ClientURL.GET_ORG_HOME_PAGE_DYNAMIC, params);
    		strDynamic = JsonUtil.getString(returnStr, "result");
		}catch(Exception e){
			strDynamic = "获取动态信息出错："+e.getMessage();
			logger.error("获取用户登陆信息出错："+e.getMessage());
		}
    	response.setContentType("text/plain");
    	response.setCharacterEncoding("UTF-8");
    	PrintWriter out = response.getWriter();
		out.print(strDynamic);
		out.close();
    }

}
