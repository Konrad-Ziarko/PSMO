package com.example.psmo.medteam1;

/**
 * Created by Konrad on 21.11.2016.
 */

public class Successor{
    private int sucId;
    private String description;

    public int getSucId() {
        return sucId;
    }

    public void setSucId(int sucId) {
        this.sucId = sucId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Successor(int sucId, String description) {
        this.sucId = sucId;
        this.description = description;
    }
}