package com.project.Forum.Controller;

import com.project.Forum.Dto.EntryDto;
import com.project.Forum.Entity.Entry;
import com.project.Forum.Entity.Heading;
import com.project.Forum.Repo.EntryRepository;
import com.project.Forum.Service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Controller
@RequestMapping(path = "/baslik")
public class HeadingController {

    private final UserService userService;
    private final HeadingService headingService;
    private final ChannelService channelService;
    private final EntryService entryService;
    private final HeadingVChannelService headingVChannelService;
    private final EntryVHeadingService entryVHeadingService;

    private final EntryRepository entryRepository;

    public HeadingController(HeadingService headingService, UserService userService, ChannelService channelService, EntryService entryService, HeadingVChannelService headingVChannelService, EntryVHeadingService entryVHeadingService, EntryRepository entryRepository) {
        this.headingService = headingService;
        this.userService = userService;
        this.channelService = channelService;
        this.entryService = entryService;
        this.headingVChannelService = headingVChannelService;
        this.entryVHeadingService = entryVHeadingService;
        this.entryRepository = entryRepository;
    }

    @GetMapping
    public String HeadingCont(){
        return "Headings";
    }

    @GetMapping("/get")
    public ResponseEntity<List<Heading>> GetHeading(){
        return ResponseEntity.ok(headingService.GetHeadings());
    }

    @GetMapping("get/{id}")
    public Optional<Heading> getHeadingById(@PathVariable("id") Long id){
        return headingService.getHeadingById(id);
    }

    @PostMapping({"/save"})
    public ResponseEntity<Heading> Insert(@RequestBody Heading heading){
        return ResponseEntity.ok(headingService.Insert(heading));
    }

    @GetMapping("/{header}")
    public String HeadingPage(@PathVariable("header") String header, Model model, @AuthenticationPrincipal OAuth2User user){
        Heading heading = headingService.getHeaderByName(header);
        List<EntryDto> entries = entryVHeadingService.getEntries(heading.getId());
        entries.sort((left, right) -> (int) (left.getId() - right.getId()));

        if (user == null){
            model.addAttribute("user", "");
        }
        else {
            userService.ControlUser(user);
            model.addAttribute("user", user.getAttributes().get("name"));
            model.addAttribute("LikeEntry", entryRepository.getLikeEntryByUser(userService.ControlUser(user).getId(), heading.getId()));
            model.addAttribute("DislikeEntry", entryRepository.getDislikeEntryByUser(userService.ControlUser(user).getId(), heading.getId()));
        }
        model.addAttribute("entry", new Entry());
        model.addAttribute("header", heading);
//        model.addAttribute("entries", entryVHeadingService.getEntries(heading.getId()));
        model.addAttribute("entries", entries);


        return "header";
    }

    @PostMapping("/yeni-baslik/channelname={channelName}")
    public String NewHeader(@PathVariable("channelName") String channelName, Heading header,  @AuthenticationPrincipal OAuth2User user){
        header.setCreateDate(new Date());
//        header.setCreateUser(user);
        header.setCreateUser(userService.ControlUser(user));
        header.setStatus("A");
        headingService.Insert(header);
        headingVChannelService.Insert(header, channelService.getChannelByName(channelName));

        Entry entry = new Entry();

        entry.setLike(0);
        entry.setDislike(0);
        entry.setCreateUser(header.getCreateUser());
        entry.setStatus(header.getStatus());
        entry.setCreateDate(header.getCreateDate());
        entry.setName(header.getDescription());

        entryService.Insert(entry);

        entryVHeadingService.Insert(entry, header);

        System.out.println(channelName);

        byte[] bytes = channelName.getBytes(StandardCharsets.UTF_8);

        String s = new String(bytes, StandardCharsets.UTF_8);

        System.out.println(s);

        return "redirect:/kanal/" + channelName;
    }
}
