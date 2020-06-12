package com.demo.stu.dao.impl;

import com.demo.stu.entity.TeacherDO;
import com.demo.stu.mapper.TeacherDOMapper;
import com.demo.stu.dao.ITeacherDao;
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
public class TeacherDaoImpl extends ServiceImpl<TeacherDOMapper, TeacherDO> implements ITeacherDao {

}
