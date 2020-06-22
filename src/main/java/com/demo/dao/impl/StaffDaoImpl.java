package com.demo.dao.impl;

import com.demo.entity.StaffDO;
import com.demo.mapper.StaffDOMapper;
import com.demo.dao.IStaffDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工登记表 服务实现类
 * </p>
 *

 */
@Service
public class StaffDaoImpl extends ServiceImpl<StaffDOMapper, StaffDO> implements IStaffDao {

    @Override
    public int getMaxIdByJobType(int jobType) {
        // '01%' like条件
        String key = "0" + jobType + "%";
        return this.baseMapper.getMaxIdByJobType(key);
    }
}
