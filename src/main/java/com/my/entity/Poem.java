package com.my.entity;

import lombok.Data;

@Data
public class Poem {
    private Long id;

    private String title;

    private Long author;

    private Byte type;
}