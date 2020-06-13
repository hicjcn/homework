package com.demo.stu.controller;


import com.demo.stu.entity.StudentDO;
import com.demo.stu.entity.vo.CourseVO;
import com.demo.stu.entity.vo.GradeVO;
import com.demo.stu.service.ICourseService;
import com.demo.stu.service.IRelCourseStudentService;
import com.demo.stu.service.IStudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
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
@RequestMapping("/admin")
public class RelCourseStudentController {

    @Resource
    private ICourseService courseService;

    @Resource
    private IStudentService studentService;

    @Resource
    private IRelCourseStudentService relCourseStudentService;

    @GetMapping("/rel-course-student-do")
    public String list(String courseId, Model model) {

        // 课程信息
        CourseVO courseVO = courseService.getCourseVO(courseId);
        model.addAttribute("course", courseVO);

        // 所有学生信息
        List<StudentDO> studentDOS = studentService.getStudents();
        model.addAttribute("students", studentDOS);

        // 所有学生信息
        List<String> rels = relCourseStudentService.getRels(courseId);
        model.addAttribute("rels", rels);

        return "/admin/rel-course-student";
    }

    @PostMapping("/rel-course-student-do")
    public String list(String courseId, String[] studentId, Model model) {

        // 保存关联信息课程信息
        relCourseStudentService.rel(courseId, studentId);

        return "redirect:/admin/rel-course-student-do?courseId=" + courseId;
    }

    @GetMapping("/rel-course-student-grade-do")
    public String grade(String courseId, Model model, @ModelAttribute("msg") String msg) {

        // 课程信息
        CourseVO courseVO = courseService.getCourseVO(courseId);
        model.addAttribute("course", courseVO);

        // 课程学生的成绩信息
        List<GradeVO> grades = relCourseStudentService.getStudentGrades(courseId);
        model.addAttribute("grades", grades);

        // 如果有提示信息则显示
        if (StringUtils.isNotEmpty(msg)) {
            model.addAttribute("msg", msg);
        }

        return "/teacher/rel-course-student-grade";
    }

    @PostMapping("/rel-course-student-grade-do")
    public String grade(String courseId, String relId, int grade, RedirectAttributes attributes) {

        // 保存课程成绩
        if (relCourseStudentService.saveGrade(relId, grade)) {
            attributes.addAttribute("msg", "更新成功");
        } else {
            attributes.addAttribute("msg", "更新失败");
        }

        return "redirect:/admin/rel-course-student-grade-do?courseId=" + courseId;
    }

}
