package com.example.opdracht2uidavyjurre.Light;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.opdracht2uidavyjurre.JsonParser.HueEmulatorConnector;
import com.example.opdracht2uidavyjurre.JsonParser.LightResponse;
import com.example.opdracht2uidavyjurre.MainActivity;
import com.example.opdracht2uidavyjurre.R;

import java.nio.channels.SelectionKey;
import java.util.ArrayList;

import yuku.ambilwarna.AmbilWarnaDialog;

public class LightInfoFragment extends Fragment {

    ArrayList<LightResponse> hueEmulator;
    int position;
     SeekBar seekbarcolor;
     SeekBar seekbarbrightness;
     SeekBar seekbarSat;

    public LightInfoFragment(ArrayList<LightResponse> lights, int position) {
        this.hueEmulator = lights;
        this.position = position;

    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment__setinformation_light, container, false);

        seekbarcolor = (SeekBar) view.findViewById(R.id.SeekbarColor);
        seekbarbrightness = (SeekBar) view.findViewById(R.id.SeekbarBri) ;
        seekbarSat = (SeekBar)view.findViewById(R.id.SeekbarSat);

        seekbarcolor.setMax(1559);

        seekbarcolor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                HueEmulatorConnector.setColorLight(position, progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        colorPicker.show();
    }

        return view;
    }


}
