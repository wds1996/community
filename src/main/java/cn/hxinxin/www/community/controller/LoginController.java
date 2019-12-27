package cn.hxinxin.www.community.controller;

import cn.hxinxin.www.community.dto.AccessTokenDTO;
import cn.hxinxin.www.community.dto.GitUser;
import cn.hxinxin.www.community.service.LoginService;
import com.alibaba.fastjson.JSON;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 王东升
 * @create 2019/12/23--17:22
 */
@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @Value("${github.client_id}")
    private String Client_id;
    @Value("${github.client_secret}")
    private String Client_secret;
    @Value("${github.redirect_uri}")
    private String Redirect_uri;
    @GetMapping("/login/callback")
    public String login(@RequestParam(name ="code") String code,
                        @RequestParam(name = "state") String state){
        System.out.println("login");
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(Client_id);
        accessTokenDTO.setClient_secret(Client_secret);
        accessTokenDTO.setState(state);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(Redirect_uri);
        GitUser loginUserInfo = loginService.getLoginInfo(accessTokenDTO);
        System.out.println(JSON.toJSON(loginUserInfo));
        return "index";
    }
}
