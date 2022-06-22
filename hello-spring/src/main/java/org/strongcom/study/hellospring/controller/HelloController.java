package org.strongcom.study.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")    // /hello 가 들어오면 이 메소드 호출됨.
    public String hello(Model model){
        //key == data, value == hello
        model.addAttribute("data","hello!");
        return "hello";
    }
}
