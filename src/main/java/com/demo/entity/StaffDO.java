package com.demo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 员工登记表
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-06-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("STAFF")
public class StaffDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
    @TableId("StaffID")
    private String StaffID;

    /**
     * 姓名
     */
    @TableField("StaffName")
    private String StaffName;

    /**
     * 性别1男 0女
     */
    @TableField("StaffSex")
    private Integer StaffSex;

    /**
     * 身份证号
     */
    @TableField("IDNumber")
    private String IDNumber;

    /**
     * 工资
     */
    @TableField("Wage")
    private BigDecimal Wage;

    /**
     * 员工类型
     */
    @TableField("StaffType")
    private Integer StaffType;

    /**
     * 密码
     */
    @TableField("Password")
    private String Password;


}
