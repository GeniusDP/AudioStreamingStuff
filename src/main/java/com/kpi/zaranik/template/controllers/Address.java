package com.kpi.zaranik.template.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    private String country;
    private String cityOrVillage;
    private String street;
    private String houseNumber;
}
