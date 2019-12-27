package cn.hxinxin.www.community.service;

import cn.hxinxin.www.community.dto.AccessTokenDTO;
import cn.hxinxin.www.community.dto.GitUser;
import cn.hxinxin.www.community.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 王东升
 * @create 2019/12/25--9:38
 */
@Service
public class LoginService {
    @Autowired
    GitHubProvider gitHubProvider;

    public GitUser getLoginInfo(AccessTokenDTO accessTokenDTO){
        String accessToken_string = gitHubProvider.getAccessToken(accessTokenDTO);
        String[] split = accessToken_string.split("&");
        String accessToken = split[0].split("=")[1];
        GitUser userInfo = gitHubProvider.getUserInfo(accessToken);
        return userInfo;
    }
}
