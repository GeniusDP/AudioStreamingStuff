package com.kpi.zaranik.template.controllers;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "set")
public class Person {
    private String firstName;
    private String secondName;
    private LocalDate dateOfBirth;
    private Address address;
    private String email;

    public static PersonBuilder builder(String firstName, String secondName){
        return new PersonBuilder().setFirstName(firstName).setSecondName(secondName);
    }
}
