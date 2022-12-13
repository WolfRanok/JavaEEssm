package com.jinzheng.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        // 去除登录的拦截
        if(request.getRequestURI().indexOf("login") > 0 || request.getRequestURI().indexOf("goLogin") > 0
                ||  request.getRequestURI().indexOf("getVerifiCodeImage") > 0 ){
            return true;
        }
        HttpSession session = request.getSession();
        if(session != null && session.getAttribute("userInfo") != null){
            return true;
        } else {
            request.setAttribute("msg", "您当前还未登录，请登录后在使用");
            // 页面转发要写一个相对路径，视图解析器不生效
            request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
            return false;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        System.out.println("指向完成handler方法之后，并且在视图渲染之前执行  postHandle 方法");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("在视图渲染之后执行 afterCompletion");
    }
}
