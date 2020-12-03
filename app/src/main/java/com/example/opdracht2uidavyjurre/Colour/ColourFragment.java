package com.example.opdracht2uidavyjurre.Colour;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.opdracht2uidavyjurre.JsonParser.LightResponse;
import com.example.opdracht2uidavyjurre.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ColourFragment extends Fragment {

    ArrayList<LightResponse> hueEmulator;

    public ColourFragment(ArrayList<LightResponse> hueEmulator) {

        this.hueEmulator = hueEmulator;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {




        View view =  inflater.inflate(R.layout.fragment__setinformation_light, container, false);
//
//
//        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewColour);
//
//        ColourAdapter colourAdapter = new ColourAdapter(hueEmulator);
//
//        recyclerView.setAdapter(colourAdapter);
//
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
//
//        recyclerView.setLayoutManager(layoutManager);
//
        return view;

    }
}
