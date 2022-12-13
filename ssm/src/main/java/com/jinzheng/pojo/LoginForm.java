package com.jinzheng.pojo;


//接收前端请求
public class LoginForm {
    //主键id
    private Integer id;
    //用户名
    private String username;
    //密码
    private String password;
    //验证码
    private String verifiCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifiCode() {
        return verifiCode;
    }

    public void setVerifiCode(String verifiCode) {
        this.verifiCode = verifiCode;
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", verifiCode='" + verifiCode + '\'' +
                '}';
    }
}
