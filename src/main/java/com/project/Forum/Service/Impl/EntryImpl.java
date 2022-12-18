package com.project.Forum.Service.Impl;

import com.project.Forum.Entity.DislikeVUser;
import com.project.Forum.Entity.Entry;
import com.project.Forum.Entity.LikeVUser;
import com.project.Forum.Entity.User;
import com.project.Forum.Repo.DislikeVUserRespository;
import com.project.Forum.Repo.EntryRepository;
import com.project.Forum.Repo.LikeVUserRepository;
import com.project.Forum.Service.DislikeVUserService;
import com.project.Forum.Service.EntryService;
import com.project.Forum.Service.LikeVUserService;
import com.project.Forum.Service.UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EntryImpl implements EntryService {

    private final EntryRepository entryRepository;

    private final UserService userService;

    private final LikeVUserService likeVUserService;

    private final DislikeVUserService dislikeVUserService;

    private final LikeVUserRepository likeVUserRepository;

    private final DislikeVUserRespository dislikeVUserRespository;

    public EntryImpl(EntryRepository entryRepository, UserService userService, LikeVUserService likeVUserService, DislikeVUserService dislikeVUserService, LikeVUserRepository likeVUserRepository, DislikeVUserRespository dislikeVUserRespository) {
        this.entryRepository = entryRepository;
        this.userService = userService;
        this.likeVUserService = likeVUserService;
        this.dislikeVUserService = dislikeVUserService;
        this.likeVUserRepository = likeVUserRepository;
        this.dislikeVUserRespository = dislikeVUserRespository;
    }

    @Override
    public Entry Insert(Entry entry) {
        return entryRepository.save(entry);
    }

    @Override
    public List<Entry> GetEntry() {
        return entryRepository.findAll();
    }

    @Override
    public void SetLikeAndDisLike(Long id) {
        Entry entry = entryRepository.findAll().stream()
                .filter(e -> e.getId().equals(id))
                .findFirst().orElse(null);
        if (entry != null){
            entry.setLike(entryRepository.countLikeByColumn(id));
            entry.setDislike(entryRepository.countDislikeByColumn(id));
            Insert(entry);
        }
    }

    @Override
    public Entry getEntryById(Long id){
        return   entryRepository.findAll().stream()
                .filter(e -> Objects.equals(e.getId(), id))
                .findFirst().orElse(null);
    }

    @Override
    public void LikeEntry(Long id, OAuth2User user) {
        User Ouser = userService.ControlUser(user);

        try {
            LikeVUser likeVUser = likeVUserRepository.selectByEntryAndUser(id, Ouser.getId());
            likeVUserRepository.deleteLikeVUserByEntry(likeVUser.getLikeVUserId().getEntryID().getId(), Ouser.getId());
        }
        catch (Exception exception){
            likeVUserService.Insert(getEntryById(id), Ouser);
            System.out.println("BosSorguLike1");
        }

        try {
            DislikeVUser dislikeVUser = dislikeVUserRespository.selectByEntryAndUser(id, Ouser.getId());
            dislikeVUserRespository.deleteDislikeVUserByEntry(dislikeVUser.getDislikeVUserId().getEntryID().getId(), Ouser.getId());
        }catch (Exception exception){
            System.out.println("BosSorguLike2");
        }

    }

    @Override
    public void DislikeEntry(Long id, OAuth2User user) {
        User Ouser = userService.ControlUser(user);

        try {
            DislikeVUser dislikeVUser = dislikeVUserRespository.selectByEntryAndUser(id, Ouser.getId());
            dislikeVUserRespository.deleteDislikeVUserByEntry(dislikeVUser.getDislikeVUserId().getEntryID().getId(), Ouser.getId());
        }catch (Exception exception){
            System.out.println("BosSorguDislike1");
            dislikeVUserService.Insert(getEntryById(id), Ouser);
        }

        try {
            LikeVUser likeVUser = likeVUserRepository.selectByEntryAndUser(id, Ouser.getId());
            likeVUserRepository.deleteLikeVUserByEntry(likeVUser.getLikeVUserId().getEntryID().getId(), Ouser.getId());
        }
        catch (Exception exception){
            System.out.println("BosSorguDislike2");
        }
    }



}
