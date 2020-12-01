package com.example.opdracht2uidavyjurre.Light;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.opdracht2uidavyjurre.Information.InformationAdapter;
import com.example.opdracht2uidavyjurre.R;

public class LightFragment extends Fragment {

    private Light[] lights;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        lights = new Light[2];

        View view =  inflater.inflate(R.layout.fragment_light, container, false);

        lights[0] = new Light("lamp1", "informatie over lamp 1", "nogmeer info neef");
        lights[1] = new Light("lamp2 ", "informatie over lamp 2", "nogmeer info neef maar dan 2");

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewLight);

        LightAdapter lightAdapter = new LightAdapter(lights);

        recyclerView.setAdapter(lightAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}
