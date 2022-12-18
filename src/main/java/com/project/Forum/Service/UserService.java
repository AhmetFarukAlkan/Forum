package com.project.Forum.Service;

import com.project.Forum.Entity.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User Insert(User user);

    List<User> GetUsers();

    Optional<User> getUserById(Long id);

    User ControlUser(OAuth2User user);

    User getUserByEmail(String mail);
}
