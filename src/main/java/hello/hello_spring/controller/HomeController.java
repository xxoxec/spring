package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /*
    컨트롤러가 정적 파일보다 우선 순위가 높다
     */
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
