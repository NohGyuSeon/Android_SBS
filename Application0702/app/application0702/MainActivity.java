package com.example.application0702;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*
    Android Stack, Task 관리
      Task : 앱 실행을 위한 정보를 저장하기 위한 공간
      Android Stack : Task 에 쌓인 Activity 를 저장하는 공간
                    : 기존에 실행되던 Activity 를 저장하며, stack 구조를 가진다.
      
      Android Stack 을 관리하지 않으면
        - 동일한 Activity 가 여러 개 생성된다.
            → Activity 는 서로 독립적이기 때문에 데이터가 공유가 안된다.
            → 같은 Activity 라도 다른 공간을 사용하기 때문
        - 원할한 Activity 이동이 불가능하다.
            → 맨 처음 Activity 로 되돌아가려면 그만큼 뒤로 가야한다.

      이를 관리하기 위한 수단 : "Flag"

      플래그의 종류
        - FLAG_ACTIVITY_SINGLE_TOP
            : Activity 를 생성할 때 바로 이전 Activity 와 동일한 경우
              기존 Activity 를 재사용(재실행)
            : 기존 Activity 가 재실행되는 것이기 때문에
              onCreate() 메서드가 아닌 onNewIntent() 메서드가 실행
        - FLAG_ACTIVITY_CLEAR_TOP
            : 안드로이드 스택에 저장된 Activity 와 동일한 Activity 를 호출한 경우
              그 사이에 있는 Activity 를 모두 종료
            : 호출된 Activity 가 새로 생성되어 실행되기 때문에
              이전 Activity 를 유지하며 재실행하기 위해선
              FLAG_ACTIVITY_SINGLE_TOP 와 같이 사용
         - FLAG_ACTIVITY_NO_HISTORY
            : 호출된 Activity 는 안드로이드 스택에 저장하지 않는다.
            : 단, 1회 출력하기 위한 Activity 에 설정
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button toMainBtn, toSub01Btn, toSub02Btn, toSub03Btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toMainBtn = findViewById(R.id.main_button_toMain);
        toSub01Btn = findViewById(R.id.main_button_toSub01);
        toSub02Btn = findViewById(R.id.main_button_toSub02);
        toSub03Btn = findViewById(R.id.main_button_toSub03);
        toMainBtn.setOnClickListener(this);
        toSub01Btn.setOnClickListener(this);
        toSub02Btn.setOnClickListener(this);
        toSub03Btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        int id = view.getId(); // 이벤트가 발생한 View 객체의 id
        if(id == R.id.main_button_toMain) {
            intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        }else if(id == R.id.main_button_toSub01) {
            intent = new Intent(this, Sub01Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        }else if(id == R.id.main_button_toSub02) {
            intent = new Intent(this, Sub02Activity.class);
        }else if(id == R.id.main_button_toSub03) {
            intent = new Intent(this, Sub03Activity.class);
        }else { return; }

        startActivity(intent);
    }


    // 기존 Activity 가 재실행 됐을 때 수행하는 메서드
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Toast.makeText(this, "MainActivity 재실행", Toast.LENGTH_SHORT).show();
    }
}