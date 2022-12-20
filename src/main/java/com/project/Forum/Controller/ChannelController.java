package com.project.Forum.Controller;

import com.project.Forum.Entity.Channel;
import com.project.Forum.Entity.Heading;
import com.project.Forum.Entity.User;
import com.project.Forum.Repo.HeadingRepository;
import com.project.Forum.Service.ChannelService;
import com.project.Forum.Service.HeadingService;
import com.project.Forum.Service.HeadingVChannelService;
import com.project.Forum.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/kanal")
public class ChannelController {

    private final ChannelService channelService;

    private final UserService userService;

    private final HeadingVChannelService headingVChannelService;

    private final HeadingService headingService;

    public ChannelController(ChannelService headingService, UserService userService, HeadingVChannelService headingVChannelService, HeadingService headingService1, HeadingRepository headingRepository) {
        this.channelService = headingService;
        this.userService = userService;
        this.headingVChannelService = headingVChannelService;
        this.headingService = headingService1;
    }

    @GetMapping
    public String ChannelCont(){
        return "Channels";
    }

    @GetMapping("/get")
    public ResponseEntity<List<Channel>> GetChannels(){
        return ResponseEntity.ok(channelService.GetChannel());
    }

    @GetMapping("get/{id}")
    public Optional<Channel> getChannelById(@PathVariable("id") Long id){
        return channelService.getChannelById(id);
    }

    @PostMapping({"/save"})
    public ResponseEntity<Channel> Insert(@RequestBody Channel channel){
        return ResponseEntity.ok(channelService.Insert(channel));
    }

    @GetMapping("/{category}")
    public String CategoryPage(@PathVariable("category") String category, Model model, @AuthenticationPrincipal OAuth2User user){
        Channel channel = channelService.getChannelByName(category);
        headingService.GetHeadings();
        if (user == null){
            model.addAttribute("user", "");
        }
        else {
            userService.ControlUser(user);
            model.addAttribute("user", user.getAttributes().get("name"));
        }
        model.addAttribute("channel", channel);
        model.addAttribute("headings", headingVChannelService.getHeadings(channel.getId()));

        return "category";
    }

    @GetMapping("/{channel}/yeni-baslik")
    public String NewHeader(@PathVariable("channel") String channelName,  Model model, @AuthenticationPrincipal OAuth2User user){

        Channel channel = channelService.getChannelByName(channelName);

        if (user == null){
            model.addAttribute("user", new User());
        }
        else {
            userService.ControlUser(user);
//          user.getAttributes().get("name")
            model.addAttribute("user", userService.ControlUser(user));
        }

        model.addAttribute("channel", channel);
        model.addAttribute("header", new Heading());

        return "newWriting";
    }



}
