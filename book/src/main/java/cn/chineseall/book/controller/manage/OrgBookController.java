package cn.chineseall.book.controller.manage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.controller.BaseController;
import cn.chineseall.model.org.vo.OrgBookQueryVo;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.ExcelUtil;
import cn.chineseall.utils.ImageUtils;
import cn.chineseall.utils.JsonUtil;
import cn.chineseall.utils.PageUtil;
import cn.chineseall.utils.RequestUtil;

@Controller
@RequestMapping("/manage/orgbook")
public class OrgBookController extends BaseController {
    
    @Resource(type=org.apache.commons.configuration.PropertiesConfiguration.class)
    private PropertiesConfiguration fileUploadConfig;
    
    @RequestMapping("/listOrgtreeBooks")
    public ModelAndView listOrgtreeBooks(OrgBookQueryVo bookQueryVo, HttpServletRequest request) {
        if(bookQueryVo.getCurrentPage()==null || bookQueryVo.getCurrentPage().intValue() == 0){
            bookQueryVo.setCurrentPage(1);
        }
        bookQueryVo.setPageSize(pageSize);
        bookQueryVo.setOrgTreeId(orgTreeId);
        if(bookQueryVo.getState()!=null && bookQueryVo.getState().intValue()==-1){
            bookQueryVo.setState(null);
        }
        Map<String, Object> prameters = new HashMap<String, Object>();
        prameters.put("queryVo", bookQueryVo);
        bookQueryVo = ClientUtil.getObjectClient(ClientURL.LIST_ORG_BOOK, prameters, OrgBookQueryVo.class);
        PageUtil pageUtil = new PageUtil(null,bookQueryVo.getTotalCount().intValue(),bookQueryVo.getPageSize(), bookQueryVo.getCurrentPage());
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/manage/orgbook/listOrgBooks");
        mav.getModelMap().put("bookQueryVo", bookQueryVo);
        mav.getModelMap().put("pageUtil", pageUtil);
        mav.getModelMap().put("queryCondition", RequestUtil.getQueryCondition(request));
        request.setAttribute("imgDomainName", fileUploadConfig.getString("img_domain"));
        setStaticModel(ImageUtils.class, request);
        return mav;        
    }
    
    @RequestMapping("/setOrgtreeBooksState")
    public String setOrgtreeBooksState(Long[] orgBookIds,Integer isHidden, HttpServletRequest request) {
        if(isHidden == null || (isHidden.intValue()!=0 && isHidden.intValue()!=1)){
            return "redirect:/manage/orgbook/listOrgtreeBooks.action";
        }
        if(orgBookIds!=null && orgBookIds.length >0){
            Map<String, Object> prameters = new HashMap<String, Object>();
            prameters.put("orgTreeId", orgTreeId);
            prameters.put("orgBookIds", orgBookIds);
            prameters.put("isHidden", isHidden);
            ClientUtil.getStringClient(ClientURL.DELETE_ORG_BOOK, prameters);
        }
        return "redirect:/manage/orgbook/listOrgtreeBooks.action";        
    }
    
    @RequestMapping("/showBookDetail")
    public ModelAndView showBookDetail(Long id, HttpServletRequest request) {
        
        //获取图书详情
        Map<String, Object> prameters = new HashMap<String, Object>();
        prameters.put("id", id);
        prameters.put("orgTreeId", orgTreeId);
        String returnStr = ClientUtil.getStringClient(ClientURL.GET_ORG_BOOK_DETAIL, prameters);
        HashMap<String, Object> resultMap = null;
        try {
            resultMap = JsonUtil.jsonToObject(returnStr, "bookInfoMap", HashMap.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelAndView mav = new ModelAndView();
        if(resultMap!=null){
        	mav.setViewName("/manage/orgbook/showBookDetail");
        	mav.getModelMap().put("bookMap", resultMap);
        	mav.getModelMap().put("returnUrl", "");
        	request.setAttribute("imgDomainName", fileUploadConfig.getString("img_domain"));
        	setStaticModel(ImageUtils.class, request);
        }else{
        	mav.setViewName("redirect:/error.action?errorCode=2004");
        }
        return mav;
    }
    
    @RequestMapping("/exportOrgBook")
    public void exportOrgBook(OrgBookQueryVo bookQueryVo, HttpServletRequest request, HttpServletResponse response) {
        bookQueryVo.setOrgTreeId(8l);
        if(bookQueryVo.getState()!=null && bookQueryVo.getState().intValue()==-1){
            bookQueryVo.setState(null);
        }
        Map<String, Object> prameters = new HashMap<String, Object>();
        prameters.put("queryVo", bookQueryVo);
        bookQueryVo = ClientUtil.getObjectClient(ClientURL.LIST_All_ORG_BOOK, prameters, OrgBookQueryVo.class);
        String path = "/template/OrgBooks.xls";
        String fileName = path.substring(path.lastIndexOf("/")+1);
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path);
        Workbook workbook = ExcelUtil.getWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        if(bookQueryVo.getData() != null && bookQueryVo.getData().size()>0){
            for(int i = 0;i<bookQueryVo.getData().size(); i++){
                HashMap<String, Object> map = (HashMap<String, Object>) bookQueryVo.getData().get(i);
                if(map.get("bookName")!=null){
                    ExcelUtil.writeData(sheet, i+1, 0, map.get("bookName").toString());
                }
                if(map.get("publisher")!=null){
                    ExcelUtil.writeData(sheet, i+1, 1, map.get("publisher").toString());
                }
                if(map.get("author")!=null){
                    ExcelUtil.writeData(sheet, i+1, 2, map.get("author").toString());
                }
            }
        }
        writeFileToUser(workbook, fileName, response);   
    }
    
    private void writeFileToUser(Workbook workbook,String fileName,HttpServletResponse response){
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
}
