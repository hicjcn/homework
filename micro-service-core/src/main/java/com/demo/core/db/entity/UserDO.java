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
@TableName("user")
public class UserDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编码（登录用）
     */
    private String userCode;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户类型（1老师，2学生）
     */
    private Integer userType;


}
