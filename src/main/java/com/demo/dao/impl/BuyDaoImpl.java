package com.demo.dao.impl;

import com.demo.entity.BuyDO;
import com.demo.mapper.BuyDOMapper;
import com.demo.dao.IBuyDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *

 */
@Service
public class BuyDaoImpl extends ServiceImpl<BuyDOMapper, BuyDO> implements IBuyDao {

    /**
     * 获取分区最大流水号
     *
     * @param partition
     * @return
     */
    @Override
    public int getMaxIdByPartition(String partition) {
        String key = partition + "%";
        return this.baseMapper.getMaxIdByPartition(key);
    }
}
