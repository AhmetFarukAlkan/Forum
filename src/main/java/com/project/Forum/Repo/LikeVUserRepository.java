package com.project.Forum.Repo;

import com.project.Forum.Entity.LikeVUser;
import com.project.Forum.Entity.LikeVUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Nullable;

@Repository
public interface LikeVUserRepository extends JpaRepository<LikeVUser, LikeVUserId> {

//    @Modifying(clearAutomatically = true)
    @Query(value = "SELECT * FROM likevuser WHERE entryid = :value1 and userid = :value2", nativeQuery = true)
    LikeVUser selectByEntryAndUser(@Param("value1") Long value1, @Param("value2") Long value2);

    @Query(value = "DELETE FROM likevuser WHERE entryid = :value and userid = :value2", nativeQuery = true)
    void deleteLikeVUserByEntry(@Param("value") Long value, @Param("value2") Long value2);
}
