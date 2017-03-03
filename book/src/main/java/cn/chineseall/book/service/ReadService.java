package cn.chineseall.book.service;

import net.sf.json.JSONArray;

public interface ReadService {
    
    /**
     * 获取阅读文本
     * 
     * @param tokenKey 获取内容令牌
     * @param page 页码
     * @return 文本内容
     */
    public String getTxtContent(String tokenKey, String tokenContent)throws Exception;

    /**
     * 获取图书目录
     * 
     * @param bookId 图书id
     * @param type 目录类型(参考阅读格式)
     * @return 目录列表
     */
    public JSONArray getDirectory(Long bookId, Integer type)throws Exception;

}
