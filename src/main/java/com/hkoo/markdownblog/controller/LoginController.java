package com.hkoo.markdownblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }


    @RequestMapping("/loginSuccess")
    public String loginComplete(){
        return "redirect:/board/list";
    }

    @RequestMapping("/signUp")
    public String signUpUser(){
        return "signUp";
    }

}
