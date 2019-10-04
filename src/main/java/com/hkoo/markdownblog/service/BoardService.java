package com.hkoo.markdownblog.service;

import com.hkoo.markdownblog.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {
    Page<Board> findBoardList(Pageable pageable);
    Board findBoardByIdx(Long idx);
}
