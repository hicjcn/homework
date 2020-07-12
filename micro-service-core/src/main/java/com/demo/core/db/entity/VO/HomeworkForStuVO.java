package com.demo.core.db.entity.VO;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
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

    /**
     * 提交时间
     */
    private LocalDateTime submitTime;

    /**
     * 得分
     */
    private Float grade;

    /**
     * 文件名
     */
    private String hsFileName;

    /**
     * 作业描述
     */
    private String hsDescribe;

}
