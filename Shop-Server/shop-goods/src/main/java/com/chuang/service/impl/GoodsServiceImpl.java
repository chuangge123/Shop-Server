package com.chuang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chuang.entity.Goods;
import com.chuang.entity.GoodsPic;
import com.chuang.mapper.GoodsMapper;
import com.chuang.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: Shop-Server
 * @description: 实现业务类
 * @author: chuang
 * @create: 2021-06-11 10:10
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {
    //引入mapper

    @Override
    public boolean addGoods(Goods goods) {
       return baseMapper.addGoods(goods)>0;

    }

    @Override
    public List<Goods> getGoodsPage() {
        return baseMapper.getGoodsPage();
    }

    @Override
    public List<GoodsPic> selectPicById(Integer id) {
        return baseMapper.selectPicById(id);
    }
}
