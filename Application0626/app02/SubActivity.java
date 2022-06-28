    package com.example.app02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity extends AppCompatActivity {
    public static final int RESULT_FAIL = -100;
    EditText num1Edit, num2Edit;
    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        num1Edit = findViewById(R.id.sub_edit_num1);
        num2Edit = findViewById(R.id.sub_edit_num2);
        submitButton = findViewById(R.id.sub_button_ok);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = num1Edit.getText().toString();
                String str2 = num2Edit.getText().toString();

                if(str1.isEmpty() || str2.isEmpty()) {
                    setResult(RESULT_FAIL);
                    finish();
                    return;
                }

                int num1 = Integer.parseInt(str1);
                int num2 = Integer.parseInt(str2);

                // 이전 Activity 인 MainActivity 에 데이터를 전달하기 위해
                // 데이터를 저장할 Intent 객체를 생성
                Intent intent = new Intent();
                intent.putExtra("number1", num1);
                intent.putExtra("number2", num2);

                // 이전 Activity 로 데이터를 전달하는 메서드
                //  setResult(int resultCode[, Intent data]);
                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
    }
}