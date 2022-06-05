package com.example.app03;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // 입력을 받는 EditText 를 참조하는 변수
    EditText accountEdit, passwordEdit;
    // 알림을 주기 위한 TextView 를 참조하는 변수
    TextView alertText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // View 를 탐색
        //  → 입력된 값을 반환하는 것이 아니다.
        accountEdit = findViewById(R.id.main_edit_account);
        passwordEdit = findViewById(R.id.main_edit_password);
        alertText = findViewById(R.id.main_text_alert);
    }

    // login 버튼을 눌렀을 때
    //  계정이 입력되지 않았다면 "You must enter your account." 를 출력하고
    //  비밀번호가 입력되지 않았다면 "You must enter your password." 를 출력
    public void onSubmit(View v) {
        String account = accountEdit.getText().toString();
        String password = passwordEdit.getText().toString();

        if(account == null || account.isEmpty()) {
            alertText.setText("You must enter your account.");
            alertText.setVisibility(View.VISIBLE);
            return;
        }
        if(password == null || password.isEmpty()) {
            alertText.setText("You must enter your password");
            alertText.setVisibility(View.VISIBLE);
            return;
        }
        alertText.setVisibility(View.INVISIBLE);
        // 입력된 계정과 비밀번호를 검사
    }

}