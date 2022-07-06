package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 스프링은 Controller를 명시해 주어야 함
public class HelloController {

    @GetMapping("hello")    // '/hello'하면 이 메서드를 호출
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

}
