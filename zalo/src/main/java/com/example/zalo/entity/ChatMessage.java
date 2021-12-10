package com.example.zalo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "chat_message")
public class ChatMessage {

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

    @Column(name ="sender_name")
    private String senderName;

    @Column(name ="recipient_name")
    private String recipientName;

    @Column(name ="content")
    private String content;

    @Column(name ="time")
    private Date timestamp;

    @Column(name ="status")
    private MessageStatus status;

}
