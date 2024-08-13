package com.lrp.springboot.learn_spring_boot.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private LocalDate membershipDate;
}
