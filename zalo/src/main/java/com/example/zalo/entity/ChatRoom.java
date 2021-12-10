package com.example.zalo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "chat_room")
public class ChatRoom {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name ="chat_id")
    private String chatId;

    //    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    @Column(name ="sender_id")
    private String senderId;

    //    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "recipient_id", referencedColumnName = "id")
    @Column(name ="recipient_id")
    private String recipientId;
}