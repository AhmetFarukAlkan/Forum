package com.project.Forum.Repo;

import com.project.Forum.Entity.Channel;
import com.project.Forum.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
