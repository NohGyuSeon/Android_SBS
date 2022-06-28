package com.example.app02;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// Activity 간 데이터 전달
//  호출된 Activity 에서 이전 Activity 에 데이터를 전달
//   → MainActivity 에서 특정 기능을 위해 SubActivity 를 실행하고
//     그 결과를 받아오기 위한 경우에 사용된다.
//   → startActivityForResult() 메서드      : 구 버전
//   → ActivityResultLauncher 클래스의 객체  : 신 버전
public class MainActivity extends AppCompatActivity {
    Button toSubButton;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.main_text_result);
        toSubButton = findViewById(R.id.main_button);

        toSubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);

                // startActivity(intent);

                // Activity 를 실행하는 목적이 특정 결과를 요구하기 위해 실행하는 것이라면
                // startActivityForResult() 메서드를 이용하며
                // 실행되는 Activity 에 맞는 코드 값을 같이 전달
                // startActivityForResult(intent, 1000);
                // requestCode : Activity 를 어떤 요청을 보냈는지 의미를 표현하는 코드

                // ActivityResultLauncher 를 이용하여 Activity 를 실행
                subActivityResultLauncher.launch(intent);
            }
        });
    }

    // startActivityForResult() 메서드로 호출된 Activity 에서
    // 전달한 데이터를 처리하기 위한 메서드
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 매개변수
        //  - requestCode : 요청 코드
        //  - resultCode  : 결과 코드
        //  - data        : Activity 에서 전달한 데이터가 저장된 Intent 객체
        if(requestCode == 1000) {
            if (resultCode == RESULT_OK) {
                int num1 = data.getIntExtra("number1", 0);
                int num2 = data.getIntExtra("number2", 0);
                textView.setText("num1 = " + num1 + ", num2 = " + num2);
            }else if(resultCode == RESULT_CANCELED) {
                textView.setText("RESULT : CANCELED!");
            }else if(resultCode == SubActivity.RESULT_FAIL) {
                textView.setText("RESULT : FAIL!");
            }
        }
    }
    // ---------------------------------------------------------------
    //  ActivityResultLauncher 클래스를 이용
    ActivityResultLauncher<Intent> subActivityResultLauncher = registerForActivityResult(
            // Activity 를 띄우는 목적
            new ActivityResultContracts.StartActivityForResult(),
            // 결과 값을 받고 처리할 콜백 메서드를 가진 클래스
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    // result 객체에 결과 코드와 Activity 가 전달한 데이터가 저장되어있다.
                    if(result.getResultCode() == RESULT_OK) {
                        // result.getData() = Activity 에서 전달한 Intent 객체를 반환
                        Intent data = result.getData();
                        int num1 = data.getIntExtra("number1", 0);
                        int num2 = data.getIntExtra("number2", 0);
                        textView.setText("num1 = " + num1 + ", num2 = " + num2);
                    }else if(result.getResultCode() == RESULT_CANCELED) {
                        textView.setText("RESULT : CANCELED!");
                    }
                }
            }
    );
}















