package com.example.example01_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


// LoginActivity 에서 계정과 비밀번호를 정상적으로 입력하고
// 로그인 버튼을 누르면 MainActivity 로 이동되도록 하고
// 회원가입 버튼을 누르면 SignupActivity 로 이동되록 작성
//  → 회원가입으로 넘어갈 때는 계정과 비밀번호 입력 유무는 상관 없다.

public class LoginActivity extends AppCompatActivity {
    EditText accountEdit, passwordEdit;
    Button submitButton, toSignupButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        accountEdit = findViewById(R.id.login_edit_account);
        passwordEdit = findViewById(R.id.login_edit_password);
        submitButton = findViewById(R.id.login_button_submit);
        toSignupButton = findViewById(R.id.login_button_toSignup);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 계정과 비밀번호가 정상적으로 입력된 경우에만
                // MainActivity 를 실행
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();

                if(account.isEmpty() || password.isEmpty()) return;
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                startActivity(intent);
                // 로그인을 성공적으로 되었다면
                // 로그인창은 종료를 해주는 것이 일반적이다.
                finish(); // Activity 를 종료
            }
        });
        toSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);

                startActivity(intent);
            }
        });
    }
}