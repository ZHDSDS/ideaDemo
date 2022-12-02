package com.xxxx.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @RequestMapping("666")
    public ModelAndView hello(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hello2","hello2 springmvc");
        modelAndView.setViewName("hello");
        return modelAndView;
    }
    @RequestMapping("test")
    public void test(String a,String b){
        System.out.println(a+"+"+b);
    }
}
