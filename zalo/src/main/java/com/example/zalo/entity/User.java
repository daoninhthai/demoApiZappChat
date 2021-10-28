package com.example.zalo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name ="first_name", nullable = false)
    private String firstName;

    @Column(name ="last_name", nullable = false)
    private String lastName;

    @Column(name ="dob")
//    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dob;

    @Column(name ="gender")
    private String gender;

    @Column(name ="joined_date")
//    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate joinedDate;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name ="status" )
    private String status;


    @OneToOne(mappedBy = "user" ,cascade = CascadeType.ALL)
    private Authority authority;

    @Column(name = "link_avatar")
    private String linkAvatar;


    @OneToMany(mappedBy = "author" ,cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Post> posts;



}
