package org.strongcom.study.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")    // /hello 가 들어오면 이 메소드 호출됨.
    public String hello(Model model){
        //key == data, value == hello
        model.addAttribute("data","hello!");
        return "hello";
    }

    //쿼리문으로 name 파라미터 요청가능
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model ){
        model.addAttribute("name",name);
        return "hello-template";
    }

    //html 없이 문자 그대로 내려감.
    //쓸일 거의 없긴함.
    @GetMapping("hello-string")
    @ResponseBody   //http body 에 데이터를 직접 넣어준다.
    public String helloString(@RequestParam("name")String name){
        return "hello "+name;
    }

    // 객체를 내려주면 json 방식으로 표현됨
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
