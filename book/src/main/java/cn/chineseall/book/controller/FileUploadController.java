package cn.chineseall.book.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.chineseall.utils.JsonUtil;


@Controller
@RequestMapping("/")
public class FileUploadController extends BaseController{
	
	private static final Long FILE_MAX_SIZE = 10000000000l;
	
	@Resource
	private PropertiesConfiguration fileUploadConfig;
    
    private static HashMap<String, String> extMap = new HashMap<String, String>();
    static {
    	extMap.put("image", "gif,jpg,jpeg,png,bmp");
    }
    
    /**
     * kindeditor的上传方法
     * @param dataType
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/editorUpload")
    public void editorUpload(@RequestParam("imgFile") MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
        response.setContentType("text/html; charset=UTF-8");	
		response.setHeader("Pragma","No-cache");
	    response.setHeader("Cache-Control","no-cache"); 
	    response.setDateHeader("Expires", 0); 
	    
	    Map<String, Object> dataMap = new HashMap<String, Object>();
		//检查文件大小
		if(file.getSize() > FILE_MAX_SIZE){
			dataMap.put("error", 1);
			dataMap.put("message", "上传文件大小超过限制!");
			return;
		}
		String fileName = file.getOriginalFilename();
		//检查扩展名
		String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
		if(!extMap.get("image").contains(fileExt)){
			dataMap.put("error", 1);
			dataMap.put("message", "上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get("image") + "格式.");
			try {
	            response.getWriter().print(JsonUtil.toJson(dataMap));
	            response.getWriter().flush();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			return;
		}
		String imgDomain = fileUploadConfig.getString("img_domain");
		String uploadDir = fileUploadConfig.getString("bookcover_upload_base_dir");
        File f1 = new File(uploadDir);
        if (!f1.exists()) {
            f1.mkdirs();
        }
        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")); 
        String name = UUID.randomUUID().toString();
        String distFileName = "/kindeditor/upload/"+name + extName;
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            File distFile = new File(uploadDir, distFileName);
            if (!distFile.getParentFile().exists()) {
                distFile.getParentFile().mkdirs();
            }
            FileOutputStream fos = new FileOutputStream(distFile);
            fos.write(bytes);
            fos.flush();
            fos.close();
            //删除掉老图
            Thread.sleep(1000);
        }
        dataMap.put("error", 0);
        dataMap.put("url", "http://"+imgDomain+"/"+distFileName);
        try {
			response.getWriter().print(JsonUtil.toJson(dataMap));
			response.getWriter().flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
