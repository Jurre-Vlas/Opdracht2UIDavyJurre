package com.example.opdracht2uidavyjurre.JsonParser;

import java.util.List;

public class State{
	private List<Double> xy;
	private int ct;
	private String alert;
	private int sat;
	private String effect;
	private int bri;
	private int hue;
	private String colormode;
	private boolean reachable;
	private boolean on;

	public List<Double> getXy(){
		return xy;
	}

	public int getCt(){
		return ct;
	}

	public String getAlert(){
		return alert;
	}

	public int getSat(){
		return sat;
	}

	public String getEffect(){
		return effect;
	}

	public int getBri(){
		return bri;
	}

	public int getHue(){
		return hue;
	}

	public String getColormode(){
		return colormode;
	}

	public boolean isReachable(){
		return reachable;
	}

	public boolean isOn(){
		return on;
	}
}