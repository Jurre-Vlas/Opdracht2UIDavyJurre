package com.example.opdracht2uidavyjurre.JsonParser;

public class LightResponse implements Comparable<LightResponse>{
    private String modelid;
    private String name;
    private String swversion;
    private String type;
    private String uniqueid;
    private State state;

    public LightResponse(String modelid, String name, String swversion, String type, String uniqueid) {
        this.modelid = modelid;
        this.name = name;
        this.swversion = swversion;
        this.type = type;
        this.uniqueid = uniqueid;
    }

    public String getModelid() {
        return modelid;

    }

    public String getName() {
        return name;
    }

    public String getSwversion() {
        return swversion;
    }

    public String getType() {
        return type;
    }

    public String getUniqueid() {
        return uniqueid;
    }

    public State getState() {
        return state;
    }

    public int compareTo(LightResponse o) {
        return name.compareTo(o.name);
    }

}
