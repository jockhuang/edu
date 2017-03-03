package cn.chineseall.book.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.chineseall.book.service.APIService;
import cn.chineseall.model.eduyun.EduUser;
import cn.chineseall.utils.HttpUtil;
import cn.chineseall.utils.JsonUtil;


@Service("aPIService")
public class APIServiceImpl implements APIService {
    
    private static final Logger logger = LoggerFactory.getLogger(APIServiceImpl.class);

    @Resource(name="apiConfig")
    private PropertiesConfiguration  apiConfig;
    
    @Resource(name="eduyunConfig")
    private PropertiesConfiguration  eduyunConfig;
    
    /**
     * account获取用户信息
     * @see cn.chineseall.book.service.APIService#getUserInfo(java.lang.String)
     */
    @Override
    public EduUser getUserInfo(String account) throws Exception {
        String USER_INFO_URL = apiConfig.getString("USER_INFO_URL");
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("account", account);
        String returnStr = requestBody(USER_INFO_URL, JsonUtil.toJson(parameters));
        String retcode = JsonUtil.getString(returnStr, "result");
        EduUser eduUser = null;
        if(retcode!=null && "000000".equals(retcode)){
            eduUser = JsonUtil.jsonToObject(returnStr,"userinfo", EduUser.class);
        }else if (retcode !=null && "301001".equals(retcode)){
            logger.error("用户不存在!account="+account);
        }else if (retcode !=null && "301999".equals(retcode)){
            logger.error("usessionid验证失败!account="+account);
        }
        return eduUser;
    }
    
    @Override
    public List<EduUser> getUserInfoByBatch(String persionIds[]) throws Exception {
        String BATCH_GET_USER_URL = apiConfig.getString("BATCH_GET_USER_URL");
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("persionids", JsonUtil.toJson(persionIds));
        String returnStr = requestBody(BATCH_GET_USER_URL, JsonUtil.toJson(parameters));
        String retcode = JsonUtil.getString(returnStr, "result");
        List<EduUser> eduUserList = null;
        if(retcode!=null && "000000".equals(retcode)){
            eduUserList = JsonUtil.jsonToList(returnStr,"userinfolist", EduUser.class);
        }else if (retcode !=null && "301001".equals(retcode)){
            logger.error("用户不存在!persionIds="+persionIds);
        }else if (retcode !=null && "301999".equals(retcode)){
            logger.error("usessionid验证失败!persionIds="+persionIds);
        }
        return eduUserList;
    }
    
