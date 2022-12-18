package com.project.Forum.Service.Impl;

import com.project.Forum.Dto.EntryDto;
import com.project.Forum.Entity.*;
import com.project.Forum.Repo.EntryRepository;
import com.project.Forum.Repo.EntryVHeadingRepository;
import com.project.Forum.Service.EntryService;
import com.project.Forum.Service.EntryVHeadingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntryVHeadingImpl implements EntryVHeadingService {

    private final EntryVHeadingRepository entryVHeadingRepository;

    private final EntryService entryService;


    public EntryVHeadingImpl(EntryVHeadingRepository headingRepository, EntryRepository entryRepository, EntryService entryService) {
        this.entryVHeadingRepository = headingRepository;
        this.entryService = entryService;
    }

    @Override
    public List<EntryDto> getEntries(long HeaderId) {
        List<EntryVHeading> entryVHeadings = entryVHeadingRepository.findAll()
                .stream().filter(eh -> eh.getEntryVHeadingId().getHeadingID().getId() == HeaderId)
                .collect(Collectors.toList());
        List<EntryDto> entryDtos = new ArrayList<>();

        for (EntryVHeading entryVHeading:entryVHeadings) {
            EntryDto entryDto = new EntryDto();
            entryDto.setId(entryVHeading.getEntryVHeadingId().getEntryID().getId());
            entryService.SetLikeAndDisLike(entryDto.getId());
            entryDto.setCreateDate(entryVHeading.getEntryVHeadingId().getEntryID().getCreateDate().toString());
            entryDto.setName(entryVHeading.getEntryVHeadingId().getEntryID().getName());
            entryDto.setCreateUser(entryVHeading.getEntryVHeadingId().getEntryID().getCreateUser().getName());
            entryDto.setCreateUserPhoto(entryVHeading.getEntryVHeadingId().getEntryID().getCreateUser().getPhoto());
            entryDto.setDislike(String.valueOf(entryVHeading.getEntryVHeadingId().getEntryID().getDislike()));
            entryDto.setLike(String.valueOf(entryVHeading.getEntryVHeadingId().getEntryID().getLike()));
            entryDtos.add(entryDto);
        }
        return entryDtos;
    }

    @Override
    public EntryVHeading Insert(Entry entry, Heading heading) {
        EntryVHeading entryVHeading = new EntryVHeading();
        EntryVHeadingId entryVHeadingId = new EntryVHeadingId();
        entryVHeadingId.setEntryID(entry);
        entryVHeadingId.setHeadingID(heading);
        entryVHeading.setEntryVHeadingId(entryVHeadingId);
        entryVHeadingRepository.save(entryVHeading);
        return entryVHeading;
    }
}
