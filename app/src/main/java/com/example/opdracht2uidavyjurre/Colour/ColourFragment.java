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

import com.example.opdracht2uidavyjurre.Information.InformationAdapter;
import com.example.opdracht2uidavyjurre.Light.Light;
import com.example.opdracht2uidavyjurre.R;

public class ColourFragment extends Fragment {

    private ColourPattern[] colourPattern;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        colourPattern = new ColourPattern[2];

        View view =  inflater.inflate(R.layout.fragment_colour, container, false);

//        colourPattern[0] = new ColourPattern("", "informatie over lamp 1", "nogmeer info neef");
//        lights[1] = new Light("lamp2 ", "informatie over lamp 2", "nogmeer info neef maar dan 2");2

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewColour);

        ColourAdapter colourAdapter = new ColourAdapter(colourPattern);

        recyclerView.setAdapter(colourAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);

        return view;



        //return inflater.inflate(R.layout.fragment_colour, container, false);
    }
}
