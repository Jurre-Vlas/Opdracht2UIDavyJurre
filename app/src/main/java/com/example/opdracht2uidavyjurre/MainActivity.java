package com.example.opdracht2uidavyjurre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.opdracht2uidavyjurre.Colour.ColourFragment;
import com.example.opdracht2uidavyjurre.Information.InformationFragment;

import com.example.opdracht2uidavyjurre.JsonParser.HueEmulatorConnector;
import com.example.opdracht2uidavyjurre.JsonParser.LightResponse;
import com.example.opdracht2uidavyjurre.Light.LightFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<LightResponse> hueEmulator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        hueEmulator = HueEmulatorConnector.retrieveLights();
//
//        for (int i = 0; i < hueEmulator.size(); i++) {
//            HueEmulatorConnector.turnOnLight(i);
//
//            System.out.println(hueEmulator.get(i).getName() + "is on");
//
//        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new MainFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.nav_info:
                            selectedFragment  = new InformationFragment(hueEmulator);
                            break;

                        case R.id.nav_light:
                            selectedFragment  = new LightFragment(hueEmulator);
                            break;

                        case R.id.nav_colour:
                            selectedFragment  = new ColourFragment(hueEmulator);
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, selectedFragment).commit();
                return true;
                }
            };

}