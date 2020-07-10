package cn.jcera.restapi.controller;

import cn.jcera.core.entity.ResultBean;
import cn.jcera.restapi.version.ApiVersion;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ApiVersion(1)
@RequestMapping("/demo")
public class DemoController {

    @GetMapping
    public ResultBean<String> hello(String name) {
        return ResultBean.success("hello " + (StringUtils.isNotEmpty(name) ? name : "未知先生"));
    }
}
