package com.project.Forum.Repo;

import com.project.Forum.Entity.Heading;
import com.project.Forum.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface HeadingRepository extends JpaRepository<Heading, Long> {
    @Query(value = "SELECT COUNT(*) FROM entryvheading WHERE headingid = :value", nativeQuery = true)
    int countByColumn(@Param("value") Long value);

    @Query(value = "SELECT headings.id FROM headings WHERE LOWER(headings.name) LIKE %:value%", nativeQuery = true)
//    @Query(value = "select headingid from headingvchannel join headings on headingvchannel.headingid=headings.headingid where headings.name LIKE :value", nativeQuery = true)
    ArrayList<Integer> getSearchByHeadings(@Param("value") String value);
}
