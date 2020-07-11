package com.demo.core.db.entity.VO;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClassStudentVO implements Serializable {

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
     * 学生名
     */
    private String studentName;

    /**
     * 状态（0通过，1审核中，2驳回）
     */
    private Integer status;

}
