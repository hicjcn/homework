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
@TableName("BUY")
public class BuyDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 入库单号
     */
    @TableId("BuyID")
    private String BuyID;

    /**
     * 价格
     */
    @TableField("Price")
    private BigDecimal Price;

    /**
     * 数量
     */
    @TableField("Quantity")
    private Integer Quantity;

    /**
     * 入库日期
     */
    @TableField("BuyDate")
    private LocalDateTime BuyDate;

    /**
     * 商品编码
     */
    @TableField("WareID")
    private String WareID;

    /**
     * 购买员工
     */
    @TableField("BuyPerson")
    private String BuyPerson;


}
