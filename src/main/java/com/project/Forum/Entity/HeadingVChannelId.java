package com.project.Forum.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HeadingVChannelId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "HeadingID")
    private Heading HeadingID;

    @ManyToOne
    @JoinColumn(name = "ChannelID")
    private Channel ChannelID;

}
