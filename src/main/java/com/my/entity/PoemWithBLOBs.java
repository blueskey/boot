package com.my.entity;

public class PoemWithBLOBs extends Poem {
    private byte[] content;

    private byte[] annotation;

    private byte[] appreciate;

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public byte[] getAnnotation() {
        return annotation;
    }

    public void setAnnotation(byte[] annotation) {
        this.annotation = annotation;
    }

    public byte[] getAppreciate() {
        return appreciate;
    }

    public void setAppreciate(byte[] appreciate) {
        this.appreciate = appreciate;
    }
}