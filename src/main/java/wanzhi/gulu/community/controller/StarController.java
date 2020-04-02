package wanzhi.gulu.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import wanzhi.gulu.community.dto.CommentResultDTO;
import wanzhi.gulu.community.dto.PTSWResultDTO;
import wanzhi.gulu.community.dto.StarCreateDTO;
import wanzhi.gulu.community.exception.CustomizeErrorCode;
import wanzhi.gulu.community.model.Star;
import wanzhi.gulu.community.model.User;
import wanzhi.gulu.community.service.StarService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StarController {

    @Autowired
    StarService starService;

    //收藏功能
    @ResponseBody
    @PostMapping("/star")
    public Object star(@RequestBody StarCreateDTO starCreateDTO,
                       HttpServletRequest request){
        //如果未登录提示登录
        User user = (User)request.getSession().getAttribute("user");
        if (user == null) {
            //用户未登录
            return CommentResultDTO.errorOf(CustomizeErrorCode.LOGIN_NOT_FOUND);
        }
        Star star = starService.checkStarStatus(starCreateDTO);
        Integer status;
        Long starCount;
        if (star==null){
            //点赞
            starCount = starService.createStar(starCreateDTO);
            status = 1;
        }else {
            //取消点赞
            starCount = starService.removeStar(star);
            status = 0;
        }
        return PTSWResultDTO.okOf(status,starCount);
    }
}
