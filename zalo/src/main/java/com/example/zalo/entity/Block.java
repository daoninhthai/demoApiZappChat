package com.example.zalo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "block")
public class Block {

    @Id
    @Column(name ="bid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;



    @JoinColumn(name = "user_a", nullable = false, updatable = false)
    @ManyToOne(optional = false)
    public User userA;

    @JoinColumn(name = "user_b", nullable = false, updatable = false)
    @ManyToOne(optional = false)
    public User userB;


    @Column(name ="created")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDate created;

    @Column(name = "state")
    private String state;



}
