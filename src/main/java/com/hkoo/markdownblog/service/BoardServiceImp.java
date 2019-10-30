package com.hkoo.markdownblog.service;

import com.hkoo.markdownblog.commons.FileUtils;
import com.hkoo.markdownblog.domain.Board;
import com.hkoo.markdownblog.domain.Thumbnail;
import com.hkoo.markdownblog.repository.BoardRepository;
import com.hkoo.markdownblog.repository.ThumbnailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Lob;

@Slf4j
@Service
public class BoardServiceImp implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private FileUtils fileUtils;

    @Autowired
    private ThumbnailRepository thumbnailRepository;

    @Override
    public void insertBoard(Board board, MultipartFile multipartFile) throws Exception {
        board.setCreatedDateNow();
        boardRepository.save(board);
        if (multipartFile.isEmpty() == false){
            Thumbnail thumbnail = fileUtils.parseFileInfo(board.getIdx(), multipartFile); // 썸네일 파일 생성 및 썸네일 객체 생성
            thumbnailRepository.save(thumbnail);
            board.setThumbnail(thumbnail);
            boardRepository.save(board);
        }
    }

    @Override
    public void updateBoard(Board persistBoard, Board newBoard, MultipartFile multipartFile) throws Exception {
        if (multipartFile.isEmpty() == false){
            Thumbnail thumbnail = fileUtils.parseFileInfo(persistBoard.getIdx(), multipartFile);
            thumbnailRepository.save(thumbnail);
            persistBoard.setThumbnail(thumbnail);
        }
        persistBoard.update(newBoard);
        persistBoard.updateDateTime();
        boardRepository.save(persistBoard);
    }

    @Override
    public void deleteBoard(Board board) throws Exception {
        Long id = board.getThumbnail().getIdx();
        boardRepository.delete(board);
        thumbnailRepository.deleteById(id);
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

    public void oldThumbnailDelete(Thumbnail thumbnail){
        
    }
}
