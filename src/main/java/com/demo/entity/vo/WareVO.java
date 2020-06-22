package com.demo.entity.vo;

import com.demo.entity.StaffDO;
import com.demo.entity.WareDO;
import lombok.Data;

@Data
public class WareVO extends WareDO {

    /**
     * 10——食品类
     * 20——饮品类
     * 30——熟食类
     * 40——文具类
     * 50——酒类
     * 60——烟类
     * 70——生活用品
     * 80——娱乐用品
     */
    public int wareType;
}
