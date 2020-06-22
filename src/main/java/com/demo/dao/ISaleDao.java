package com.demo.dao;

import com.demo.entity.SaleDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *

 */
public interface ISaleDao extends IService<SaleDO> {

    /**
     * 获取目前最大的流水号
     * @param s
     * @return
     */
    int getMaxIdByPartition(String s);
}
