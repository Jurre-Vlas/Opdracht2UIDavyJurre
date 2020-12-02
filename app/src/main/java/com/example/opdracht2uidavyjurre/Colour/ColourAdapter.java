package com.example.opdracht2uidavyjurre.Colour;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

public class ColourAdapter extends RecyclerView.Adapter<ColourAdapter.InformationViewHolder > {

    private InformationFragment informationFragment;
    private ArrayList<LightResponse> lights;

    public ColourAdapter(ArrayList<LightResponse> lights) {
        this.lights = lights;
    }


    @NonNull
    @Override
    public InformationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.colour_boxview, parent, false);
        return new InformationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InformationViewHolder holder, int position) {
        holder.textView1.setText(lights.get(position).getName());

//        holder.textView1.setText(lights.get(position).getName());


        holder.button.setOnClickListener(v -> {

//           int colourNumber = Integer.parseInt(holder.editText.getText().toString());

         String numberString = holder.editText.getText().toString();
         int numberInt = Integer.parseInt(numberString);

           if (numberInt > 0 && numberInt < 65535 ){
//               HueEmulatorConnector.setColorLight(colourNumber, position);
               HueEmulatorConnector.setColorLight(position,numberInt);
           }
        });

    }

    @Override
    public int getItemCount() {
        return lights.size();
    }

    public class InformationViewHolder extends RecyclerView.ViewHolder {

        TextView textView1;
        Button button;
        CardView colourLayout;
        EditText editText;



        public InformationViewHolder(@NonNull View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.textView1Colour);
            button = itemView.findViewById(R.id.buttonColour);

            colourLayout = itemView.findViewById(R.id.colourLayout);

            editText = itemView.findViewById(R.id.editColour);

        }
    }
}
