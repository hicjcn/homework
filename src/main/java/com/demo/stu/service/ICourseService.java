package com.demo.stu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demo.stu.entity.CourseDO;
import com.demo.stu.entity.TeacherDO;

public interface ICourseService {

    /**
     * 分页列表筛选
     * @param pageNo
     * @param name
     * @return
     */
    IPage<CourseDO> page(Integer pageNo, String name);

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
}
