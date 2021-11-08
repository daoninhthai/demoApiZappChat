package com.example.zalo.model.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlockDTO {

    public int id;

    public Integer userA;

    public Integer userB;

    private LocalDate created;

    private String state;

}
