package com.demo.stu.dao.impl;

import com.demo.stu.entity.StudentDO;
import com.demo.stu.mapper.StudentDOMapper;
import com.demo.stu.dao.IStudentDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-06-12
 */
@Service
public class StudentDaoImpl extends ServiceImpl<StudentDOMapper, StudentDO> implements IStudentDao {

}
