package com.demo.entity.vo;

import com.demo.entity.SaleDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SaleVO extends SaleDO {

    /**
     * 商品名称
     */
    private String wareName;

}
