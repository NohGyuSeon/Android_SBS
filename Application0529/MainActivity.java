package com.example.application0529;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/*
    한 화면을 구상하고 출력하기 위해서는
    Activity 라는 컴포넌트를 만들어야한다.

    Activity 는 Java 파일과 XML 파일을 한 쌍으로 다뤄진다.
     Java 파일 → 동적인 기능을 구현
     XML 파일  → 화면을 구상 및 표현

    View
     - 화면을 구성하기 위한 레이아웃 또는
       위젯과 같은 UI 를 표현
     - 안드로이드에서 사용되는 모든 요소들이
       상속을 받고 있는 클래스

    ViewGroup
     - View 의 하위 클래스
     - 다수의 View 를 포함하기 위한 클래스
     - 포함된 View 들을 제어하기 위한 역할

 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        setContentView(R.layout.activity_sub);
        setContentView(R.layout.activity_constraint);
    }

    // View 를 클릭했을 때 수행할 메서드
    public void onClickedButton(View view) {
        Toast.makeText(this, "Clicked Button!", Toast.LENGTH_SHORT).show();
    }

    
}