package cn.chineseall.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreemarkerUtils {

    private static Configuration configurations;

    static {
        configurations = new Configuration();
        try {
            ClassPathResource freemarkerSettings = new ClassPathResource("freemarker.properties");
            configurations.setSettings(freemarkerSettings.getInputStream());
            File file = new File(FreemarkerUtils.class.getResource("/freemarker.properties").getFile()).getParentFile();
            configurations.setDirectoryForTemplateLoading(new File(file.getPath(),"../view"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("rawtypes")
    public static void buildTemplateByTemplateFile(Map root, String savePath, String fileName, String templatePath)
            throws Exception {
        Template temp = configurations.getTemplate(templatePath);
        File distFile = new File(savePath, fileName);
        if (!distFile.getParentFile().exists()) {
            distFile.getParentFile().mkdirs();
        }
        if (!distFile.exists()) {
            distFile.createNewFile();
        }
        Writer out = new OutputStreamWriter(new FileOutputStream(distFile), configurations.getDefaultEncoding());
        temp.process(root, out);
    }

    @SuppressWarnings("rawtypes")
    public static void buildTemplateByTemplateStr(Map root, String savePath, String fileName, String templateStr)
            throws Exception {
        StringTemplateLoader templateLoader = new StringTemplateLoader();
        templateLoader.putTemplate("templateKey", templateStr);
        configurations.setTemplateLoader(templateLoader);
        Template temp = configurations.getTemplate("templateKey");
        File distFile = new File(savePath, fileName);
        if (!distFile.getParentFile().exists()) {
            distFile.getParentFile().mkdirs();
        }
        if (!distFile.exists()) {
            distFile.createNewFile();
        }
        Writer out = new OutputStreamWriter(new FileOutputStream(distFile), configurations.getDefaultEncoding());
        temp.process(root, out);
    }

    @SuppressWarnings("rawtypes")
    public static String buildStrTemplateToString(Map root, String templateStr) throws Exception {
        StringTemplateLoader templateLoader = new StringTemplateLoader();
        templateLoader.putTemplate("templateKey", templateStr);
        configurations.setTemplateLoader(templateLoader);
        Template temp = configurations.getTemplate("templateKey");
        StringWriter writer = new StringWriter();
        temp.process(root, writer);
        return writer.toString();
    }
    

    @SuppressWarnings("rawtypes")
    public static String buildFileTemplateToString(Map root, String templatePath) throws Exception {
        Template temp = configurations.getTemplate(templatePath);
        StringWriter writer = new StringWriter();
        temp.process(root, writer);
        return writer.toString();
    }
}
