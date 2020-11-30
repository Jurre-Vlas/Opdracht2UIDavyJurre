package com.example.opdracht2uidavyjurre.Information;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.opdracht2uidavyjurre.Light.Light;
import com.example.opdracht2uidavyjurre.R;

import org.w3c.dom.Text;

public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.InformationViewHolder > {

    private InformationFragment informationFragment;
    private Light[] light;


    public InformationAdapter(Light[] lights){
        this.light = lights;


    }



    @NonNull
    @Override
    public InformationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.information_boxview, parent, false);
        return new InformationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InformationViewHolder holder, int position) {
        Light light = this.light[position];

        holder.textView1.setText(light.getName());
        holder.textView2.setText(light.getInformation());


        holder.informationMainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return light.length;
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
