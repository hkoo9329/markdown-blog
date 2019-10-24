package com.hkoo.markdownblog.repository;

import com.hkoo.markdownblog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
    User findByPrincipal(String principal);
}
