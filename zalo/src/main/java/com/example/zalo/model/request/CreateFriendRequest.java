package com.example.zalo.model.request;

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
public class CreateFriendRequest {


    @JsonProperty("userA_id")
    private Integer userA;

    @JsonProperty("userB_id")
    private Integer userB;

    @JsonProperty("created")
    private LocalDate created;

    @JsonProperty("state")
    private String state;
}
