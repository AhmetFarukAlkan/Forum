package com.project.Forum.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

import java.util.Date;

@Entity
@Table(name = "Entries")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name",
            length = 500)
    private String Name;

    @Column(name = "Create_Date")
    private Date CreateDate;

    @Column(name = "Status",
//            columnDefinition = "CHAR",
            length = 1)
    private String Status;

    @ManyToOne
    @JoinColumn(name = "Create_User")
    private User createUser;
//    @Column(name = "Create_User")
//    private Long createUser;

    @Column(name = "Likes")
    private int Like;

    @Column(name = "Dislikes")
    private int Dislike;
}
