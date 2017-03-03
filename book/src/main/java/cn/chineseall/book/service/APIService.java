package cn.chineseall.book.service;

import java.util.List;

import cn.chineseall.model.eduyun.EduUser;


public interface APIService {
    
    /**
     * 根据用户id或者账户名获取用户信息
     * 参数二选一
     * @param personId  
     * @param account
     * @throws Exception 
     */
    public EduUser getUserInfo(String account) throws Exception;
    
    /**
     * 根据用户id批量获取用户信息的方法
     * 
     * @param persionIds
     * @return
     * @throws Exception
     */
    public List<EduUser> getUserInfoByBatch(String persionIds[]) throws Exception;
    
    /**
     * 获取用户好友列表
     * 
     * @param personId
     * @param pagesize
     * @param pageno
     * @return
     * @throws Exception
     */
    public List<EduUser> getUserFriends(String personId, Integer pageSize, Integer pageno) throws Exception;
    
    /**
     * 判断当前用户和某一用户是否好友关系
     * 
     * @param personid  当前用户id
     * @param friendid  好友id
     * @return
     * @throws Exception 
     */
    public  boolean isFriend(String personid, String friendid) throws Exception;
    
    
    /**
     * 添加发送消息的接口
     * 
     * @param sid
     * @param c
     * @param title
     * @param type
     * @param toFans
     * @param toUid
     * @return
     * @throws Exception
     */
    public boolean sendMessage(String sid,String c,String title,String type,String toFans,String toUid) throws Exception;
    
    
    /**
     * 支付接口
     * 
     * @param callbackUrl
     * @param notifyUrl
     * @param providerId
     * @param requestId
     * @param hmac
     * @param amount
     * @param orderDate
     * @param orderId
     * @param merAcDate
     * @param productDesc
     * @param productId
     * @param productName
     * @param productNum
     * @param usercode
     */
    public void payment(String callbackUrl, String notifyUrl, String providerId, String requestId, String hmac, Integer amount, String orderDate, String orderId, String merAcDate, String productDesc, String productId
            , String productName, Integer productNum, String usercode);

    public EduUser getUserInfoBySessionId(String usersessionId, String token) throws Exception;
    
    
    public String getToken();
}
