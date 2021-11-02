package com.example.zalo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FriendDTO {
    private Integer id;

    private Integer userA;// người gửi

    private Integer userB;// người nhận

    private LocalDate created;

    private String  state;
}
