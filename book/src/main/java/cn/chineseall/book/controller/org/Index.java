package cn.chineseall.book.controller.org;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Index {
    
   public static Logger logger = LoggerFactory.getLogger(Index.class);

	@RequestMapping("/index")
	public String IndexPage(String orgTreeId, HttpServletRequest request) {
	    return "redirect:/org/index.action?orgTreeId="+orgTreeId;
	}
}
