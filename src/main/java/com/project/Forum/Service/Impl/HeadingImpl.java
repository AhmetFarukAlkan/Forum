package com.project.Forum.Service.Impl;

import com.project.Forum.Entity.Channel;
import com.project.Forum.Entity.Heading;
import com.project.Forum.Repo.HeadingRepository;
import com.project.Forum.Service.HeadingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

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
    public Optional<Heading> getHeadingById(Long id) {
        return headingRepository.findById(id);
    }

    @Override
    public Heading getHeaderByName(String name) {
        return   headingRepository.findAll().stream()
                .filter(h -> h.getName().toLowerCase(Locale.ROOT).equals(name.replace("-", " ").toLowerCase()))
                .findFirst().orElse(null);
    }
}
