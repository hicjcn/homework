package com.demo.restapi.controller;


import com.demo.core.db.entity.HomeworkDO;
import com.demo.core.db.entity.VO.HomeworkVO;
import com.demo.core.db.service.IHomeworkDao;
import com.demo.core.entity.ResultBean;
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
@RequestMapping("/homework")
public class HomeworkController {

    @Resource
    private IHomeworkDao iHomeworkDao;

    /**
     * 发布作业
     */
    @PostMapping("/releaseHomework")
    public ResultBean releaseHomework(HttpServletRequest request, @RequestBody HomeworkDO homeworkDO, MultipartFile file) {
        homeworkDO.setTeacherCode(request.getHeader("User-Token"));
        iHomeworkDao.releaseHomework(homeworkDO, file);
        return ResultBean.success(null);
    }

    /**
     * 获取作业列表
     */
    @GetMapping("/getHomeworkList")
    public ResultBean<List<HomeworkVO>> getHomeworkList(HttpServletRequest request, @RequestParam String className) {
        return ResultBean.success(iHomeworkDao.getHomeworkList(request.getHeader("User-Token"), className));
    }

}
