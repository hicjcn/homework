package com.demo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *

 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("SALE")
public class SaleDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 销售单号
     */
    @TableId("SaleID")
    private String SaleID;

    /**
     * 价格
     */
    @TableField("SalePrice")
    private BigDecimal SalePrice;

    /**
     * 数量
     */
    @TableField("SaleQuantity")
    private Integer SaleQuantity;

    /**
     * 销售日期
     */
    @TableField("SaleDate")
    private LocalDateTime SaleDate;

    /**
     * 商品编码
     */
    @TableField("WareID")
    private String WareID;


}
