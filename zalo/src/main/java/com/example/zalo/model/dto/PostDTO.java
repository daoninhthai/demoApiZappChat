package com.example.zalo.model.dto;



import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private Integer id;

    private String content;

    private String media;

    private LocalDate updated;

    private Integer author;

}
