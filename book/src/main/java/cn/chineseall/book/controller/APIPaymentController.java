package cn.chineseall.book.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.chineseall.utils.HttpUtil;

public class APIPaymentController extends HttpServlet {
    
    /**  */
    private static final long serialVersionUID = -4717261313552991691L;
    private Logger logger = LoggerFactory.getLogger(APIPaymentController.class);
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.debug("synicronize请求返回接口！打印返回参数!");
        HttpUtil.logParameters(req, true);
        resp.sendRedirect("/user/i.action");
    };
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req,resp);
    };
}
