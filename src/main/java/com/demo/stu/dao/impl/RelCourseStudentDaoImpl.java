package com.demo.stu.dao.impl;

import com.demo.stu.entity.RelCourseStudentDO;
import com.demo.stu.entity.vo.GradeVO;
import com.demo.stu.mapper.RelCourseStudentDOMapper;
import com.demo.stu.dao.IRelCourseStudentDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
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
public class RelCourseStudentDaoImpl extends ServiceImpl<RelCourseStudentDOMapper, RelCourseStudentDO> implements IRelCourseStudentDao {

    /**
     * 获取学生的成绩
     *
     * @param courseId
     * @return
     */
    @Override
    public List<GradeVO> getStudentGrades(String courseId) {
        if (StringUtils.isEmpty(courseId)) {
            return Lists.newArrayList();
        }
        return this.baseMapper.getStudentGrades(courseId);
    }
}
