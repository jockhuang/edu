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
import cn.chineseall.model.org.vo.ManageBookQueryVo;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.ExcelUtil;
import cn.chineseall.utils.ImageUtils;
import cn.chineseall.utils.JsonUtil;
import cn.chineseall.utils.PageUtil;
import cn.chineseall.utils.RequestUtil;

@Controller
@RequestMapping("/manage/orgbook")
public class ChooseBookController extends BaseController {
    
    @Resource(type=org.apache.commons.configuration.PropertiesConfiguration.class)
    private PropertiesConfiguration fileUploadConfig;
    
    /**
     * 展示选书列表
     * 
     * @param bookQueryVo
     * @param request
     * @return
     */
    @RequestMapping("/listOrgChooseBooks")
    public ModelAndView listOrgChooseBooks(ManageBookQueryVo bookQueryVo, HttpServletRequest request) {
        if(bookQueryVo.getCurrentPage()==null || bookQueryVo.getCurrentPage().intValue() == 0){
            bookQueryVo.setCurrentPage(1);
        }
        bookQueryVo.setPageSize(10);
        bookQueryVo.setOrgTreeId(8l);
        Map<String, Object> prameters = new HashMap<String, Object>();
        prameters.put("queryVo", bookQueryVo);
        bookQueryVo = ClientUtil.getObjectClient(ClientURL.LIST_ORG_CHOOSE_BOOK, prameters, ManageBookQueryVo.class);
        PageUtil pageUtil = new PageUtil(null,bookQueryVo.getTotalCount().intValue(),bookQueryVo.getPageSize(), bookQueryVo.getCurrentPage());
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/manage/orgbook/listChooseBooksList");
        mav.getModelMap().put("bookQueryVo", bookQueryVo);
        mav.getModelMap().put("pageUtil", pageUtil);
        request.setAttribute("imgDomainName", fileUploadConfig.getString("img_domain"));
        setStaticModel(ImageUtils.class, request);
        mav.getModelMap().put("queryCondition", RequestUtil.getQueryCondition(request));
        return mav;        
    }
    
    @RequestMapping("/showChooseBookDetail")
    public ModelAndView showChooseBookDetail(Long bookId, HttpServletRequest request) {
        
        //获取图书详情
        Map<String, Object> prameters = new HashMap<String, Object>();
        prameters.put("bookId", bookId);
        String returnStr = ClientUtil.getStringClient(ClientURL.GET_CHOOSE_BOOK_DETAIL, prameters);
        HashMap<String, Object> resultMap = null;
        try {
            resultMap = JsonUtil.jsonToObject(returnStr, "bookInfoMap", HashMap.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/manage/orgbook/chooseBookDetail");
        mav.getModelMap().put("bookMap", resultMap);
        mav.getModelMap().put("returnUrl", "");
        setStaticModel(ImageUtils.class, request);
        mav.getModelMap().put("queryCondition", RequestUtil.getQueryCondition(request));
        return mav;
    }
    
    @RequestMapping("/exportOrgChooseBook")
    public void exportOrgChooseBook(ManageBookQueryVo bookQueryVo,HttpServletRequest request, HttpServletResponse response) {
        bookQueryVo.setOrgTreeId(8l);
        Map<String, Object> prameters = new HashMap<String, Object>();
        prameters.put("queryVo", bookQueryVo);
        bookQueryVo = ClientUtil.getObjectClient(ClientURL.LIST_ALL_ORG_CHOOSE_BOOK, prameters, ManageBookQueryVo.class);
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
