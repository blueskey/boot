package com.my.entity;

import lombok.Data;

@Data
public class PoemWithBLOBs extends Poem {
    private String content;

    private String annotation;

    private String appreciate;

}