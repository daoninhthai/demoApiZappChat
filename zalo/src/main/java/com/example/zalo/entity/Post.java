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
@Table(name = "post")
public class Post {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "content")
    private String content;

    @Column(name = "media")
    private String media;

    @Column(name ="updated")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate updated;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User author;


    @OneToMany(mappedBy = "commentPost" ,cascade = CascadeType.ALL)
    private  List<Comment> comment;


    @OneToMany(mappedBy = "likePost" ,cascade = CascadeType.ALL)
    private  List<Like> like;



}
