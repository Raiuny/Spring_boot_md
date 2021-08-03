package com.example.fruit_show.vo;

import lombok.Data;

import java.util.List;

@Data
public class BarVO { //viewobject
    private List<String> names;
    private  List<DataVo> values;
}
