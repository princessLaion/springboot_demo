package com.lrp.springboot.learn_spring_boot.model;


import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonFilter("StudentRecordFilter")
public class StudentRecord {
    private String name;
    private String course;
    private String schoolYear;
}
