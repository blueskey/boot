package com.my.entity;

public class Author {
    private Long id;

    private String name;

    private String dynasty;

    private byte[] introduction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty == null ? null : dynasty.trim();
    }

    public byte[] getIntroduction() {
        return introduction;
    }

    public void setIntroduction(byte[] introduction) {
        this.introduction = introduction;
    }
}