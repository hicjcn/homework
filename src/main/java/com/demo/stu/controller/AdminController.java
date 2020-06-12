package com.demo.stu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.stu.dao.IStudentDao;
import com.demo.stu.entity.CourseDO;
import com.demo.stu.entity.StudentDO;
import com.demo.stu.entity.TeacherDO;
import com.demo.stu.service.ICourseService;
import com.demo.stu.service.IStudentService;
import com.demo.stu.service.ITeacherService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 首页相关控制器
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Resource
    private IStudentService studentService;

    @Resource
    private ITeacherService teacherService;

    @Resource
    private ICourseService courseService;

    /**
     * 学生管理
     * @return
     */
    @GetMapping("/student/list")
    public String studentList(Integer pageNo, String no, String name, String phone, Model model) {

        // 学生数据
        IPage<StudentDO> pages = studentService.page(pageNo, no, name, phone);
        model.addAttribute("page", pages);

        return "/admin/student";
    }

    @PostMapping("/student/save")
    public String saveStudent(StudentDO studentDO) {
        studentService.save(studentDO);
        return "redirect:/admin/student/list";
    }

    @GetMapping("/student/del")
    public String delStudent(String no) {
        studentService.delete(no);
        return "redirect:/admin/student/list";
    }

    /**
     * 教师管理
     * @return
     */
    @GetMapping("/teacher/list")
    public String teacherList(Integer pageNo, String no, String name, String phone, Model model) {

        // 数据
        IPage<TeacherDO> pages = teacherService.page(pageNo, no, name, phone);
        model.addAttribute("page", pages);

        return "/admin/teacher";
    }

    @PostMapping("/teacher/save")
    public String saveTeacher(TeacherDO teacherDO) {
        teacherService.save(teacherDO);
        return "redirect:/admin/teacher/list";
    }

    @GetMapping("/teacher/del")
    public String delTeacher(String no) {
        teacherService.delete(no);
        return "redirect:/admin/teacher/list";
    }

    /**
     * 课程管理
     * @return
     */
    @GetMapping("/course/list")
    public String courseList(Integer pageNo, String name, Model model) {

        // 数据
        IPage<CourseDO> pages = courseService.page(pageNo, name);
        model.addAttribute("page", pages);

        return "/admin/course";
    }

    @PostMapping("/course/save")
    public String saveCourse(CourseDO courseDO) {
        courseService.save(courseDO);
        return "redirect:/admin/course/list";
    }

    @GetMapping("/course/del")
    public String delCourse(String no) {
        courseService.delete(no);
        return "redirect:/admin/course/list";
    }
}
