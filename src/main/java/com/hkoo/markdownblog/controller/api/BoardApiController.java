package com.hkoo.markdownblog.controller.api;

import com.hkoo.markdownblog.domain.Board;
import com.hkoo.markdownblog.domain.enums.BoardType;
import com.hkoo.markdownblog.repository.BoardRepository;
import com.hkoo.markdownblog.repository.ThumbnailRepository;
import com.hkoo.markdownblog.repository.UserRepository;
import com.hkoo.markdownblog.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.PagedResources.PageMetadata;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.Map;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Slf4j
@RestController
@RequestMapping("/api/boards")
public class BoardApiController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardService boardService;


    @PostMapping
    public ResponseEntity<?> postBoard(@RequestParam(value = "title") String title,
                                       @RequestParam(value = "content") String content,
                                       @RequestParam(value = "user") String userIdx,
                                       @RequestParam(value = "boardType") String boardType,
                                       @RequestParam(value = "thumbnail") MultipartFile multipartFile) throws Exception {
        Board board = Board.builder()
                .title(title)
                .content(content)
                .boardType(BoardType.valueOf(boardType))
                .user(userRepository.getOne(Long.valueOf(userIdx)))
                .build();
        boardService.insertBoard(board,multipartFile);
        return new ResponseEntity<>("{}", HttpStatus.CREATED);
    }

    @PostMapping("update/{idx}")
    public ResponseEntity<?> updateBoard(@PathVariable("idx") Long idx,
                                         @RequestParam(value = "title") String title,
                                         @RequestParam(value = "content") String content,
                                         @RequestParam(value = "boardType") String boardType,
                                         @RequestParam(value = "thumbnail") MultipartFile multipartFile) throws Exception {
        Board persistBoard = boardRepository.getOne(idx);
        Board board = Board.builder()
                .title(title)
                .content(content)
                .boardType(BoardType.valueOf(boardType))
                .build();
       boardService.updateBoard(persistBoard,board,multipartFile);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @DeleteMapping("/{idx}")
    public ResponseEntity<?> deleteBoard(@PathVariable("idx") Long idx) throws Exception {
        boardService.deleteBoard(boardRepository.getOne(idx));
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
}
