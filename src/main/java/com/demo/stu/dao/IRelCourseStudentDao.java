package com.demo.stu.dao;

import com.demo.stu.entity.RelCourseStudentDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.stu.entity.vo.GradeVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-06-02
 */
public interface IRelCourseStudentDao extends IService<RelCourseStudentDO> {

    /**
     * 获取学生的成绩
     * @param courseId
     * @return
     */
    List<GradeVO> getStudentGrades(String courseId);
}