    /**
     * 获取用户好友信息
     * @see cn.chineseall.book.service.APIService#getUserFriends(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public List<EduUser> getUserFriends(String personId, Integer pageSize, Integer pageno) throws Exception {
        String FETCH_USER_FRIENDS = apiConfig.getString("FETCH_USER_FRIENDS") + personId+"?start="+String.valueOf((pageno-1) * pageSize  + 1)+"&end="+pageSize;
        Map<String, String> parameters = new HashMap<String, String>();
        String returnStr = HttpUtil.sendGet(FETCH_USER_FRIENDS, parameters);
        String retcode = JsonUtil.getString(returnStr, "result");
        List<EduUser> eduUsers = null;
        Integer totalResults = 0;
        if(retcode!=null && "000000".equals(retcode)){
            eduUsers = JsonUtil.jsonToList(returnStr,"list", EduUser.class);
        }else if (retcode !=null && "301001".equals(retcode)){
            logger.error("用户不存在!persionid="+personId+";pagesize="+pageSize+";pageno="+pageno);
        }else if (retcode !=null && "999999".equals(retcode)){
            logger.error("接口异常!persionid="+personId+";pagesize="+pageSize+";pageno="+pageno);
        }
        return eduUsers;
    }
    
    /**
     * 判断当前用户和某一用户是否好友关系
     * 
     * @param personid  当前用户id
     * @param friendid  好友id
     * @return
     * @throws Exception 
     */
    @Override
    public  boolean isFriend(String personid, String friendid) throws Exception{
        String USER_IS_FRIENDS = apiConfig.getString("USER_IS_FRIENDS");
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("personid", personid);
        parameters.put("friendid", friendid);
        String returnStr = requestBody(USER_IS_FRIENDS, JsonUtil.toJson(parameters));
        String retcode = JsonUtil.getString(returnStr, "result");
        boolean isFriend = false;
        if(retcode!=null && "000000".equals(retcode)){
            isFriend = true;
        }else if (retcode !=null && "301001".equals(retcode)){
            logger.error("用户不存在!persionid="+personid+";friendid="+friendid);
        }else if (retcode !=null && "301122".equals(retcode)){
            logger.error("好友不存在!persionid="+personid+";friendid="+friendid);
        }
        return isFriend;
    }
    
    
    /**
     * 消息接口
     * 
     * @param uid  personId
     * @param c    信息内容
     * @param title   消息标题
     * @param type    固定remind
     * @param toFans  发送给关注我的人true(可选项)
     * @param toUid   发送给指定人(可选项和toFans只有有一个存在即可)  
     * @return
     * @throws Exception 
     */
    public boolean sendMessage(String sid,String c,String title,String type,String toFans,String toUid) throws Exception{
        
        String SEND_MESSAGE = apiConfig.getString("SEND_MESSAGE");
        Map<String, String> parameters = new HashMap<String, String>();
        String appId = eduyunConfig.getString("APPID");
        parameters.put("appid", appId);
        parameters.put("c", c);
        parameters.put("title", title);
        parameters.put("type", type);
        parameters.put("toFans", toFans);
        if(toUid!=null){
        	parameters.put("toUid", toUid);
        }
        parameters.put("sid", sid);
        
        String returnStr = HttpUtil.sendPost(SEND_MESSAGE, parameters);
        String retcode = JsonUtil.getString(returnStr, "retCode");
        boolean result = false;
        if(retcode!=null && "0".equals(retcode)){
            result = true;
        }else{
            logger.error("系统发生错误", parameters);
        }
        return result;
    }
    
    
    /**
     * 支付接口
     * 
     * @param callbackUrl  页面通知交易结果时将返回到这个URL
     * @param notifyUrl    后台通知交易结果时返回到这个URL
     * @param providerId   支付平台给合作伙伴分配的唯一标识
     * @param requestId    合作伙伴请求的交易流水号，需要唯一
     * @param hmac         获得hmac的方法见签名算法,参数顺序按照表格中从上到下的顺序,但不包括本参数
     * @param amount       订单金额，以分为单位, 如1元表示为100
     * @param orderDate    合作伙伴发起请求的时间(年年年年月月日日)
     * @param orderId      合作伙伴系统订单号
     * @param merAcDate    合作伙伴发起请求的会计日期(年年年年月月日日)
     * @param productDesc  对产品的描述
     * @param productId    所购买产品的编号
     * @param productName  所购买产品的名称
     * @param productNum   所购买产品的数量
     * @param usercode     用户帐号
     */
    @Override
    public void payment(String callbackUrl, String notifyUrl, String providerId, String requestId, String hmac, Integer amount, String orderDate, String orderId, String merAcDate, String productDesc, String productId
, String productName, Integer productNum, String usercode){
        String PAYMENT_URL = apiConfig.getString("PAYMENT_URL");
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("callbackUrl", callbackUrl);
        parameters.put("notifyUrl", notifyUrl);
        parameters.put("providerId", providerId);
        parameters.put("requestId", requestId);
        parameters.put("amount", amount.toString());
        parameters.put("hmac", hmac);
        parameters.put("orderDate", orderDate);
        parameters.put("orderId", orderId);
        parameters.put("merAcDate", merAcDate);
        parameters.put("productDesc", productDesc);
        parameters.put("productId", productId);
        HttpUtil.sendPost(PAYMENT_URL, parameters);
    }
    
    
    private String requestBody(String urlPath, String parametersStr) throws Exception{
        
        URL url = null;
        try {
            url = new URL(urlPath);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("content-type", "application/json;charset=UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.setUseCaches(false);
            OutputStream outStream = urlConnection.getOutputStream();
            outStream.write(parametersStr.getBytes("UTF-8"));
            outStream.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
        
        String returnStr = "";
        try {
            InputStream in = urlConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            String line = bufferedReader.readLine();
            while (line != null) {
                returnStr = returnStr + line + "\r\n";
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
        return returnStr;
    }

    @Override
    public EduUser getUserInfoBySessionId(String usersessionId, String token) throws Exception {
        String USER_INFO_URL = apiConfig.getString("CURRENT_USER_INFO_URL")+usersessionId+"?token="+token;
        String returnStr = HttpUtil.sendGet(USER_INFO_URL);
        String retcode = JsonUtil.getString(returnStr, "result");
        EduUser eduUser = null;
        if(retcode!=null && "000000".equals(retcode)){
            eduUser = JsonUtil.jsonToObject(returnStr,"userinfo", EduUser.class);
        }else if (retcode !=null && "301001".equals(retcode)){
            logger.error("用户不存在!usersessionId="+usersessionId);
        }else if (retcode !=null && "301999".equals(retcode)){
            logger.error("usessionid验证失败!usersessionId="+usersessionId);
        }
        return eduUser;
    }

    @Override
    public String getToken() {
        String APPID=eduyunConfig.getString("APPID");
        String APPKEY=eduyunConfig.getString("APPKEY");
        String GET_TOKEN = apiConfig.getString("GET_TOKEN");
        Long timestemp = System.currentTimeMillis();
        String hmacStr=APPID+APPKEY+timestemp;
//        byte[] hmacSHA = EncryptionUtils.getHmacSHA1(hmacStr, APPKEY);
        String hmac =null;// EncryptionUtils.bytesToHexString(hmacSHA);
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("appid", APPID);
        parameters.put("timestamp", timestemp.toString());
        parameters.put("keyinfo", hmac);
        String returnStr = null;
        String retcode = null;
        try {
            returnStr = requestBody(GET_TOKEN, JsonUtil.toJson(parameters));
            logger.debug("returnStr="+returnStr);
            retcode = JsonUtil.getString(returnStr, "result");
            if("000000".equals(retcode)){
                HashMap map = JsonUtil.jsonToObject(returnStr, "tokenInfo", HashMap.class);
                return map.get("token").toString();
            }
            logger.error("获取token失败!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
