package com.example.application0618;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


// Button 을 클릭했을 때
// EditText 에 입력된 값을 TextView 에 출력

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    // Button   : 이벤트 리스너를 설정
    // EditText : 입력된 값을 읽기
    // TextView : 입력된 값을 설정
    // → 위 3개의 View 를 조작하기 위해서는 '참조 변수를 선언'
    // → 참조 변수는 필드 영역에 선언을 해야한다.
    Button button;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 레이아웃에 정의된 View 들을 참조
        button = findViewById(R.id.main_button);
        editText = findViewById(R.id.main_edit);
        textView = findViewById(R.id.main_text);

        // button 을 클릭했을 때의 기능을 구현하기 위해서는
        // 이벤트 리스너를 구현을 해야한다.
        //  → Activity 에서 이벤트 리스너를 상속 받아 구현
        //  → View 에 이벤트 리스너를 익명 클래스로 구현

        // 이벤트 리스너를 설정하기 위한 메서드
        button.setOnClickListener(this);
        // this = 현재 레퍼런스
        //      = 현재 레퍼런스의 OnClickListener 영역이 전달

        // 이벤트 리스너를 익명 클래스로 구현하여 설정
        //  익명 클래스 : 이름이 없는 클래스이며
        //             : 객체를 바로 만들기 위한 클래스
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // EditText 의 입력된 값을 반환
                String input = editText.getText().toString();

                // 입력된 값을 TextView 에 출력되도록 설정
                textView.setText(input);

                // + editText 의 입력된 값을 삭제
                editText.setText("");
            }
        });
    }


    @Override
    public void onClick(View view) {
        // OnClickListener 인터페이스의 onClick 메서드를 오버라이딩

        // EditText 의 입력된 값을 반환
        String input = editText.getText().toString();
        
        // 입력된 값을 TextView 에 출력되도록 설정
        textView.setText(input);
    }
}












