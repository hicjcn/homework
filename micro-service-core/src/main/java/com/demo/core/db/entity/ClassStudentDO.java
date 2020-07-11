package com.demo.core.db.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-07-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("class_student")
public class ClassStudentDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 关联ID
     */
    private Integer csId;

    /**
     * 班级ID
     */
    private Integer classId;

    /**
     * 学生ID
     */
    private String studentCode;

    /**
     * 状态（0通过，1审核中，2驳回）
     */
    private Integer status;

    /**
     * 教师ID
     */
    private String teacherCode;


}
