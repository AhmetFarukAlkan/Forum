package com.project.Forum.Service;

import com.project.Forum.Entity.Channel;

import java.util.List;
import java.util.Optional;

public interface ChannelService {
    Channel Insert(Channel channel);

    List<Channel> GetChannel();

    Optional<Channel> getChannelById(Long id);

    Channel getChannelByName(String name);
}
