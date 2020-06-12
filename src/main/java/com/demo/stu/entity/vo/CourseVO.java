package com.demo.stu.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.demo.stu.entity.CourseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 *
 * @author MybatisPlus
 * @since 2020-06-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CourseVO extends CourseDO {


    /**
     * 教师名称
     */
    private String teacher;

}
