package com.project.Forum.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DislikeVUserId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "EntryID")
    private Entry EntryID;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User UserID;

}
