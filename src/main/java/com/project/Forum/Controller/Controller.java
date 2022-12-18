package com.project.Forum.Controller;

import com.project.Forum.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.parameters.P;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@org.springframework.stereotype.Controller
//@RestController
public class Controller {

    private final UserService userService;

    @Autowired
    public Controller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String main(Model model, @AuthenticationPrincipal OAuth2User user){

        if (user == null){
            model.addAttribute("user", "");
        }else{
            userService.ControlUser(user);
            model.addAttribute("user", user.getAttributes().get("name"));
        }
        return "index";
    }



}
