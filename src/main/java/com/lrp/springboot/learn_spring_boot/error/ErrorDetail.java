package com.lrp.springboot.learn_spring_boot.error;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
public class ErrorDetail {
    private LocalDateTime localDateTime;
    private String message;
    private String description;
}
