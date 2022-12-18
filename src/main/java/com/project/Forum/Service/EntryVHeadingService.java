package com.project.Forum.Service;

import com.project.Forum.Dto.EntryDto;
import com.project.Forum.Dto.HeadingDto;
import com.project.Forum.Entity.*;

import java.util.List;

public interface EntryVHeadingService {
    List<EntryDto> getEntries(long HeaderId);

    EntryVHeading Insert(Entry entry, Heading heading);
}
