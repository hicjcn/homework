package com.demo.stu.controller;

import com.demo.stu.entity.enumcode.UserType;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录相关控制器
 */
@Controller
public class LoginController {

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @PostMapping("login")
    public String loginAction(String username, String password, UserType type, Model model) {
        model.addAttribute("username", username);
        assert null != type;
        if (StringUtils.isAnyEmpty(username, password)) {
            model.addAttribute("error", "请输入用户名/密码");
        }
        if (type == UserType.STUDENT) {

        }
        return "login";
    }

}
