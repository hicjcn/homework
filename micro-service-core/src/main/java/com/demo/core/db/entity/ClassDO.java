package com.demo.core.db.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("class")
public class ClassDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程ID
     */
    @TableId(value = "class_id", type = IdType.AUTO)
    private Integer classId;

    /**
     * 课程名
     */
    private String className;

    /**
     * 教师编码
     */
    private String teacherCode;

    /**
     * 教师姓名
     */
    private String teacherName;

    /**
     * 描述
     */
    private String classDescribe;


}
