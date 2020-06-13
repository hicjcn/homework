package com.demo.stu.controller;


import com.demo.stu.entity.Constants;
import com.demo.stu.entity.StudentDO;
import com.demo.stu.entity.vo.CourseScoreVO;
import com.demo.stu.service.IStudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
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
@RequestMapping("/student")
public class StudentController {

    @Resource
    private IStudentService studentService;

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
            StudentDO studentDO = studentService.getStudentById(username);
            model.addAttribute("info", studentDO);
        }

        if (StringUtils.isNotEmpty(msg)) {
            model.addAttribute("msg", msg);
        }

        return "/student/info";
    }

    @PostMapping("/info")
    public String saveStudent(StudentDO studentDO, RedirectAttributes request) {
        studentService.save(studentDO);
        request.addAttribute("msg", "更新成功");
        return "redirect:/student/info";
    }

    @GetMapping("/scores")
    public String getScores(Model model) {
        String username = String.valueOf(session.getAttribute(Constants.USERNAME));

        List<CourseScoreVO> list = studentService.getCourseScoresByStu(username);
        model.addAttribute("list", list);

        return "/student/scores";
    }

}
