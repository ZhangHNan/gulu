package wanzhi.gulu.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import wanzhi.gulu.community.exception.CustomizeErrorCode;
import wanzhi.gulu.community.exception.CustomizeException;
import wanzhi.gulu.community.model.Report;
import wanzhi.gulu.community.model.User;
import wanzhi.gulu.community.service.ReportService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ReportController {

    @Autowired
    ReportService reportService;

    @PostMapping("/report")
    public String questionReport(Report report,
                                 HttpServletRequest request){
        //举报表单
        User user = (User)request.getSession().getAttribute("user");
        if (user == null){
            //如果未登录
            throw new CustomizeException(CustomizeErrorCode.LOGIN_NOT_FOUND);
        }
        report.setReporter(user.getId());
        report.setGmtCreate(System.currentTimeMillis());
        reportService.createReport(report);
        return "redirect:index";
    }


}
