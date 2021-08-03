package com.example.fruit_show.controller;


import com.example.fruit_show.entity.Fruit;
import com.example.fruit_show.service.FruitService;
import com.example.fruit_show.vo.BarVO;
import com.example.fruit_show.vo.PieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2021-08-03
 */
@RestController
@RequestMapping("//fruit")
public class FruitController {
    @Autowired
    private FruitService fruitService;

    @GetMapping("/list")
    public List<Fruit> list() {
        return this.fruitService.list();
    }

    @DeleteMapping("/{id}")
    public boolean removeById(@PathVariable("id") Integer id) {
        return this.fruitService.removeById(id);
    }

    @GetMapping("/{id}")
    public Fruit getById(@PathVariable("id") Integer id) {
        return this.fruitService.getById(id);
    }
    @PutMapping("/update")
    public boolean update(@RequestBody Fruit fruit) {
        return this.fruitService.updateById(fruit);
    }
    @PostMapping  //restful格式
    public boolean save(@RequestBody Fruit fruit) { //接收传入的json数据，转化为Fruit对象
        return this.fruitService.save(fruit);
    }

    @GetMapping("/bar")
    public BarVO barVo() {
        return this.fruitService.barVOList();
    }

    @GetMapping("/pie")
    public List<PieVO> pieVO() {
        return this.fruitService.pieVOList();
    }
}

