package com.chuang.shopgoods;

import com.chuang.entity.Goods;
import com.chuang.entity.GoodsPic;
import com.chuang.service.IGoodsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @program: Shop-Server
 * @description: 测试类
 * @author: chuang
 * @create: 2021-06-19 13:01
 */
@SpringBootTest
public class ShopGoodsApplicationTest {
    @Autowired
    private IGoodsService iGoodsService2;
    @Test
    public void testone(){
        Goods goods = new Goods();
        goods.setGname("兵线");
        goods.setGdesc("这趟兵线包含炮车与超级兵");
        goods.setGtype(22);
        goods.setTempPng("a.png|b.png|c.png");
        goods.setGprice(new BigDecimal(8999));

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
        boolean b = iGoodsService2.addGoods(goods);
        System.out.println(b);
    }
}
