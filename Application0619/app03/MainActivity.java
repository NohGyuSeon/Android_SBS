package com.example.app03_keyevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

// 키 이벤트(Key Event)
//  - onKeyDown() 메서드를 오버라이딩하여 구현
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 뒤로 가기 버튼
        //  → 뒤로가기 버튼은 따로 기능을 처리하는 경우가 많다보니
        //    별도의 메서드가 따로 정의되어있다.
        /*
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            Toast.makeText(this, "Keycode = Back", Toast.LENGTH_SHORT).show();
            return false;
        }
        */

        if(keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            Toast.makeText(this, "Keycode = KEYCODE_VOLUME_UP", Toast.LENGTH_SHORT).show();
            return false;
        }

        return super.onKeyDown(keyCode, event);
    }


    // 뒤로가기 버튼을 누른 시간을 저장하기 위한 변수
    long previousTime = 0;

    // 뒤로가기 버튼을 눌렀을 때 수행되는 메서드
    @Override
    public void onBackPressed() {
        // 현재 시간
        long currentTime = System.currentTimeMillis(); // 1s = 1000ms
        // 기존에 버튼을 누른 시간과 현재 시간의 차이가 2초 이내이면 종료
        if((currentTime - previousTime) <= 2000) {
            // super.onBackPressed();
            finish(); // Activity 를 종료하는 메서드
            return;
        }


        Toast.makeText(this, "종료하시겠습니까? ", Toast.LENGTH_SHORT).show();
        previousTime = currentTime;
        // super.onBackPressed();
    }
}