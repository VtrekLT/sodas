package com.example.bakis;

public class Plant {
    private String name;
    private String type;
    private int persquare;

    public Plant() {
        //empty constructor needed
    }

    public Plant(String name, String type, int persquare) {
        this.name = name;
        this.type = type;
        this.persquare = persquare;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPersquare() {
        return persquare;
    }
}
