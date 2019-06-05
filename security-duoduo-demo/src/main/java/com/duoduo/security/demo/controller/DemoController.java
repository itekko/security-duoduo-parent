package com.duoduo.security.demo.controller;

import com.duoduo.security.core.response.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lixiaolong
 * @create 2019-06-05 15:01
 */
@RestController
public class DemoController {

    @GetMapping("/demo")
    public Result demo(){
        return Result.ok();
    }

}
