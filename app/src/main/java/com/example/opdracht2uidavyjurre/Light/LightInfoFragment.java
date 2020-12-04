package com.example.opdracht2uidavyjurre.Light;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.opdracht2uidavyjurre.JsonParser.HueEmulatorConnector;
import com.example.opdracht2uidavyjurre.JsonParser.LightResponse;
import com.example.opdracht2uidavyjurre.MainActivity;
import com.example.opdracht2uidavyjurre.R;

import java.util.ArrayList;

import yuku.ambilwarna.AmbilWarnaDialog;

public class LightInfoFragment extends Fragment {

    ArrayList<LightResponse> hueEmulator;
    int position;
    Button setCollorButton;

    public LightInfoFragment(ArrayList<LightResponse> lights, int position) {
        this.hueEmulator = lights;
        this.position = position;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment__setinformation_light, container, false);

        setCollorButton = (Button) view.findViewById(R.id.ButtonSetCollor);

        setCollorButton.setOnClickListener(v -> {

            openColorPicker();

        });



        setData();

        return view;
    }

    private void openColorPicker() {
        System.out.println("hij komt hier in");
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(getActivity(), 0, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                System.out.println(color);
                HueEmulatorConnector.setColorLight(position, color );

            }
        });

        colorPicker.show();



    }

    private void getData() {
    }


    public void setData() {

    }
}
