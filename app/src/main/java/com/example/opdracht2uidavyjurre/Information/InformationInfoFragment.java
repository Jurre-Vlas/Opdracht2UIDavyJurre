package com.example.opdracht2uidavyjurre.Information;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.opdracht2uidavyjurre.Light.Light;
import com.example.opdracht2uidavyjurre.R;

import org.w3c.dom.Text;

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

    private void setData() {

    }


    private void getData() {
        title.setText(data1);
        description.setText(data2);

        info.setText(data3);
    }
}
