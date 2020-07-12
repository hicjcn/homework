package com.demo.restapi.controller;


import com.demo.core.db.entity.HomeworkDO;
import com.demo.core.db.entity.HomeworkStudentDO;
import com.demo.core.db.service.IHomeworkStudentDao;
import com.demo.core.entity.ResultBean;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

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
@RequestMapping("/homeworkStudent")
public class HomeworkStudentController {

    @Resource
    private IHomeworkStudentDao iHomeworkStudentDao;

    /**
     * 提交作业
     */
    @PostMapping("/submitHomework")
    public ResultBean submitHomework(HttpServletRequest request, HomeworkStudentDO homeworkStudentDO, MultipartFile file) {
        homeworkStudentDO.setStudentCode(request.getHeader("User-Token"));
        iHomeworkStudentDao.submitHomework(homeworkStudentDO, file);
        return ResultBean.success(null);
    }

    /**
     *教师获取学生作业列表
     */
    @GetMapping("/getStudentHomeworkList/{hId}")
    public ResultBean<List<HomeworkStudentDO>> getStudentHomeworkList(HttpServletRequest request, @PathVariable Integer hId) {
        String teacherCode = request.getHeader("User-Token");
        return ResultBean.success(iHomeworkStudentDao.getStudentHomeworkList(teacherCode, hId));
    }

    /**
     *打分
     */
    @GetMapping("/setHomeworkGrade")
    public ResultBean setHomeworkGrade(HttpServletRequest request, @RequestParam Integer hsId, @RequestParam Float grade) {
        String teacherCode = request.getHeader("User-Token");
        iHomeworkStudentDao.setHomeworkGrade(teacherCode, hsId, grade);
        return ResultBean.success(null);
    }

}
