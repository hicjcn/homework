package com.demo.dao.impl;

import com.demo.entity.WareDO;
import com.demo.mapper.WareDOMapper;
import com.demo.dao.IWareDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品登记表 服务实现类
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-06-22
 */
@Service
public class WareDaoImpl extends ServiceImpl<WareDOMapper, WareDO> implements IWareDao {

}
