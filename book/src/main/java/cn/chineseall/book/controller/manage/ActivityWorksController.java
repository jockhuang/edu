package cn.chineseall.book.controller.manage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.controller.BaseController;
import cn.chineseall.model.activity.AcBaseinfo;
import cn.chineseall.model.activity.AcConfig;
import cn.chineseall.model.activity.AcJury;
import cn.chineseall.model.activity.AcOrgSetting;
import cn.chineseall.model.activity.AcWorksGroup;
import cn.chineseall.model.activity.AcWorksRecommend;
import cn.chineseall.model.activity.vo.AcWorks;
import cn.chineseall.model.activity.vo.AcWorksQueryVo;
import cn.chineseall.model.org.OrgTree;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.ExcelUtil;
import cn.chineseall.utils.JsonUtil;
import cn.chineseall.utils.PageUtil;
import cn.chineseall.utils.RequestUtil;

@Controller
@RequestMapping("/manage/activity/works")
public class ActivityWorksController extends BaseController {
    

	/**
	 * 查看单个作品
	 * @param acWorksQueryVo
	 * @param request
	 * @return
	 * @throws Exception 
	 */
    @RequestMapping("/getWorks")
    public ModelAndView listAllWorks(@RequestParam(value="activityId") Long activityId,
  			@RequestParam(value="worksId") Long worksId
  			, HttpServletRequest request) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("activityId", activityId);
		params.put("orgTreeId", getOrgTreeId(request));
        params.put("userId", getLoginUserId(request));
        params.put("worksId", worksId);

