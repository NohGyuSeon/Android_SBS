package com.example.application0731;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // 기존의 ActionBar 대신 Toolbar 를 사용
        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        // 새로 설정된 Toolbar 가 ActionBar 타입으로 변환되면서 반환
        actionBar = getSupportActionBar();
    }
}