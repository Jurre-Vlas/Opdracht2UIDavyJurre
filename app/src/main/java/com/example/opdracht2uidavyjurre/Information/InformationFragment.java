package com.example.opdracht2uidavyjurre.Information;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.opdracht2uidavyjurre.Light.Light;
import com.example.opdracht2uidavyjurre.R;

public class InformationFragment extends Fragment {

    private Light[] lights;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        lights = new Light[2];

        View view =  inflater.inflate(R.layout.fragment_information, container, false);

      lights[0] = new Light("lamp1", "informatie over lamp 1", "nogmeer info neef");
      lights[1] = new Light("lamp2 ", "informatie over lamp 2", "nogmeer info neef");

      RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

      InformationAdapter informationAdapter = new InformationAdapter(lights);

      recyclerView.setAdapter(informationAdapter);

      RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

      recyclerView.setLayoutManager(layoutManager);

      return view;



    }


}
