package com.hkoo.markdownblog.controller.api;

import com.hkoo.markdownblog.annotation.SocialUser;
import com.hkoo.markdownblog.domain.User;
import com.hkoo.markdownblog.repository.UserRepository;
import com.hkoo.markdownblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CreateUserApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/check/id")
    public boolean userIdExistsCheck(@RequestParam(value = "id") String id){
        User user = userRepository.findByEmail(id);
        if (user == null){
            return true;
        }else{
            return false;
        }
    }
    @RequestMapping("/create/user")
    public void signUpUser(@RequestBody Map<String,String> user){
        userService.signUpUser(user);
    }
    @RequestMapping("/check/email")
    public void updateEmail(@RequestBody String email, @SocialUser User user){
        userService.updateUserEmail(email, user);
    }

}
