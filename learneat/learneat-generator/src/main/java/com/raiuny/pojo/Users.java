package com.raiuny.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
    protected Serializable pkVal() {
        return this.id;
    }

}
