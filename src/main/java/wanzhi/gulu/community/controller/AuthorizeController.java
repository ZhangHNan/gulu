package wanzhi.gulu.community.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wanzhi.gulu.community.dto.AccessTokenDTO;
import wanzhi.gulu.community.dto.GithubUser;
import wanzhi.gulu.community.exception.CustomizeErrorCode;
import wanzhi.gulu.community.exception.CustomizeException;
import wanzhi.gulu.community.model.User;
import wanzhi.gulu.community.provider.GithubProvider;
import wanzhi.gulu.community.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${git.client.id}")
    private String clientId;
    @Value("${git.client.secret}")
    private String clientSecret;
    @Value("${git.redirect.uri}")
    private String redirectUri;

    @Autowired
    private UserService userService;

    //跳转到github授权页面授权后，github访问/callback（redirect_uri）同时携带code和state参数
    @GetMapping("/callback")
    public String callback(@RequestParam("code") String code,
                           @RequestParam(name="state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response){//接收code和state参数
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        //以post方式，请求https://github.com/login/oauth/access_token并携带某些必要参数（accessTokenDTO）
        //请求access_token接口后会返回access_token和scope=user和token_type，只需要access_token参数即可
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        //将获取的access_token作为参数请求http://api.github.com/user会返回用户的信息，将需要使用的信息抽取为GithubUser用于接收
        GithubUser githubUser = githubProvider.getGithubUser(accessToken);
        if(githubUser != null && githubUser.getId()!=null){
            if (accessTokenDTO.getState().equals("1")){//此功能为github登录功能
                //登录成功，保存账户信息，将token（随机值）存入cookie中
                User user = new User();//下面要使用set方法给这个对象的属性赋值，此处不可用null，必须实例化一个对象。
                String token = UUID.randomUUID().toString();//抽取token用于存入cookie
                user.setToken(token);
                user.setGmtModified(System.currentTimeMillis());
                user.setAccountId(githubUser.getId());
                user.setAvatarUrl(githubUser.getAvatarUrl());
                user.setEmail(githubUser.getEmail());
                user.setBio(githubUser.getBio());
                if(StringUtils.isBlank(githubUser.getName())){
                    user.setName(githubUser.getLogin());
                }else{
                    user.setName(githubUser.getName());
                }
                userService.createOrUpdate(user);
                response.addCookie(new Cookie("token",token));
                return "redirect:/index";
            }else if(accessTokenDTO.getState().equals("2")){
                User loginUser = (User)request.getSession().getAttribute("user");
                if (loginUser==null){
                    throw new CustomizeException(CustomizeErrorCode.LOGIN_NOT_FOUND);
                }
                if (loginUser.getAccountId()!=null){
                    throw new CustomizeException(CustomizeErrorCode.GITHUB_ALREADY_BINDING);
                }
                boolean AccountIsExist =userService.checkAccountId(githubUser.getId());
                if (AccountIsExist){
                    throw new CustomizeException(CustomizeErrorCode.ACCOUNTID_IS_EXIST);
                }
                loginUser.setAccountId(githubUser.getId());
                if (loginUser.getEmail()==null){
                    loginUser.setEmail(githubUser.getEmail());
                }
                if (loginUser.getBio()==null){
                    loginUser.setBio(githubUser.getBio());
                }
                userService.binding(loginUser);
                return "redirect:/myProfile";//此功能为绑定github账号：使用此功能时是手机号登录的，必须绑定accountId，无简介则刷新简介，无email则绑定email
            }
        }else {
            //登录失败，重新登录
            return "redirect:/index";
        }
        System.out.println("state不是1和2");
        return "redirect:/index";
    }
}
