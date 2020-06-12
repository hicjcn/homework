package com.demo.stu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demo.stu.entity.StudentDO;
import com.demo.stu.entity.TeacherDO;

import java.util.List;

public interface ITeacherService {

    /**
     * 分页列表筛选
     * @param pageNo
     * @param no
     * @param name
     * @param phone
     * @return
     */
    IPage<TeacherDO> page(Integer pageNo, String no, String name, String phone);

    /**
     * 保存或更新
     * @param teacherDO
     */
    void save(TeacherDO teacherDO);

    /**
     * 删除
     * @param no
     */
    void delete(String no);

    /**
     * 列出所有教师
     * @return
     */
    List<TeacherDO> list();
}
