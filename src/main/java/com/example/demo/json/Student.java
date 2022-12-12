package com.example.demo.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class Student {
    @JsonProperty("Name")
    private String name;

    @JsonProperty("Age")
    private int age;

    @JsonProperty("Address")
    private String address;
}
