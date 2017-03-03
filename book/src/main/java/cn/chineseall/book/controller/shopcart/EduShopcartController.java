package cn.chineseall.book.controller.shopcart;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.controller.BaseController;
import cn.chineseall.model.eduyun.EduShopCart;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.ImageUtils;
import cn.chineseall.utils.JsonUtil;

@Controller
@RequestMapping("/edushopcart/")
public class EduShopcartController extends BaseController {

    @RequestMapping("/listShopCart")
    public ModelAndView listShopCart(HttpServletRequest request) throws Exception {
        //获取当前用户
        Long userId = getLoginUserId(request);
        //获取当前用户购物车条目列表
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("userId", userId);
        String returnStr = ClientUtil.getStringClient(ClientURL.LIST_SHOP_CART, parameters);
        Integer result = JsonUtil.getInt(returnStr, "result");
        
        ModelAndView mav = new ModelAndView();
        if(result != null && result == 1){
        	Map<String, Object> data = JsonUtil.jsonToObject(returnStr, "data", HashMap.class);
        	mav.getModelMap().put("data", data);
        }
        setStaticModel(ImageUtils.class, request);
        mav.setViewName("/eduyun/shopcart/listShopCart");
        return mav;
    }
    
    @RequestMapping("/addShopCart")
    public String addShopCart(EduShopCart shopCart, HttpServletRequest request,RedirectAttributes redirectAttributes) throws Exception {
        //获取当前用户
        Long userId = getLoginUserId(request);
        shopCart.setCreateTime(new Date());
        shopCart.setUserId(userId);
        //获取当前用户购物车条目列表
        if(shopCart.getBookId() != null || shopCart.getPackageId()!=null){
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("shopCart", shopCart);
            JsonUtil.toJson(parameters);
            String returnStr = ClientUtil.getStringClient(ClientURL.Add_EDUYUN_SHOP_CART, parameters);
            if(returnStr!=null && !"".equals(returnStr.trim())){
            	redirectAttributes.addFlashAttribute("msg", JsonUtil.getString(returnStr, "msg"));
            }
        }else{
            redirectAttributes.addFlashAttribute("msg", "请选择购买条目.");
        }
        return "redirect:/edushopcart/listShopCart.action";
    }
    
    @RequestMapping("/deleteItem")
    public String deleteItem(Integer ids[], HttpServletRequest request) throws Exception {
        //获取当前用户
        Long userId = getLoginUserId(request);
        //获取当前用户购物车条目列表
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("userId", userId);
        parameters.put("itemIds", ids);
        ClientUtil.getStringClient(ClientURL.DETELE_SHOP_CART_ITEMS, parameters);
        return "redirect:/edushopcart/listShopCart.action";
    }
    
}
