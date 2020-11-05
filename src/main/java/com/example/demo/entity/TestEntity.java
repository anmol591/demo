package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@JsonIgnoreProperties(ignoreUnknown = true)
public class TestEntity{

//    @NotBlank(message = "checksum error")
//            @JsonProperty("checksum")
//    private String checksum;


    @JsonProperty("jwt")
    private String jwt;

    public TestEntity(){

    }

    public TestEntity(String jwt) {
        this.jwt = jwt;
    }

    @NotNull(message = "jwt can't be null")
    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
