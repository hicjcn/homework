package com.demo.stu.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-06-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("teacher")
public class TeacherDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId
    private String id;

    /**
     * 教工号
     */
    private String no;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别1男0女
     */
    private Integer sex;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;


}
