package com.project.Forum.Service.Impl;

import com.project.Forum.Entity.*;
import com.project.Forum.Repo.LikeVUserRepository;
import com.project.Forum.Service.LikeVUserService;
import org.springframework.stereotype.Service;

@Service
public class LikeVUserImpl implements LikeVUserService {

    private final LikeVUserRepository likeVUserRepository;

    public LikeVUserImpl(LikeVUserRepository likeVUserRepository) {
        this.likeVUserRepository = likeVUserRepository;
    }

    @Override
    public LikeVUser Insert(Entry entry, User user) {
        LikeVUser likeVUser = new LikeVUser();
        LikeVUserId likeVUserId = new LikeVUserId();
        likeVUserId.setEntryID(entry);
        likeVUserId.setUserID(user);
        likeVUser.setLikeVUserId(likeVUserId);
        likeVUserRepository.save(likeVUser);
        return likeVUser;
    }
}
