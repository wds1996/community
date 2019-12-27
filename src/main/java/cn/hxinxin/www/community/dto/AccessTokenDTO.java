package cn.hxinxin.www.community.dto;

import org.springframework.context.annotation.Bean;

/**
 * @author 王东升
 * @create 2019/12/25--10:19
 */
public class AccessTokenDTO {
    String client_id;   //您从GitHub收到的GitHub App的客户端ID。
    String client_secret;  //您从GitHub收到的GitHub App的客户密码。
    String code;   //您收到的作为对步骤1的响应的代码。
    String redirect_uri;   //	授权后将用户发送到应用程序中的URL。
    String state;

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
