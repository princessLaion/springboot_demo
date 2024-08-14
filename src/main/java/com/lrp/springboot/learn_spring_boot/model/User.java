package com.lrp.springboot.learn_spring_boot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity(name = "user_details")
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=2, message = "Name is Minimum of 2 characters required")
    @NotNull(message = "Name is required.")
    @JsonProperty("user_name")
    private String name;

    @Past(message = "Birth date should be in the past")
    @NotNull(message = "Birth date is required.")
    private LocalDate birthDate;

    @JsonIgnore
    //Can also specify the fields on class label using JsonIgnoreProperties at class level and specifying the field names.
    private String confidentialData;
}
