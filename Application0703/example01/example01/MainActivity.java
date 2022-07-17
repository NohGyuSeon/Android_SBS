package com.example.example01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button redButton, greenButton, blueButton;

    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redButton = findViewById(R.id.main_button_red);
        greenButton = findViewById(R.id.main_button_green);
        blueButton = findViewById(R.id.main_button_blue);

        redButton.setOnClickListener(this);
        greenButton.setOnClickListener(this);
        blueButton.setOnClickListener(this);

        manager = getSupportFragmentManager();
    }


    @Override
    public void onClick(View view) {

        Fragment fragment = null;
        FragmentTransaction transaction = manager.beginTransaction();
        if(view.getId()== R.id.main_button_red)
            fragment = new RedFragment();
        else if(view.getId()== R.id.main_button_green)
            fragment = new GreenFragment();
        else if(view.getId()== R.id.main_button_blue)
            fragment = new BlueFragment();
        else return;

        transaction
                .replace(R.id.fragmentContainerView, fragment)
                .commit();
    }
}