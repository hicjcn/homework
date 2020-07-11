package com.demo.core.db.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

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
@TableName("homework")
public class HomeworkDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 作业ID
     */
    @TableId(value = "h_id", type = IdType.AUTO)
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
     * 教师ID
     */
    private String teacherCode;

    /**
     * 文件名
     */
    private String fileName;


}
