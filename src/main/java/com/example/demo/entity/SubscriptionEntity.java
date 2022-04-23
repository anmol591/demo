package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SubscriptionEntity {
    private String mid;
    private String subsId;

    @NotBlank
    private String status;
}
