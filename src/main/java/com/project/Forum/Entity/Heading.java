package com.project.Forum.Entity;

import com.project.Forum.Repo.HeadingRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Headings")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Heading {

//    final private HeadingRepository headingRepository;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name",
            length = 100)
    private String Name;

    @Column(name = "Description", length = 500)
    private String Description;

    @Column(name = "Create_Date")
    private Date CreateDate;

    @Column(name = "Status",
//            columnDefinition = "CHAR",
            length = 1)
    private String Status;

    @Column(name = "NumberEntry")
    private int NumberEntry;

    @ManyToOne
    @JoinColumn(name = "Create_User")
    private User createUser;
//    @Column(name = "Create_User")
//    private Long createUser;

}
