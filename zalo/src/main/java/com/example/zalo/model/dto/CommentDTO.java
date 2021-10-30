package com.example.zalo.model.dto;

import com.example.zalo.entity.Post;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {

    private Integer id;


    private  Integer commentatorId;


    private String content;


    private LocalDate updated;


    private Integer postId;
}
