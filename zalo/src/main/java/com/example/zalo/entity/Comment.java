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
@Table(name = "comment")
public class Comment {

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "commentator_id")
    private  Integer commentatorId;

    @Column(name = "content")
    private String content;

    @Column(name ="updated")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate updated;


    @Column(name ="post_id")
    private Integer postId;


}
