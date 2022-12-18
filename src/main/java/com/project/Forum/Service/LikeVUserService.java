package com.project.Forum.Service;

import com.project.Forum.Entity.Entry;
import com.project.Forum.Entity.LikeVUser;
import com.project.Forum.Entity.User;

public interface LikeVUserService {
    LikeVUser Insert(Entry entry, User user);
}
