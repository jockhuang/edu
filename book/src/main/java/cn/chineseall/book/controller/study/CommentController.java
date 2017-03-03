/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Lv15
 */
package cn.chineseall.book.controller.study;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.service.BookService;
import cn.chineseall.book.service.UserService;
import cn.chineseall.model.book.Book;
import cn.chineseall.model.book.BookComment;
import cn.chineseall.model.user.UserReadingBook;
import cn.chineseall.model.user.vo.UserInfo;
import cn.chineseall.model.user.vo.UserReadingDetail;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.JsonUtil;

/**
 * 
 * @author Lv15
 */
@Controller
@RequestMapping("/user")
public class CommentController extends StudyController {

    @RequestMapping("commentbook")
    public ModelAndView commentbook(
            @RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mav = new ModelAndView();
        ModelMap map = mav.getModelMap();
        UserInfo loginUser = getLoginUser();

        HashMap<Object, Object> params = new HashMap<Object, Object>();
        params.put("userId", loginUser.getUserId());
        params.put("pageSize", 12);
        params.put("currentPage", currentPage);

        String json = ClientUtil.getStringClient(ClientURL.LIST_USER_COMMENT_BOOK, params);
        map.put("list", JsonUtil.jsonToList(json, "list", Book.class));
        map.put("count", JsonUtil.getLong(json, "count"));
        map.put("currentPage", currentPage);

        mav.setViewName("/user/comment/commentbook");
        return mav;
    }

    @RequestMapping("bcomment")
    public ModelAndView bcomment(@RequestParam("bookId") Long bookId,
            @RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mav = new ModelAndView();
        ModelMap map = mav.getModelMap();
        UserInfo loginUser = getLoginUser();

        HashMap<Object, Object> params = new HashMap<Object, Object>();

        /**
         * 获取我对单本图书书评
         */
        params.put("bookId", bookId);
        params.put("userId", loginUser.getUserId());
        params.put("type", "my");
        params.put("currentPage", currentPage);
        params.put("pageSize", 20);
        String json = ClientUtil.getStringClient(ClientURL.LIST_BOOK_COMMENT, params);

        map.put("list", JsonUtil.jsonToList(json, "list", BookComment.class));
        map.put("count", JsonUtil.getLong(json, "count"));
        map.put("currentPage", currentPage);

        /**
         * 获取对单本图书阅读记录
         */
        params.clear();
        params.put("userId", loginUser.getUserId());
        params.put("bookId", bookId);
        json = ClientUtil.getStringClient(ClientURL.GET_USER_READING_BOOK, params);
        map.put("reading", JsonUtil.jsonToObject(json, "userReadingBook", UserReadingBook.class));
        
        /**
         * 获取对单本图书阅读记录
         */
        params.clear();
        params.put("bookId", bookId);
        json = ClientUtil.getStringClient(ClientURL.GET_BOOKS, params);
        List<Book> listBook = JsonUtil.jsonToList(json, "list", Book.class);
        map.put("book", listBook != null && listBook.size() > 0 ? listBook.get(0) : null);

        mav.setViewName("/user/comment/bcomment");
        return mav;
    }
    
    @RequestMapping("comment")
    public ModelAndView comment(
            @RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mav = new ModelAndView();
        ModelMap map = mav.getModelMap();
        UserInfo loginUser = getLoginUser();

        HashMap<Object, Object> params = new HashMap<Object, Object>();

        /**
         * 获取我对单本图书书评
         */
        params.put("userId", loginUser.getUserId());
        params.put("type", "my");
        params.put("currentPage", currentPage);
        params.put("pageSize", 20);
        String json = ClientUtil.getStringClient(ClientURL.LIST_BOOK_COMMENT, params);

        List<BookComment> listComment = JsonUtil.jsonToList(json, "list", BookComment.class);
        map.put("list", listComment);
        map.put("count", JsonUtil.getLong(json, "count"));
        map.put("currentPage", currentPage);

        /**
         * 获取书评关联图书
         */
        params.clear();
        params.put("bookIds", bookService.getBookIds(listComment));
        json = ClientUtil.getStringClient(ClientURL.GET_BOOKS, params);
        List<Book> listBook = JsonUtil.jsonToList(json, "list", Book.class);
        HashMap<String, Book> mapBook = new HashMap<String, Book>();
        for(Book book : listBook){
            mapBook.put(book.getId().toString(), book);
        }
        map.put("mapBook", mapBook);

        mav.setViewName("/user/comment/comment");
        return mav;
    }

    @RequestMapping("fcomment")
    public ModelAndView fcomment(
            @RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mav = new ModelAndView();
        ModelMap map = mav.getModelMap();
        UserInfo loginUser = getLoginUser();

        pageSize = 20;
        HashMap<Object, Object> params = new HashMap<Object, Object>();
        /**
         * 获取我的书友图书书评
         */
        params.put("userId", loginUser.getUserId());
        params.put("type", "friend");
        params.put("currentPage", currentPage);
        params.put("pageSize", pageSize);
        String json = ClientUtil.getStringClient(ClientURL.LIST_FRIEND_BOOK_COMMENT, params);

        List<BookComment> listComment = JsonUtil.jsonToList(json, "list", BookComment.class);
        map.put("list", listComment);
        map.put("count", JsonUtil.getLong(json, "count"));
        map.put("currentPage", currentPage);
        map.put("pageSize", pageSize);

        /**
         * 获取提交书评用户
         */
        List<UserInfo> listUserInfo = JsonUtil.jsonToList(json, "listUserInfo", UserInfo.class);
        HashMap<String, UserInfo> mapUserInfo = new HashMap<String, UserInfo>();
        for (UserInfo userInfo : listUserInfo) {
            mapUserInfo.put(userInfo.getUserId().toString(), userInfo);
        }
        map.put("mapUserInfo", mapUserInfo);
        
        /**
         * 获取书评关联图书
         */
        params.clear();
        params.put("bookIds", bookService.getBookIds(listComment));
        json = ClientUtil.getStringClient(ClientURL.GET_BOOKS, params);
        List<Book> listBook = JsonUtil.jsonToList(json, "list", Book.class);
        HashMap<String, Book> mapBook = new HashMap<String, Book>();
        for(Book book : listBook){
            mapBook.put(book.getId().toString(), book);
        }
        map.put("mapBook", mapBook);
        
        mav.setViewName("/user/comment/fcomment");
        return mav;
    }

    @Resource
    private UserService userService;
    
    @Resource
    private BookService bookService;

}
