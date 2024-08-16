package com.lrp.springboot.learn_spring_boot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @NotEmpty
    private String message;

    @JsonIgnore //We don't want it as part of response
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
