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
 * 商品登记表
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-06-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("WARE")
public class WareDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品编号
     */
    @TableId("WareID")
    private String WareID;

    /**
     * 商品名称
     */
    @TableField("WareName")
    private String WareName;

    /**
     * 价格
     */
    @TableField("WarePrice")
    private BigDecimal WarePrice;


}
