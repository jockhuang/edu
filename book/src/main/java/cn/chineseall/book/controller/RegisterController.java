package cn.chineseall.book.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.controller.converter.DateConverter;
import cn.chineseall.book.interceptor.LoginInterceptor;
import cn.chineseall.book.service.UserService;
import cn.chineseall.model.Region;
import cn.chineseall.model.user.User;
import cn.chineseall.model.user.UserAccount;
import cn.chineseall.model.user.UserBaseinfo;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.CookiesUtil;
import cn.chineseall.utils.DomainUtil;
import cn.chineseall.utils.EncodeUtil;
import cn.chineseall.utils.ImageUtils;
import cn.chineseall.utils.JsonUtil;
import cn.chineseall.utils.MD5;
import cn.chineseall.utils.PageUtil;
import cn.chineseall.utils.RequestUtil;

@Controller
@RequestMapping("/")
public class RegisterController extends BaseController {
	
	@Resource(type=org.apache.commons.configuration.PropertiesConfiguration.class)
    private PropertiesConfiguration fileUploadConfig;
	
	@Resource
	private UserService userService;
    
    @RequestMapping("/showRegister")
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response){   
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/registers/register");
        return mav;
    }
    
    
    @RequestMapping("/register")
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response,
    		Long orgTreeId, User user, UserAccount userAccount, UserBaseinfo userBaseinfo,
    		String next, String over) throws Exception{   
    	
    	ModelAndView mav = new ModelAndView();
    	
    	String domain = DomainUtil.getCommonDomain(request);
    	if(next!=null){
    		// TODO 进入下一步
    		Map<String, Object> params = new HashMap<String, Object>();
    		params.put("orgTreeId", orgTreeId);
    		params.put("user", user);
    		params.put("userBaseinfo", userBaseinfo);
    		params.put("userAccount", userAccount);
    		String returnStr = ClientUtil.getStringClient(ClientURL.REGISTER_USER, params);
    		Long userId = JsonUtil.getLong(returnStr, "userId");
    		//登陆
            //登录完添加cookie,默认有效期,用户id进行加密
            String uidCookieValue = EncodeUtil.encode(userId);
            CookiesUtil.setCookie(response, domain, LoginInterceptor.UID_COOKIE_KEY, uidCookieValue, 1);
            CookiesUtil.setCookie(response, domain, LoginInterceptor.UID_VALID_COOKIE_KEY, MD5.getMD5(userId.toString()+LoginInterceptor.UID_MD5_KEY), 1);
    		mav.setViewName("redirect:/registers/showUploaded.action");
            return mav;
    	}else if(over!=null){
    		// TODO 进入书房
    		Map<String, Object> params = new HashMap<String, Object>();
    		params.put("orgTreeId", orgTreeId);
    		params.put("user", user);
    		params.put("userBaseinfo", userBaseinfo);
    		params.put("userAccount", userAccount);
    		String returnStr = ClientUtil.getStringClient(ClientURL.REGISTER_USER, params);
    		Long userId = JsonUtil.getLong(returnStr, "userId");
    		//登陆
            //登录完添加cookie,默认有效期,用户id进行加密
            String uidCookieValue = EncodeUtil.encode(userId);
            CookiesUtil.setCookie(response, domain, LoginInterceptor.UID_COOKIE_KEY, uidCookieValue, 1);
            CookiesUtil.setCookie(response, domain, LoginInterceptor.UID_VALID_COOKIE_KEY, MD5.getMD5(userId.toString()+LoginInterceptor.UID_MD5_KEY), 1);
    		//跳到用户书房
    		mav.setViewName("redirect:/user/i.action");
            return mav;
    	}else{
    		mav.setViewName("redirect:/showRegister.action");
            return mav;
    	}
    	
    }
    
    @RequestMapping("/registers/showUploaded")
    public ModelAndView showUploaded(HttpServletRequest request, HttpServletResponse response) throws Exception{   
    	ModelAndView mav = new ModelAndView();
        mav.setViewName("/registers/uploaded");
        return mav;
    }
    
    @RequestMapping(value="/registers/customavator", method=RequestMethod.POST)
    public ModelAndView customavator(HttpServletRequest request, HttpServletResponse response,
    		@RequestParam("portrait") MultipartFile portrait) throws Exception{   
    	
    	ModelAndView mav = new ModelAndView();
    	String baseDir = fileUploadConfig.getString("image_upload_base_dir");
        String logoUrl = ImageUtils.getUserImgUrl(getLoginUserId(request));
        BufferedImage image = ImageIO.read(portrait.getInputStream());
        int maxWidth = 500;
        int width = image.getWidth();
        int height = image.getHeight();
        if(width>maxWidth){
        	height = height/(width/maxWidth);
        	width = maxWidth;
        }
        image = ImageUtils.scale(ImageIO.read(portrait.getInputStream()), width, height);
        File distFile = new File(baseDir+"/cache", logoUrl);
        if (!distFile.getParentFile().exists()) {
        	distFile.getParentFile().mkdirs();
        }
        if (!distFile.exists()) {
        	distFile.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(distFile);
        ImageIO.write(image, "JPEG",ImageIO.createImageOutputStream(fos));
        fos.flush();
        fos.close();
        try {
        	Thread.sleep(1000);
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
        mav.getModelMap().put("portrait", "http://img3.chineseall.cn/cache"+logoUrl);
    	mav.setViewName("/registers/uploading");
        return mav;
    }
    
    @RequestMapping("/registers/uploading")
    public ModelAndView uploading(HttpServletRequest request, HttpServletResponse response) throws Exception{   
    	ModelAndView mav = new ModelAndView();
        mav.setViewName("/registers/uploading");
        return mav;
    }
    
    @RequestMapping(value="/registers/uploaded")
    public ModelAndView uploaded(HttpServletRequest request, HttpServletResponse response,String next, String save,
    		@RequestParam(value = "headImg", required = false) String headImg,
			@RequestParam(value = "width", required = false) Integer width,
			@RequestParam(value = "height", required = false) Integer height,
			@RequestParam(value = "x1", required = false) Integer x1,
			@RequestParam(value = "y1", required = false) Integer y1,
			@RequestParam(value = "x2", required = false) Integer x2,
			@RequestParam(value = "y2", required = false) Integer y2) throws Exception{   
    	ModelAndView mav = new ModelAndView();
    	
    	if(next!=null){
    		mav.setViewName("redirect:/registers/friend.action");
            return mav;
    	}else if(save!=null){
    		// TODO 保存用户设置的头像  进入下一步
    		userService.settingHeadImg(getLoginUserId(request), headImg, width, height, x1,y1, x2, y2);
    		/*String baseDir = fileUploadConfig.getString("image_upload_base_dir");
            String logoUrl = ImageUtils.getUserImgUrl(getLoginUserId(request));
            URL url = new URL(headImg);
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            BufferedImage image = ImageIO.read(connection.getInputStream());
        	image = ImageUtils.cut(image, x1, y1, width, height);
        	image = ImageUtils.scale(image, 200, 200);
            File distFile = new File(baseDir, logoUrl);
            if (!distFile.getParentFile().exists()) {
            	distFile.getParentFile().mkdirs();
            }
            if (!distFile.exists()) {
            	distFile.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(distFile);
            ImageIO.write(image, "JPEG",ImageIO.createImageOutputStream(fos));
            fos.flush();
            fos.close();
            try {
            	Thread.sleep(1000);
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }*/
    		mav.setViewName("redirect:/registers/friend.action");
            return mav;
    	}else{
    		mav.setViewName("redirect:/registers/showUploaded.action");
            return mav;
    	}
    }
    
    @RequestMapping("/registers/friend")
    public ModelAndView friend(HttpServletRequest request, HttpServletResponse response) throws Exception{   
    	ModelAndView mav = new ModelAndView();
    	//TODO 随机从数据库中提取20条用户记录
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("orgTreeId", orgTreeId);
    	params.put("userId", getLoginUserId(request));
		String returnStr = ClientUtil.getStringClient(ClientURL.RAND_GET_USER, params);
		List<HashMap> userList = JsonUtil.jsonToList(returnStr, "userList", HashMap.class);
		mav.getModelMap().put("userList", userList);
        mav.setViewName("/registers/friend");
        setStaticModel(ImageUtils.class, request);
        return mav;
    }
    
    
    @RequestMapping("/registers/addFriend")
    public ModelAndView addFriend(HttpServletRequest request, HttpServletResponse response,
    		Long[] userIds, String next, String save) throws Exception{   
    	ModelAndView mav = new ModelAndView();
    	if(next!=null){
    		// TODO 进入下一步
    		mav.setViewName("redirect:/registers/collectBook.action");
            return mav;
    	}else if(save!=null){
    		// TODO 保存用户书友 进入下一步
    		Map<String, Object> params = new HashMap<String, Object>();
        	params.put("userIds", userIds);
        	params.put("userId", getLoginUserId(request));
    		ClientUtil.getStringClient(ClientURL.ADD_USER_CONCERNS, params);
    		mav.setViewName("redirect:/registers/collectBook.action");
            return mav;
    	}else{
    		mav.setViewName("redirect:/registers/showUploaded.action");
            return mav;
    	}
    }
    
    @RequestMapping("/registers/collectBook")
    public ModelAndView collectBook(HttpServletRequest request, HttpServletResponse response) throws Exception{   
    	ModelAndView mav = new ModelAndView();
    	//TODO 随机提取16条图书
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("orgTreeId", orgTreeId);
		String returnStr = ClientUtil.getStringClient(ClientURL.RAND_GET_BOOK, params);
		List<HashMap> bookList = JsonUtil.jsonToList(returnStr, "bookList", HashMap.class);
		mav.getModelMap().put("bookList", bookList);
        mav.setViewName("/registers/collectBook");
        setStaticModel(ImageUtils.class, request);
        return mav;
    }
    
    @RequestMapping("/registers/registerOver")
    public ModelAndView registerOver(HttpServletRequest request, HttpServletResponse response,
    		Long[] bookIds) throws Exception{   
    	ModelAndView mav = new ModelAndView();
    	// TODO 保存收藏图书
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("bookIds", bookIds);
    	params.put("userId", getLoginUserId(request));
		ClientUtil.getStringClient(ClientURL.ADD_USER_COLLECTION, params);
    	
        mav.setViewName("redirect:/user/i.action");
        return mav;
    }
    
    
    
    @RequestMapping("/searchOrg")
    public ModelAndView searchOrg(HttpServletRequest request, HttpServletResponse response,
    		@RequestParam(value="regionId" , required = false , defaultValue = "0") Integer regionId,
    		@RequestParam(required = false, value = "orgName" , defaultValue = "") String orgName,
    		@RequestParam(value="currentPage" , required = false , defaultValue = "1") Integer currentPage) throws Exception{   
        ModelAndView mav = new ModelAndView();
        pageSize = 7;
    	Map<String, Object> params = new HashMap<String, Object>();
    	if(regionId!=0){
    		params.put("regionId", regionId);
    		mav.getModelMap().put("regionId", regionId);
    	}
    	if(!"".equals(orgName)){
    		params.put("orgName", orgName);
    		mav.getModelMap().put("orgName", orgName);
    	}
    	params.put("currentPage", currentPage);
    	params.put("pageSize", pageSize);
    	
    	String returnStr = ClientUtil.getStringClient(ClientURL.SEARCH_ORG, params);
    	
    	List<HashMap> items = JsonUtil.jsonToList(returnStr, "list", HashMap.class);
        Integer totalCount = JsonUtil.getInt(returnStr, "count");
        PageUtil pageUtil = new PageUtil(items, totalCount, pageSize, currentPage);
        
        mav.getModelMap().put("pageUtil", pageUtil);
        mav.getModelMap().put("queryCondition", RequestUtil.getQueryCondition(request));
        mav.setViewName("/registers/searchOrg");
        return mav;
    }
    
    @ResponseBody
    @RequestMapping("/checkUserName")
    public Boolean checkUserName(@RequestParam(required = false, value = "userId", defaultValue = "0") Long userId,
            @RequestParam(required = false, value = "userName") String userName)
            throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", userId);
    	params.put("userName", userName);
        String returnStr = ClientUtil.getStringClient(ClientURL.CHECK_USERNAME, params);
        Boolean flag = JsonUtil.jsonToObject(returnStr, "flag", Boolean.class);
        return flag;
    }
    
    @ResponseBody
    @RequestMapping("/isInWordUnit")
    public ModelMap isInWordUnit(@RequestParam(required = false, value = "userName") String userName)
            throws Exception {
    	ModelMap modelMap = new ModelMap();
        Map<String, Object> params = new HashMap<String, Object>();
    	params.put("userName", userName);
    	String returnStr = ClientUtil.getStringClient(ClientURL.IS_IN_WORDUNIT, params);
        List<String> wordUnitList = JsonUtil.jsonToList(returnStr, "wordUnitList", String.class);
        modelMap.put("flag", 0);
        if(wordUnitList.size()>0){
        	String message = "包含关键字:";
        	String inWord = "";
        	for (String wordunit : wordUnitList) {
        		inWord+=("“"+wordunit+"”");
			}
        	message += inWord;
        	modelMap.put("flag", 1);
        	modelMap.put("message", message);
        }
        return modelMap;
    }
    
    @ResponseBody
    @RequestMapping("/getRegion")
    public ModelMap getRegion(@RequestParam(required = false, value = "parentId", defaultValue = "0") Integer parentId) throws Exception {
    	ModelMap modelMap = new ModelMap();
        /**
         * 返回地域信息
         */
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("parentId", parentId);
        String returnStr = ClientUtil.getStringClient(ClientURL.GET_REGION, params);
        List<Region> regionList = JsonUtil.jsonToList(returnStr, "regionList", Region.class);
        modelMap.put("regionList", regionList);
        return modelMap;
    }
    
    @InitBinder  
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {  
        binder.registerCustomEditor(Date.class, new DateConverter());  
    }  
    
}
