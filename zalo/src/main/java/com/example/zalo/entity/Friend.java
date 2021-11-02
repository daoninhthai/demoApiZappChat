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
@Table(name = "Friend")
public class Friend {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "user_A", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false, targetEntity = User.class)
    public User userA;

    @JoinColumn(name = "user_B", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false, targetEntity = User.class)
    public User userB;

    @Column(name ="created")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate created;

    @Column(name = "state")
    private String state;
}
