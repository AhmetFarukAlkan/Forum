package com.project.Forum.Dto;

import lombok.Data;

@Data
public class EntryDto {
    Long id;
    String name;
    String description;
    String createUser;
    String createUserPhoto;
    String createDate;
    int numberReply;
    String like;
    String dislike;
}
