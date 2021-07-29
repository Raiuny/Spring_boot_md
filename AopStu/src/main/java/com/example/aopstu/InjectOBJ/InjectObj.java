package com.example.aopstu.InjectOBJ;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "obj")
public class InjectObj {
    private String name;
    private Integer age;
    private Boolean sex;
    private String[] arrays;
    private List<String> likes;
    private Map<String, String> maps;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "InjectObj{" +
                "likes=" + likes +
                '}';
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Boolean getSex() {
        return sex;
    }

    public String[] getArrays() {
        return arrays;
    }

    public List<String> getLikes() {
        return likes;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public void setArrays(String[] arrays) {
        this.arrays = arrays;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }
}
