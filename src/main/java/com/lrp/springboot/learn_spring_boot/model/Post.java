package com.lrp.springboot.learn_spring_boot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    private String message;

    @JsonIgnore //We don't want it as part of response
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
