package com.demo.mapper;

import com.demo.entity.StaffDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 员工登记表 Mapper 接口
 * </p>
 *

 */
public interface StaffDOMapper extends BaseMapper<StaffDO> {

    int getMaxIdByJobType(String jobType);
}
