package com.project.Forum.Repo;

import com.project.Forum.Entity.DislikeVUser;
import com.project.Forum.Entity.DislikeVUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Nullable;

@Repository
public interface DislikeVUserRespository extends JpaRepository<DislikeVUser, DislikeVUserId> {
//    @Modifying(clearAutomatically = true)
    @Query(value = "SELECT * FROM dislikevuser WHERE entryid =:value1 and userid = :value2", nativeQuery = true)
    DislikeVUser selectByEntryAndUser(@Param("value1") Long value1, @Param("value2") Long value2);
//    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM dislikevuser WHERE entryid = :value", nativeQuery = true)
    void deleteDislikeVUserByEntry(@Param("value") Long value);
}
