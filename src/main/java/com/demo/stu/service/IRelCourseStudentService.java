package com.demo.stu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demo.stu.entity.CourseDO;
import com.demo.stu.entity.vo.CourseVO;
import com.demo.stu.entity.vo.GradeVO;

import java.util.List;

public interface IRelCourseStudentService {

    /**
     * 更新关联关系
     * @param courseId
     * @param studentId
     */
    void rel(String courseId, String[] studentId);


    /**
     * 获取所有关联关系
     * @param courseId
     * @return
     */
    List<String> getRels(String courseId);

    /**
     * 获取学生的成绩
     * @param courseId
     * @return
     */
    List<GradeVO> getStudentGrades(String courseId);

    /**
     * 保存学生课程成绩
     * @param relId
     * @param grade
     */
    boolean saveGrade(String relId, int grade);
}
