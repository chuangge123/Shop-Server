package com.chuang.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chuang.entity.Goods;
import com.chuang.entity.GoodsPic;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: Shop-Server
 * @description: 实现业务类
 * @author: chuang
 * @create: 2021-06-11 10:06
 */

public interface IGoodsService extends IService<Goods> {

    boolean addGoods(Goods goods);  //自定义SQL逻辑

    List<Goods> getGoodsPage();

    List<GoodsPic> selectPicById(Integer id);

}
