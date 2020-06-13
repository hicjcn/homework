package com.demo.stu.entity.vo;

import lombok.Data;

@Data
public class CourseScoreVO {

    /**
     * 教师名称
     */
    private String teacher;

    /**
     * 课程
     */
    private String course;

    /**
     * 成绩
     */
    private Integer score;
}
