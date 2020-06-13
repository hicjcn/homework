package com.demo.stu.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demo.stu.entity.Constants;
import com.demo.stu.entity.CourseDO;
import com.demo.stu.entity.StudentDO;
import com.demo.stu.entity.TeacherDO;
import com.demo.stu.service.ICourseService;
import com.demo.stu.service.IRelCourseStudentService;
import com.demo.stu.service.ITeacherService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-06-02
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Resource
    private ITeacherService teacherService;

    @Resource
    private ICourseService courseService;

    @Resource
    private HttpSession session;

    /**
     * 个人中心
     * @return
     */
    @GetMapping("/info")
    public String info(Model model, @ModelAttribute("msg") String msg) {

        String username = String.valueOf(session.getAttribute(Constants.USERNAME));
        if (StringUtils.isNotEmpty(username)) {
            // 数据
            TeacherDO teacherDO = teacherService.getTeacherById(username);
            model.addAttribute("info", teacherDO);
        }

        if (StringUtils.isNotEmpty(msg)) {
            model.addAttribute("msg", msg);
        }

        return "/teacher/info";
    }

    @PostMapping("/info")
    public String saveTeacher(TeacherDO teacherDO, RedirectAttributes request) {
        teacherService.save(teacherDO);
        request.addAttribute("msg", "更新成功");
        return "redirect:/teacher/info";
    }

    /**
     * 学生成绩管理
     * @return
     */
    @GetMapping("/grade")
    public String grade(Model model) {

        String username = String.valueOf(session.getAttribute(Constants.USERNAME));
        if (StringUtils.isNotEmpty(username)) {
            // 课程数据
            List<CourseDO> courseDOS = courseService.getCoursesByTeacherNo(username);
            model.addAttribute("courses", courseDOS);
        }

        return "/teacher/grade";
    }

}
