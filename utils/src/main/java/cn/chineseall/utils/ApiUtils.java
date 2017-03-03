package cn.chineseall.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class ApiUtils {

    private static Logger log = Logger.getLogger(ApiUtils.class);

    public static <T> T getApiData(Class<T> clazz, String url, String jsonStr, String mothed) throws Exception {

        Map<String, String> paramMap = new HashMap<String, String>();

        /**
         * 直接传入完整地址，取消和ClientURL.API_PREFIX组合
         */
        // url = ClientURL.API_PREFIX + url;

        paramMap.put("jsonStr", jsonStr);
        String returnStr = "";
        if (mothed.equalsIgnoreCase("post")) {
            returnStr = HttpUtil.sendPost(url, paramMap);
        } else {
            returnStr = HttpUtil.sendGet(url, paramMap);
        }
        String result = JsonUtil.jsonToObject(returnStr, "result", String.class);
        if (result.equals("1")) {
            return JsonUtil.jsonToObject(returnStr, "data", clazz);
        } else {
            String errorCode = "";
            String errorMessage = "";
            try {
                errorCode = JsonUtil.jsonToObject(returnStr, "errorCode", String.class);
                errorMessage = JsonUtil.jsonToObject(returnStr, "errorMessage", String.class);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
    }

    public static <T> List getApiListData(Class<T> clazz, String url, String jsonStr, String mothed) throws Exception {

        Map<String, String> paramMap = new HashMap<String, String>();

        /**
         * 直接传入完整地址，取消和ClientURL.API_PREFIX组合
         */
        // url = ClientURL.API_PREFIX + url;

        paramMap.put("jsonStr", jsonStr);
        String returnStr = "";
        if (mothed.equalsIgnoreCase("post")) {
            returnStr = HttpUtil.sendPost(url, paramMap);
        } else {
            returnStr = HttpUtil.sendGet(url, paramMap);
        }

        String result = JsonUtil.jsonToObject(returnStr, "result", String.class);
        if (result.equals("1")) {
            List<T> list = JsonUtil.jsonToList(returnStr, "data", clazz);
            return list;

        } else {
            String errorCode = "";
            String errorMessage = "";
            try {
                errorCode = JsonUtil.jsonToObject(returnStr, "errorCode", String.class);
                errorMessage = JsonUtil.jsonToObject(returnStr, "errorMessage", String.class);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

    }

    public static String getApiListDataAjax(String url, String jsonStr, String mothed) throws Exception {
        Map<String, String> paramMap = new HashMap<String, String>();

        /**
         * 直接传入完整地址，取消和ClientURL.API_PREFIX组合
         */
        // url = ClientURL.API_PREFIX + url;

        paramMap.put("jsonStr", jsonStr);
        String returnStr = "";
        if (mothed.equalsIgnoreCase("post")) {
            returnStr = HttpUtil.sendPost(url, paramMap);
        } else {
            returnStr = HttpUtil.sendGet(url, paramMap);
        }
        String result = JsonUtil.jsonToObject(returnStr, "result", String.class);
        if (result.equals("1")) {
            // TODO error!!!
            returnStr = returnStr;
        } else {
            String errorCode = "";
            String errorMessage = "";
            try {
                errorCode = JsonUtil.jsonToObject(returnStr, "errorCode", String.class);
                errorMessage = JsonUtil.jsonToObject(returnStr, "errorMessage", String.class);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return returnStr;
    }

    public static String getApiJson(String url, String jsonStr, String mothed) throws Exception {
        Map<String, String> paramMap = new HashMap<String, String>();

        /**
         * 直接传入完整地址，取消和ClientURL.API_PREFIX组合
         */
        // url = ClientURL.API_PREFIX + url;

        paramMap.put("jsonStr", jsonStr);
        String returnStr = "";

        if (mothed.equalsIgnoreCase("post")) {
            returnStr = HttpUtil.sendPost(url, paramMap);
        } else {
            returnStr = HttpUtil.sendGet(url, paramMap);
        }
        return returnStr;
    }

}
