package com.project.Forum.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DislikeVUser")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DislikeVUser {
    @EmbeddedId
    private DislikeVUserId dislikeVUserId;
}
