package com.demo.core.db.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@TableName("homework_student")
public class HomeworkStudentDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "hs_id", type = IdType.AUTO)
    private Integer hsId;

    /**
     * 学生编码
     */
    private String studentCode;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 作业ID
     */
    private Integer hId;

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
