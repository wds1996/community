package cn.hxinxin.www.community.provider;

import cn.hxinxin.www.community.dto.GitUser;
import cn.hxinxin.www.community.dto.AccessTokenDTO;
import com.alibaba.fastjson.JSON;

import okhttp3.*;
import org.springframework.stereotype.Component;

/**
 * @author 王东升
 * @create 2019/12/25--10:24
 */
@Component
public class GitHubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType json = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(json, JSON.toJSONString(accessTokenDTO));
        //System.out.println(JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            //System.out.println(string);
            return string;
        }catch (Exception e){
            //System.out.println(e);
        }
        return null;
    }

    public GitUser getUserInfo(String access_token){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+access_token)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String result = response.body().string();
            return JSON.parseObject(result,GitUser.class);
        }catch (Exception e){
            //System.out.println(e.getStackTrace());
        }
        return null;
    }
}
