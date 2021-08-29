package com.chuang.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chuang.entity.Goods;
import com.chuang.entity.GoodsPic;
import com.chuang.entity.ResultEntity;
import com.chuang.mapper.GoodsMapper;
import com.chuang.service.IGoodsService;
import org.bouncycastle.jcajce.provider.symmetric.AES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: Shop-Server
 * @description: controller
 * @author: chuang
 * @create: 2021-06-11 10:14
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IGoodsService iGoodsService;

    @RequestMapping("/addGoods")
    public ResultEntity addGoods(@RequestBody Goods goods){//@RequestBody Goods goods
//        //1 添加商品信息
//        boolean insert = iGoodsService.insert(goods);
//        Integer id = goods.getId(); //mybatice plus 主键回填
        /* 为了提高性能，忽略以上代码。 */
//        Goods goods = new Goods();
//        goods.setGname("兵线2");
//        goods.setGdesc("这趟兵线包含炮车与超级兵");
//        goods.setGtype(22);
//        goods.setTempPng("f.png|d.png|e.png");
//        goods.setGprice(new BigDecimal(8999));

        String tempPng = goods.getTempPng();
        //拆解图片 根据|拆解 为数组
        String[] split = tempPng.split("\\|");  //不加\\会被当成正则 无法判断
        //创建一个LIst 并把便利创建的图片对象传送给 List 进行插入数据库
        ArrayList<GoodsPic> goodsList = new ArrayList<>();
        for(int i=0;i<split.length;i++){
            GoodsPic goodsPic = new GoodsPic();
            goodsPic.setPng(split[i]);
            goodsPic.setGid(goods.getId());
            goodsList.add(goodsPic);
        }
        //便利后 将获取的ArrayList 传送给Goods 对象里
        goods.setGoodsPicList(goodsList);

        System.out.println(goods);
        boolean b = iGoodsService.addGoods(goods);
        return ResultEntity.ResponseClient(b);
    }

    @RequestMapping("/getGoodsPage")
    public IPage<Goods> getGoodsPage(@RequestBody Page<Goods> page){
        //这里存在需要显示商品与图片id相等的商品，但是有些商品没有图片，所以需要左连接，由于该商品sql为自定义因此分页需要自主控制。
        //获取所有商品
//        page=new Page<Goods>(1,5);
        IPage<Goods> page1 = iGoodsService.page(page, null);
        List<Goods> records = page1.getRecords();
        //取得物品id 然后通过该id进行查找对应商品图，并填充回pic_list
        for (Goods record: records){
            Integer id = record.getId();
            List<GoodsPic> goodsPicList = iGoodsService.selectPicById(id);
            System.out.println(goodsPicList);
            record.setGoodsPicList(goodsPicList);

        }


        return page1;

    }
    @RequestMapping("/getGoodById/{id}")
    public Goods getGoodById(@PathVariable Integer id){
        return iGoodsService.getById(id);
    }
    @RequestMapping("/updateGoods")
    public ResultEntity updateGoods (@RequestBody Goods goods){
        return ResultEntity.ResponseClient(iGoodsService.updateById(goods));
    }
    @RequestMapping("/deleteGoods/{id}")
    public ResultEntity deletGoodsById(@PathVariable Integer id){
        return ResultEntity.ResponseClient(iGoodsService.removeById(id));
    }
    @RequestMapping("/test/{id}")
    public List<GoodsPic> testById(@PathVariable Integer id){
        return iGoodsService.selectPicById(id);
    }


}
