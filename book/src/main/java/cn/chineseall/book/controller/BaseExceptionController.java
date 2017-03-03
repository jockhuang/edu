package cn.chineseall.book.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import freemarker.core.ParseException;

/**
 * @author      huqilong
 * @description treat Exceptions and as base controller
 * @date        2010-07-14
 * @version     0.1 
 */
@Controller
public class BaseExceptionController {
	
    private Logger logger = Logger.getLogger(BaseExceptionController.class);
	
	@ExceptionHandler(Exception.class)
	public void handleException(Exception ex, HttpServletRequest request, PrintWriter pw){
		logger.error(".....................exception happend....................",ex);
		ex.printStackTrace();
	}

	@ExceptionHandler(Throwable.class)
	public void handleError(Exception ex, HttpServletRequest request, PrintWriter pw){
	    logger.error(".....................exception happend....................", ex);
	    ex.printStackTrace();
	}
}
