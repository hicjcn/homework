package com.demo.stu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demo.stu.entity.StudentDO;
import com.demo.stu.entity.vo.CourseScoreVO;
import com.demo.stu.entity.vo.CourseVO;

import java.util.List;

public interface IStudentService {

    /**
     * 分页列表筛选
     * @param pageNo
     * @param no
     * @param name
     * @param phone
     * @return
     */
    IPage<StudentDO> page(Integer pageNo, String no, String name, String phone);

    /**
     * 保存或更新
     * @param studentDO
     * @return
     */
    boolean save(StudentDO studentDO);

    /**
     * 删除
     * @param no
     */
    void delete(String no);

    /**
     * 获取所有学生信息
     * @return
     */
    List<StudentDO> getStudents();

    /**
     * 根据账号获取学生
     *
     * @param id
     * @return
     */
    StudentDO getStudentById(String id);

    /**
     * 根据学生获取课程成绩列表
     *
     * @param stuNo
     * @return
     */
    List<CourseScoreVO> getCourseScoresByStu(String stuNo);
}
