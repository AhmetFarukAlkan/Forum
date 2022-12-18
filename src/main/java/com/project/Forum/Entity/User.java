package com.project.Forum.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

import java.util.Date;

@Entity
@Table(name = "Users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@EqualsAndHashCode(of = {"email"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name",
            length = 100)
    private String Name;

    @Column(name = "Email",
            length = 100)
    private String email;

    @Column(name = "Create_Date")
    private Date CreateDate;

    @Column(name = "Status",
            //columnDefinition = "CHAR",
            length = 1)
    private String Status;

    @Column(name = "Photo", length = 250)
    private String Photo;

//    @ManyToOne
//    @JoinColumn(name = "Role")
//    private Role role;

}
