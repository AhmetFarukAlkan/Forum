package com.project.Forum.Service;

import com.project.Forum.Entity.Channel;
import com.project.Forum.Entity.Heading;

import java.util.List;
import java.util.Optional;

public interface HeadingService {
    Heading Insert(Heading heading);

    List<Heading> GetHeadings();

    Optional<Heading> getHeadingById(Long id);

    Heading getHeaderByName(String name);
}
