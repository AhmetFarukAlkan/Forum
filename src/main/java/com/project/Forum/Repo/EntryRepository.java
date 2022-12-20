package com.project.Forum.Repo;

import com.project.Forum.Entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {
    @Query(value = "SELECT COUNT(*) FROM likevuser WHERE entryid = :value", nativeQuery = true)
    int countLikeByColumn(@Param("value") Long value);

    @Query(value = "SELECT COUNT(*) FROM dislikevuser WHERE entryid = :value", nativeQuery = true)
    int countDislikeByColumn(@Param("value") Long value);

    @Query(value = "select entryvheading.entryid from likevuser join entryvheading on likevuser.entryid=entryvheading.entryid where likevuser.userid =:value and entryvheading.headingid =:value2", nativeQuery = true)
    ArrayList<Integer> getLikeEntryByUser(@Param("value") Long value, @Param("value2") Long value2);

    @Query(value = "select entryvheading.entryid from dislikevuser join entryvheading on dislikevuser.entryid=entryvheading.entryid where dislikevuser.userid =:value and entryvheading.headingid =:value2", nativeQuery = true)
    ArrayList<Integer> getDislikeEntryByUser(@Param("value") Long value, @Param("value2") Long value2);

}
