package com.hkoo.markdownblog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class LoginController {

    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/loginSuccess")
    public String loginComplete(){
        return "redirect:/home";
    }

    @RequestMapping("/signUp")
    public String signUpUser(){
        return "signUp";
    }

    @RequestMapping("/loginFail")
    public String loginFail(){
        return "redirect:/login";
    }

}
