package com.project.Forum.Service.Impl;

import com.project.Forum.Entity.Channel;
import com.project.Forum.Repo.ChannelRepository;
import com.project.Forum.Service.ChannelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ChannelImpl implements ChannelService {

    private final ChannelRepository channelRepository;

    public ChannelImpl(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    @Override
    public Channel Insert(Channel channel) {
        return channelRepository.save(channel);
    }

    @Override
    public List<Channel> GetChannel() {
        return channelRepository.findAll();
    }

    @Override
    public Optional<Channel> getChannelById(Long id) {
        return channelRepository.findById(id);
    }

    @Override
    public Channel getChannelByName(String name){
        return   channelRepository.findAll().stream()
                .filter(c -> c.getName().toLowerCase(Locale.ROOT).equals(name.replace("-", " ").toLowerCase()))
                .findFirst().orElse(null);
    }
}
