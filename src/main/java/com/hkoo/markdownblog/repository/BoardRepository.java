package com.hkoo.markdownblog.repository;

import com.hkoo.markdownblog.domain.Board;
import com.hkoo.markdownblog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {
    Board findByUser(User user);
}
