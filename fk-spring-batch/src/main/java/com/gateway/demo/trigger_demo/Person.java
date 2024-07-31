package com.gateway.demo.trigger_demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer status;
    private LocalDateTime gmtTime;
}
