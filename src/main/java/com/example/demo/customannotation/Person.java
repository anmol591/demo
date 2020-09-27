package com.example.demo.customannotation;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@JsonSerializable
public class Person {

    @JsonElement
    @NonNull
    private String firstName;

    @JsonElement
    @NonNull
    private String lastName;

    @JsonElement(key = "personAge")
    @NonNull
    private String age;

    @NonNull
    private String address;

    @Init
    private void initNames(){
        this.firstName = this.firstName.substring(0, 1).toUpperCase()
                + this.firstName.substring(1);
        this.lastName = this.lastName.substring(0, 1).toUpperCase()
                + this.lastName.substring(1);
    }

}
