package com.demo.core.db.entity.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class HomeworkVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 作业ID
     */
    private Integer hId;

    /**
     * 作业主题
     */
    private String hTopic;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 截至时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deadline;

    /**
     * 班级ID
     */
    private Integer classId;

    /**
     * 班级名称
     */
    private Integer className;

    /**
     * 教师ID
     */
    private String teacherCode;

    /**
     * 文件名
     */
    private String fileName;

}
