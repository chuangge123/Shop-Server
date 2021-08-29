package com.chuang.feign.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chuang.entity.Goods;
import com.chuang.entity.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: Shop-Server
 * @description: goodsfeign
 * @author: chuang
 * @create: 2021-06-13 19:00
 */
@FeignClient("shop-goods")
public interface IGoodsService {
    @RequestMapping("/goods/addGoods")
    public ResultEntity addGoods(@RequestBody Goods goods);
    @RequestMapping("/goods/getGoodsPage")
    public Page<Goods> getGoodsPage(Page<Goods> page);
    @RequestMapping("/goods/getGoodById/{id}")
    public Goods getGoodById(@PathVariable Integer id);
    @RequestMapping("/goods/updateGoods")
    public ResultEntity updateGoods (@RequestBody Goods goods);
    @RequestMapping("/goods/deleteGoods/{id}")
    public ResultEntity deletGoodsById(@PathVariable Integer id);

}
