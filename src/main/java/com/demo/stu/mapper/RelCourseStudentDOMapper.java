package com.demo.stu.mapper;

import com.demo.stu.entity.RelCourseStudentDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.stu.entity.vo.GradeVO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-06-02
 */
public interface RelCourseStudentDOMapper extends BaseMapper<RelCourseStudentDO> {

    /**
     * 获取学生的成绩
     * @param courseId
     * @return
     */
    List<GradeVO> getStudentGrades(String courseId);
}
