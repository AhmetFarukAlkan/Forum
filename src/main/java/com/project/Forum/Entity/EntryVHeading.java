package com.project.Forum.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

import java.io.Serializable;

@Entity
@Table(name = "EntryVHeading")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EntryVHeading implements Serializable {
    @EmbeddedId
    private EntryVHeadingId entryVHeadingId;
}
