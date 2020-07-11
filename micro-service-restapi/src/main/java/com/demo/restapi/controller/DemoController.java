package com.demo.restapi.controller;

import com.demo.core.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/file")
public class DemoController {

    @GetMapping("/download")
    public void download(String name, HttpServletResponse response) throws Exception{
        FileUtil.download(name, response);
    }
}
