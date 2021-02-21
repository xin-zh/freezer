package cn.xhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *@author:zx
 *@create time:2021/2/21 10:28
 *@desciption:
 *
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("")
    public String test(){
        return "test";
    }
}
