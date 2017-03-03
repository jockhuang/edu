package cn.chineseall.book.interceptor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.controller.study.OtherUserController;
import cn.chineseall.book.controller.study.StudyController;
import cn.chineseall.model.user.UserStudy;
import cn.chineseall.model.user.vo.UserInfo;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.ImageUtils;
import cn.chineseall.utils.JsonUtil;
import cn.chineseall.utils.RequestUtil;

public class StudyInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		if (!(handler instanceof HandlerMethod)) {
			return super.preHandle(request, response, handler);
		}
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		if (!(handlerMethod.getBean() instanceof StudyController)) {
			return super.preHandle(request, response, handler);
		}
		UserInfo userInfo = getUserInfo(getUserId(request));
		StudyController controller = (StudyController) handlerMethod.getBean();
		controller.setLoginUser(userInfo);
		if (userInfo != null) {
			
			request.setAttribute("loginUser", userInfo);

			HashMap<Object, Object> params = new HashMap<Object, Object>();
			params.put("userId", userInfo.getUserId());
			/**
			 * 存入用户未读书信
			 */
			String json = ClientUtil.getStringClient(
					ClientURL.GET_NOT_READ_LETTER_COUNT, params);
			request.setAttribute("notReadLetterCount", JsonUtil.getInt(json, "count"));
			
			if (!(controller instanceof OtherUserController)) {
				/**
				 * 存入用户书房样式
				 */
				json = ClientUtil.getStringClient(ClientURL.GET_USER_STUDY,
						params);
				request.setAttribute("userStudy",
						JsonUtil.jsonToObject(json, "userStudy", UserStudy.class));
			}
		} else if (!(controller instanceof OtherUserController)) {
			String queryCondition = RequestUtil.getQueryCondition(request);
            String returnUrl = request.getServletPath();
            if(queryCondition!=null && !"".equals(queryCondition.trim())){
                returnUrl += "?" + queryCondition;
            }
            response.sendRedirect("/showLogin.action?returnUrl="+returnUrl);
			return false;
		}
		
		controller.setStaticModel(ImageUtils.class, request);
		controller.setStaticModel("textHandle", StudyController.class, request);
		
		return super.preHandle(request, response, handler);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
	
	private Long getUserId(HttpServletRequest request){
        Object userIdObj = request.getAttribute("userId");
        Long userId = null;
        if(userIdObj != null){
            userId = Long.valueOf(userIdObj.toString());
        }
        return userId;
    }
	
    public UserInfo getUserInfo(Long userId) throws Exception {
        if (userId != null) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("userId", userId);
            String returnStr = ClientUtil.getStringClient(ClientURL.GET_USER_INFO, params);
            List<UserInfo> userInfo = JsonUtil.jsonToList(returnStr, "list", UserInfo.class);
            return userInfo.size() > 0 ? userInfo.get(0) : null;
        }
        return null;
    }
}
