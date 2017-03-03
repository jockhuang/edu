package cn.chineseall.book.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.model.eduyun.EduPayNotify;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.JsonUtil;

public class NotifyPaymentController extends HttpServlet {

    private static final long serialVersionUID = -4717261313552991691L;
    private Logger logger = LoggerFactory.getLogger(NotifyPaymentController.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.debug("asyncrinize异步请求返回接口！打印返回参数!");
        PropertiesConfiguration eduyunConfig = null;
        try {
            eduyunConfig = new PropertiesConfiguration("eduyun.properties");
        } catch (ConfigurationException e1) {
            e1.printStackTrace();
        }
        String returnStr = "";
        InputStream in = req.getInputStream();
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
        logger.debug("eduyun  payment log returnStr = " + returnStr);
        PrintWriter pw = resp.getWriter();
        //添加支付日志，更新订单状态
        EduPayNotify notify = null;
        try {
            notify = JsonUtil.jsonToObject(returnStr, EduPayNotify.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (notify.getReturnCode() != null && "000000".equals(notify.getReturnCode())) {
            // 返回参数验证，使用加密算法验证
            String hmacStr = notify.getProviderid() + notify.getPayNo() + notify.getReturnCode() + notify.getMessage()
                    + notify.getSignType() + notify.getAmount() + notify.getVersion() + notify.getOrderid()
                    + notify.getPayDate() + notify.getReserved1() + notify.getReserved2() + notify.getReserved3()
                    + notify.getStatus() + notify.getOrderDate() + notify.getFee();

//            byte[] hmacSHA = EncryptionUtils.getHmacSHA1(hmacStr, eduyunConfig.getString("APPKEY"));
            String hmac = null;//EncryptionUtils.bytesToHexString(hmacSHA);
            if (notify.getHmac() == null || "".equals(notify.getHmac().trim()) || !hmac.equalsIgnoreCase(notify.getHmac().trim())) {
                logger.debug("fail");
                logger.debug("callback hmac="+notify.getHmac());
                logger.debug("valide hmac="+hmac);
                pw.print("fail");
                pw.flush();
                pw.close();
                return;
            }
            
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("notify", notify);
            String resultStr = ClientUtil.getStringClient(ClientURL.UPDATE_ORDERS_STATUS, parameters);
            logger.debug("api返回参数 = " + resultStr);
            Integer result = null;
            try {
                result = JsonUtil.getInt(resultStr, "result");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (result != null && result.intValue() == 1) {
                logger.debug("支付成功,定单状态修改成功!");
                pw.print("success");
                pw.flush();
                pw.close();
            } else {
                logger.debug("添加支付日志错误,定单状态未修改成功!");
                pw.print("fail");
                pw.flush();
                pw.close();
            }
        }
    };

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    };
}
