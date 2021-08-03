package com.example.fruit_show.service.impl;

import com.example.fruit_show.entity.Fruit;
import com.example.fruit_show.mapper.FruitMapper;
import com.example.fruit_show.service.FruitService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fruit_show.util.DataUtil;
import com.example.fruit_show.vo.BarVO;
import com.example.fruit_show.vo.DataVo;
import com.example.fruit_show.vo.PieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2021-08-03
 */
@Service
public class FruitServiceImpl extends ServiceImpl<FruitMapper, Fruit> implements FruitService {

    @Autowired
    private FruitMapper fruitMapper;

    @Override
    public List<PieVO> pieVOList() {
        List<PieVO> pievo_list = new ArrayList<>();
        List<Fruit> fruits = this.fruitMapper.selectList(null);
        for(Fruit fruit : fruits) {
            PieVO pievo = new PieVO();
            pievo.setName(fruit.getName());
            pievo.setValue(fruit.getSale());
            pievo.setItemStyle(DataUtil.createItemStyle(fruit.getSale()));
            pievo_list.add(pievo);
        }
        return pievo_list;
    }

    @Override
    public BarVO barVOList() {
        BarVO barVO = new BarVO();
        List<String> names = new ArrayList<>();
        List<DataVo> values = new ArrayList<>();
        List<Fruit> fruits = this.fruitMapper.selectList(null);
        for(Fruit fruit : fruits) {
            names.add(fruit.getName());
            DataVo datavo = new DataVo();
            datavo.setValue(fruit.getSale());
            datavo.setItemStyle(DataUtil.createItemStyle(fruit.getSale()));
            values.add(datavo);
        }
        barVO.setNames(names);
        barVO.setValues(values);
    return barVO;
    }
}
