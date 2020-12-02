package com.example.opdracht2uidavyjurre.JsonParser;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class HueEmulatorConnector {

    private final String bridgeIp = "192.168.178.24"; // Fill in the IP address of your Bridge
    private final String postManUrl = "http://localhost:8000/api/newdeveloper/lights";
    private final String androidUrl = "http://10.0.2.2:8000/api/newdeveloper/lights";
    private final String bridgeUrl = "http://10.0.2.2:8000/api/1028d66426293e821ecfd9ef1a0731df/lights";

    public static ArrayList<LightResponse> retrieveLights() {
        final String androidUrlLight = "http://10.0.2.2:8000/api/newdeveloper/lights/";

        System.out.println("Method called");

        ArrayList<LightResponse> arrayLights = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(androidUrlLight + i)
                    .get()
                    .build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onResponse(Response response) throws IOException {
                    System.out.println("****************************************************************************************");
                    String jsonReturned = response.body().string();
                    System.out.println("We received this JSON File : " + jsonReturned);

                    if (!jsonReturned.contains("error")) {
                        System.out.println("Adding the file now!!");
                        LightResponse jsonResponse = new Gson().fromJson(jsonReturned, LightResponse.class);

                        arrayLights.add(jsonResponse);


                        System.out.println("Added an item! The size of the array is now: " + arrayLights.size());
                    }

                    System.out.println("****************************************************************************************");


                    for (int i = 0; i < arrayLights.size(); i++) {
                        System.out.println("Before sorting");
                        System.out.println(arrayLights.get(i).getName());
                    }

                    Collections.sort(arrayLights);

                    for (int i = 0; i < arrayLights.size(); i++) {
                        System.out.println("after sorting");
                        System.out.println(arrayLights.get(i).getName());
                    }
                }

                @Override
                public void onFailure(Request request, IOException e) {
                    System.out.println("Failure");
                    System.out.println("****************************************************************************************");
                    System.out.println(e.getCause());
                    System.out.println(e.getLocalizedMessage());
                    System.out.println(e.getMessage());
                    System.out.println("****************************************************************************************");
                }
            });
        }


        return arrayLights;
    }


    public static void turnOffLight(int lightNumber) {
        final String androidUrlLight = "http://10.0.2.2:8000/api/newdeveloper/lights/";
        String jsonBody = "{\"on\":false}\n";
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, jsonBody);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(androidUrlLight + lightNumber + "/state")
                .put(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Response response) throws IOException {
                System.out.println("Succes! Light turned off");
            }

            @Override
            public void onFailure(Request request, IOException e) {
                System.out.println("Fail!");

            }
        });
    }

    public static void turnOnLight(int lightNumber) {
        final String androidUrlLight = "http://10.0.2.2:8000/api/newdeveloper/lights/";
        String jsonBody = "{\"on\":true}\n";
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, jsonBody);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(androidUrlLight + lightNumber + "/state")
                .put(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Response response) throws IOException {
                System.out.println("Succes! Light turned off");
            }

            @Override
            public void onFailure(Request request, IOException e) {
                System.out.println("Fail!");

            }
        });
    }

    public static void setColorLight(int lightNumber, int Colour) {
        //https://developers.meethue.com/develop/hue-api/lights-api/
        final String androidUrlLight = "http://10.0.2.2:8000/api/newdeveloper/lights/";
//        String jsonBody = "{\"hue\":25500}\n";
        String jsonBody = "{\"hue\":"+ Colour + "}\n";

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, jsonBody);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(androidUrlLight + lightNumber + "/state")
                .put(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Response response) throws IOException {
                System.out.println("Succes! Light turned other colour");
            }

            @Override
            public void onFailure(Request request, IOException e) {
                System.out.println("Fail!");

            }
        });
    }


}
