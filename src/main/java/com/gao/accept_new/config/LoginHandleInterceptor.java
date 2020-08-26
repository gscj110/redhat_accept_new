package com.gao.accept_new.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//配置拦截器
public class LoginHandleInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功之后，应该有用户的session；
        Object loginUser=request.getSession().getAttribute("loginUser");
        if (loginUser==null){
            //没有登录
            request.setAttribute("msg","没有权限，请先登录");
            request.getRequestDispatcher("/").forward(request,response);

            return false;
        }else {
            return true;
        }


    }


}
