package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestEntity extends EntityBase{

    @NotBlank(message = "checksum error")
            @JsonProperty("checksum")
    private String checksum;


    @JsonProperty("jwt")
    private String jwt;
}
