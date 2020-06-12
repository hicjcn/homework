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
@TableName("rel_course_teacher")
public class RelCourseTeacherDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId
    private String id;

    /**
     * 课程号
     */
    private Integer courseId;

    /**
     * 教师号
     */
    private Integer teacherId;


}
