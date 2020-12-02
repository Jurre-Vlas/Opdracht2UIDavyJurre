package com.example.opdracht2uidavyjurre.JsonParser;

import org.junit.Test;

import static org.junit.Assert.*;

public class LightResponseTest {

    @Test
    public void getModelid() {
        LightResponse testLight = new LightResponse("LCT001", "Hue Lamp 1", "65003148", "Extended color light", "00:17:88:01:00:d4:12:08-0a");
        String expectedOutput = "LCT001";
        assertEquals(testLight.getModelid(), expectedOutput);
    }

    @Test
    public void getName() {
        LightResponse testLight = new LightResponse("LCT001", "Hue Lamp 1", "65003148", "Extended color light", "00:17:88:01:00:d4:12:08-0a");
        String expectedOutput = "Hue Lamp 1";
        assertEquals(testLight.getName(), expectedOutput);
    }

    @Test
    public void getSwversion() {
        LightResponse testLight = new LightResponse("LCT001", "Hue Lamp 1", "65003148", "Extended color light", "00:17:88:01:00:d4:12:08-0a");
        String expectedOutput = "65003148";
        assertEquals(testLight.getSwversion(), expectedOutput);
    }

    @Test
    public void getType() {
        LightResponse testLight = new LightResponse("LCT001", "Hue Lamp 1", "65003148", "Extended color light", "00:17:88:01:00:d4:12:08-0a");
        String expectedOutput = "Extended color light";
        assertEquals(testLight.getType(), expectedOutput);
    }

    @Test
    public void getUniqueid() {
        LightResponse testLight = new LightResponse("LCT001", "Hue Lamp 1", "65003148", "Extended color light", "00:17:88:01:00:d4:12:08-0a");
        String expectedOutput = "00:17:88:01:00:d4:12:08-0a";
        assertEquals(testLight.getUniqueid(), expectedOutput);
    }

    @Test
    public void compareTo() {

    }
}