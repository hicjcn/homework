package com.demo.stu.controller;


import com.demo.stu.entity.StudentDO;
import com.demo.stu.entity.vo.CourseVO;
import com.demo.stu.service.ICourseService;
import com.demo.stu.service.IRelCourseStudentService;
import com.demo.stu.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

        return "/admin/rel-course-student";
    }

}
