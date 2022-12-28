package com.project.Forum.Controller;

import com.project.Forum.Entity.Entry;
import com.project.Forum.Service.EntryService;
import com.project.Forum.Service.EntryVHeadingService;
import com.project.Forum.Service.HeadingService;
import com.project.Forum.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/entries")
public class EntryController {
    private final EntryService entryService;

    private final UserService userService;

    private final EntryVHeadingService entryVHeadingService;

    private final HeadingService headingService;

    public EntryController(EntryService entryService, UserService userService, EntryVHeadingService entryVHeadingService, HeadingService headingService) {
        this.entryService = entryService;
        this.userService = userService;
        this.entryVHeadingService = entryVHeadingService;
        this.headingService = headingService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<Entry>> GetEntries(){
        return ResponseEntity.ok(entryService.GetEntry());
    }

//    @GetMapping("/get/{id}")
//    public Optional<Entry> getEntryById(@PathVariable("id") Long id){
//        return entryService.getEntryById(id);
//    }

    @PostMapping({"/new-entry"})
    public ResponseEntity<Entry> Insert(@RequestParam("entryName") String entryName, @RequestParam("header") String heading, @AuthenticationPrincipal OAuth2User user) throws UnsupportedEncodingException {
        Entry entry = new Entry();
        entry.setName(entryName);
        entry.setStatus("A");
        entry.setDislike(0);
        entry.setLike(0);
        entry.setCreateDate(new Date());
        entry.setCreateUser(userService.ControlUser(user));
        entry = entryService.Insert(entry);
        entryVHeadingService.Insert(entry, headingService.getHeaderByName(heading));

        return ResponseEntity.ok(entryService.Insert(entry));
    }

    @PostMapping("/like")
    public ResponseEntity<Entry> Like(@RequestParam("id") String id, @AuthenticationPrincipal OAuth2User user){
        entryService.LikeEntry(Long.valueOf(id), user);
        return null;
    }

    @PostMapping("/dislike")
    public ResponseEntity<Entry> Dislike(@RequestParam("id") String id, @AuthenticationPrincipal OAuth2User user){
        entryService.DislikeEntry(Long.valueOf(id), user);
        return null;
    }
}
