package com.demo.dao;

import com.demo.entity.StaffDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 员工登记表 服务类
 * </p>
 *

 */
public interface IStaffDao extends IService<StaffDO> {

    int getMaxIdByJobType(int jobType);
}
