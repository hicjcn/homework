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
    @GetMapping("/getClassStudentList")
    public ResultBean<List<ClassStudentVO>> getTeacherClassList(HttpServletRequest request, @RequestParam Integer classId, @RequestParam Integer type) {
        String teacherCode = request.getHeader("User-Token");
        return ResultBean.success(iClassStudentDao.getClassStudentList(teacherCode, classId, type));
    }

    /**
     * 提交申请
     */
    @PostMapping("/applyForClass")
    public ResultBean applyForClass(HttpServletRequest request, @RequestBody ClassStudentDO classStudentDO) {
        classStudentDO.setStudentCode(request.getHeader("User-Token"));
        iClassStudentDao.applyForClass(classStudentDO);
        return ResultBean.success(null);
    }

    /**
     * 审批通过
     */
    @PostMapping("/agreeApply")
    public ResultBean agreeApply(@RequestParam String id) {
        iClassStudentDao.changeStudentStatus(Integer.valueOf(id), 0);
        return ResultBean.success(null);
    }

    /**
     * 审批驳回
     */
    @PostMapping("/disagreeApply")
    public ResultBean disagreeApply(@RequestParam String id) {
        iClassStudentDao.changeStudentStatus(Integer.valueOf(id), 2);
        return ResultBean.success(null);
    }


}
