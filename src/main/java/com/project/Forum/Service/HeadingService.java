package com.project.Forum.Service;

import com.project.Forum.Dto.HeadingDto;
import com.project.Forum.Entity.Channel;
import com.project.Forum.Entity.Heading;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface HeadingService {
    Heading Insert(Heading heading);

    List<Heading> GetHeadings();

    Optional<Heading> getHeadingById(Long id);

    Heading getHeaderByName(String name) throws UnsupportedEncodingException;

    ArrayList<HeadingDto> getHeaderListById(ArrayList<Integer> idList);
    Heading getHeaderByID(int id);
}
