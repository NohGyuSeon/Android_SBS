package com.example.example03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button sub01Button, sub02Button;
    TextView resultText;

    // Sub01Activity 를 호출하기 위한 요청 코드
    public static final int REQUEST_CODE_SUB01 = 1000;

    // Sub02Activity 를 호출하기 위한 요청 코드
    public static final int REQUEST_CODE_SUB02 = 1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sub01Button = findViewById(R.id.main_button_toSub01);
        sub02Button = findViewById(R.id.main_button_toSub02);
        resultText = findViewById(R.id.main_text_result);

        sub01Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Sub01Activity.class);
                startActivityForResult(intent, REQUEST_CODE_SUB01);
            }
        });

        sub02Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Sub02Activity.class);
                startActivityForResult(intent, REQUEST_CODE_SUB02);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_CANCELED) {
            resultText.setText("CANCELED!");
            return;
        }

        // 전달된 결과가 Sub01Activity 에서 온 경우
        if(requestCode == REQUEST_CODE_SUB01) {
            if(resultCode == RESULT_OK) {
                String str = data.getStringExtra("str");
                resultText.setText("Sub01 >>> " + str);
            }
        }
        // 전달된 결과가 Sub02Activity 에서 온 경우
        else if(requestCode == REQUEST_CODE_SUB02) {
            if(resultCode == RESULT_OK) {
                int num = data.getIntExtra("num", 0);
                resultText.setText("Sub02 >>> " + num);
            }
        }


    }
}