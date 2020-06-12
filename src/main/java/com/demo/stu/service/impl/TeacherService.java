package com.demo.stu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.stu.dao.IStudentDao;
import com.demo.stu.dao.ITeacherDao;
import com.demo.stu.entity.StudentDO;
import com.demo.stu.entity.TeacherDO;
import com.demo.stu.service.IStudentService;
import com.demo.stu.service.ITeacherService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherService implements ITeacherService {

    @Resource
    private ITeacherDao teacherDao;

    @Value("${stu.config.default.password}")
    private String defaultPassword;

    /**
     * 分页列表筛选
     * @param pageNo
     * @param no
     * @param name
     * @param phone
     * @return
     */
    @Override
    public IPage<TeacherDO> page(Integer pageNo, String no, String name, String phone) {
        QueryWrapper<TeacherDO> queryWrapper = new QueryWrapper<>();
        // 模糊搜索no
        if (StringUtils.isNotEmpty(no)) {
            queryWrapper.lambda().eq(TeacherDO::getNo, no);
        }
        // 模糊搜索name
        if (StringUtils.isNotEmpty(name)) {
            queryWrapper.lambda().like(TeacherDO::getName, name);
        }
        // 搜索phone
        if (StringUtils.isNotEmpty(phone)) {
            queryWrapper.lambda().eq(TeacherDO::getPhone, phone);
        }

        IPage<TeacherDO> page = new Page<>();
        if (null != pageNo) {
            page.setCurrent(pageNo);
        } else {
            page.setCurrent(1);
        }
        // 每页10条数据
        page.setSize(10);

        return teacherDao.page(page, queryWrapper);
    }

    @Override
    public void save(TeacherDO teacherDO) {

        // 查找是否存在该教工号 补充密码
        TeacherDO teacherDOById = teacherDao.getById(teacherDO.getNo());
        if (null != teacherDOById) {
            teacherDO.setPassword(teacherDOById.getPassword());
        }

        if (StringUtils.isEmpty(teacherDO.getPassword())) {
            teacherDO.setPassword(defaultPassword);
        }
        teacherDao.saveOrUpdate(teacherDO);
    }

    /**
     * 删除
     *
     * @param no
     */
    @Override
    public void delete(String no) {
        teacherDao.removeById(no);
    }

    /**
     * 列出所有教师
     *
     * @return
     */
    @Override
    public List<TeacherDO> list() {
        return teacherDao.list();
    }
}
