package com.hkoo.markdownblog.service;

import com.hkoo.markdownblog.domain.Board;
import com.hkoo.markdownblog.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
@Service
public class BoardServiceImp implements BoardService{

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public Page<Board> findBoardList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() -1 ,
                pageable.getPageSize());
        return boardRepository.findAll(pageable);
    }

    @Override
    public Board findBoardByIdx(Long idx) {
        return boardRepository.findById(idx).orElse(new Board());
    }
}
