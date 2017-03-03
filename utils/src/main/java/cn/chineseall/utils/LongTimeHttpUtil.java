package cn.chineseall.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发送http请求,log request请求参数
 * 
 * @author huqilong
 * @version 2.0
 */

public class LongTimeHttpUtil {

    private static Logger logger = LoggerFactory.getLogger(LongTimeHttpUtil.class);
    
    private static String encoding = "UTF-8";

    private static Map<String, String> requestProperties = new HashMap<String, String>();

    static {
        requestProperties.put("Accept", "*/*");
        requestProperties.put("Accept-Language", "zh-cn");
        requestProperties.put("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
        requestProperties.put("Cache-Control", "no-cache");
        requestProperties.put("ContentType", "text/html; charset=" + encoding);
        requestProperties.put("Connection", "close");
    }

    @SuppressWarnings("unchecked")
    public static void logParameters(HttpServletRequest request) {
        logParameters(request, false);
    }

    @SuppressWarnings("unchecked")
    public static void logParameters(HttpServletRequest request, boolean isError) {
        String uri = request.getRequestURI();
        Map<String, Object> parameterMap = request.getParameterMap();
        StringBuffer sb = new StringBuffer();
        sb.append("request uri = " + uri + " || ");
        Set<String> keySet = parameterMap.keySet();
        if (keySet != null) {
            for (String key : keySet) {
                if (key != null) {
                    sb.append(key + "=");
                    sb.append(request.getParameter(key));
                    sb.append(",");
                }
            }
        }
        if (isError) {
            logger.info(sb.toString());
        } else {
            logger.info(sb.toString());
        }
    }

    public static String sendGet(String urlString) {
        return send(urlString, "GET", null, requestProperties, null);
    }

    public static String sendGet(String urlString, Map<String, String> params) {
        return send(urlString, "GET", params, requestProperties, null);
    }

    public static String sendGet(String urlString, Map<String, String> params, Map<String, String> propertys) {
        return send(urlString, "GET", params, propertys, null);
    }

    public static String sendPost(String urlString) {
        return send(urlString, "POST", null, requestProperties, null);
    }

    public static String sendPost(String urlString, Map<String, String> params) {
        return send(urlString, "POST", params, requestProperties, null);
    }

    public static String sendPost(String urlString, Map<String, String> params, Map<String, String> propertys) {
        return send(urlString, "POST", params, propertys, null);
    }

    public static String sendXml(String urlString, Map<String, String> params) {
        Map<String, String> props = new HashMap<String, String>();
        props.put("Accept", "*/*");
        props.put("Accept-Language", "zh-cn");
        props.put("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
        props.put("Cache-Control", "no-cache");
        props.put("ContentType", "application/x-www-form-urlencoded; charset=GB2312");
        props.put("Connection", "close");
        return send(urlString, "POST", params, props, "GB2312");
    }

    private static String send(String sendUrl, String method, Map<String, String> parametersMap,
            Map<String, String> propertyMap, String encodType) {
        StringBuffer parameters = new StringBuffer();
        if (encodType == null) {
            encodType = encoding;
        }
        if ("GET".equalsIgnoreCase(method) && parametersMap != null) {
            int i = 0;
            for (String key : parametersMap.keySet()) {
                if (i == 0) {
                    parameters.append("?");
                } else {
                    parameters.append("&");
                }
                parameters.append(key);
                parameters.append("=");
                parameters.append(encoding(parametersMap.get(key), encodType));
                i++;
            }
            sendUrl = sendUrl + parameters.toString();
        }

        URL url = null;
        try {
            url = new URL(sendUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            urlConnection.setRequestMethod(method);
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.setUseCaches(false);
            urlConnection.setConnectTimeout(60000);
            if (propertyMap != null) {
                for (String key : propertyMap.keySet()) {
                    urlConnection.addRequestProperty(key, propertyMap.get(key));
                }
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        }

        if ("POST".equalsIgnoreCase(method) && parametersMap != null) {
            int i = 0;
            for (String key : parametersMap.keySet()) {
                if (i != 0) {
                    parameters.append("&");
                }
                parameters.append(key);
                parameters.append("=");
                parameters.append(encoding(parametersMap.get(key), encodType));
                i++;
            }
            try {
                urlConnection.getOutputStream().write(parameters.toString().getBytes(encodType));
                urlConnection.getOutputStream().flush();
                urlConnection.getOutputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return makeContent(sendUrl, urlConnection, encodType);
    }

    private static String makeContent(String urlString, HttpURLConnection urlConnection, String encoding) {
        String returnContent = "";
        try {
            InputStream in = urlConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, encoding));
            String line = bufferedReader.readLine();
            while (line != null) {
                returnContent = returnContent + line + "\r\n";
                line = bufferedReader.readLine();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return returnContent.toString();
    }

    private static String encoding(String content, String encoding) {
        if (content != null) {
            try {
                content = URLEncoder.encode(content, encoding);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return content;
    }
}
