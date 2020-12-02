package com.example.opdracht2uidavyjurre.JsonParser;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class State {

    public State() {

    }

    public State(List<Double> xy, int ct, String alert, int sat, String effect, int bri, int hue, String colormode, boolean reachable, boolean on) {
        this.xy = xy;
        this.ct = ct;
        this.alert = alert;
        this.sat = sat;
        this.effect = effect;
        this.bri = bri;
        this.hue = hue;
        this.colormode = colormode;
        this.reachable = reachable;
        this.on = on;
    }

    @SerializedName("xy")
    private List<Double> xy;

    @SerializedName("ct")
    private int ct;

    @SerializedName("alert")
    private String alert;

    @SerializedName("sat")
    private int sat;

    @SerializedName("effect")
    private String effect;

    @SerializedName("bri")
    private int bri;

    @SerializedName("hue")
    private int hue;

    @SerializedName("colormode")
    private String colormode;

    @SerializedName("reachable")
    private boolean reachable;

    @SerializedName("on")
    private boolean on;

    public List<Double> getXy() {
        return xy;
    }

    public int getCt() {
        return ct;
    }

    public String getAlert() {
        return alert;
    }

    public int getSat() {
        return sat;
    }

    public String getEffect() {
        return effect;
    }

    public int getBri() {
        return bri;
    }

    public int getHue() {
        return hue;
    }

    public String getColormode() {
        return colormode;
    }

    public boolean isReachable() {
        return reachable;
    }

    public boolean isOn() {
        return on;
    }
}