package com.example.opdracht2uidavyjurre;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.opdracht2uidavyjurre.JsonParser.HueEmulatorConnector;
import com.example.opdracht2uidavyjurre.JsonParser.LightResponse;

import java.util.ArrayList;

public class ExitFragment extends Fragment {

    ArrayList<LightResponse> lights;



    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try {
            lights= HueEmulatorConnector.retrieveLights();
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        View view = inflater.inflate(R.layout.activity_fragment_exit, container, false);

         lights = HueEmulatorConnector.retrieveLights();

         try {
             Thread.sleep(500);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

        Button exitButton = (Button) view.findViewById(R.id.exitButton);

         exitButton.setOnClickListener(v -> {

             for (int i = 0; i < lights.size() ; i++) {
                 HueEmulatorConnector.turnOffLight(i+ 1);

             }
             try {
                 Thread.sleep(100);
                 System.exit(0);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }

        });

         return view;
    }
}