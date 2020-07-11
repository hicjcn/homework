package com.demo.core.db.entity.VO;

import lombok.Data;

@Data
public class HomeworkForStuVO extends HomeworkVO {

    /**
     * 教师名称
     */
    private String teacherName;

    /**
     * 作业完成状态
     */
    private Integer hStatus;

}
