package cn.chineseall.book.controller.manage.tree;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import cn.chineseall.book.model.OrgTreeBaseinfoVo;
import cn.chineseall.model.org.Org;
import cn.chineseall.model.org.OrgAppendModel;
import cn.chineseall.model.org.OrgBaseinfo;
import cn.chineseall.model.org.OrgTree;
import cn.chineseall.model.org.OrgTreeConf;
import cn.chineseall.model.org.WebTemplate;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.HttpUtil;
import cn.chineseall.utils.ImageUtils;
import cn.chineseall.utils.JsonUtil;

@Controller
@RequestMapping("/manage/tree")
public class OrgTreeController extends BaseController {
    
    @Resource(type=org.apache.commons.configuration.PropertiesConfiguration.class)
    private PropertiesConfiguration fileUploadConfig;
    
    @RequestMapping("/showUpdate")
    public String showUpdate(HttpServletRequest request) throws Exception{
        Map<String, String> parameters = new HashMap<String,String>();
        parameters.put("id", orgTreeId.toString());
        Map<String, String> jsonMap = new HashMap<String, String>();
        jsonMap.put("jsonStr", JsonUtil.toJson(parameters));
        String resultStr = HttpUtil.sendGet(ClientURL.GET_ORG_TREE_INFO, jsonMap);
        Org org = (Org) JsonUtil.jsonToObject(resultStr, "org", Org.class);
        OrgTree orgTree = (OrgTree) JsonUtil.jsonToObject(resultStr, "orgTree", OrgTree.class);
        OrgBaseinfo orgBaseinfo = (OrgBaseinfo) JsonUtil.jsonToObject(resultStr, "orgBaseinfo", OrgBaseinfo.class);
        OrgTreeConf orgTreeConf = (OrgTreeConf) JsonUtil.jsonToObject(resultStr, "orgTreeConf", OrgTreeConf.class);
        request.setAttribute("orgTree", orgTree);
        request.setAttribute("orgBaseinfo", orgBaseinfo);
        request.setAttribute("orgTreeConf", orgTreeConf);
        request.setAttribute("org", org);
        setStaticModel(ImageUtils.class, request);
        return "/manage/tree/updateOrgTreeBaseinfo";
    }
    
    @RequestMapping("/update")
    public String update(OrgTreeBaseinfoVo vo, HttpServletRequest request) throws IOException{
        vo.setId(orgTreeId);
        OrgTree orgTree = new OrgTree();
        orgTree.setId(vo.getId());
        orgTree.setViewName(vo.getViewName());
        
        OrgTreeConf orgTreeConf = new OrgTreeConf();
        orgTreeConf.setOrgTreeId(vo.getId());
        //设置是否代理
        orgTreeConf.setIsDelegate(vo.getIsAgent());
        //设置是否显示机构书展示名称
        orgTreeConf.setIsView(vo.getIsView());
        
        OrgBaseinfo orgBaseinfo = new OrgBaseinfo();
        orgBaseinfo.setOrgTreeId(vo.getId());
        orgBaseinfo.setDescription(vo.getIntro());
        orgBaseinfo.setFooterContent(vo.getFooterContent());
        
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("orgTree", orgTree);
        parameters.put("orgTreeConf", orgTreeConf);
        parameters.put("orgBaseinfo", orgBaseinfo);
        ClientUtil.getStringClient(ClientURL.UPDATE_ORG_TREE_BASE_INFO, parameters);
        return "redirect:/manage/tree/showUpdate.action";
    }
    

    @RequestMapping("/updateTreeLogo")
    public ModelAndView updateTreeLogo(@RequestParam("treeLogo") MultipartFile treeLogo, HttpServletRequest request) throws IOException{
    	ModelAndView mav = new ModelAndView();
        String baseDir = fileUploadConfig.getString("image_upload_base_dir");
        String logoUrl =  ImageUtils.getOrgLogoUrl(orgTreeId);;
        logoUrl = uploadImg(baseDir,"/",logoUrl, treeLogo);
        mav.setViewName("/manage/tree/updateTreeLogo");
        mav.getModelMap().put("upload", "succeed");
        return mav;
    }
    
    @RequestMapping("/showBanner")
    public String showBanner(HttpServletRequest request){
        Map<String, String> parameters = new HashMap<String,String>();
        parameters.put("id", orgTreeId.toString());
        OrgBaseinfo orgBaseinfo = ClientUtil.getObjectClient(ClientURL.GET_ORG_BASE_INFO, parameters, OrgBaseinfo.class);
        request.setAttribute("orgBaseinfo", orgBaseinfo);
        request.setAttribute("imgDomainName", fileUploadConfig.getString("img_domain"));
        setStaticModel(ImageUtils.class, request);
        return "/manage/tree/setBanner";
    }
    
