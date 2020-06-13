package com.demo.stu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.stu.dao.ICourseDao;
import com.demo.stu.dao.ITeacherDao;
import com.demo.stu.entity.CourseDO;
import com.demo.stu.entity.TeacherDO;
import com.demo.stu.entity.vo.CourseVO;
import com.demo.stu.service.ICourseService;
import com.demo.stu.service.ITeacherService;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CourseService implements ICourseService {

    @Resource
    private ITeacherDao teacherDao;

    @Resource
    private ICourseDao courseDao;

    /**
     * 分页列表筛选
     * @param pageNo
     * @param name
     * @return
     */
    @Override
    public IPage<CourseVO> page(Integer pageNo, String name) {
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

        IPage<CourseDO> courseDOIPage = courseDao.page(page, queryWrapper);

        // 全部教师
        List<TeacherDO> teacherDOList = teacherDao.list();
        Map<String, String> teacherNameMap = teacherDOList.stream().collect(Collectors.toMap(TeacherDO::getNo, TeacherDO::getName));

        // 补充教师姓名
        IPage<CourseVO> courseVOIPage = new Page<>();
        courseVOIPage.setSize(courseDOIPage.getSize());
        courseVOIPage.setCurrent(courseDOIPage.getCurrent());
        courseVOIPage.setTotal(courseDOIPage.getTotal());
        courseVOIPage.setPages(courseDOIPage.getPages());

        List<CourseVO> list = Lists.newArrayList();
        courseDOIPage.getRecords().forEach(courseDO -> {
            CourseVO courseVO = new CourseVO();
            BeanUtils.copyProperties(courseDO, courseVO);
            // 补充教师
            courseVO.setTeacher(teacherNameMap.getOrDefault(courseVO.getTeacherId(), "未知"));
            list.add(courseVO);
        });

        courseVOIPage.setRecords(list);

        return courseVOIPage;
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

    /**
     * 获取课程信息
     *
     * @param courseId
     * @return
     */
    @Override
    public CourseVO getCourseVO(String courseId) {
        if (StringUtils.isEmpty(courseId)) {
            return new CourseVO();
        }
        CourseDO courseDO = courseDao.getById(courseId);

        // 复制数据
        CourseVO courseVO = new CourseVO();
        BeanUtils.copyProperties(courseDO, courseVO);

        // 补充教师信息
        TeacherDO teacherDO = teacherDao.getById(courseVO.getTeacherId());
        if (null != teacherDO) {
            courseVO.setTeacher(teacherDO.getName());
        } else {
            courseVO.setTeacher("未知");
        }

        return courseVO;
    }
}
