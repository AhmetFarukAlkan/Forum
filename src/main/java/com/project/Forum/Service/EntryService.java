package com.project.Forum.Service;

import com.project.Forum.Entity.Entry;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.List;
import java.util.Optional;

public interface EntryService {
    Entry Insert(Entry entry);

    List<Entry> GetEntry();

    Entry getEntryById(Long id);

    void SetLikeAndDisLike(Long id);

    void LikeEntry(Long id, OAuth2User user);

    void DislikeEntry(Long id, OAuth2User user);
}
