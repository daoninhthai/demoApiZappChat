package com.example.zalo.model.request;

import com.example.zalo.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

public class CreatePostRequest {
    @ApiModelProperty(
            example="content",
            required=true
    )
    @JsonProperty("content")
    private String content;

    @ApiModelProperty(
            example="123456",
            required=true
    )
    @JsonProperty("media")
    private String media;


    @ApiModelProperty(
            example="1999-06-02T21:33:45.249967",
            required=true
    )
    @JsonProperty("updated")
    private LocalDate updated;



}
