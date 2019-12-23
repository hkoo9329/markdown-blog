package com.hkoo.markdownblog.repository;

import com.hkoo.markdownblog.domain.Board;
import com.hkoo.markdownblog.domain.Thumbnail;
import com.hkoo.markdownblog.domain.User;
import com.hkoo.markdownblog.domain.enums.BoardType;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {
    Board findByUser(User user);
    Page<Board> findAllByBoardType(BoardType boardType, Pageable pageable);
}
