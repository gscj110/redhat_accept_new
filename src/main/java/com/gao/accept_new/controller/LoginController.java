package com.gao.accept_new.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/user/login")
    //@ResponseBody
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model,
            HttpSession session){
        //判断用户名是否正确
        if("redhat".equals(username)&&"admins".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            //告诉用户登录失败
            model.addAttribute("msg","用户名或者密码错误");
            return "admin";
        }



    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/admin.html";
    }

}
