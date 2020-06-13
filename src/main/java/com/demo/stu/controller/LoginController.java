package com.demo.stu.controller;

import com.demo.stu.entity.Constants;
import com.demo.stu.entity.enumcode.UserType;
import com.demo.stu.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 登录相关控制器
 */
@Controller
public class LoginController {

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private IUserService userService;

    @Resource
    private HttpSession session;

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("logout")
    public String logout() {
        // 清除session
        session.invalidate();
        return "redirect:/login";
    }

    @PostMapping("login")
    public String loginAction(String username, String password, UserType type, Model model) {
        model.addAttribute("username", username);
        assert null != type;
        if (StringUtils.isAnyEmpty(username, password)) {
            model.addAttribute("error", "请输入用户名/密码");
        }
        if (userService.login(username, password, type)) {
            session.setAttribute(Constants.USERNAME, username);
            session.setAttribute(Constants.USER_TYPE, type);
            return "redirect:/index";
        } else {
            model.addAttribute("error", "用户名/密码错误");
        }
        return "login";
    }


    @GetMapping("reset-password")
    public String resetPwd(@ModelAttribute("msg") String msg, Model model) {

        // 如果有提示信息则显示
        if (StringUtils.isNotEmpty(msg)) {
            model.addAttribute("msg", msg);
        }

        return "reset";
    }

    @PostMapping("reset-password")
    public String resetPwd(String oldPwd, String newPwd, RedirectAttributes attributes) {

        String username = String.valueOf(session.getAttribute(Constants.USERNAME));
        UserType userType = UserType.valueOf(String.valueOf(session.getAttribute(Constants.USER_TYPE)));

        if (StringUtils.isAnyEmpty(username, oldPwd, newPwd) || null == userType) {
            attributes.addAttribute("msg", "信息不完整无法修改");
        } else {
            // 修改密码
            if (userService.resetPwd(username, oldPwd, newPwd, userType)) {
                attributes.addAttribute("msg", "修改成功");
            } else {
                attributes.addAttribute("msg", "修改失败");
            }
        }

        return "redirect:/reset-password";
    }

}
