package com.example.opdracht2uidavyjurre.JsonParser;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class StateTest {

    @Mock
    State stateMock;

    @Before
    public void setUp() throws Exception {
        stateMock = new State();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://10.0.2.2:8000/api/newdeveloper/lights/1")
                .get()
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                System.out.println("****************************************************************************************");
                String jsonReturned = response.body().string();
                System.out.println("We received this JSON File : " + jsonReturned);

                if (!jsonReturned.contains("error")) {
                    System.out.println("Adding the file now!!");
                    LightResponse jsonResponse = new Gson().fromJson(jsonReturned, LightResponse.class);
                    stateMock = jsonResponse.getState();
                }


            }
        });
    }

    @Test
    public void getXy() {
    }

    @Test
    public void getCt() {
    }

    @Test
    public void getAlert() {
    }

    @Test
    public void getSat() {
        State mockie = Mockito.mock(State.class);
        assertEquals(stateMock.getSat(), mockie.getSat());
    }

    @Test
    public void getEffect() {
    }

    @Test
    public void getBri() {
    }

    @Test
    public void getHue() {
    }

    @Test
    public void getColormode() {
    }

    @Test
    public void isReachable() {
    }

    @Test
    public void isOn() {
    }
}