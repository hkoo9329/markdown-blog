package com.hkoo.markdownblog.service;

import com.hkoo.markdownblog.domain.User;
import com.hkoo.markdownblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Map;

public class UserServiceIml implements UserService{

    @Autowired
    private UserRepository userRepository;

    // 비밀번호 암호화 , 해당 Bean은 SecurityConfig에 있음
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void signUpUser(Map<String, String> userInfo) {
        User user = User.builder()
                .name(userInfo.get("name"))
                .email(userInfo.get("email"))
                .password(bCryptPasswordEncoder.encode(userInfo.get("password")))//비밀번호를 암호화해서 저장
                .build();
        userRepository.save(user);
    }

    @Override
    public void updateUserEmail(String email, User user) {
        user.setEmail(email);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null){
            throw new UsernameNotFoundException("can not find user");
        }
        return user;
    }
}
