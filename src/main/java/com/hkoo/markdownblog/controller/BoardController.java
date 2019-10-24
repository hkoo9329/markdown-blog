package com.hkoo.markdownblog.controller;

import com.hkoo.markdownblog.annotation.Socialuser;
import com.hkoo.markdownblog.domain.User;
import com.hkoo.markdownblog.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/page")
    public String board(@RequestParam(value = "idx", defaultValue = "0") Long idx,
                        Model model) {
        model.addAttribute("board", boardService.findBoardByIdx(idx));
        return "/board/form";
    }

    @GetMapping("/list")
    public String list(@PageableDefault Pageable pageable, @AuthenticationPrincipal User formUser, @Socialuser User socialUser, Model model) {
        model.addAttribute("boardList", boardService.findBoardList(pageable));
        User user = formUser != null ? formUser : socialUser;
        log.info("user : " + user.getIdx());
        return "/board/list";
    }
}
