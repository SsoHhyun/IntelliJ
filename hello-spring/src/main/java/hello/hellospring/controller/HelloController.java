package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "spring!!");
        return "hello";
    }
    // 스프링부트 thymeleaf 템플릿 엔진
    // templates 이하의 hello라는 이름의 파일을 찾아 반환해 줌 -> 화면에 hello.html이 나타남


}
