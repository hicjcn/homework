package com.demo.core.db.service.impl;

import com.demo.core.db.entity.HomeworkDO;
import com.demo.core.db.mapper.HomeworkDOMapper;
import com.demo.core.db.service.IHomeworkDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-07-11
 */
@Service
public class HomeworkDaoImpl extends ServiceImpl<HomeworkDOMapper, HomeworkDO> implements IHomeworkDao {

}
