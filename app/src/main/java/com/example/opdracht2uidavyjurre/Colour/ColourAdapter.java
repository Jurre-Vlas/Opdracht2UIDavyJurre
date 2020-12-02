package com.example.opdracht2uidavyjurre.Colour;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.opdracht2uidavyjurre.Information.InformationFragment;
import com.example.opdracht2uidavyjurre.R;

public class ColourAdapter extends RecyclerView.Adapter<ColourAdapter.InformationViewHolder > {

    private InformationFragment informationFragment;
    private ColourPattern[] colourPatterns;


    public ColourAdapter(ColourPattern[] colourPatterns){
        this.colourPatterns = colourPatterns;
    }



    @NonNull
    @Override
    public InformationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.colour_boxview, parent, false);
        return new InformationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InformationViewHolder holder, int position) {
      ColourPattern colourPattern = colourPatterns[position];

        holder.textView1.setText(colourPattern.getName());

        holder.colourLayout.setOnClickListener(v -> {

//            colourPattern[position];

        });
    }

    @Override
    public int getItemCount() {
        return colourPatterns.length;
    }

    public class InformationViewHolder extends RecyclerView.ViewHolder {

        TextView textView1;
        Button button;
        CardView colourLayout;



        public InformationViewHolder(@NonNull View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.textView1Colour);
            button = itemView.findViewById(R.id.buttonColour);

            colourLayout = itemView.findViewById(R.id.colourLayout);

        }
    }
}
