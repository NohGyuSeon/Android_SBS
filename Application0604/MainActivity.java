package com.example.application0604;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    // 필드 영역에 해당 Activity 에서 조작할 View 들을
    // 참조할 참조 변수를 선언
    TextView blueText, greenText, orangeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//      setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_frame2);

        // 조작할 View 들을 탐색
        //  View 를 식별하기 위한 수단 → id 속성
        //  View 를 탐색하기 위한 메서드
        blueText = findViewById(R.id.blue_text);
        greenText = findViewById(R.id.green_text);
        orangeText = findViewById(R.id.orange_text);


    }

    // 버튼을 눌렀을 때 수행할 메서드
    public void onClickedColorButton(View v) {
        // 버튼이 클릭되면 해당 메서드가 실행되고
        // 클릭된 버튼이 매개변수로 업캐스팅되어 전달된다.

        // 모두 보여지지 않도록 숨긴다.
        blueText.setVisibility(View.INVISIBLE);
        greenText.setVisibility(View.INVISIBLE);
        orangeText.setVisibility(View.INVISIBLE);
        // 클릭된 버튼과 관련된 텍스트만 보이도록 한다.
        switch (v.getId()) {
            case R.id.blue_button:
                // 파랑만 보이도록
                blueText.setVisibility(View.VISIBLE);
                break;
            case R.id.green_button:
                // 초록만 보이도록
                greenText.setVisibility(View.VISIBLE);
                break;
            case R.id.orange_button:
                // 주황만 보이도록
                orangeText.setVisibility(View.VISIBLE);
                break;
            default:
                // 그 외
        }


    }

}