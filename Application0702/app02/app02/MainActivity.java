package com.example.app02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

// 생명 주기(Life Cycle)
//  - Activity 가 생성되고 사라지기까지의 모든 과정
//  - 각 과정마다 수행할 기능을 구현하기 위한 메서드를 지원
//  - 종류
//      - onCreate()
//      - onStart()
//        onResume()
//        onPause()
//      - onStop()
//        onRestart()
//      - onDestroy()

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("LifeCycle", "onCreate()");
        
        // Activity 가 생성될 때 한 번만 수행
        // 레이아웃에 정의된 View 들을 참조
        // View 에 대한 기본적인 설정 및 복원
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LifeCycle", "onStart()");
        // onCreate() 메서드 또는 onRestart() 메서드 다음에 수행
        // Activity 를 수행시킬 때 마다 수행할 기능을 정의
        // ex) 회원 인증
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // 기존 Activity 의 데이터를 복원
        // ex) 인증된 회원의 데이터
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LifeCycle", "onResume()");
        // 복원 데이터를 View 적용
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LifeCycle", "onPause()");
        // 일시 정지 상태
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // 정지 상태가 되기 전에 기존의 데이터들을 저장
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LifeCycle", "onStop()");
        // 정지
        // Activity 가 화면에 보이지 않는 상태
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("LifeCycle", "onRestart()");
        // 정지 상태에서 Activity 를 다시 화면에 출력할 때
        // 맨 처음 수행되는 메서드
        // 호출된 다음에는 onStart() 메서드를 호출
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LifeCycle", "onDestroy()");
        // Activity 를 종료하기 전에 호출
    }
}