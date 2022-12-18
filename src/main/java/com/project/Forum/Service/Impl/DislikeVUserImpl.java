package com.project.Forum.Service.Impl;

import com.project.Forum.Entity.*;
import com.project.Forum.Repo.DislikeVUserRespository;
import com.project.Forum.Service.DislikeVUserService;
import org.springframework.stereotype.Service;

@Service
public class DislikeVUserImpl implements DislikeVUserService {

    private final DislikeVUserRespository dislikeVUserRespository;

    public DislikeVUserImpl(DislikeVUserRespository entryVHeading) {
        this.dislikeVUserRespository = entryVHeading;
    }

    @Override
    public DislikeVUser Insert(Entry entry, User user) {
        DislikeVUser dislikeVUser = new DislikeVUser();
        DislikeVUserId dislikeVUserId = new DislikeVUserId();
        dislikeVUserId.setEntryID(entry);
        dislikeVUserId.setUserID(user);
        dislikeVUser.setDislikeVUserId(dislikeVUserId);
        dislikeVUserRespository.save(dislikeVUser);
        return dislikeVUser;
    }
}
