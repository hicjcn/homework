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
import com.demo.stu.service.IRelCourseStudentService;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RelCourseStudentService implements IRelCourseStudentService {

}
