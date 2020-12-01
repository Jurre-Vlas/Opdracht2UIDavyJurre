package com.example.opdracht2uidavyjurre.Light;

public class Light {

    private String name;
    private String information;
    private String description;

    public Light(String name, String description, String information) {
        this.name = name;
        this.description = description;
        this.information = information;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
