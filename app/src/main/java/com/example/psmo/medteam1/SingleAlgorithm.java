package com.example.psmo.medteam1;

/**
 * Created by Konrad on 01.12.2016.
 */

public class SingleAlgorithm {
    private int id;
    private String name;
    private String file;
    private String image;

    public SingleAlgorithm(int id, String name, String file, String image) {
        this.id = id;
        this.name = name;
        this.file = file;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
