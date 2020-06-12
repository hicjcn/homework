package com.demo.stu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.stu.dao.IStudentDao;
import com.demo.stu.entity.StudentDO;
import com.demo.stu.service.IStudentService;
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

    /**
     * 学生管理
     * @return
     */
    @GetMapping("/student/list")
    public String studentList(Integer pageNo, String no, String name, String phone, Model model) {

        // 学生数据
        IPage<StudentDO> pages = studentService.page(pageNo, no, name, phone);
        model.addAttribute("stuPage", pages);

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
}
