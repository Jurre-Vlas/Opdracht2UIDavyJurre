package com.example.opdracht2uidavyjurre.Information;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.opdracht2uidavyjurre.R;

public class InformationInfoFragment extends Fragment {

    private TextView title;
    private TextView description;
    private TextView info;

    private String data1;
    private String data2;
    private String data3;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment__information_light, container, false);

        title = view.findViewById(R.id.titleLight);
        description = view.findViewById(R.id.lightDescription);
        info = view.findViewById(R.id.lightInfo);

        getData();
        setData();

        return view;
    }

    public void getData() {

        data1 = getActivity().getIntent().getExtras().getString("data1");
        data2 = getActivity().getIntent().getExtras().getString("data2");
        data3 = getActivity().getIntent().getExtras().getString("data3");
    }


    public void setData() {
        title.setText(data1);
        description.setText(data2);

        info.setText(data3);
    }
}
