package com.raiuny.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

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
@TableName("Users")
@ApiModel(value="Users对象", description="")
public class Users extends Model<Users> {


    @TableField("name")
    private String name;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("age")
    private Integer age;

    @TableField("email")
    private String email;

    @TableField("birthday")
    private LocalDate birthday;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
