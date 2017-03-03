package cn.chineseall.book.controller.orders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.controller.study.StudyController;
import cn.chineseall.book.service.APIService;
import cn.chineseall.model.eduyun.EduBookPackage;
import cn.chineseall.model.eduyun.EduPayment;
import cn.chineseall.model.eduyun.EduUserOrders;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.ImageUtils;
import cn.chineseall.utils.JoDaTimeUtil;
import cn.chineseall.utils.JsonUtil;
import cn.chineseall.utils.PageUtil;
import cn.chineseall.utils.RequestUtil;


@Controller
@RequestMapping("/user/")
public class EduOrdersController extends StudyController {

    @Resource(name = "eduyunConfig")
    private PropertiesConfiguration eduyunConfig;
    
    @Resource
    private APIService apiService;
    
    /**
     * 我的订单列表
     * 
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/listMyOrders")
    public ModelAndView listMyOrders(Integer pageSize, Integer currentPage, HttpServletRequest request)
            throws Exception {
        Long userId = getLoginUserId(request);
        pageSize = (pageSize == null ? 10 : pageSize);
        currentPage = (currentPage == null ? 1 : currentPage);
        pageSize=5;
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("userId", userId);
        parameters.put("pageSize", pageSize);
        parameters.put("currentPage", currentPage);
        String returnStr = ClientUtil.getStringClient(ClientURL.LIST_EDUYUN_MY_ORDERS, parameters);
        Integer result = JsonUtil.getInt(returnStr, "result");

        List<HashMap> userOrdersList = null;
        Integer count = 0;
        if (result != null && result == 1) {
            userOrdersList = JsonUtil.jsonToList(returnStr, "data", HashMap.class);
            count = JsonUtil.getInt(returnStr, "count");
        }
        PageUtil pageUtil = new PageUtil(userOrdersList, count, pageSize, currentPage);
        ModelAndView mav = new ModelAndView();
        setStaticModel(ImageUtils.class, request);
        mav.setViewName("/user/orders/listMyOrders");
        mav.getModelMap().put("pageUtil", pageUtil);
        mav.getModelMap().put("queryCondition", RequestUtil.getQueryCondition(request));
        return mav;
    }

    /**
     * 添加订单，通知跳转到订单支付接口
     * 
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/addOrders")
    public String addOrders(HttpServletRequest request, Long[] ids) throws Exception {
        // 添加订单，请求支付接口
        Long userId = getLoginUserId(request);
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("userId", userId);
        parameters.put("orderIds", ids);
        String returnStr = ClientUtil.getStringClient(ClientURL.ADD_EDUYUN_ORDERS, parameters);
        Integer result = JsonUtil.getInt(returnStr, "result");
        Long ordersId = null;
        if (result != null && result.intValue() == 1) {
            // 并进行支付
            EduUserOrders userOrders = JsonUtil.jsonToObject(returnStr, "orders", EduUserOrders.class);
            if (userOrders != null) {
                ordersId = userOrders.getId();
            }
        }else{
        	return "redirect:/edushopcart/listShopCart.action";
        }
        // TODO:订单号不存在报错
        // 跳转到确认页面
        return "redirect:/user/gotoPay.action?ordersId=" + ordersId;
    }
    
    /**
     * 直接购买单本图书
     * 
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/pay")
    public String pay(HttpServletRequest request, Long bookId, Long packageId) throws Exception {
    	Long userId = getLoginUserId(request);
        // 添加订单，请求支付接口
    	if(bookId == null && packageId == null){
    		return "redirect:"+request.getHeader("Referer");
    	}
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("userId", userId);
        parameters.put("bookId", bookId);
        parameters.put("packageId", packageId);
        String returnStr = ClientUtil.getStringClient(ClientURL.ADD_EDUYUN_USER_ORDERS, parameters);
        Integer result = JsonUtil.getInt(returnStr, "result");
        Long ordersId = null;
        if (result != null && result.intValue() == 1) {
            // 并进行支付
            EduUserOrders userOrders = JsonUtil.jsonToObject(returnStr, "orders", EduUserOrders.class);
            if (userOrders != null) {
                ordersId = userOrders.getId();
            }
        }else{
        	// TODO:订单号不存在报错
        	return "redirect:/edushopcart/listShopCart.action";
        }
        // 跳转到确认页面
        return "redirect:/user/gotoPay.action?ordersId=" + ordersId;
    }

    /**
     * 单一支付接口
     * 
     * @param ordersId
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/gotoPay")
    public ModelAndView gotoPay(Long ordersId, HttpServletRequest request) throws Exception {
        // 添加订单，请求支付接口
        Long userId = getLoginUserId(request);
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("userId", userId);
        parameters.put("ordersId", ordersId);
        String returnStr = ClientUtil.getStringClient(ClientURL.GET_EDU_ODERS_BY_ID, parameters);
        Integer result = JsonUtil.getInt(returnStr, "result");
        EduPayment payment = null;
        if (result != null && result.intValue() == 1) {
            // 并进行支付
            EduUserOrders userOrders = JsonUtil.jsonToObject(returnStr, "orders", EduUserOrders.class);
            if (userOrders != null) {
                Map<String, Object> ordersDetailParameters = new HashMap<String, Object>();
                ordersDetailParameters.put("userId", userId);
                ordersDetailParameters.put("ordersId", userOrders.getId());
                String orderDetailReturnStr = ClientUtil.getStringClient(ClientURL.SHOW_ORDERS_DETAIL, ordersDetailParameters);
                List<HashMap> bookList = JsonUtil.jsonToList(orderDetailReturnStr, "bookList", HashMap.class);
                List<EduBookPackage> packageList = JsonUtil.jsonToList(orderDetailReturnStr, "packageList", EduBookPackage.class);
                payment = new EduPayment();
                // 订单金额，以元为单位
                payment.setAmount(userOrders.getPrice()/100);
                // 回调URL
                payment.setCallbackUrl("http://eduyun.chineseall.cn/eduyun/payment/sycronizeNotify.do");
                // 合作伙伴发起请求的会计日期 yyyy-MM-dd
                payment.setMerAcDate(JoDaTimeUtil.toString(new Date(), "yyyyMMdd"));
                // 后台通知的url
                payment.setNotifyUrl("http://eduyun.chineseall.cn/eduyun/payment/asycronizeNotify.do");
                // 订单的创建时间
                if (userOrders.getCreateTime() != null) {
                    payment.setOrderDate(JoDaTimeUtil.toString(userOrders.getCreateTime(), "yyyyMMdd"));
                } else {
                    payment.setOrderDate(JoDaTimeUtil.toString(new Date(), "yyyyMMdd"));
                }

                payment.setAppid(eduyunConfig.getString("APPID"));
                // 订单号
                payment.setOrderId(userOrders.getOrdersNo());
                // 商品条目描述
                payment.setProductDesc("书香中国图书产品购买");
                String productId = "";
                String productName = "";
                int num = 0;
                if(bookList!=null && bookList.size()>0){
                    num = num + bookList.size();
                    for(HashMap bookMap : bookList){
                        if(bookMap!=null && bookMap.get("id")!=null){
                            productId = productId + bookMap.get("id").toString()+";";
                            /**
                             * TODO: 添加消息
                             */
                            String content = "您的好友购买了<a href='http://eduyun.chineseall.cn/book/detail.action?bookId=" +bookMap.get("id").toString()+ "' target='_blank'>" + bookMap.get("bookName").toString() + "</a>";
                            apiService.sendMessage(getSessionId(request), content, "购买图书",
                            		"remind", "true", null);
                        }
                        if(bookMap != null && bookMap.get("bookName") != null){
                            productName = productName + bookMap.get("bookName").toString()+";";
                        }
                    }
                }
                productId=productId + "|";
                productName=productName + "|";
                if(packageList!=null && packageList.size()>0){
                    num = num + packageList.size();
                    for(EduBookPackage bookPackage : packageList){
                        if(bookPackage!=null && bookPackage.getId()!=null){
                            productId = productId + bookPackage.getId()+";";
                            /**
                             * TODO: 添加消息
                             */
                            String content = "您的好友购买了<a href='http://eduyun.chineseall.cn/eduyun/package/detail.action?id=" + bookPackage.getId() + "' target='_blank'>" + bookPackage.getName()+ "</a>";
                            apiService.sendMessage(getSessionId(request), content, "购买专辑",
                            		"remind", "true", null);
                        }
                        if(bookPackage!=null && bookPackage.getName()!=null){
                            productName = productName + bookPackage.getName()+";";
                        }
                    }
                }
                if(productId.length()>50){
                    productId = productId.substring(0,49);
                }
                if(productName.length()>50){
                    productName = productName.substring(0,49);
                }
                // 商品条目Id
                payment.setProductId(productId);
                // 产品名称
                payment.setProductName(productName);
                // 数量
                payment.setProductNum(1);
                // 支付平台给合作伙伴分配的唯一标识
                payment.setProviderId(eduyunConfig.getString("PROVIVER_ID"));
                // 合作伙伴请求的交易流水号，需要唯一
                payment.setRequestId(userOrders.getOrdersNo());
                // 用户帐号
                payment.setUsercode((String)request.getAttribute("persionId"));
                // 加密验证的串
                String hmacStr = payment.getCallbackUrl() + payment.getNotifyUrl() + payment.getProviderId()
                        + payment.getRequestId() + payment.getAmount() + payment.getOrderDate() + payment.getOrderId()
                        + (payment.getMerAcDate()==null?"":payment.getMerAcDate()) + payment.getProductDesc() + payment.getProductId()
                        + payment.getProductName() + payment.getProductNum() + payment.getUsercode()+payment.getAppid();

