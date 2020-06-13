package com.demo.stu.dao;

import com.demo.stu.entity.StudentDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.stu.entity.vo.CourseScoreVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-06-02
 */
public interface IStudentDao extends IService<StudentDO> {

    /**
     * 根据学生获取课程成绩列表
     *
     * @param stuNo
     * @return
     */
    List<CourseScoreVO> getCourseScoresByStu(String stuNo);

}
