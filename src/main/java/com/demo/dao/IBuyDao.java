package com.demo.dao;

import com.demo.entity.BuyDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *

 */
public interface IBuyDao extends IService<BuyDO> {

    /**
     * 获取分区最大流水号
     * @param partition
     * @return
     */
    int getMaxIdByPartition(String partition);
}
