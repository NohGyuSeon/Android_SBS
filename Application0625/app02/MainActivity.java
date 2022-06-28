package com.example.app02_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*
    안드로이드 어플리케이션은 컴포넌트 기반이다.
     → 컴포넌트 중 하나가 화면을 출력하는 Activity 이다.
     → 컴포넌트는 개발자가 임의로 수행시키거나 생성할 수 없다.
        → 컴포넌트는 안드로이드 시스템에 의해 관리가 되어지기 때문에
          개발자가 수행시키려면 안드로이스 시스템에 요청을 해야한다.
     → 안드로이드 시트템에 요청을 보내기 위한 수단 : Intent 클래스의 객체

     Intent
      - 컴포넌트 기반의 개념을 완성시키는 클래스
      - 컴포넌트를 실행하기 위해 안드로이드 시스템에 넘기는 정보
         → 컴포넌트 정보를 담은 인텐트를 생성한 다음 시스템에 넘기면
           시스템에서 인텐트를 분석하여 해당 요구를 실행시켜준다.

     Activity 간 데이터 전달
        MainActivity 에서 SubActivity 를 호출하면서 데이터를 전달
         - 안드로이드 시스템에 전달되는 Intent 객체에 전달할 데이터를 저장
         - 호출된 SubActivity 에서는 안드로이드 시스템에 Intent 객체를 요청
        호출된 SubActivity 에서 호출한 MainActivity 로 데이터를 전달
         - SubActivity 에서 결과를 전달하기 위한 Intent 객체를 생성
         - MainActivity 에서는 전달받은 Intent 객체를 처리하기 위한 코드
            - SubActivity 를 실행할 때 startActivityForResult() 메서드로 실행
            - ActivityResultLauncher 클래스의 객체를 이용

        사용자 정의 클래스의 객체는 Activity 간 전달이 기본적으로 되지 않는다.
        객체를 직렬화(하나의 데이터로 변환)를 해서 안드로이드 시스템에 전달해야하기 때문에
        사용자 정의 클래스가 직렬화가 될 수 있도록 Parcelable 인터페이스를 통해 구현

 */

class Simple {
    int data;
    Simple(int data) {
        this.data = data;
    }
}

public class MainActivity extends AppCompatActivity {
    Button toSubButton;
    Button toNaverButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent extra = getIntent();
//        Toast.makeText(this, "extra : " + extra.toString(), Toast.LENGTH_SHORT).show();

        toSubButton = findViewById(R.id.main_button);
        toSubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼을 클릭했을 때 SubActivity 를 실행

                // 명시적 인텐트
                //  - 실행하고자하는 컴포넌트의 클래스 명을 직접 지정하는 경우

                // 수행시킬 Activity 에 대한 정보를 Intent 객체에 저장
                // 1. 현재 Activity 에 대한 정보
                // 2. 수행 시킬 Activity 에 대한 클래스 정보
                Intent intent = new Intent(MainActivity.this, SubActivity.class);

                // SubActivity 로 전달할 데이터를 추가
                //  Intent 객체 내에는 어떠한 데이터든 저장하기 위한 저장 공간이 있다.
                //  데이터를 저장할 때 Bundle 클래스의 객체로 저장.
                intent.putExtra("dummyText", "Hello SubActivity!"); // 부가 데이터(Extra Data)
                intent.putExtra("dummyNumber", 12345);

                Simple s = new Simple(100);
                // intent.putExtra("SimpleObject", s);


                // Intent 객체를 안드로이드 시스템에 전달
                startActivity(intent);
            }
        });

        toNaverButton = findViewById(R.id.main_button_toNaver);
        toNaverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 암시적 인텐트
                //  클래스 명이 아닌 Intent Filter 정보를 활용하는 방법
                //  클래스 명을 알 수 없는 외부 앱의 컴포넌트를 실행할 때 사용

                // 1. 어떤 기능(수행)
                // 2. 기능을 수행하기 위한 데이터
                // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.naver.com"));
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel://010-1234-5678"));

                startActivity(intent);

            }
        });
    }
}