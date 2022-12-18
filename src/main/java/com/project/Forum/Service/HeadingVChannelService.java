package com.project.Forum.Service;

import com.project.Forum.Dto.HeadingDto;
import com.project.Forum.Entity.Channel;
import com.project.Forum.Entity.Heading;
import com.project.Forum.Entity.HeadingVChannel;

import java.util.List;

public interface HeadingVChannelService {
    List<HeadingDto> getHeadings(long ChannelId);

    HeadingVChannel Insert(Heading heading, Channel channel);

}
