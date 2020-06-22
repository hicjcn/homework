package com.demo.entity.vo;

import com.demo.entity.BuyDO;
import com.demo.entity.SaleDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BuyVO extends BuyDO {

    /**
     * 商品名称
     */
    private String wareName;

    /**
     * 采购员姓名
     */
    private String buyPersonName;

}
