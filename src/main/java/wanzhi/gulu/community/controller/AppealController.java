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
import wanzhi.gulu.community.mapper.QuestionMapper;
import wanzhi.gulu.community.model.User;
import wanzhi.gulu.community.service.AppealService;
import wanzhi.gulu.community.service.QuestionService;
import wanzhi.gulu.community.service.ReportService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AppealController {

    @Autowired
    AppealService appealService;

    @Autowired
    ReportService reportService;

    @Autowired
    QuestionService questionService;

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

    @GetMapping("/appealDeal")
    public String toAppealManagement(@RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage,
                                     HttpServletRequest request,
                                     Model model){
        User loginUser = (User)request.getSession().getAttribute("user");
        if (loginUser == null){
            //如果未登录
            throw new CustomizeException(CustomizeErrorCode.LOGIN_NOT_FOUND);
        }
        PageDTO pageDTO =appealService.findAppealDealPage(currentPage);
        model.addAttribute("pageDTO",pageDTO);
        return "appealManagement";
    }

    @GetMapping("/failAppeal")
    public String failAppeal(HttpServletRequest request,
                             @RequestParam("id") Long id){
        User loginUser = (User)request.getSession().getAttribute("user");
        if (loginUser == null){
            //如果未登录
            throw new CustomizeException(CustomizeErrorCode.LOGIN_NOT_FOUND);
        }
        //申诉不通过，
        //appeal的状态置3 返回report_deal的id
        Long dealId = appealService.outAppeal(id);
        //删除相应的帖子和一级及二级评论,
        reportService.foreverBan(dealId,1);
        return "redirect:/appealDeal";
    }

    @GetMapping("/passAppeal")
    public String passAppeal(HttpServletRequest request,
                             @RequestParam("id") Long id){
        User loginUser = (User)request.getSession().getAttribute("user");
        if (loginUser == null){
            //如果未登录
            throw new CustomizeException(CustomizeErrorCode.LOGIN_NOT_FOUND);
        }
        //需要loginUser有管理员权限
        //申诉通过：
        // reportDeal表 latest_count 清零，status置0，设置处理时间，设置处理结果：申诉成功
        reportService.passAppeal(id);
        // question表 ban状态置0
        questionService.cancelBan(id);
        // appeal表状态置 0
        appealService.passAppeal(id);
        return "redirect:/appealDeal";
    }
}