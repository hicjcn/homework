package com.demo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demo.entity.StaffDO;
import com.demo.entity.vo.StaffVO;
import com.demo.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 员工登记表 前端控制器
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-06-22
 */
@Controller
@RequestMapping("/staff")
public class StaffController {

    @Resource
    private IUserService userService;

    @GetMapping("/list")
    public String list(Integer pageNo, Model model) {
        // 数据
        IPage<StaffDO> pages = userService.page(pageNo);
        model.addAttribute("page", pages);

        return "/staff/list";

    }

    @PostMapping("/save")
    public String save(StaffVO staffDO) {
        userService.save(staffDO);
        return "redirect:/staff/list";
    }

    @GetMapping("/del")
    public String del(String no) {
        userService.delete(no);
        return "redirect:/staff/list";
    }
}
