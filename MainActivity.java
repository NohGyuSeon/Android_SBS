package com.example.application0528;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setContentView()
        //   → 지정된 레이아웃을 화면에 출력하는 메서드
        // setContentView(R.layout.activity_main);
        // R = resource
        // layout = layout 폴더
        // activity_main = activity_main.xml

        setContentView(R.layout.activity_sub);

        // R.drawable.ic_launcher_background
        // res 폴더의 drawable 폴더의 ic_launcher_background.xml
    }
}