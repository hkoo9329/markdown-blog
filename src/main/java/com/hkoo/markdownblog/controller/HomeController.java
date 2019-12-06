package com.hkoo.markdownblog.controller;

import com.hkoo.markdownblog.annotation.Socialuser;
import com.hkoo.markdownblog.domain.User;
import com.hkoo.markdownblog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private BoardService boardService;

    @RequestMapping({"/","/home"})
    public String homePage(@PageableDefault Pageable pageable, @AuthenticationPrincipal User formUser, @Socialuser User socialUser, Model model){
        User user = formUser != null ? formUser : socialUser;
        model.addAttribute("user",user);
        model.addAttribute("boardList", boardService.findBoardList(pageable));
        return "home";
    }
}
