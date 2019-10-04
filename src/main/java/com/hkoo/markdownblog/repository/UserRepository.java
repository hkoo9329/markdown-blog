package com.hkoo.markdownblog.repository;

import com.hkoo.markdownblog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
