package com.demo.mapper;

import com.demo.entity.WareDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 商品登记表 Mapper 接口
 * </p>
 *

 */
public interface WareDOMapper extends BaseMapper<WareDO> {

    int getMaxIdByWareType(String wareType);
}
