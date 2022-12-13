package com.jinzheng.controller;

import com.jinzheng.pojo.LoginForm;
import com.jinzheng.pojo.User;
import com.jinzheng.service.UserService;
import com.jinzheng.util.CreateVerifiCodeImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Controller  //通过注解将Controller放入Bean中管理
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getVerifiCodeImage")
    public void getVerifiCodeImage(HttpServletRequest request, HttpServletResponse response) {
        // 验证码图片
        BufferedImage verifiCodeImage = CreateVerifiCodeImage.getVerifiCodeImage();
        // 验证码
        String verifiCode = String.valueOf(CreateVerifiCodeImage.getVerifiCode());
        // 将验证码图片输出到登录页面
        try {
            ImageIO.write(verifiCodeImage, "JPEG", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 存储验证码Session
        request.getSession().setAttribute("verifiCode", verifiCode);
    }


    //0.登入方法
    @RequestMapping("login")
    @ResponseBody
    public Map<String,Object> login(LoginForm loginForm, HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        //校验验证码信息
        String vcode = (String) request.getSession().getAttribute("verifiCode");

        if ("".equals(vcode)){
            result.put("success",false);
            result.put("msg","长时间未操作，会话已失效，请刷新页面后重试！");
            return result;
        } else if (!loginForm.getVerifiCode().equalsIgnoreCase(vcode)) {
            result. put("success", false);
            result. put("msg", "验证码错误!");
            return result;
        }
        request. getSession(). removeAttribute("verifiCode");

        //校验用户名和密码
        User admin = userService.selectByUser(new User(null,loginForm.getUsername(), loginForm.getPassword()));

        System.out.println("username = "+loginForm.getUsername()+"\npassword = "+loginForm.getPassword()+"\n最终结果 = "+admin); // 记录用户的登录信息

        if (admin != null){
            //将用户信息存储到Session
            HttpSession session = request. getSession();
            session. setAttribute("userInfo", admin);
            result. put("success", true);
            return result;
        }
        //登录失败
        result. put("success", false);
        result. put("msg", "用户名或密码错误!");
        return result;
    }

    //1. 登录方法
    @RequestMapping("/loginTo")
    public String login(){
        return "login";
    }

    //2. 退出方法
    @RequestMapping("/loginOut")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "login";
    }

    //3.进入到主页的方法
    @GetMapping("/goSystemMainView")
    public String goSystemMainView(){
        return "forward:allBook";
    }
}
