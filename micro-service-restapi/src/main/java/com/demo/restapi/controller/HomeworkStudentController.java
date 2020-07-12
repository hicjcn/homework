package com.demo.restapi.controller;


import com.demo.core.db.entity.HomeworkDO;
import com.demo.core.db.entity.HomeworkStudentDO;
import com.demo.core.db.service.IHomeworkStudentDao;
import com.demo.core.entity.ResultBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

}
