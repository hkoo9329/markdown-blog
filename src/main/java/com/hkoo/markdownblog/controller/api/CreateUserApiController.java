package com.hkoo.markdownblog.controller.api;

import com.hkoo.markdownblog.annotation.Socialuser;
import com.hkoo.markdownblog.domain.User;
import com.hkoo.markdownblog.repository.UserRepository;
import com.hkoo.markdownblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    @RequestMapping("/create/email")
    public void updateEmail(@RequestBody String email, @Socialuser User user){
        userService.updateUserEmail(email, user);
    }
    @GetMapping("/check/email")
    public boolean userEmailCheck(@Socialuser User socialUser, @AuthenticationPrincipal User FormUser){
        User user = FormUser != null ? FormUser : socialUser;
        boolean checker = (user.getEmail().equals("null"));
        return checker;
    }

}
