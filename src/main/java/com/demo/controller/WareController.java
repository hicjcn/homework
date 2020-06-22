package com.demo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demo.entity.StaffDO;
import com.demo.entity.WareDO;
import com.demo.entity.vo.StaffVO;
import com.demo.entity.vo.WareVO;
import com.demo.service.IUserService;
import com.demo.service.IWareService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 商品登记表 前端控制器
 * </p>
 *
 * @author MybatisPlus
 * @since 2020-06-22
 */
@Controller
@RequestMapping("/ware")
public class WareController {

    @Resource
    private IWareService wareService;

    @GetMapping("/list")
    public String list(Integer pageNo, Model model) {
        // 数据
        IPage<WareDO> pages = wareService.page(pageNo);
        model.addAttribute("page", pages);

        return "/ware/list";

    }

    @PostMapping("/save")
    public String save(WareVO wareVO) {
        wareService.save(wareVO);
        return "redirect:/ware/list";
    }

    @GetMapping("/del")
    public String del(String no) {
        wareService.delete(no);
        return "redirect:/ware/list";
    }

}
