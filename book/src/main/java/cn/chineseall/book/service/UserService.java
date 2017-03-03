/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Lv15
 */
package cn.chineseall.book.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import cn.chineseall.model.user.User;
import cn.chineseall.model.user.UserStudy;
import cn.chineseall.model.user.vo.UserInfo;

/**
 * 
 * @author Lv15
 */
public interface UserService {

    public Map<String , Object> getUserIndexPageData(Long userId) throws Exception;
    
    public Map<String , Long> mapHaveConcernUserId(Long userId ,Collection<Long> listUserId)throws Exception;
    
    public boolean haveConcernUserId(Long userId, Long concernUserId)throws Exception;
    
    public String settingHeadImg(Long userId , String headImg , Integer width, Integer height,
			Integer x1, Integer y1, Integer x2, Integer y2);
	
	public String saveCacheHeadImg(Long userId , MultipartFile uploadIcon)throws Exception;

	public User getUser(Long userId) throws Exception;

	public UserInfo getUserInfo(Long userId) throws Exception;
	
	public List<UserInfo> listUserInfo(List<Long> userIds) throws Exception;

	public Integer getNotReadLetterCount(Long userId) throws Exception;

	public UserStudy getUserStudy(Long userId) throws Exception;

//    public UserStudy getUserStudy(Long userId) throws Exception;
//
//    public Integer getNotReadLetterCount(Long userId) throws Exception;

}
