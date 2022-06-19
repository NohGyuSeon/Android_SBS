package com.example.app02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// 방향 전환
//  - 처음 앱을 개발할 때 문제가 많이 발생하는 부분
//      → 방향 전환을 하면 기존에 연산된 데이터들이 날아간다.
//      → 방향 전환을 하게되면 Activity 를 종료했다가 다시 실행한다.
//  - 기존의 데이터를 유지하는 방법
//      → onSaveInstanceState() 메서드
//          → 종료될 때 필요한 데이터들을 따로 저장
//          → 새로 시작될 때 데이터들을 불러올 수 있다.
//              → 불러오는 방법이 두 가지
//                   1. onRestoreInstanceState()
//                   2. onCreate()
//      → manifest.xml 파일에서 configChanges 속성을 설정
//          → Activity 를 그대로 유지하며, 데이터도 유지
//          → android:configChanges="orientation|screenSize|keyboardHidden"
//
public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.main_edit);
        textView = findViewById(R.id.main_text);
        button = findViewById(R.id.main_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 입력된 값
                String text = editText.getText().toString();
                if(text.isEmpty()) text = "NONE";
                textView.setText(text);
            }
        });

        //----------------------------------------------------------
        // onSaveInstanceState() 메서드에 의해 저장된 값을 불러와서 적용하기
        /*
        if(savedInstanceState != null) {
            String text = savedInstanceState.getString("inputText");
            int other = savedInstanceState.getInt("otherData");
            textView.setText(text + " / " + other);
        }
        */
    }

    // Activity 가 종료되기 전에 저장할 데이터들이 있다면
    // Bundle 객체에 따로 저장시킨다.
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // Bundle 클래스
        //  Collection 의 Map 과 유사한 형태의 저장소
        //  <Key-Value>를 쌍으로 저장하는 저장소
        //      Key : 문자열
        //      Value : 기본 자료형, 배열, 객체

        outState.putString("inputText", textView.getText().toString());
        outState.putInt("otherData", 1000);
    }

    // onSaveInstanceState() 메서드에 의해 저장된 Bundle 객체를 불러온다.
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String text = savedInstanceState.getString("inputText");
        int other = savedInstanceState.getInt("otherData");
        textView.setText(text + " / " + other);
    }
}