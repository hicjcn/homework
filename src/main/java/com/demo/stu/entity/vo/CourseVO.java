package com.demo.stu.entity.vo;

import com.demo.stu.entity.CourseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author MybatisPlus
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CourseVO extends CourseDO {


    /**
     * 教师名称
     */
    private String teacher;

}
