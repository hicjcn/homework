package com.demo.stu.dao.impl;

import com.demo.stu.entity.StudentDO;
import com.demo.stu.entity.vo.CourseScoreVO;
import com.demo.stu.mapper.StudentDOMapper;
import com.demo.stu.dao.IStudentDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-06-02
 */
@Service
public class StudentDaoImpl extends ServiceImpl<StudentDOMapper, StudentDO> implements IStudentDao {

    @Override
    public List<CourseScoreVO> getCourseScoresByStu(String stuNo) {
        return this.baseMapper.getCourseScoresByStu(stuNo);
    }

}
