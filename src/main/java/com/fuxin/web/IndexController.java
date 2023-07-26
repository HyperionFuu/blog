package com.fuxin.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Description: IndexController
 * Author: Fuu
 * Date: 2023/7/25
 */
@Controller
public class IndexController {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    @GetMapping( "/")
    public String index(){
        return "index";
    }

}
