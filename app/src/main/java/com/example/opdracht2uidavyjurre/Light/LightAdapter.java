package com.example.opdracht2uidavyjurre.Light;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.opdracht2uidavyjurre.Information.InformationFragment;
import com.example.opdracht2uidavyjurre.Information.InformationInfoFragment;
import com.example.opdracht2uidavyjurre.JsonParser.HueEmulatorConnector;
import com.example.opdracht2uidavyjurre.JsonParser.LightResponse;
import com.example.opdracht2uidavyjurre.R;

import java.util.ArrayList;

public class LightAdapter extends RecyclerView.Adapter<LightAdapter.InformationViewHolder > {

    ArrayList<LightResponse> lights;

    public LightAdapter(ArrayList<LightResponse> hueEmulator) {
        lights = hueEmulator;
    }

    @NonNull
    @Override
    public InformationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.information_boxview, parent, false);
        return new InformationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InformationViewHolder holder, int position) {
        holder.checkBox.setId(position);
        holder.textView1.setText(lights.get(position).getName());
        holder.checkBox.setVisibility(View.VISIBLE);
        holder.textView2.setText(lights.get(position).getModelid());


        holder.checkBox.setChecked(lights.get(position).getState().isOn());

        holder.checkBox.setOnClickListener(v -> {
            if (holder.checkBox.isChecked()) {
                HueEmulatorConnector.turnOnLight(position + 1);
            }

            if (!holder.checkBox.isChecked()) {
                HueEmulatorConnector.turnOffLight(position + 1);
            }
        });

        holder.lightMainLayout.setOnClickListener(v -> {

            AppCompatActivity appCompatActivity = (AppCompatActivity) v.getContext();
            LightInfoFragment informationInfoFragment = new LightInfoFragment(lights, position);

            appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment, informationInfoFragment).commit();

        });

    }

    @Override
    public int getItemCount() {
        return lights.size();
    }

    public class InformationViewHolder extends RecyclerView.ViewHolder {

        TextView textView1;
        TextView textView2;
        CardView lightMainLayout;
        CheckBox checkBox;

        public InformationViewHolder(@NonNull View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);

            lightMainLayout = itemView.findViewById(R.id.informationLayout);
            checkBox = itemView.findViewById(R.id.checkBoxOn);


        }
    }
}
