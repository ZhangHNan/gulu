package wanzhi.gulu.community.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import wanzhi.gulu.community.check.LoginCheck;
import wanzhi.gulu.community.model.User;
import wanzhi.gulu.community.service.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//登录拦截器 ：作登录状态检查，以及获取未读通知
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    LoginCheck loginCheck;

    @Autowired
    NotificationService notificationService;

    @Autowired
    QuestionService questionService;

    @Autowired
    StarService starService;

    @Autowired
    WatchService watchService;

    @Autowired
    AppealService appealService;

    @Autowired
    ReportService reportService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //进入首页时，获取cookies中的token数据，根据token查询数据库中有无登录数据
        //若服务器重启，用户第一次访问页面的请求没有检查登录状态，则导航栏不会显示已登录状态
        Cookie[] cookies = request.getCookies();
        //登录检查
        loginCheck.check(cookies, request);
        //获取未读通知数
        User user = (User)request.getSession().getAttribute("user");
        if(user!=null){
            //如果登录了就将这些数据存入session域
            Integer unread = notificationService.findUnreadCountByReceiver(user.getId());
            Integer myQuestionCount =questionService.findMyQuestionCount(user.getId());
            Integer myStarCount = starService.findMyStarCount(user.getId());
            Integer myWatchCount = watchService.findMyWatchCount(user.getId());
            Integer myAppealCount = appealService.findMyAppealCount(user.getId());
            Integer appealApplyCount = appealService.findAppealApplyCount();
            Integer dealApplyCount = reportService.findDealApplyCount();
            request.getSession().setAttribute("myStarCount",myStarCount); //查询我的收藏数
            request.getSession().setAttribute("myWatchCount",myWatchCount);//查询我的关注
            request.getSession().setAttribute("myAppealCount",myAppealCount);//查询我的被暂封帖子数 申诉中心
            request.getSession().setAttribute("appealApplyCount",appealApplyCount);//需要处理的申诉申请数
            request.getSession().setAttribute("dealApplyCount",dealApplyCount); //需要申请的举报处理数
            request.getSession().setAttribute("myQuestionCount",myQuestionCount);//查询登录用户的问题数
            //上面这些应该另外写个拦截器处理，不然到每个页面都要查询，降低响应速度
            request.getSession().setAttribute("unread",unread);//查询未读通知数
        }
        return true;
    }
}
