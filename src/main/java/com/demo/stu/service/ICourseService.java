package com.demo.stu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demo.stu.entity.CourseDO;
import com.demo.stu.entity.TeacherDO;
import com.demo.stu.entity.vo.CourseVO;

public interface ICourseService {

    /**
     * 分页列表筛选
     * @param pageNo
     * @param name
     * @return
     */
    IPage<CourseVO> page(Integer pageNo, String name);

    /**
     * 保存或更新
     * @param courseDO
     */
    void save(CourseDO courseDO);

    /**
     * 删除
     * @param no
     */
    void delete(String no);

    /**
     * 获取课程信息
     * @param courseId
     * @return
     */
    CourseVO getCourseVO(String courseId);
}
