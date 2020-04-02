package wanzhi.gulu.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wanzhi.gulu.community.dto.AppealApplyDTO;
import wanzhi.gulu.community.dto.PageDTO;
import wanzhi.gulu.community.exception.CustomizeErrorCode;
import wanzhi.gulu.community.exception.CustomizeException;
import wanzhi.gulu.community.model.User;
import wanzhi.gulu.community.service.AppealService;
import wanzhi.gulu.community.service.ReportService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyAppealController {

    @Autowired
    AppealService appealService;

    @Autowired
    ReportService reportService;

    //到申诉中心页面
    @GetMapping("/myAppeal")
    public String toAppeal(@RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage,
                           HttpServletRequest request,
                           Model model){
        User loginUser = (User)request.getSession().getAttribute("user");
        if (loginUser == null){
            //如果未登录
            throw new CustomizeException(CustomizeErrorCode.LOGIN_NOT_FOUND);
        }
        PageDTO pageDTO =appealService.findMyAppealPageById(currentPage,loginUser.getId());
        model.addAttribute("pageDTO",pageDTO);
        return "myAppeal";
    }

    //取消申诉功能
    @GetMapping("/cancelAppeal")
    public String cancelAppeal(HttpServletRequest request,
                               @RequestParam("id") Long id){
        User loginUser = (User)request.getSession().getAttribute("user");
        if (loginUser == null){
            //如果未登录
            throw new CustomizeException(CustomizeErrorCode.LOGIN_NOT_FOUND);
        }
        //已登录，要确认是取消申请本人的，是才取消，不是报错
        Boolean isSelf =appealService.check(id,loginUser.getId());
        if (isSelf){
            //安全，
            //appeal的状态置3 返回report_deal的id
            Long dealId = appealService.outAppeal(id);
            //删除相应的帖子和一级及二级评论,
            reportService.foreverBan(dealId,1);
            return "redirect:/myAppeal";
        }else{
            throw new CustomizeException(CustomizeErrorCode.PERMISSION_DENIED);
        }
    }

    //申请申诉功能
    @PostMapping("/appeal")
    public String appeal(HttpServletRequest request,
                         AppealApplyDTO appealApplyDTO){
        User loginUser = (User)request.getSession().getAttribute("user");
        if (loginUser == null){
            //如果未登录
            throw new CustomizeException(CustomizeErrorCode.LOGIN_NOT_FOUND);
        }
        appealService.createApply(appealApplyDTO);
        return "redirect:/myAppeal";
    }
}
