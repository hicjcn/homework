package com.demo.stu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.stu.dao.ICourseDao;
import com.demo.stu.dao.ITeacherDao;
import com.demo.stu.entity.CourseDO;
import com.demo.stu.entity.TeacherDO;
import com.demo.stu.service.ICourseService;
import com.demo.stu.service.ITeacherService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CourseService implements ICourseService {

    @Resource
    private ICourseDao courseDao;

    /**
     * 分页列表筛选
     * @param pageNo
     * @param name
     * @return
     */
    @Override
    public IPage<CourseDO> page(Integer pageNo, String name) {
        QueryWrapper<CourseDO> queryWrapper = new QueryWrapper<>();
        // 模糊搜索name
        if (StringUtils.isNotEmpty(name)) {
            queryWrapper.lambda().like(CourseDO::getName, name);
        }

        IPage<CourseDO> page = new Page<>();
        if (null != pageNo) {
            page.setCurrent(pageNo);
        } else {
            page.setCurrent(1);
        }
        // 每页10条数据
        page.setSize(10);

        return courseDao.page(page, queryWrapper);
    }

    @Override
    public void save(CourseDO courseDO) {
        courseDao.saveOrUpdate(courseDO);
    }

    /**
     * 删除
     *
     * @param no
     */
    @Override
    public void delete(String no) {
        courseDao.removeById(no);
    }
}
