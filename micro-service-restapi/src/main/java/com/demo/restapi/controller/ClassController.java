package com.demo.restapi.controller;


import com.demo.core.db.entity.ClassDO;
import com.demo.core.db.service.IClassDao;
import com.demo.core.entity.ResultBean;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-07-11
 */
@RestController
@RequestMapping("/class")
public class ClassController {

    @Resource
    private IClassDao iClassDao;

    /**
     * 教师获取班级列表
     */
    @GetMapping("/getTeacherClassList")
    public ResultBean getTeacherClassList(HttpServletRequest request) {
        String teacherCode = request.getHeader("User-Token");
        return ResultBean.success(iClassDao.getClassDOList(teacherCode));
    }

    /**
     * 创建课程
     */
    @PostMapping("/createClass")
    public ResultBean registry(HttpServletRequest request, @RequestBody ClassDO classDO) {
        classDO.setTeacherCode(request.getHeader("User-Token"));
        iClassDao.createClass(classDO);
        return ResultBean.success(null);
    }

    /**
     * 教师获取班级列表
     */
    @GetMapping("/getStudentClassList")
    public ResultBean getStudentClassList() {
        return ResultBean.success(iClassDao.getClassDOList(null));
    }

}
