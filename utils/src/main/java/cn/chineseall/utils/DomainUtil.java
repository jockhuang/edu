package cn.chineseall.utils;

import javax.servlet.http.HttpServletRequest;

public class DomainUtil {

    public static String getFullDomainName(HttpServletRequest request){
        return request.getServerName();
    }
    
    public static String getCommonDomain(HttpServletRequest request){
        String domain = request.getServerName();
        int index = domain.indexOf(".");
        if(index!=-1){
            domain = domain.substring(index);
        }
        return domain;
    }
}
