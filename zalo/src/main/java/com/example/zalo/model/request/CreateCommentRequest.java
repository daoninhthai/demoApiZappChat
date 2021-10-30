package com.example.zalo.model.request;

import com.example.zalo.entity.Post;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCommentRequest {
    @ApiModelProperty(
            example="content",
            required=true
    )
    @JsonProperty("content")
    private String content;

    @ApiModelProperty(
            example="content",
            required=true
    )
    @JsonProperty("commentator_id")
    private  Integer commentatorId;

    @ApiModelProperty(
            example="1999-06-02T21:33:45.249967",
            required=true
    )
    @JsonProperty("updated")
    private LocalDate updated;

    @ApiModelProperty(
            example="content",
            required=true
    )
    @JsonProperty("comment_post")
    private Integer commentPost;
}
