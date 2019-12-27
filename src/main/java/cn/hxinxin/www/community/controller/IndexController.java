package cn.hxinxin.www.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 王东升
 * @create 2019/12/24--18:04
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){

        return "index";
    }
}
