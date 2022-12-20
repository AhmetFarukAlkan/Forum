package com.project.Forum.Service.Impl;

import com.project.Forum.Dto.HeadingDto;
import com.project.Forum.Entity.Channel;
import com.project.Forum.Entity.Heading;
import com.project.Forum.Entity.HeadingVChannel;
import com.project.Forum.Repo.HeadingRepository;
import com.project.Forum.Service.HeadingService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HeadingImpl implements HeadingService {

    private final HeadingRepository headingRepository;

    public HeadingImpl(HeadingRepository headingRepository) {
        this.headingRepository = headingRepository;
    }

    @Override
    public Heading Insert(Heading heading) {
        return headingRepository.save(heading);
    }

    @Override
    public List<Heading> GetHeadings() {

        for (Heading heading : headingRepository.findAll()){
            heading.setNumberEntry(headingRepository.countByColumn(heading.getId()));
            headingRepository.save(heading);
        }

        return headingRepository.findAll();
    }

    @Override
    public ArrayList<HeadingDto> getHeaderListById(ArrayList<Integer> idList){

        ArrayList<HeadingDto> headingDtos = new ArrayList<>();

        for (Integer integer : idList) {
            HeadingDto headingDto = new HeadingDto();
            Heading heading = getHeaderByID(integer);
            headingDto.setId(heading.getId());
            headingDto.setName(heading.getName());
            headingDto.setNameURL(heading.getName().replace(" ", "-").toLowerCase(Locale.ROOT));
            headingDto.setDescription(heading.getDescription());
            headingDto.setCreateUser(heading.getCreateUser().getName());
            headingDto.setCreateUserPhoto(heading.getCreateUser().getPhoto());
            headingDto.setCreateDate(heading.getCreateDate().toString());
            headingDto.setNumberReply(heading.getNumberEntry());
            headingDtos.add(headingDto);
        }

        return headingDtos;
    }

    @Override
    public Optional<Heading> getHeadingById(Long id) {
        return headingRepository.findById(id);
    }

    @Override
    public Heading getHeaderByName(String name) {
        return   headingRepository.findAll().stream()
                .filter(h -> h.getName().toLowerCase(Locale.ROOT).equals(name.replace("-", " ").toLowerCase()))
                .findFirst().orElse(null);
    }

    @Override
    public Heading getHeaderByID(int id) {
        return   headingRepository.findAll().stream()
                .filter(e -> Objects.equals(e.getId(), (long) id))
                .findFirst().orElse(null);
    }
}
