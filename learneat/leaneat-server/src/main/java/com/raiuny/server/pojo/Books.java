package com.raiuny.server.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zy
 * @since 2021-08-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("Books")
@ApiModel(value="Books对象", description="")
public class Books extends Model<Books> {


    @TableId("pid")
    private Integer pid;

    @TableField("name")
    private String name;

    @TableField("author")
    private String author;

    @TableField("price")
    private Integer price;

    @TableField("occupy")
    private Boolean occupy;


    @Override
    public Serializable pkVal() {
        return this.pid;
    }

}
