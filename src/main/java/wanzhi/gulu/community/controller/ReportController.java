package wanzhi.gulu.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wanzhi.gulu.community.dto.BanCreateDTO;
import wanzhi.gulu.community.dto.PageDTO;
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
    public String report(Report report,
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

    @GetMapping("/dealManage")
    public String toDeal(@RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage,
                         HttpServletRequest request,
                         Model model){
        User user = (User)request.getSession().getAttribute("user");
        if (user == null){
            //如果未登录
            throw new CustomizeException(CustomizeErrorCode.LOGIN_NOT_FOUND);
        }
        PageDTO pageDTO =reportService.findDealPage(currentPage);
        model.addAttribute("pageDTO",pageDTO);
        return "reportManagement";
    }

    @GetMapping("/cancelDeal")
    public String cancelDeal(@RequestParam("id") Long id){
        //驳回 :举报不成功 latest_count 清零，status置0
        System.out.println(id);
        return "redirect:/dealManage";
    }

    @PostMapping("/banDeal")
    public String banDeal(BanCreateDTO banCreateDTO){

        //banCount=2 永久封禁 status=4
        //封禁 :举报成功，latest_count清零，status置2，banCount+1，增加处理时间，处理结果
        System.out.println(banCreateDTO);
        return "redirect:/dealManage";
    }

}
