package com.demo.dao.impl;

import com.demo.entity.SaleDO;
import com.demo.mapper.SaleDOMapper;
import com.demo.dao.ISaleDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *

 */
@Service
public class SaleDaoImpl extends ServiceImpl<SaleDOMapper, SaleDO> implements ISaleDao {

    /**
     * 获取目前最大的流水号
     *
     * @param s
     * @return
     */
    @Override
    public int getMaxIdByPartition(String partition) {
        String key = partition + '%';
        return this.baseMapper.getMaxIdByPartition(key);
    }
}
