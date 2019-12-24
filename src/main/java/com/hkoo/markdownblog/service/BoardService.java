package com.hkoo.markdownblog.service;

import com.hkoo.markdownblog.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface BoardService {
    void insertBoard(Board board, MultipartFile multipartFile) throws Exception;
    void updateBoard(Board persistBoard, Board newBoard, MultipartFile multipartFile) throws Exception;
    void deleteBoard(Board board) throws Exception;
    Page<Board> findBoardList(Pageable pageable, String boardType);
    Board findBoardByIdx(Long idx);
}
