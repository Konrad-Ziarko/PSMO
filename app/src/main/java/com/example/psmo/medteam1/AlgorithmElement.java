package com.example.psmo.medteam1;

import java.util.List;

/**
 * Created by Konrad on 21.11.2016.
 */

public class AlgorithmElement {
    private int id;
    private String description;
    private List<Successor> successors;
    private String b64Image;
    private String extraDescription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Successor> getSuccessors() {
        return successors;
    }

    public void setSuccessors(List<Successor> successors) {
        this.successors = successors;
    }

    public String getB64Image() {
        return b64Image;
    }

    public void setB64Image(String b64Image) {
        this.b64Image = b64Image;
    }

    public String getExtraDescription() {
        return extraDescription;
    }

    public void setExtraDescription(String extraDescription) {
        this.extraDescription = extraDescription;
    }

    public AlgorithmElement() {
    }

    public AlgorithmElement(int id, String description, List<Successor> successors, String b64Image, String extraDescription) {
        this.id = id;
        this.description = description;
        this.successors = successors;
        this.b64Image = b64Image;
        this.extraDescription = extraDescription;
    }
}
