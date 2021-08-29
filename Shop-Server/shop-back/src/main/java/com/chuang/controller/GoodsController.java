package com.chuang.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.chuang.entity.Goods;
import com.chuang.entity.ResultEntity;
import com.chuang.feign.api.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: Shop-Server
 * @description: 商品后台接口
 * @author: chuang
 * @create: 2021-06-13 19:06
 */
@Controller
@RequestMapping("/goodsController")
public class GoodsController {
    @Autowired
    private IGoodsService iGoodsService;
    @RequestMapping("/getGoodsPage")
    public String getGoodsPage (Page<Goods> page, ModelMap modelMap){

        Page<Goods> goodsPage = iGoodsService.getGoodsPage(page);
        modelMap.put("page",goodsPage);
        modelMap.put("url","http://localhost/shop-back/goodsController/getGoodsPage");
        return "goods/goodsList";
    }
    @RequestMapping("/addGoods")
    @ResponseBody
    public ResultEntity addGoods(Goods goods){
        return iGoodsService.addGoods(goods);
    }
}
