package com.demo.entity.vo;

import com.demo.entity.StaffDO;
import lombok.Data;

@Data
public class StaffVO extends StaffDO {

    /**
     * 1 结账区
     * 2 上货区
     * 3 熟食区
     */
    public int jobType;
}
