package cn.chineseall.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {

    @SuppressWarnings("unchecked")
    public static String getQueryCondition(HttpServletRequest request) {
        StringBuffer parametersBuffer = new StringBuffer();
        Enumeration<String> parameterNames = request.getParameterNames();
        String key = null, value = null;
        while (parameterNames.hasMoreElements()) {
            key = parameterNames.nextElement();
            if ("pageSize".equals(key) || "currentPage".equals(key)) {
                continue;
            }
            value = request.getParameter(key);
            parametersBuffer.append(key);
            parametersBuffer.append("=");
            try {
                parametersBuffer.append(URLEncoder.encode(value, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            parametersBuffer.append("&");
        }
        if (parametersBuffer != null && parametersBuffer.length() > 0) {
            parametersBuffer.deleteCharAt(parametersBuffer.length() - 1);
        }
        return parametersBuffer.toString();
    }
    public static String getQueryCondition(HttpServletRequest request,String ... filterParams) {
        StringBuffer parametersBuffer = new StringBuffer();
        Enumeration<String> parameterNames = request.getParameterNames();
        String key = null, value = null;
        while (parameterNames.hasMoreElements()) {
            key = parameterNames.nextElement();
            boolean contains = false;
            for(String filter:filterParams){
                if(filter.equals(key)){
                    contains = true;
                    break;
                }
            }
            if(contains){
                continue;
            }
            value = request.getParameter(key);
            parametersBuffer.append(key);
            parametersBuffer.append("=");
            try {
                parametersBuffer.append(URLEncoder.encode(value, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            parametersBuffer.append("&");
        }
        if (parametersBuffer != null && parametersBuffer.length() > 0) {
            parametersBuffer.deleteCharAt(parametersBuffer.length() - 1);
        }
        return parametersBuffer.toString();
    }
    
    public static String getInludeQueryCondition(HttpServletRequest request, String ... keys) {
        StringBuffer parametersBuffer = new StringBuffer();
        Enumeration<String> parameterNames = request.getParameterNames();
        for (String key:keys) {
            String value = request.getParameter(key);
            parametersBuffer.append(key);
            parametersBuffer.append("=");
            try {
                parametersBuffer.append(URLEncoder.encode(value, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            parametersBuffer.append("&");
        }
        if (parametersBuffer != null && parametersBuffer.length() > 0) {
            parametersBuffer.deleteCharAt(parametersBuffer.length() - 1);
        }
        return parametersBuffer.toString();
    }
}
