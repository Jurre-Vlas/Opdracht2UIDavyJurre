package com.example.opdracht2uidavyjurre.Information;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.opdracht2uidavyjurre.JsonParser.HueEmulatorConnector;
import com.example.opdracht2uidavyjurre.JsonParser.LightResponse;
import com.example.opdracht2uidavyjurre.R;

import java.util.ArrayList;

public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.InformationViewHolder > {

    ArrayList<LightResponse> lights;

    public InformationAdapter(ArrayList<LightResponse> hueEmulator) {
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


        holder.textView1.setText(lights.get(position).getName());
        holder.textView2.setText(lights.get(position).getModelid());

        holder.informationMainLayout.setOnClickListener(v -> {
            AppCompatActivity appCompatActivity = (AppCompatActivity) v.getContext();
            InformationInfoFragment informationInfoFragment = new InformationInfoFragment();
            
            appCompatActivity.getIntent().putExtra("data1", lights.get(position).getName());
            appCompatActivity.getIntent().putExtra("data2", lights.get(position).getModelid());
            appCompatActivity.getIntent().putExtra("data3", lights.get(position).getType());
            
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
        CardView informationMainLayout;

        public InformationViewHolder(@NonNull View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
            informationMainLayout = itemView.findViewById(R.id.informationLayout);


        }
    }
}
