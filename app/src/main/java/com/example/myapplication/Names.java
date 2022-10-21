package com.example.myapplication;

import java.io.Serializable;

public class Names implements Serializable {
    private String name;
    private String title;
    private Integer img;

    public Names(String name, String title, Integer img) {
        this.name = name;
        this.title = title;
        this.img = img;
    }

    public Names() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Names{" +
                "name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", img=" + img +
                '}';
    }
}
