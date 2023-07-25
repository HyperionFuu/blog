package com.fuxin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Description: IndexController
 * Author: Fuu
 * Date: 2023/7/25
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

}
