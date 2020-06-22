package com.demo.mapper;

import com.demo.entity.BuyDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *

 */
public interface BuyDOMapper extends BaseMapper<BuyDO> {

    int getMaxIdByPartition(String partition);
}