        ModelAndView mav = new ModelAndView();
        /**
         * 获取活动信息
         */
        String returnStr=ClientUtil.getStringClient(ClientURL.GET_ACTIVITY_DETAIL, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("activity", JsonUtil.jsonToObject(returnStr, "activity", AcBaseinfo.class));
        }
        /**
         * 获取用户参加权限
         */
        returnStr = ClientUtil.getStringClient(ClientURL.GET_USER_JOIN_LIMIT, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	Long userOrgTreeId=JsonUtil.jsonToObject(returnStr, "treeId", Long.class);
        	if(userOrgTreeId==null){
            	mav.setViewName("redirect:/error.action?errorCode=a0010");
        		return mav;
            }else{
            	mav.getModelMap().put("userOrgTreeId", userOrgTreeId);
            }
        }
        /**
         * 获取推荐权限
         */
        returnStr = ClientUtil.getStringClient(ClientURL.GET_PAR_ORG_REC_LIMIT, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("orgSetting", JsonUtil.jsonToObject(returnStr, "orgSetting", AcOrgSetting.class));
        }
        returnStr=ClientUtil.getStringClient(ClientURL.GET_REC_COUNT_LIMIT, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("recCountLimit", JsonUtil.jsonToObject(returnStr, "result", String.class));
        }
	    /**
	       * 获取作品信息
	       */
	    returnStr = ClientUtil.getStringClient(ClientURL.GET_ACTIVITY_WORK, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("work", JsonUtil.jsonToObject(returnStr, "work", AcWorks.class));
        }
        /**
         * 获取评委列表
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_AC_JURYS, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("jurys", JsonUtil.jsonToList(returnStr, "list", AcJury.class));
        }
        /**
         * 获取作品评语信息
         */
        returnStr = ClientUtil.getStringClient(ClientURL.GET_AC_WORKS_SCOR, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("acWorksRecommend", JsonUtil.jsonToObject(returnStr, "result", AcWorksRecommend.class));
        }
	    mav.getModelMap().put("activityId", activityId);
	    mav.getModelMap().put("worksId", worksId);
	    mav.setViewName("/manage/activity/work");
	    return mav;
    }
	/**
	 * 所有作品
	 * @param acWorksQueryVo
	 * @param request
	 * @return
	 * @throws Exception 
	 */
    @RequestMapping("/listAllWorks")
    public ModelAndView listAllWorks(AcWorksQueryVo acWorksQueryVo, HttpServletRequest request) throws Exception {
        if(acWorksQueryVo.getCurrentPage()==null || acWorksQueryVo.getCurrentPage().intValue() == 0){
        	acWorksQueryVo.setCurrentPage(1);
        }
        acWorksQueryVo.setPageSize(10);
        acWorksQueryVo.setOrgTreeId1(getOrgTreeId(request));
        acWorksQueryVo.setUserId(getLoginUserId(request));
        Map<String, Object> prameters = new HashMap<String, Object>();
        prameters.put("queryVo", acWorksQueryVo);
        acWorksQueryVo = ClientUtil.getObjectClient(ClientURL.LIST_ALL_AC_WORKS, prameters, AcWorksQueryVo.class);
        PageUtil pageUtil = null;
        if(acWorksQueryVo!=null){
        	pageUtil=new PageUtil(null,acWorksQueryVo.getTotalCount().intValue(),acWorksQueryVo.getPageSize(), acWorksQueryVo.getCurrentPage());
        }
        ModelAndView mav = new ModelAndView();
        prameters.put("activityId", acWorksQueryVo.getActivityId());
        /**
         * 获取活动信息
         */
        String returnStr=ClientUtil.getStringClient(ClientURL.GET_ACTIVITY_DETAIL, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("activity", JsonUtil.jsonToObject(returnStr, "activity", AcBaseinfo.class));
        }
        /**
         * 获取活动配置信息
         */
        returnStr=ClientUtil.getStringClient(ClientURL.GET_AC_CONFIG, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("acconfig", JsonUtil.jsonToObject(returnStr, "acconfig", AcConfig.class));
        }
        /**
         * 获取用户参加权限
         */
        prameters.put("orgTreeId", getOrgTreeId(request));
        returnStr = ClientUtil.getStringClient(ClientURL.GET_USER_JOIN_LIMIT, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	Long userOrgTreeId=JsonUtil.jsonToObject(returnStr, "treeId", Long.class);
        	if(userOrgTreeId==null){
            	mav.setViewName("redirect:/error.action?errorCode=a0010");
        		return mav;
            }else{
            	mav.getModelMap().put("userOrgTreeId", userOrgTreeId);
            }
        }
        /**
         * 获取下级机构列表
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_SUB_ORGS, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("subOrgs", JsonUtil.jsonToList(returnStr, "list", OrgTree.class));
        }
        /**
         * 获取自定义分组列表
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_GROUPS, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("groups", JsonUtil.jsonToList(returnStr, "list", AcWorksGroup.class));
        }
        /**
         * 获取评委列表
         */
        prameters.put("orgTreeId", getOrgTreeId(request));
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_AC_JURYS, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("jurys", JsonUtil.jsonToList(returnStr, "list", AcJury.class));
        }
        mav.setViewName("/manage/activity/listAllWorks");
        mav.getModelMap().put("activityId", acWorksQueryVo.getActivityId());
        mav.getModelMap().put("queryVo", acWorksQueryVo);
        mav.getModelMap().put("pageUtil", pageUtil);
        mav.getModelMap().put("queryCondition", RequestUtil.getQueryCondition(request));
        return mav; 
    }
    
    /**
	 * 下级推荐作品或本级作品
	 * @param acWorksQueryVo
	 * @param request
	 * @return
     * @throws Exception 
	 */
    @RequestMapping("/listSubRecAcWorks")
    public ModelAndView listSubRecAcWorks(AcWorksQueryVo acWorksQueryVo, HttpServletRequest request) throws Exception {
        if(acWorksQueryVo.getCurrentPage()==null || acWorksQueryVo.getCurrentPage().intValue() == 0){
        	acWorksQueryVo.setCurrentPage(1);
        }
        if(acWorksQueryVo.getScoreState()==null){
        	acWorksQueryVo.setScoreState(0);
        }
        acWorksQueryVo.setPageSize(10);
        acWorksQueryVo.setOrgTreeId1(getOrgTreeId(request));
        acWorksQueryVo.setUserId(getLoginUserId(request));
        Map<String, Object> prameters = new HashMap<String, Object>();
        prameters.put("queryVo", acWorksQueryVo);
        acWorksQueryVo = ClientUtil.getObjectClient(ClientURL.LIST_SUB_REC_AC_WORKS, prameters, AcWorksQueryVo.class);
        PageUtil pageUtil = new PageUtil(null,acWorksQueryVo.getTotalCount().intValue(),acWorksQueryVo.getPageSize(), acWorksQueryVo.getCurrentPage());
        ModelAndView mav = new ModelAndView();
        prameters.put("activityId", acWorksQueryVo.getActivityId());
        /**
         * 获取活动信息
         */
        String returnStr=ClientUtil.getStringClient(ClientURL.GET_ACTIVITY_DETAIL, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("activity", JsonUtil.jsonToObject(returnStr, "activity", AcBaseinfo.class));
        }
        /**
         * 获取用户参加权限
         */
        prameters.put("orgTreeId", getOrgTreeId(request));
        returnStr = ClientUtil.getStringClient(ClientURL.GET_USER_JOIN_LIMIT, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	Long userOrgTreeId=JsonUtil.jsonToObject(returnStr, "treeId", Long.class);
        	if(userOrgTreeId==null){
            	mav.setViewName("redirect:/error.action?errorCode=a0010");
        		return mav;
            }else{
            	mav.getModelMap().put("userOrgTreeId", userOrgTreeId);
            }
        }
        /**
         * 获取活动配置信息
         */
        returnStr=ClientUtil.getStringClient(ClientURL.GET_AC_CONFIG, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("acconfig", JsonUtil.jsonToObject(returnStr, "acconfig", AcConfig.class));
        }
        /**
         * 获取下级机构列表
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_SUB_ORGS, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("subOrgs", JsonUtil.jsonToList(returnStr, "list", OrgTree.class));
        }
        /**
         * 获取自定义分组列表
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_GROUPS, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("groups", JsonUtil.jsonToList(returnStr, "list", AcWorksGroup.class));
        }
        /**
         * 获取评委列表
         */
        prameters.put("orgTreeId", getOrgTreeId(request));
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_AC_JURYS, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("jurys", JsonUtil.jsonToList(returnStr, "list", AcJury.class));
        }
        /**
         * 获取下级推荐权限信息
         */
         returnStr = ClientUtil.getStringClient(ClientURL.GET_ORG_REC_LIMIT, prameters);
         if(returnStr!=null && !"".equals(returnStr)){
        	 mav.getModelMap().put("orgSetting", JsonUtil.jsonToObject(returnStr, "orgSetting", AcOrgSetting.class));
         }
         if(acWorksQueryVo.getType()==3){
        	 mav.setViewName("/manage/activity/listMyWorks");
         }else if(acWorksQueryVo.getType()==2){
        	 mav.setViewName("/manage/activity/listSubRecWorks");
         }
        mav.getModelMap().put("queryVo", acWorksQueryVo);
        mav.getModelMap().put("activityId", acWorksQueryVo.getActivityId());
        mav.getModelMap().put("pageUtil", pageUtil);
        mav.getModelMap().put("queryCondition", RequestUtil.getQueryCondition(request));
        return mav; 
    }
    /**
	 * 评委打分的作品
	 * @param acWorksQueryVo
	 * @param request
	 * @return
     * @throws Exception 
	 */
    @RequestMapping("/listScoreAcWorks")
    public ModelAndView listScoreAcWorks(AcWorksQueryVo acWorksQueryVo,
    		HttpServletRequest request) throws Exception {
        if(acWorksQueryVo.getCurrentPage()==null || acWorksQueryVo.getCurrentPage().intValue() == 0){
        	acWorksQueryVo.setCurrentPage(1);
        }
        if(acWorksQueryVo.getScoreState()==null){
        	acWorksQueryVo.setScoreState(0);
        }
        if(acWorksQueryVo.getOrderby()==null || acWorksQueryVo.getOrderby().intValue() == 0){
        	acWorksQueryVo.setOrderby(1);
        }
        acWorksQueryVo.setPageSize(10);
        acWorksQueryVo.setOrgTreeId1(getOrgTreeId(request));
        acWorksQueryVo.setUserId(getLoginUserId(request));
        Map<String, Object> prameters = new HashMap<String, Object>();
        prameters.put("queryVo", acWorksQueryVo);
        acWorksQueryVo = ClientUtil.getObjectClient(ClientURL.LIST_SCORE_AC_WORKS, prameters, AcWorksQueryVo.class);
        PageUtil pageUtil = new PageUtil(null,acWorksQueryVo.getTotalCount().intValue(),acWorksQueryVo.getPageSize(), acWorksQueryVo.getCurrentPage());
        ModelAndView mav = new ModelAndView();
        prameters.put("activityId", acWorksQueryVo.getActivityId());
        /**
         * 获取活动信息
         */
        String returnStr=ClientUtil.getStringClient(ClientURL.GET_ACTIVITY_DETAIL, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("activity", JsonUtil.jsonToObject(returnStr, "activity", AcBaseinfo.class));
        }
        /**
         * 获取用户参加权限
         */
        prameters.put("orgTreeId", getOrgTreeId(request));
        returnStr = ClientUtil.getStringClient(ClientURL.GET_USER_JOIN_LIMIT, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	Long userOrgTreeId=JsonUtil.jsonToObject(returnStr, "treeId", Long.class);
        	if(userOrgTreeId==null){
            	mav.setViewName("redirect:/error.action?errorCode=a0010");
        		return mav;
            }else{
            	mav.getModelMap().put("userOrgTreeId", userOrgTreeId);
            }
        }
        /**
         * 获取活动配置信息
         */
        returnStr=ClientUtil.getStringClient(ClientURL.GET_AC_CONFIG, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("acconfig", JsonUtil.jsonToObject(returnStr, "acconfig", AcConfig.class));
        }
        /**
         * 获取推荐权限
         */
        returnStr = ClientUtil.getStringClient(ClientURL.GET_PAR_ORG_REC_LIMIT, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("orgSetting", JsonUtil.jsonToObject(returnStr, "orgSetting", AcOrgSetting.class));
        }
        returnStr=ClientUtil.getStringClient(ClientURL.GET_REC_COUNT_LIMIT, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("recCountLimit", JsonUtil.jsonToObject(returnStr, "result", String.class));
        }
        /**
         * 获取下级机构列表
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_SUB_ORGS, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("subOrgs", JsonUtil.jsonToList(returnStr, "list", OrgTree.class));
        }
        /**
         * 获取自定义分组列表
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_GROUPS, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("groups", JsonUtil.jsonToList(returnStr, "list", AcWorksGroup.class));
        }
        mav.setViewName("/manage/activity/listScoreWorks");
        mav.getModelMap().put("queryVo", acWorksQueryVo);
        mav.getModelMap().put("activityId", acWorksQueryVo.getActivityId());
        mav.getModelMap().put("pageUtil", pageUtil);
        mav.getModelMap().put("queryCondition", RequestUtil.getQueryCondition(request));
        return mav; 
    }
    /**
	 * 已推荐给上级的作品
	 * @param acWorksQueryVo
	 * @param request
	 * @return
     * @throws Exception 
	 */
    @RequestMapping("/listRecAcWorks")
    public ModelAndView listRecAcWorks(AcWorksQueryVo acWorksQueryVo, HttpServletRequest request) throws Exception {
        if(acWorksQueryVo.getCurrentPage()==null || acWorksQueryVo.getCurrentPage().intValue() == 0){
        	acWorksQueryVo.setCurrentPage(1);
        }
        acWorksQueryVo.setPageSize(10);
        acWorksQueryVo.setOrgTreeId1(getOrgTreeId(request));
        acWorksQueryVo.setUserId(getLoginUserId(request));
        Map<String, Object> prameters = new HashMap<String, Object>();
        prameters.put("queryVo", acWorksQueryVo);
        acWorksQueryVo = ClientUtil.getObjectClient(ClientURL.LIST_REC_AC_WORKS, prameters, AcWorksQueryVo.class);
        PageUtil pageUtil = new PageUtil(null,acWorksQueryVo.getTotalCount().intValue(),acWorksQueryVo.getPageSize(), acWorksQueryVo.getCurrentPage());
        ModelAndView mav = new ModelAndView();
        prameters.put("activityId", acWorksQueryVo.getActivityId());
        /**
         * 获取活动信息
         */
        String returnStr=ClientUtil.getStringClient(ClientURL.GET_ACTIVITY_DETAIL, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("activity", JsonUtil.jsonToObject(returnStr, "activity", AcBaseinfo.class));
        }
        /**
         * 获取用户参加权限
         */
        prameters.put("orgTreeId", getOrgTreeId(request));
        returnStr = ClientUtil.getStringClient(ClientURL.GET_USER_JOIN_LIMIT, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	Long userOrgTreeId=JsonUtil.jsonToObject(returnStr, "treeId", Long.class);
        	if(userOrgTreeId==null){
            	mav.setViewName("redirect:/error.action?errorCode=a0010");
        		return mav;
            }else{
            	mav.getModelMap().put("userOrgTreeId", userOrgTreeId);
            }
        }
        /**
         * 获取下级机构列表
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_SUB_ORGS, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("subOrgs", JsonUtil.jsonToList(returnStr, "list", OrgTree.class));
        }
        /**
         * 获取自定义分组列表
         */
        returnStr = ClientUtil.getStringClient(ClientURL.LIST_ACTIVITY_GROUPS, prameters);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("groups", JsonUtil.jsonToList(returnStr, "list", AcWorksGroup.class));
        }
        mav.setViewName("/manage/activity/listRecWorks");
        mav.getModelMap().put("queryVo", acWorksQueryVo);
        mav.getModelMap().put("activityId", acWorksQueryVo.getActivityId());
        mav.getModelMap().put("pageUtil", pageUtil);
        mav.getModelMap().put("queryCondition", RequestUtil.getQueryCondition(request));
        return mav; 
    }
    
    @RequestMapping("/exportWorks")
    public void exportWorks(AcWorksQueryVo acWorksQueryVo, 
    		@RequestParam(value="type") Integer type,
    		HttpServletRequest request, HttpServletResponse response) {
    	if(acWorksQueryVo.getCurrentPage()==null || acWorksQueryVo.getCurrentPage().intValue() == 0){
        	acWorksQueryVo.setCurrentPage(1);
        }
        acWorksQueryVo.setPageSize(100000);
        acWorksQueryVo.setOrgTreeId1(getOrgTreeId(request));
        Map<String, Object> prameters = new HashMap<String, Object>();
        prameters.put("queryVo", acWorksQueryVo);
        
        String path = "/template/acWorks.xls";
        String fileName = path.substring(path.lastIndexOf("/")+1);
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path);
        Workbook workbook = ExcelUtil.getWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        if(type==1){
        	acWorksQueryVo = ClientUtil.getObjectClient(ClientURL.LIST_ALL_AC_WORKS, prameters, AcWorksQueryVo.class);
        }else if(type==5){
        	acWorksQueryVo = ClientUtil.getObjectClient(ClientURL.LIST_REC_AC_WORKS, prameters, AcWorksQueryVo.class);
        }
        if(acWorksQueryVo.getData() != null && acWorksQueryVo.getData().size()>0){
            for(int i = 0;i<acWorksQueryVo.getData().size(); i++){
                HashMap<String, Object> map = (HashMap<String, Object>) acWorksQueryVo.getData().get(i);
                if(map.get("worksName")!=null){
                    ExcelUtil.writeData(sheet, i+1, 0, map.get("worksName").toString());
                }
                if(map.get("author")!=null){
                    ExcelUtil.writeData(sheet, i+1, 1, map.get("author").toString());
                }
                if(map.get("orgTreeName")!=null){
                    ExcelUtil.writeData(sheet, i+1, 2, map.get("orgTreeName").toString());
                }
                if(map.get("worksGroupName")!=null){
                    ExcelUtil.writeData(sheet, i+1, 3, map.get("worksGroupName").toString());
                }
            }
        }
        writeFileToWork(workbook, fileName, response);   
    }
    
    private void writeFileToWork(Workbook workbook,String fileName,HttpServletResponse response){
        response.setContentType("application/vnd.ms-excel");
        try {
            response.setHeader("Content-disposition", "attachment;filename="+new String(fileName.getBytes("UTF-8"),"iso8859-1"));
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        try {
            OutputStream outStream = response.getOutputStream();
            workbook.write(outStream);
            outStream.flush();
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
	 * 修改作品审核状态
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
    @RequestMapping("/updateAcWorksState")
	public ModelAndView updateAcWorksState(@RequestParam(value="activityId") Long activityId,
			@RequestParam(value="worksId") Long[] worksId,
			@RequestParam(value="auditState") Integer auditState,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("orgTreeId", getOrgTreeId(request));
       	params.put("userId", getLoginUserId(request));
        params.put("activityId", activityId);
        params.put("worksId", worksId);
        params.put("auditState", auditState);

        /**
         * 修改作品审核状态
         */
        ClientUtil.getStringClient(ClientURL.UPDATE_AC_WORKS_STATE, params);
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("activityId", activityId);
        mav.getModelMap().put("orgTreeId", getOrgTreeId(request));
        mav.setViewName("redirect:/manage/activity/works/listAllWorks.action");
        return mav;
	}
    /**
	 * 修改作品推荐数量页面
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
    @RequestMapping("/acWorksRecCount")
	public ModelAndView acWorksRecCount(@RequestParam(value="activityId") Long activityId,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("activityId", activityId);
    	params.put("orgTreeId", getOrgTreeId(request));
       	params.put("userId", getLoginUserId(request));

       	ModelAndView mav = new ModelAndView();
        /**
         * 获取活动信息
         */
        String returnStr=ClientUtil.getStringClient(ClientURL.GET_ACTIVITY_DETAIL, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("activity", JsonUtil.jsonToObject(returnStr, "activity", AcBaseinfo.class));
        }
        /**
         * 获取作品推荐数量
         */
        returnStr = ClientUtil.getStringClient(ClientURL.GET_AC_CONFIG, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	mav.getModelMap().put("config", JsonUtil.jsonToObject(returnStr, "acconfig", AcConfig.class));
        }
        mav.getModelMap().put("activityId", activityId);
        mav.setViewName("/manage/activity/recCount");
        return mav;
	}
   /**
	 * 修改作品推荐数量
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
    @RequestMapping("/updateAcWorksRecCount")
	public ModelAndView updateAcWorksRecCount(@RequestParam(value="activityId") Long activityId,
			@RequestParam(value="num1",required = false) Integer num1,
			@RequestParam(value="num2",required = false) Integer num2,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("activityId", activityId);
    	params.put("orgTreeId", getOrgTreeId(request));
       	params.put("userId", getLoginUserId(request));
        params.put("num1", num1);
        params.put("num2", num2);

        /**
         * 修改作品推荐数量
         */
        ClientUtil.getStringClient(ClientURL.UPDATE_AC_WORKS_REC_COUNT, params);
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("activityId", activityId);
        mav.setViewName("redirect:/manage/activity/works/acWorksRecCount.action");
        return mav;
	}
    
    /**
   	 * 修改下级推荐权限
   	 * @param model
   	 * @param request
   	 * @param response
   	 * @throws Exception
   	 */
    @RequestMapping("/updateRecLimit")
   	public void updateRecLimit(@RequestParam(value="activityId") Long activityId,
   			@RequestParam(value="id",required = false) Long id,
   			@RequestParam(value="allow") Integer allow,
   			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
       	Map<String, Object> params = new HashMap<String, Object>();
       	params.put("activityId", activityId);
       	params.put("orgTreeId", getOrgTreeId(request));
        params.put("id", id);
        params.put("allow", allow);

        String result="";
        /**
        * 修改下级推荐权限
        */
        String returnStr = ClientUtil.getStringClient(ClientURL.UPDATE_REC_LIMIT, params);
        if(returnStr!=null && !"".equals(returnStr)){
        	result= JsonUtil.jsonToObject(returnStr, "orgSetting", String.class);
        }
        PrintWriter out;
		out = response.getWriter();
		out.print(result);
   	}
    /**
	 * 推荐作品
	 * @param model
	 * @param request
	 * @param response
	 * @throws Exception
	 */
    @RequestMapping("/recAcWorks")
	public ModelAndView recAcWorks(@RequestParam(value="activityId") Long activityId,
			@RequestParam(value="worksId") Long[] worksId,
			@RequestParam(value="score",required = false) Integer[] score,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Map<String, Object> params = new HashMap<String, Object>();
    	params.put("activityId", activityId);
    	params.put("orgTreeId", getOrgTreeId(request));
       	params.put("userId", getLoginUserId(request));
        params.put("worksId", worksId);
        params.put("score", score);

        /**
         * 推荐作品
         */
        ClientUtil.getStringClient(ClientURL.REC_AC_WORKS, params);
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("activityId", activityId);
        mav.setViewName("redirect:/manage/activity/works/listScoreAcWorks.action");
        return mav;
	}
    /**
   	 * 删除作品
   	 * @param model
   	 * @param request
   	 * @param response
   	 * @throws Exception
   	 */
       @RequestMapping("/delAcWorks")
   	public ModelAndView delAcWorks(@RequestParam(value="activityId") Long activityId,
   			@RequestParam(value="worksId") Long[] worksId,
   			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
       	Map<String, Object> params = new HashMap<String, Object>();
       	params.put("activityId", activityId);
       	params.put("orgTreeId", getOrgTreeId(request));
       	params.put("userId", getLoginUserId(request));
        params.put("worksId", worksId);

        /**
         * 删除作品
         */
        ClientUtil.getStringClient(ClientURL.DEL_AC_WORKS, params);
        ModelAndView mav = new ModelAndView();
        mav.getModelMap().put("activityId", activityId);
        mav.setViewName("redirect:/manage/activity/works/listAllWorks.action");
        return mav;
   	}
   /**
  	 * 给作品分配评委
  	 * @param model
  	 * @param request
  	 * @param response
  	 * @throws Exception
  	 */
    @RequestMapping("/addAcWorksJury")
  	public ModelAndView addAcWorksJury(@RequestParam(value="activityId") Long activityId,
  			@RequestParam(value="juryId",required = false) Long juryId,
  			@RequestParam(value="auto",required = false) Integer auto,
  			@RequestParam(value="type",required = false) Integer type,
  			@RequestParam(value="worksId",required = false) Long[] worksId,
  			@RequestParam(value="currentPage") Integer currentPage,
  			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
      	  Map<String, Object> params = new HashMap<String, Object>();
      	  params.put("activityId", activityId);
      	  params.put("orgTreeId", getOrgTreeId(request));
          params.put("userId", getLoginUserId(request));
          params.put("juryId", juryId);
          params.put("worksId", worksId);
          params.put("auto", auto);
          
	      /**
	       * 给作品分配评委
	       */
	      ClientUtil.getStringClient(ClientURL.ADD_AC_WORKS_JURY, params);
	      ModelAndView mav = new ModelAndView();
	      mav.getModelMap().put("activityId", activityId);
	      mav.getModelMap().put("type", type);
	      mav.getModelMap().put("currentPage", currentPage);
	      if(type==1){
	    	  mav.setViewName("redirect:/manage/activity/works/listAllWorks.action");
	      }else if(type==2){
	    	  mav.setViewName("redirect:/manage/activity/works/listSubRecAcWorks.action");
	      }else if(type==3){
	    	  mav.setViewName("redirect:/manage/activity/works/listSubRecAcWorks.action");
	      }
	      return mav;
  	} 
    /**
  	 * 给作品打分
  	 * @param model
  	 * @param request
  	 * @param response
  	 * @throws Exception
  	 */
    @RequestMapping("/addAcWorksScore")
  	public ModelAndView addAcWorksScore(@RequestParam(value="activityId") Long activityId,
  			@RequestParam(value="worksId") Long worksId,
  			@RequestParam(value="score") Double score,
  			@RequestParam(value="content",required = false) String content,
  			ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
      	  Map<String, Object> params = new HashMap<String, Object>();
      	  params.put("activityId", activityId);
          params.put("orgTreeId", getOrgTreeId(request));
          params.put("userId", getLoginUserId(request));
          params.put("worksId", worksId);
          params.put("score", score);
          params.put("content", content);

	      /**
	       * 给作品打分
	       */
	      ClientUtil.getStringClient(ClientURL.ADD_AC_WORKS_SCOR, params);
	      ModelAndView mav = new ModelAndView();
	      mav.getModelMap().put("activityId", activityId);
	      mav.getModelMap().put("worksId", worksId);
	      mav.setViewName("redirect:/manage/activity/works/getWorks.action");
	      return mav;
  	}
}
