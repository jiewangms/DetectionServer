package com.ms.opentech.beans;


import lombok.Getter;

public class Position {
    @Getter
    private final float x;
    @Getter
    private final float y;
    @Getter
    private final float length;
    @Getter
    private final float width;
    public Position(float x, float y, float width, float length) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.length = length;
    }

}