//                byte[] hmacSHA = EncryptionUtils.getHmacSHA1(hmacStr, eduyunConfig.getString("APPKEY"));
                String hmac = "";//EncryptionUtils.bytesToHexString(hmacSHA);
                payment.setHmac(hmac);
            }
        }
        // 跳转到确认页面
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/eduyun/goToPay");
        mav.getModelMap().put("payment", payment);
        return mav;
    }

    private static String requestBody(String urlPath, String parametersStr) throws Exception {
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
        } catch (IOException e) {
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

    /**
     * 我的订单列表
     * 
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/showOrdersDetail")
    public ModelAndView showOrders(Long id, HttpServletRequest request) throws Exception {
        Long userId = getLoginUserId(request);
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("userId", userId);
        parameters.put("ordersId", id);
        String returnStr = ClientUtil.getStringClient(ClientURL.SHOW_ORDERS_DETAIL, parameters);
        Integer result = JsonUtil.getInt(returnStr, "result");
        EduUserOrders usreOrders = JsonUtil.jsonToObject(returnStr, "orders", EduUserOrders.class);
        List<HashMap> bookList = JsonUtil.jsonToList(returnStr, "bookList", HashMap.class);
        List<EduBookPackage> packageList = JsonUtil.jsonToList(returnStr, "bookList", EduBookPackage.class);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("/eduyun/orders/listMyOrders");
        mav.getModelMap().put("packageList", packageList);
        mav.getModelMap().put("bookList", bookList);
        mav.getModelMap().put("orders", usreOrders);
        return mav;
    }
}
