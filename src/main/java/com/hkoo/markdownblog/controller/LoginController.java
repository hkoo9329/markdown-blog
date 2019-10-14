package com.hkoo.markdownblog.controller;

import com.hkoo.markdownblog.annotation.SocialUser;
import com.hkoo.markdownblog.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/loginSuccess")
    public String loginComplete(){
        return "redirect:/board/list";
    }
}
