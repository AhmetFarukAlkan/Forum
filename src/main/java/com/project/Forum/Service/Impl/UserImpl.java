package com.project.Forum.Service.Impl;

import com.project.Forum.Entity.User;
import com.project.Forum.Repo.UserRepository;
import com.project.Forum.Service.UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserImpl implements UserService {

    private final UserRepository userRepository;

    public UserImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User Insert(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> GetUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User ControlUser(OAuth2User user){
        User user1 = getUserByEmail((String) user.getAttributes().get("email"));
        if (user1==null){
            user1.setEmail((String) user.getAttributes().get("email"));
            user1.setName((String) user.getAttributes().get("name"));
//            Role role = roleRepository.getReferenceById("USER");
            user1.setCreateDate(new Date());
//            user1.setUser_role(role);
            user1.setStatus("A");
//            user1.setCreate_User("1");
            user1.setPhoto((String) user.getAttributes().get("picture"));
            user1 = userRepository.save(user1);
            return user1;
        }else{
            user1.setPhoto((String) user.getAttributes().get("picture"));
            userRepository.save(user1);
            return user1;
        }
    }
    @Override
    public User getUserByEmail(String mail){
        return   userRepository.findAll().stream()
                .filter(u -> u.getEmail().equals(mail))
                .findFirst().orElse(null);
    }

}
