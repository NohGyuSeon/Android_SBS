package com.example.application0702;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sub03Activity extends AppCompatActivity implements View.OnClickListener{
    Button toMainBtn, toSub01Btn, toSub02Btn, toSub03Btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub03);
        toMainBtn = findViewById(R.id.sub03_button_toMain);
        toSub01Btn = findViewById(R.id.sub03_button_toSub01);
        toSub02Btn = findViewById(R.id.sub03_button_toSub02);
        toSub03Btn = findViewById(R.id.sub03_button_toSub03);
        toMainBtn.setOnClickListener(this);
        toSub01Btn.setOnClickListener(this);
        toSub02Btn.setOnClickListener(this);
        toSub03Btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Intent intent = null;
        int id = view.getId(); // 이벤트가 발생한 View 객체의 id
        if(id == R.id.sub03_button_toMain) {
            intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        }else if(id == R.id.sub03_button_toSub01) {
            intent = new Intent(this, Sub01Activity.class);
        }else if(id == R.id.sub03_button_toSub02) {
            intent = new Intent(this, Sub02Activity.class);
        }else if(id == R.id.sub03_button_toSub03) {
            intent = new Intent(this, Sub03Activity.class);
        }else { return; }

        startActivity(intent);
    }
}