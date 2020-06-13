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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
