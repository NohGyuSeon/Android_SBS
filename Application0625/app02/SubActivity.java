package com.example.app02_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        textView = findViewById(R.id.textView2);


        // 이전 Activity 에서 Intent 객체에 부가 데이터를 추가한다해도
        // 호출된 Activity 에 자동으로 전달되지 않는다.
        // 때문에, 안드로이스 시스템에 Intent 객체를 별도로 요청을 해야한다.
        Intent extra = getIntent();
        String dummyText = null;
        int dummyNumber = 0;
        if(extra != null) {
            dummyText = extra.getStringExtra("dummyText");
            dummyNumber = extra.getIntExtra("dummyNumber", 0);

        }

        textView.append("\n" + dummyText + " / " + dummyNumber);

    }
}