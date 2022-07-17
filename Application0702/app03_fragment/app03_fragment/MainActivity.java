package com.example.app03_fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    // 부분 화면을 출력할 View
    FrameLayout menuContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // → 한 Activity 의 인플레이션을 하기 위한 메서드
        // → 부분 화면은 따로 인플레이션을 해주지 않는다.
        // → 별도의 xml 을 출력하려면 인플레이션 과정을 거쳐야하는데
        //   LayoutInflater 클래스의 객체를 통해서 직접 해야한다.

        // Activity 에서 별도의 xml 을 인플레이션하여
        // 화면에 출력 → bottom_nav.xml
        menuContainer = findViewById(R.id.menu_container);
        // 인플레이션을 위한 LayoutInflater 객체를 반환
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        // inflater 객체를 통해
        //  출력할 xml 파일과 부분화면을 출력할 View 를 지정
        //  인플레이션 과정 이후부터 부분화면의 View 를 접근/조작을 할 수 있다.
        View root = inflater.inflate(R.layout.bottom_nav, menuContainer);
        // 인플레이션된 레이아웃이 반환
        // bottom_nav.xml 에 정의된 뷰를 참조하려면
        // root 객체를 통해서 탐색
        //  - root.findViewById(R.id.textView);

    }
}