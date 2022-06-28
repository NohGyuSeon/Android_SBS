package com.example.example02_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.example02_login.VO.User;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    User currentUser = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.main_text);
        Intent extra = getIntent();

        if(extra == null) return;

        currentUser = extra.getParcelableExtra("currentUser");
        textView.setText(currentUser.toString());
    }
}