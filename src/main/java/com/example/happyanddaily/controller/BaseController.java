package com.example.happyanddaily.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @GetMapping("/")
    public String base(){
        return "/layout/base";
    }

    @GetMapping("/base")
    public String base2(){
        return "/layout/base";
    }

}