    @RequestMapping("/setBanner")
    public String setBanner(Integer cancel, @RequestParam("treeBanner") MultipartFile treeBanner,HttpServletRequest request) throws IOException{
        OrgBaseinfo orgBaseinfo = new OrgBaseinfo();
        orgBaseinfo.setOrgTreeId(orgTreeId);
        
        String baseDir = fileUploadConfig.getString("image_upload_base_dir");
        String bannerUrl = ImageUtils.getOrgBannerUrl(orgTreeId);
        if(cancel!=null && cancel.intValue() == 1){
            orgBaseinfo.setBanner("");
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("orgBaseinfo", orgBaseinfo);
            ClientUtil.getStringClient(ClientURL.UPDATE_ORG_BASE_INFO, parameters);
        }else if(treeBanner!=null){
            bannerUrl = uploadImg(baseDir,"/", bannerUrl, treeBanner);
            orgBaseinfo.setBanner(bannerUrl);
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("orgBaseinfo", orgBaseinfo);
            ClientUtil.getStringClient(ClientURL.UPDATE_ORG_BASE_INFO, parameters);
        }
        return "redirect:/manage/tree/showBanner.action?id="+orgTreeId;
    }
    
    /**
     * 展示页面风格设置页
     * 
     * @param request
     * @return
     */
    @RequestMapping("/showStyle")
    public String showStyle(HttpServletRequest request){
        Map<String, String> parameters = new HashMap<String,String>();
        parameters.put("orgTreeId", orgTreeId.toString());
        //获取当前使用模板
        OrgTree orgTree = ClientUtil.getObjectClient(ClientURL.GET_ORG_TREE, parameters, OrgTree.class);
        //获取所有模板信息
        List<WebTemplate> templateList = ClientUtil.getListClient(ClientURL.GET_ALL_WEB_TEMPLATE, parameters, WebTemplate.class);
        request.setAttribute("orgTree", orgTree);
        request.setAttribute("templateList", templateList);
        request.setAttribute("imgDomainName", fileUploadConfig.getString("img_domain"));
        return "/manage/tree/setStyle";
    }
    
    /**
     * 设置页面风格
     * 
     * @return
     */
    @RequestMapping("/setStyle")
    public String setStyle(Integer templateId, HttpServletRequest request){
        Map<String, String> parameters = new HashMap<String,String>();
        parameters.put("orgTreeId", orgTreeId.toString());
        parameters.put("templateId", templateId.toString());
        //获取当前使用模板
        ClientUtil.getStringClient(ClientURL.SET_WEB_TEMPLATE, parameters);
        return "redirect:/manage/tree/showStyle.action";
    }
    
    /**
     * 展示导航栏编辑页
     * 
     * @return
     */
    @RequestMapping("/showNav")
    public String showNav(HttpServletRequest request){
        Map<String, String> parameters = new HashMap<String,String>();
        parameters.put("orgTreeId", orgTreeId.toString());
        //获取所有模板信息
        List<OrgAppendModel> orgAppendModelList = ClientUtil.getListClient(ClientURL.GET_ALL_NAV, parameters, OrgAppendModel.class);
        request.setAttribute("orgAppendModelList", orgAppendModelList);
        return "/manage/tree/setNav";
    }
    
    @RequestMapping("/setNav")
    public String setNav(String[] names, String[] links, HttpServletRequest request){
        //这个地方是有顺序的
        Set<String> nameSet = new LinkedHashSet<String>();
        if(names!=null && names.length>0){
            for(String name: names){
                if(name == null || "".equals(name)){
                   break;
                }else{
                    nameSet.add(name);
                }
            }
        }
        String filterNames[] = new String[nameSet.size()];
        names = nameSet.toArray(filterNames);
        Map<String, Object> parameters = new HashMap<String,Object>();
        parameters.put("orgTreeId", orgTreeId.toString());
        parameters.put("names", filterNames);
        parameters.put("links", links);
        ClientUtil.getStringClient(ClientURL.SET_Nav, parameters);
        return "redirect:/manage/tree/showNav.action";
    }
    
    /**
     * 登陆选择
     * 
     * @param request
     * @return
     */
    @RequestMapping("/selectTree")
    public String selectTree(HttpServletRequest request){
        return "/manage/tree/selectTree";
    }
    
    /**
     * 登陆选择
     * 
     * @param request
     * @return
     */
    @RequestMapping("/showUpdateTreeLogo")
    public String showUpdateTreeLogo(HttpServletRequest request){
        return "/manage/tree/updateTreeLogo";
    }
}
