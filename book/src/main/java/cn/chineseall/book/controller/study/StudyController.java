/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Lv15
 */
package cn.chineseall.book.controller.study;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.controller.BaseController;
import cn.chineseall.model.user.UserStudy;
import cn.chineseall.model.user.vo.UserInfo;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.JsonUtil;

/**
 * 
 * @author Lv15
 */
public class StudyController extends BaseController {
    
	public static String textEllipsis(String text, int size) {
		if (text != null && (text = text.trim()).length() > size) {
			return text.substring(0, size - 1) + "…";
		}
		return text;
	}
	
	private UserInfo loginUser;
	
    public UserInfo getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(UserInfo loginUser) {
		this.loginUser = loginUser;
	}

}
