package com.example.fruit_show.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2021-08-03
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Fruit implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 编号
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 名称
     */
      private String name;

      /**
     * 销量
     */
      private Integer sale;

      /**
     * 图片url
     */
      private String icon;


}
