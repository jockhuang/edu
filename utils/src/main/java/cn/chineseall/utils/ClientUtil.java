package cn.chineseall.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientUtil {
    //private static Logger log = Logger.getLogger(ClientUtil.class);

    // 构造参数
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static Map buildParams(Object object) {
        Map senderMap = new HashMap();
        try {
            senderMap.put("jsonStr", JsonUtil.toJson(object));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return senderMap;
    }

    // 得到返回JSON里的data信息
    private static <T> T getObject(String returnJsonStr, Class<T> clazz) {
        if (returnJsonStr == null) {
            return null;
        }
        Integer result = 0;
        try {
            result = JsonUtil.getInt(returnJsonStr, "result");
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        T json = null;
        if (result == 1) {
            try {
                json = JsonUtil.jsonToObject(returnJsonStr, "data", clazz);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return json;
        }
        if (result == 0) {
            String errorCode = "";
            String errorMessage = "";
            try {
                errorCode = JsonUtil.jsonToObject(returnJsonStr, "errorCode", String.class);
                errorMessage = JsonUtil.jsonToObject(returnJsonStr, "errorMessage", String.class);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    // 得到返回JSON里的data信息
    @SuppressWarnings("unused")
    private static <T> T getObject(String returnJsonStr, String key, Class<T> clazz) {
        if (returnJsonStr == null) {
            return null;
        }
        Integer result = 0;
        try {
            result = JsonUtil.getInt(returnJsonStr, "result");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        String data = null;
        T json = null;

        if (result == 1) {
            try {
                data = JsonUtil.jsonToObject(returnJsonStr, "data", String.class);
                json = JsonUtil.jsonToObject(data, key, clazz);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return json;
        }
        if (result == 0) {
            String errorCode = "";
            String errorMessage = "";
            try {
                errorCode = JsonUtil.jsonToObject(returnJsonStr, "errorCode", String.class);
                errorMessage = JsonUtil.jsonToObject(returnJsonStr, "errorMessage", String.class);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    // 得到返回JSON里的data信息
    private static <T> List<T> getList(String returnJsonStr, Class<T> clazz) {
        if (returnJsonStr == null) {
            return null;
        }
        Integer result = 0;
        try {
            result = JsonUtil.getInt(returnJsonStr, "result");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        List<T> data = null;
        if (result == 1) {
            try {
                data = JsonUtil.jsonToList(returnJsonStr, "data", clazz);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return data;
        }
        if (result == 0) {
            String errorCode = "";
            String errorMessage = "";
            try {
                errorCode = JsonUtil.jsonToObject(returnJsonStr, "errorCode", String.class);
                errorMessage = JsonUtil.jsonToObject(returnJsonStr, "errorMessage", String.class);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    // 得到返回JSON里的data信息
    @SuppressWarnings("unused")
    private static <T> List<T> getList(String returnJsonStr, String key, Class<T> clazz) {
        if (returnJsonStr == null) {
            return null;
        }
        Integer result = 0;
        try {
            result = JsonUtil.getInt(returnJsonStr, "result");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        String data = null;
        List<T> json = null;

        if (result == 1) {
            try {
                data = JsonUtil.jsonToObject(returnJsonStr, "data", String.class);
                json = JsonUtil.jsonToList(data, key, clazz);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return json;
        }
        if (result == 0) {
            String errorCode = "";
            String errorMessage = "";
            try {
                errorCode = JsonUtil.jsonToObject(returnJsonStr, "errorCode", String.class);
                errorMessage = JsonUtil.jsonToObject(returnJsonStr, "errorMessage", String.class);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    /**
     * 得到具体对象
     * 
     * @param <T>
     * @param url
     * @param map
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getObjectClient(String url, Map map, Class<T> clazz) {
        String returnJsonStr = HttpUtil.sendGet(url, ClientUtil.buildParams(map));
        return ClientUtil.getObject(returnJsonStr, clazz);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getObjectClient(String url, Object object, Class<T> clazz) {
        String returnJsonStr = HttpUtil.sendPost(url, ClientUtil.buildParams(object));
        return ClientUtil.getObject(returnJsonStr, clazz);
    }

    /**
     * 得到jsonString， 应用于 jsonString 里面夹杂多个对象的情况
     * 
     * @param url
     * @param map
     * @return
     */
    @SuppressWarnings("unchecked")
    public static String getStringClient(String url, Map map) {
        String returnJsonStr = HttpUtil.sendPost(url, ClientUtil.buildParams(map));
        return returnJsonStr;
    }

    @SuppressWarnings("unchecked")
    public static String getStringClient(String url, Object object) {
        String returnJsonStr = HttpUtil.sendPost(url, ClientUtil.buildParams(object));
        return returnJsonStr;
    }

    /**
     * 得到list
     * 
     * @param <T>
     * @param url
     * @param map
     * @param clazz
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T> List<T> getListClient(String url, Map map, Class clazz) {
        String returnJsonStr = HttpUtil.sendGet(url, ClientUtil.buildParams(map));
        List<T> list = ClientUtil.getList(returnJsonStr, clazz);
        return list;
    }

    /**
     * @param demo
     */
    public static void main(String[] args) {
        // String url = HOST+"/shop/getShopInfo.json";
        // Map map = new HashMap();
        // map.put("merchantId", merchantId);
        // String returnJsonStr = HttpUtil.sendGet(url,buildParams(map));
        // Shop data = getObject(returnJsonStr ,Shop.class);
        // return data;
        // String url = HOST+"/category/getParentCategoryListById.json";
        // Map map = new HashMap();
        // map.put("categoryId", categoryId);
        // String returnJsonStr = HttpUtil.sendGet(url,buildParams(map));
        // List<Category> categoryList = getList(returnJsonStr ,Category.class);
        // return categoryList;
    }

}
