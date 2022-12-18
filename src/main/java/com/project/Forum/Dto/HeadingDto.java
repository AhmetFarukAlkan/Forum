package com.project.Forum.Dto;

import lombok.Data;

@Data
public class HeadingDto {
    Long id;
    String name;
    String nameURL;
    String description;
    String createUser;
    String createUserPhoto;
    String createDate;
    int numberReply;
}
