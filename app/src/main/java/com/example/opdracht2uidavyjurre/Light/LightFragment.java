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
import com.example.opdracht2uidavyjurre.JsonParser.LightResponse;
import com.example.opdracht2uidavyjurre.R;

import java.util.ArrayList;

public class LightFragment extends Fragment {

    ArrayList<LightResponse> hueEmulator;

    public LightFragment(ArrayList<LightResponse> hueEmulator) {
        this.hueEmulator = hueEmulator;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_light, container, false);


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewLight);

        LightAdapter lightAdapter = new LightAdapter(hueEmulator);

        recyclerView.setAdapter(lightAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}
