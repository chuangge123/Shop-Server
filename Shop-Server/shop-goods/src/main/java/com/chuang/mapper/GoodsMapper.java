package com.chuang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chuang.entity.Goods;
import com.chuang.entity.GoodsPic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * @program: Shop-Server
 * @description: mapper
 * @author: chuang
 * @create: 2021-06-11 10:01
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

    int addGoods(Goods goods);

    List<Goods> getGoodsPage();

    List<GoodsPic> selectPicById(Integer id);

}
