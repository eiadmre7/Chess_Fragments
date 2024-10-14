package com.example.fragments_with_chess;

public class Stone {
    private String name;
    private int img;

    public Stone(String name) {
        this.name = name;
    }

    public Stone() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}