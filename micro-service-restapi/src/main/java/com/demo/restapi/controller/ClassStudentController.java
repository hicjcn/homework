package com.demo.restapi.controller;


import com.demo.core.db.entity.ClassStudentDO;
import com.demo.core.db.entity.VO.ClassStudentVO;
import com.demo.core.db.service.IClassStudentDao;
import com.demo.core.entity.ResultBean;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-07-11
 */
@RestController
@RequestMapping("/classStudent")
public class ClassStudentController {

    @Resource
    private IClassStudentDao iClassStudentDao;

    /**
     * 教师获取班级列表
     */
    @GetMapping("/getTeacherClassList")
    public ResultBean<List<ClassStudentVO>> getTeacherClassList(HttpServletRequest request, @RequestParam Integer classId, @RequestParam Integer type) {
        String teacherCode = request.getHeader("User-Token");
        return ResultBean.success(iClassStudentDao.getClassStudentList(teacherCode, classId, type));
    }

    /**
     * 提交申请
     */
    @PostMapping("/applyForClass")
    public ResultBean applyForClass(HttpServletRequest request, @RequestBody ClassStudentDO classStudentDO) {
        classStudentDO.setTeacherCode(request.getHeader("User-Token"));
        iClassStudentDao.applyForClass(classStudentDO);
        return ResultBean.success(null);
    }

    /**
     * 审批通过
     */
    @PostMapping("/agreeApply/{id}")
    public ResultBean agreeApply(@PathVariable("id") Integer id) {
        iClassStudentDao.changeStudentStatus(id, 0);
        return ResultBean.success(null);
    }

    /**
     * 审批驳回
     */
    @PostMapping("/disagreeApply/{id}")
    public ResultBean disagreeApply(@PathVariable("id") Integer id) {
        iClassStudentDao.changeStudentStatus(id, 2);
        return ResultBean.success(null);
    }


}
