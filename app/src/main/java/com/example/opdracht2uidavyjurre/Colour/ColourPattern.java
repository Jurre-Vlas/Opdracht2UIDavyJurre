package com.example.opdracht2uidavyjurre.Colour;

import com.example.opdracht2uidavyjurre.Light.Light;

public class ColourPattern {

    Light[] lights;
    String name;

    public ColourPattern(Light[] lights, String name) {
        this.lights = lights;
        this.name = name;
    }


    public Light[] getLights() {
        return lights;
    }

    public void setLights(Light[] lights) {
        this.lights = lights;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
