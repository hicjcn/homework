package com.demo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.demo.entity.SaleDO;
import com.demo.entity.WareDO;
import com.demo.entity.vo.SaleVO;
import com.demo.entity.vo.WareVO;
import com.demo.service.ISaleService;
import com.demo.service.IWareService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 */
@Controller
@RequestMapping("/sale")
public class SaleController {

    @Resource
    private IWareService wareService;

    @Resource
    private ISaleService saleService;

    @GetMapping("/list")
    public String list(Integer pageNo, Model model) {
        // 数据
        IPage<SaleVO> pages = saleService.page(pageNo);
        model.addAttribute("page", pages);

        // 商品数据
        List<WareDO> wareDOS = wareService.list();
        model.addAttribute("wares", wareDOS);

        return "/sale/list";

    }

    @PostMapping("/save")
    public String save(SaleDO saleDO) {
        saleService.save(saleDO);
        return "redirect:/sale/list";
    }

}
