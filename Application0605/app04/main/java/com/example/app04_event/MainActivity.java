package com.example.app04_event;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/*
    View 의 이벤트
      이벤트 : 무언가의 사건 또는 상호작용
      이벤트가 발생하면 기능이 수행되도록 해야한다.

    이벤트를 처리하는 이벤트 모델
        - 델리게이션 이벤트 모델(Delegation Event Model)
            : View 에서 발생한 이벤트를 처리하기 위한 이벤트 모델
            : 클릭, 키보드 입력, 체크박스 선택 등
        - 하이어라키 이벤트 모델(Hierarchy Event Model)
            : Activity 또는 스마트폰 자체에서 발생한
              이벤트를 처리하기 위한 이벤트 모델
            : 화면 터치, 전원 키 볼륨 키 등

    델리게이션 이벤트 모델
       - 이벤트가 발생할 View 와 이벤트가 발생했을 때 수행할 기능(Handler)을
         View 에 연결하여 사용하는 모델
       - 특정 이벤트가 발생했을 때 수행할 기능을 구현하기 위한 메서드를 정의한 타입
          Listener : interface

 */

// 클릭 이벤트가 발생했을 때 수행할 기능
class ClickEventHandler implements View.OnClickListener {
    static int count = 0;
    @Override
    public void onClick(View view) {
        // 로그 출력
        Log.i("onClick()", "Button clicked!(" +count+")");
        count++;
    }
}


// Activity 내에서 이벤트 핸들러를 모두 구현하는 방법도 있다.
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // Button 을 참조하기 위한 변수를 선언
    Button button;

    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.main_button);

        // OnClickListener 인터페이스로 구현된 핸들러를
        // button 에 추가
        button.setOnClickListener(new ClickEventHandler());

        // 일반적으로 위와 같이 클래스를 정의하여 객체를 전달하기 보다
        // 익명 클래스를 통해서 인터페이스의 추상 메서드만 오버라이딩하여 바로 넘긴다.
        //      익명 클래스  : 이름이 없는 클래스
        //                  : 클래스를 작성함과 동시에 객체를 만들고 사라지는 클래스
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Button Clicked!(" + count + ")", Toast.LENGTH_SHORT).show();
                count++;
            }
        });

        // this = 자기 자신의 레퍼런스
        button.setOnClickListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Button Clicked!(" + count+")", Toast.LENGTH_SHORT).show();
        count++;
    }
}





