package com.project.Forum.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EntryVHeadingId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "EntryID")
    private Entry EntryID;

    @ManyToOne
    @JoinColumn(name = "HeadingID")
    private Heading HeadingID;

}
