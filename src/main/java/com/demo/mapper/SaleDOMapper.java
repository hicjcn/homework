package com.demo.mapper;

import com.demo.entity.SaleDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *

 */
public interface SaleDOMapper extends BaseMapper<SaleDO> {

    int getMaxIdByPartition(String partition);
}
