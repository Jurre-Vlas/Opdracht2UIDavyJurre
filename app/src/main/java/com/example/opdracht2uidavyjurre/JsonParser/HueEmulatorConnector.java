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


                    Collections.sort(arrayLights);

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


    //0 and 65535
    public static void setColorLight(int lightNumber, int Colour) {
        //https://developers.meethue.com/develop/hue-api/lights-api/
        final String androidUrlLight = "http://10.0.2.2:8000/api/newdeveloper/lights/";

        String jsonBody = "{\"hue\":" + Colour + "}\n";

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, jsonBody);

        int newNumber = lightNumber + 1;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(androidUrlLight + newNumber  + "/state/")
                .put(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Response response) throws IOException {
                System.out.println(response.body().string());
                System.out.println("Succes! Light turned other colour");
            }

            @Override
            public void onFailure(Request request, IOException e) {
                System.out.println(e.getLocalizedMessage());
                System.out.println("Fail!");

            }
        });
    }


    //sat	uint8	Saturation of the light. 254 is the most saturated (colored) and 0 is the least saturated (white)
    public static void setSaturation(int lightNumber, int Colour) {
        //https://developers.meethue.com/develop/hue-api/lights-api/
        final String androidUrlLight = "http://10.0.2.2:8000/api/newdeveloper/lights/";

        String jsonBody = "{\"sat\":" + Colour + "}\n";

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, jsonBody);

        int newNumber = lightNumber + 1;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(androidUrlLight + newNumber  + "/state/")
                .put(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Response response) throws IOException {
                System.out.println(response.body().string());
                System.out.println("Succes! Light saturation changed");
            }

            @Override
            public void onFailure(Request request, IOException e) {
                System.out.println(e.getLocalizedMessage());
                System.out.println("Fail!");

            }
        });
    }

//    bri	uint8	Brightness of the light. This is a scale from the minimum brightness the light is capable of, 1, to the maximum capable brightness, 254.
public static void setBrightness(int lightNumber, int Colour) {
    //https://developers.meethue.com/develop/hue-api/lights-api/
    final String androidUrlLight = "http://10.0.2.2:8000/api/newdeveloper/lights/";

    String jsonBody = "{\"bri\":" + Colour + "}\n";

    MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    RequestBody body = RequestBody.create(JSON, jsonBody);

    int newNumber = lightNumber + 1;

    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
            .url(androidUrlLight + newNumber  + "/state/")
            .put(body)
            .build();
    client.newCall(request).enqueue(new Callback() {
        @Override
        public void onResponse(Response response) throws IOException {
            System.out.println(response.body().string());
            System.out.println("Succes! Brightness changed");
        }

        @Override
        public void onFailure(Request request, IOException e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println("Fail!");

        }
    });
}


}
