package com.hkoo.markdownblog.service;

import com.hkoo.markdownblog.commons.FileUtils;
import com.hkoo.markdownblog.domain.Board;
import com.hkoo.markdownblog.domain.Thumbnail;
import com.hkoo.markdownblog.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BoardServiceImp implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private FileUtils fileUtils;

    @Override
    public void insertBoard(Board board, MultipartFile multipartFile) throws Exception{
        Thumbnail thumbnail = fileUtils.parseFileInfo(board.getIdx(), multipartFile);
        board.setThumbnail(thumbnail);
        board.setCreatedDateNow();
        boardRepository.save(board);
    }

    @Override
    public void updateBoard(Board persistBoard, Board newBoard, MultipartFile multipartFile) throws Exception {
        Thumbnail thumbnail = fileUtils.parseFileInfo(persistBoard.getIdx(), multipartFile);
        persistBoard.update(newBoard);
        persistBoard.setThumbnail(thumbnail);
        boardRepository.save(persistBoard);
    }

    @Override
    public Page<Board> findBoardList(Pageable pageable) {
        if (pageable.getSort().isUnsorted()) {
            pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                    pageable.getPageSize(), Sort.by(Sort.Direction.DESC, "idx"));
        }
        return boardRepository.findAll(pageable);
    }

    @Override
    public Board findBoardByIdx(Long idx) {
        return boardRepository.findById(idx).orElse(new Board());
    }
}
