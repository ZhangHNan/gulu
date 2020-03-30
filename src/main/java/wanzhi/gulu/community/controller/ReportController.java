package wanzhi.gulu.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import wanzhi.gulu.community.model.Report;

@Controller
public class ReportController {

    @PostMapping("/report")
    public String questionReport(Report report){
        System.out.println(report);
        return "redirect:index";
    }
}
