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
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("rel_course_student")
public class RelCourseStudentDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(type = IdType.AUTO)
    private String id;

    /**
     * 课程号
     */
    private Integer courseId;

    /**
     * 学生号
     */
    private String studentNo;

    /**
     * 分数
     */
    private Integer grade;


}
