package com.project.Forum.Controller;

import com.project.Forum.Repo.HeadingRepository;
import com.project.Forum.Service.HeadingService;
import com.project.Forum.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
//@RestController
public class Controller {

    private final UserService userService;

    private final HeadingService headingService;

    private final HeadingRepository headingRepository;


    @Autowired
    public Controller(UserService userService, HeadingService headingService, HeadingRepository headingRepository) {
        this.userService = userService;
        this.headingService = headingService;
        this.headingRepository = headingRepository;
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


    @GetMapping("/arama")
    public String Search(@RequestParam String input, Model model, @AuthenticationPrincipal OAuth2User user){
        System.out.println(input);

        if (user == null){
            model.addAttribute("user", "");
        }
        else {
            userService.ControlUser(user);
            model.addAttribute("user", user.getAttributes().get("name"));
        }
        try {
            model.addAttribute("headings", headingService.getHeaderListById(headingRepository.getSearchByHeadings(input.toLowerCase())));
        }catch (Exception exception){
            System.out.println("Search Error");
        }
//        headingRepository.getSearchByHeadings(input)

        return "search";
    }

}
