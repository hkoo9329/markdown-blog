package com.hkoo.markdownblog.controller;

import com.hkoo.markdownblog.annotation.Socialuser;
import com.hkoo.markdownblog.domain.User;
import com.hkoo.markdownblog.domain.enums.BoardType;
import com.hkoo.markdownblog.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class HomeController {

    @Autowired
    private BoardService boardService;

    @RequestMapping({"/","/home"})
    public String homePage(@PageableDefault Pageable pageable, @AuthenticationPrincipal User formUser,
                           @Socialuser User socialUser, Model model){
        User user = formUser != null ? formUser : socialUser;
        model.addAttribute("user",user);
        model.addAttribute("boardTypeMessage",BoardType.notice.getValue());
        model.addAttribute("boardList", boardService.findBoardList(pageable, "notice"));
        return "home";
    }
    @RequestMapping({"/home/{boardtype}"})
    public String homePage(@PageableDefault Pageable pageable, @AuthenticationPrincipal User formUser,
                           @Socialuser User socialUser, @PathVariable("boardtype") String boardType, Model model){
        User user = formUser != null ? formUser : socialUser;
        model.addAttribute("user",user);
        model.addAttribute("boardTypeMessage", BoardType.valueOf(boardType).getValue());
        model.addAttribute("boardList", boardService.findBoardList(pageable, boardType));
        return "home";
    }
}
