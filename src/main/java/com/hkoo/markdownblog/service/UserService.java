package com.hkoo.markdownblog.service;

import com.hkoo.markdownblog.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Map;

public interface UserService extends UserDetailsService {
    void signUpUser(Map<String,String> userInfo);
    void updateUserEmail(String email, User user);
}
