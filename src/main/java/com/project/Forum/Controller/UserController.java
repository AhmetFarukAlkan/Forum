package com.project.Forum.Controller;

import com.project.Forum.Entity.User;
import com.project.Forum.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<User>> GetUsers(){
        return ResponseEntity.ok(userService.GetUsers());
    }

    @GetMapping("/get/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @PostMapping({"/save"})
    public ResponseEntity<User> Insert(@RequestBody User user){
        return ResponseEntity.ok(userService.Insert(user));
    }

    @GetMapping("/get/active-user")
    public Principal getActiveUser(Principal principal){
        return principal;
    }

//    public String LoginProcesses(@AuthenticationPrincipal OAuth2User user, HttpServletRequest request){
////        System.out.println("\n\n*****************************************\n\n");
//        String referer = request.getHeader("Referer");
//        userService.ControlUser(user);
//        return "redirect:" + referer;
//    }
}
