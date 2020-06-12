package com.demo.stu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("course")
public class CourseDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 课程名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 教师号
     */
    private String teacherId;


}
