package com.kpi.zaranik.template.controllers;

import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
        Person person = Person.builder("Bogdan", "Zaranik")
                .setEmail("email")
                .setAddress(new Address("Ukraine", "Fastov", "Fed'ko", "27"))
                .setDateOfBirth(LocalDate.of(2002, Month.JULY, 24))
                .build();


    }
}

