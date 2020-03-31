package wanzhi.gulu.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppealController {

    @GetMapping("/myAppeal")
    public String toAppeal(){
        return "myAppeal";
    }
}
