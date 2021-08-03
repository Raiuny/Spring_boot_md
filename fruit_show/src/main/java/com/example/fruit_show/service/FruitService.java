package com.example.fruit_show.service;

import com.example.fruit_show.entity.Fruit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fruit_show.vo.BarVO;
import com.example.fruit_show.vo.PieVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2021-08-03
 */
public interface FruitService extends IService<Fruit> {
public BarVO barVOList();
public List<PieVO> pieVOList();
}
