package com.lrp.springboot.learn_spring_boot.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class User {
    private Integer id;

    @Size(min=2, message = "Name is Minimum of 2 characters required")
    @NotNull(message = "Name is required.")
    private String name;

    @Past(message = "Birth date should be in the past")
    @NotNull(message = "Birth date is required.")
    private LocalDate birthDate;
}
