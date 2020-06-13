package com.demo.stu.entity.vo;

import com.demo.stu.entity.CourseDO;
import com.demo.stu.entity.RelCourseStudentDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author MybatisPlus
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GradeVO extends RelCourseStudentDO {


    /**
     * 学生名称
     */
    private String student;

}
