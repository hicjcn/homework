package com.demo.stu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.stu.dao.IRelCourseStudentDao;
import com.demo.stu.entity.RelCourseStudentDO;
import com.demo.stu.service.IRelCourseStudentService;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RelCourseStudentService implements IRelCourseStudentService {

    @Resource
    private IRelCourseStudentDao relCourseStudentDao;

    /**
     * 更新关联关系
     *
     * @param courseId
     * @param studentId
     */
    @Override
    public void rel(String courseId, String[] studentId) {
        // 清除原有数据
        if (StringUtils.isNotEmpty(courseId)) {
            QueryWrapper<RelCourseStudentDO> courseDOQueryWrapper = new QueryWrapper<>();
            courseDOQueryWrapper.lambda().eq(RelCourseStudentDO::getCourseId, courseId);
            relCourseStudentDao.remove(courseDOQueryWrapper);
        }

        // 保存新的关联关系
        if (null != studentId) {
            for (int i = 0; i < studentId.length; i++) {
                RelCourseStudentDO relCourseStudentDO = new RelCourseStudentDO();
                relCourseStudentDO.setCourseId(Integer.valueOf(courseId));
                relCourseStudentDO.setStudentNo(studentId[i]);
                relCourseStudentDao.save(relCourseStudentDO);
            }
        }
    }

    /**
     * 获取所有关联关系
     * @param courseId
     * @return
     */
    @Override
    public List<String> getRels(String courseId) {

        // 查询关联的数据
        QueryWrapper<RelCourseStudentDO> courseDOQueryWrapper = new QueryWrapper<>();
        courseDOQueryWrapper.lambda().eq(RelCourseStudentDO::getCourseId, courseId);

        List<RelCourseStudentDO> relCourseStudentDOS = relCourseStudentDao.list(courseDOQueryWrapper);

        // 找出所有的课程关联学号
        if (CollectionUtils.isEmpty(relCourseStudentDOS)) {
            return Lists.newArrayList();
        }
        return relCourseStudentDOS.stream().map(RelCourseStudentDO::getStudentNo).collect(Collectors.toList());
    }
}
