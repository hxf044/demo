package com.hxf.demo.demo.codegen.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 实体映射超类
 *
 * @author yewenting2013@foxmail.com
 * @date 2019年03月06日 11:56
 */
@Data
@ToString(callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
public class BaseEntity implements Serializable {

  private static final long serialVersionUID = 6138365674309673092L;
  /**
   * 主键ID
   */
    @TableId(type = IdType.AUTO)
  protected Long id;
  /**
   * 创建时间
   */
  @TableField(fill = FieldFill.INSERT)
  protected LocalDateTime createTime;
  /**
   * 修改时间
   */
  @TableField(fill = FieldFill.INSERT_UPDATE)
  protected LocalDateTime updateTime;

  /**
   * 删除标识：0-未删除(FALSE)，1-已删除(TRUE)
   */
  @TableLogic
  @TableField(fill = FieldFill.INSERT)
  protected Boolean deleted;

}
