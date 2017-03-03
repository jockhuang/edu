package cn.chineseall.book.controller.manage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.controller.BaseController;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.JsonUtil;
import cn.chineseall.utils.PageUtil;
import cn.chineseall.utils.RequestUtil;

@Controller
@RequestMapping("/manage/orgbook")
public class BookShopCartController extends BaseController {
    
    /**
     * 展示购物车列表
     * 
     * @param bookQueryVo
     * @param request
     * @return
     * @throws Exception 
     */
    @RequestMapping("/listShopCart")
    public ModelAndView listShopCart(Integer pageSize, Integer currentPage,HttpServletRequest request) throws Exception {
        pageSize = pageSize == null?10:pageSize;
        currentPage = currentPage == null?1:currentPage;
        Map<String, Object> prameters = new HashMap<String, Object>();
        prameters.put("pageSize", pageSize);
        prameters.put("currentPage", currentPage);
        prameters.put("orgTreeId", orgTreeId);
        String resultStr = ClientUtil.getStringClient(ClientURL.LIST_SHOPCART, prameters);
        Integer totalCount = JsonUtil.getInt(resultStr, "totalCount");
        List<HashMap> data = JsonUtil.jsonToList(resultStr, "data", HashMap.class);
        //机构积分
        Long leftPoint = JsonUtil.getLong(resultStr, "leftPoint");
        //所需积分
        Long needPoint = JsonUtil.getLong(resultStr, "totalPoint");
        PageUtil pageUtil = new PageUtil(data,totalCount,pageSize, currentPage);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/manage/orgbook/listShopCart");
        mav.getModelMap().put("pageUtil", pageUtil);
        mav.getModelMap().put("queryCondition", RequestUtil.getQueryCondition(request));
        mav.getModelMap().put("leftPoint", leftPoint);
        mav.getModelMap().put("needPoint", needPoint);
        return mav;        
    }
    
    /**
     * 添加图书到购物车
     * 
     * @param bookIds
     * @return
     * @throws Exception
     */
    @RequestMapping("addToShopCart")
    public String addToShopCart(Long[] bookIds, HttpServletRequest request) throws Exception{
        Long orgTreeId = getOrgTreeId(request);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, Object> prameters = new HashMap<String, Object>();
        prameters.put("orgTreeId", orgTreeId);
        prameters.put("bookIds", bookIds);
        ClientUtil.getStringClient(ClientURL.ADD_BOOK_TO_SHOP_CART, prameters);
        return "redirect:/manage/orgbook/listShopCart.action";
    }
    
    /**
     * 从购物车删除图书
     * 
     * @param bookIds
     * @return
     * @throws Exception
     */
    @RequestMapping("deleteBookFromCart")
    public String  deleteBookFromCart(Long[] bookIds, HttpServletRequest request) throws Exception{
        Long orgTreeId = getOrgTreeId(request);
        Map<String, Object> prameters = new HashMap<String, Object>();
        prameters.put("orgTreeId", orgTreeId);
        prameters.put("bookIds", bookIds);
        ClientUtil.getStringClient(ClientURL.DELETE_BOOK_FROM_SHOP_CART, prameters);
        return "redirect:/manage/orgbook/listShopCart.action";        
    }
    
    /**
     * 采购购物车中的图书
     * 
     * @param bookIds
     * @return
     * @throws Exception
     */
    @RequestMapping("buyBookInCart")
    public ModelAndView  buyBookInCart(HttpServletRequest request) throws Exception{
    	ModelAndView mav = new ModelAndView();
        Map<String, Object> prameters = new HashMap<String, Object>();
        prameters.put("orgTreeId", orgTreeId);
        String resultStr = ClientUtil.getStringClient(ClientURL.BUY_BOOK_IN_SHOP_CART, prameters);
        Integer result = JsonUtil.getInt(resultStr, "result");
        if(result==0){
        	//成功增加100本图书，另外的50本已经有了，不需要再次购买。
        	mav.getModelMap().put("msg", "成功增加"+JsonUtil.getInt(resultStr, "succeed")+"本图书，另外的"+JsonUtil.getInt(resultStr, "lose")+"本已经有了，不需要再次购买。");
        }else{
        	mav.getModelMap().put("msg", "积分不够！");
        }
        mav.setViewName("redirect:/manage/orgbook/listShopCart.action");
        return mav;        
    }
}
