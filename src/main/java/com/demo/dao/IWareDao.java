package com.demo.dao;

import com.demo.entity.WareDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品登记表 服务类
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-06-22
 */
public interface IWareDao extends IService<WareDO> {

    /**
     * 获取目前商品最大编号
     * @param wareType
     * @return
     */
    int getMaxIdByWareType(int wareType);
}
