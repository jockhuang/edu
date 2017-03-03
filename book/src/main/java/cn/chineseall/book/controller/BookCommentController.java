package cn.chineseall.book.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.service.APIService;
import cn.chineseall.model.book.BookComment;
import cn.chineseall.model.user.vo.UserInfo;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.DateUtil;
import cn.chineseall.utils.ImageUtils;
import cn.chineseall.utils.JsonUtil;

@Controller
@RequestMapping("/book")
public class BookCommentController extends BaseController {
	
	@Resource(name = "apiConfig")
	private PropertiesConfiguration apiConfig;

	@Resource
	private APIService apiService;

    @RequestMapping("/addcomment")
    public void addComment(@RequestParam("bookId") Long bookId,
            @RequestParam("content") String content, @RequestParam(required = false, value = "page") Integer page,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        getOrgTreeId(request);
        Long userId = getLoginUserId(request);
        JSONObject object = new JSONObject();
        if (userId != null) {
            BookComment comment = new BookComment();
            comment.setSubmiterId(userId);
            comment.setBookId(bookId);
            comment.setOrgTreeId(orgTreeId);
            comment.setContent(content);
            comment.setUsefulCount(0);
            comment.setUselessCount(0);
            // comment.setSubmiterIp(submiterId);
            String returnStr = ClientUtil.getStringClient(ClientURL.ADD_BOOK_COMMENT, comment);

            object.put("success", JsonUtil.getBoolean(returnStr, "success"));
            object.put("msg", JsonUtil.getString(returnStr, "msg"));
            if(JsonUtil.getBoolean(returnStr, "success")){
            	/**
            	 * TODO: 添加消息
            	 */
            	if (JsonUtil.getBoolean(returnStr, "success")) {
            		String content2 = "您的好友评论了<a href='http://eduyun.chineseall.cn/book/detail.action?bookId="
            				+bookId+ "' target='_blank'>" +JsonUtil.getString(returnStr, "bookName")+ "</a>";
            		apiService.sendMessage(getSessionId(request), content2,
            				"评论信息", "remind", "true", null);
            	}
            }
        } else {
            object.put("success", false);
            object.put("msg", "您还未登录，无法提交书评");
        }
        response.setContentType("text/plain");
        response.getWriter().print(object.toString());
        response.getWriter().flush();
    }
    
    @RequestMapping("/deletecomment")
    public void deleteComment(@RequestParam Long commentId,HttpServletRequest request, HttpServletResponse response) throws Exception {

        getOrgTreeId(request);
        Long userId = getLoginUserId(request);
        JSONObject object = new JSONObject();
        if (userId != null) {
        	HashMap<Object, Object> params = new HashMap<Object , Object>();
        	params.put("bookCommentId", commentId);
            params.put("userId" , userId);
        	String returnStr = ClientUtil.getStringClient(ClientURL.DELETE_BOOK_COMMENT, params);
            object.put("success", JsonUtil.getBoolean(returnStr, "success"));
            object.put("msg", JsonUtil.getString(returnStr, "msg"));
        } else {
            object.put("success", false);
            object.put("msg", "您还未登录，无法提交书评");
        }
        response.setContentType("text/plain");
        response.getWriter().print(object.toString());
        response.getWriter().flush();
    }

    @RequestMapping("/usefulcomment")
    public void usefulComment(@RequestParam("commentId") Long commentId, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        Long userId = getLoginUserId(request);
        JSONObject object = new JSONObject();
        if (userId != null) {
            HashMap<Object, Object> params = new HashMap<Object, Object>();
            params.put("bookCommentId", commentId);
            params.put("userId", userId);

            String returnStr = ClientUtil.getStringClient(ClientURL.USEFUL_BOOK_COMMENT, params);

            object.put("success", JsonUtil.getBoolean(returnStr, "success"));
            object.put("msg", JsonUtil.getString(returnStr, "msg"));
        } else {
            object.put("success", false);
            object.put("msg", "您还未登录，无法对书评点击\"赞\"");
        }
        response.setContentType("text/plain");
        response.getWriter().print(object.toString());
        response.getWriter().flush();
    }

    @RequestMapping("/uselesscomment")
    public void uselessComment(@RequestParam("commentId") Long commentId, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        Long userId = getLoginUserId(request);
        JSONObject object = new JSONObject();
        if (userId != null) {
            HashMap<Object, Object> params = new HashMap<Object, Object>();
            params.put("bookCommentId", commentId);
            params.put("userId", userId);

            String returnStr = ClientUtil.getStringClient(ClientURL.USELESS_BOOK_COMMENT, params);

            object.put("success", JsonUtil.getBoolean(returnStr, "success"));
            object.put("msg", JsonUtil.getString(returnStr, "msg"));
        } else {
            object.put("success", false);
            object.put("msg", "您还未登录，无法对书评点击\"贬\"");
        }
        response.setContentType("text/plain");
        response.getWriter().print(object.toString());
        response.getWriter().flush();
    }

    @RequestMapping("/listcomment")
    public void comment(@RequestParam("bookId") Long bookId,
            @RequestParam(required = false, value = "page") Integer page,
            @RequestParam(required = false, value = "type", defaultValue = "all") String type,
            @RequestParam(required = false, value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(required = false, value = "pageSize", defaultValue = "20") Integer pageSize,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        getOrgTreeId(request);
        
        Map<Object, Object> params = new HashMap<Object, Object>();

        params.put("bookId", bookId);
        params.put("orgTreeId", orgTreeId);
        params.put("type", type);
        params.put("currentPage", currentPage);
        params.put("pageSize", pageSize > 0 && pageSize < 100 ? pageSize : 20);

        if (page != null) {
            params.put("page", page);
        }

        if (("my".equals(type) || "friend".equals(type))) {
            params.put("userId", getLoginUserId(request));
        }

        String returnStr = ClientUtil.getStringClient("friend".equals(type) ? ClientURL.LIST_FRIEND_BOOK_COMMENT
                : ClientURL.LIST_BOOK_COMMENT, params);

        List<BookComment> listComment = JsonUtil.jsonToList(returnStr, "list", BookComment.class);
        List<UserInfo> listUserInfo = JsonUtil.jsonToList(returnStr, "listUserInfo", UserInfo.class);

        JSONArray array = new JSONArray();
        for (BookComment comment : listComment) {
            JSONObject item = new JSONObject();
            item.put("id", comment.getId());
            item.put("content", comment.getContent());
            item.put("title", comment.getTitle());
            item.put("page", comment.getPage());
            item.put("usefulCount", comment.getUsefulCount());
            item.put("uselessCount", comment.getUselessCount());
            item.put("submiterId", comment.getSubmiterId());
            for (UserInfo userInfo : listUserInfo) {
                if (userInfo.getUserId().equals(comment.getSubmiterId())) {
                    item.put("submiterName", userInfo.getDisplayName() != null ? userInfo.getDisplayName() : userInfo.getUserName());
                    break;
                }
            }
            item.put("submiterHeadImg", ImageUtils.getUserImgUrl(comment.getSubmiterId()));
            item.put("submitTime", DateUtil.formatDate(comment.getSubmitTime(), "yyyy-MM-dd HH:mm"));
            array.add(item);
        }

        JSONObject object = new JSONObject();
        object.put("count", JsonUtil.getLong(returnStr, "count"));
        object.put("list", array);

        response.setContentType("text/plain");
        response.getWriter().print(object.toString());
        response.getWriter().flush();

    }

}
