package com.demo.stu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.stu.dao.IStudentDao;
import com.demo.stu.entity.StudentDO;
import com.demo.stu.entity.enumcode.UserType;
import com.demo.stu.entity.vo.CourseScoreVO;
import com.demo.stu.service.IStudentService;
import com.demo.stu.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Resource
    private IStudentDao studentDao;

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
    public IPage<StudentDO> page(Integer pageNo, String no, String name, String phone) {
        QueryWrapper<StudentDO> queryWrapper = new QueryWrapper<>();
        // 模糊搜索no
        if (StringUtils.isNotEmpty(no)) {
            queryWrapper.lambda().eq(StudentDO::getNo, no);
        }
        // 模糊搜索name
        if (StringUtils.isNotEmpty(name)) {
            queryWrapper.lambda().like(StudentDO::getName, name);
        }
        // 搜索phone
        if (StringUtils.isNotEmpty(phone)) {
            queryWrapper.lambda().eq(StudentDO::getPhone, phone);
        }

        IPage<StudentDO> page = new Page<>();
        if (null != pageNo) {
            page.setCurrent(pageNo);
        } else {
            page.setCurrent(1);
        }
        // 每页10条数据
        page.setSize(10);

        return studentDao.page(page, queryWrapper);
    }

    @Override
    public boolean save(StudentDO studentDO) {

        // 查找是否存在该学号 补充密码
        StudentDO studentDOByDb = studentDao.getById(studentDO.getNo());
        if (null != studentDOByDb) {
            studentDO.setPassword(studentDOByDb.getPassword());
        }

        if (StringUtils.isEmpty(studentDO.getPassword())) {
            studentDO.setPassword(defaultPassword);
        }
        return studentDao.saveOrUpdate(studentDO);
    }

    /**
     * 删除
     *
     * @param no
     */
    @Override
    public void delete(String no) {
        studentDao.removeById(no);
    }

    /**
     * 获取所有学生信息
     *
     * @return
     */
    @Override
    public List<StudentDO> getStudents() {
        return studentDao.list();
    }

    @Override
    public StudentDO getStudentById(String id) {
        return studentDao.getById(id);
    }

    @Override
    public List<CourseScoreVO> getCourseScoresByStu(String stuNo) {
        return studentDao.getCourseScoresByStu(stuNo);
    }
}
