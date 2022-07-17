package com.example.example02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.FrameLayout;


// 1. 한 Fragment 를 다수의 Activity 에서 사용할 경우
//    다운캐스팅을 할 때마다 검사를 해야한다.
// 2. Fragment 에서 Activity 의 메서드를 호출하는 경우
//    해당 메서드가 반드시 정의되어져 있어야한다.

public class MainActivity extends AppCompatActivity implements ColorButtonFragment.OnBackgroundChangListener{
    FrameLayout frameLayout;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        frameLayout = findViewById(R.id.main_frame);
    }

    @Override
    public void setBackgroundForFrame(int color) {
        frameLayout.setBackgroundColor(color);
    }

}