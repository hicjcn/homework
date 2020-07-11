package com.demo.core.db.service.impl;

import com.demo.core.db.entity.HomeworkStudentDO;
import com.demo.core.db.mapper.HomeworkStudentDOMapper;
import com.demo.core.db.service.IHomeworkStudentDao;
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
public class HomeworkStudentDaoImpl extends ServiceImpl<HomeworkStudentDOMapper, HomeworkStudentDO> implements IHomeworkStudentDao {

    @Override
    public void submitHomework(HomeworkStudentDO homeworkStudentDO) {

    }
}
