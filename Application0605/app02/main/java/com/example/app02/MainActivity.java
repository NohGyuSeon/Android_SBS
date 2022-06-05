package com.example.app02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // TextView 를 참조할 참조 변수
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TextView 를 탐색
        textView = findViewById(R.id.textView);
    }

    // lipsum01 ~ lipsum03 버튼을 눌렀을 때 수행할 메서드
    public void onClickedLipsumButton(View v) {

        // 누른 버튼에 따라 strings.xml 에 정의된 문자열을 반환
        //  R.id.lipsum01 → R.string.lipsum01
        //  R.id.lipsum02 → R.string.lipsum02
        //  R.id.lipsum03 → R.string.lipsum03

        // strings.xml 에 정의된 문자열을 저장하기 위한 변수
        String str = null;

        if(v.getId() == R.id.button_lipsum1) {
            // getString() : strings.xml 에 정의된 문자열을 반환하는 메서드
            str = getString(R.string.lipsum01);
        }else if(v.getId() == R.id.button_lipsum2) {
            str = getString(R.string.lipsum02);
        }else if(v.getId() == R.id.button_lipsum3) {
            str = getString(R.string.lipsum03);
        }

        // 기존 text 에 이어서 str 을 다음 줄에 출력
        String old = textView.getText().toString();
        textView.setText(old + "\n" + str);

        // textView.append("\n" + str);
    }
}















