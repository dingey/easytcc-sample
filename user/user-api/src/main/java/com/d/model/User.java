package com.d.model;

import lombok.Data;

import javax.persistence.Id;

@Data
public class User {
    @Id
    private Long id;

    private Integer score;
}
