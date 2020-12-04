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
    private TextView tvHue;
    private TextView tvBri;
    private TextView tvSat;


    private String data1;
    private String data2;
    private String data3;
    private Integer Bri;
    private Integer Hue;
    private Integer Sat;



    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment__information_light, container, false);

        title = view.findViewById(R.id.titleLight);
        description = view.findViewById(R.id.lightDescription);
        info = view.findViewById(R.id.lightInfo);

        tvHue = view.findViewById(R.id.tvHue);
        tvBri = view.findViewById(R.id.tvBri);
        tvSat = view.findViewById(R.id.tvStat);

        getData();
        setData();

        return view;
    }

    public void getData() {

        data1 = getActivity().getIntent().getExtras().getString("data1");
        data2 = getActivity().getIntent().getExtras().getString("data2");
        data3 = getActivity().getIntent().getExtras().getString("data3");
        Bri = getActivity().getIntent().getExtras().getInt("Bri");
        Hue = getActivity().getIntent().getExtras().getInt("Hue");
        Sat = getActivity().getIntent().getExtras().getInt("Sat");
    }


    public void setData() {
        title.setText(data1);
        description.setText(data2);
        info.setText(data3);
        tvHue.setText("Collor: " +  String.valueOf(Hue));
        tvBri.setText("Brightness: " + String.valueOf(Bri));
        tvSat.setText( "Saturation: " +  String.valueOf(Sat));

        //            appCompatActivity.getIntent().putExtra("data1", lights.get(position).getName());
        //            appCompatActivity.getIntent().putExtra("data2", lights.get(position).getModelid());
        //            appCompatActivity.getIntent().putExtra("data3", "type: " + lights.get(position).getType());
        //            appCompatActivity.getIntent().putExtra("Bri", "Brightness: " + lights.get(position).getState().getBri());
        //            appCompatActivity.getIntent().putExtra("Hue", "Collor: " +  lights.get(position).getState().getHue());
        //            appCompatActivity.getIntent().putExtra("Sat", "Saturation: " +  lights.get(position).getState().getSat());

    }
}
