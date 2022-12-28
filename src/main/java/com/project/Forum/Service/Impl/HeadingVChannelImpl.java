package com.project.Forum.Service.Impl;

import com.project.Forum.Dto.HeadingDto;
import com.project.Forum.Entity.Channel;
import com.project.Forum.Entity.Heading;
import com.project.Forum.Entity.HeadingVChannel;
import com.project.Forum.Entity.HeadingVChannelId;
import com.project.Forum.Repo.HeadingVChannelRepository;
import com.project.Forum.Service.HeadingVChannelService;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class HeadingVChannelImpl implements HeadingVChannelService {

    private final HeadingVChannelRepository headingVChannelRepository;

    public HeadingVChannelImpl(HeadingVChannelRepository headingVChannelRepository) {
        this.headingVChannelRepository = headingVChannelRepository;
    }

    @Override
    public List<HeadingDto> getHeadings(long ChannelId) {
        List<HeadingVChannel> headingVChannelList = headingVChannelRepository.findAll()
                .stream().filter(hc -> hc.getId().getChannelID().getId() == ChannelId)
                .collect(Collectors.toList());
//                .findFirst().orElse(null)
        List<HeadingDto> headingDtos = new ArrayList<>();

        for (HeadingVChannel headingVChannel: headingVChannelList) {
            HeadingDto headingDto = new HeadingDto();
            headingDto.setId(headingVChannel.getId().getHeadingID().getId());
            headingDto.setName(headingVChannel.getId().getHeadingID().getName());
            headingDto.setNameURL(headingVChannel.getId().getHeadingID().getName().replaceAll("[.,?]", "").trim().replace(" ", "-").toLowerCase(Locale.ROOT));
            byte[] bytes = headingDto.getNameURL().getBytes(StandardCharsets.UTF_8);
            String headerName = new String(bytes, StandardCharsets.UTF_8);
//            System.out.println(headerName.replaceAll("[.,?]", "").trim().replace(" ", "-").toLowerCase(Locale.ROOT));

            headingDto.setDescription(headingVChannel.getId().getHeadingID().getDescription());
            headingDto.setCreateUser(headingVChannel.getId().getHeadingID().getCreateUser().getName());
            headingDto.setCreateUserPhoto(headingVChannel.getId().getHeadingID().getCreateUser().getPhoto());
            headingDto.setCreateDate(headingVChannel.getId().getHeadingID().getCreateDate().toString());
            headingDto.setNumberReply(headingVChannel.getId().getHeadingID().getNumberEntry());
            headingDtos.add(headingDto);
        }

        return headingDtos;
    }

    @Override
    public HeadingVChannel Insert(Heading heading, Channel channel) {
        HeadingVChannel headingVChannel = new HeadingVChannel();
        HeadingVChannelId headingVChannelId = new HeadingVChannelId();
        headingVChannelId.setChannelID(channel);
        headingVChannelId.setHeadingID(heading);
        headingVChannel.setId(headingVChannelId);
        headingVChannelRepository.save(headingVChannel);
        return headingVChannel;
    }
}
