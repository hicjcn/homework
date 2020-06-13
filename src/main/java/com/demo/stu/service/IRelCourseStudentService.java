package com.demo.stu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demo.stu.entity.CourseDO;
import com.demo.stu.entity.vo.CourseVO;

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
}
