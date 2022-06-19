package com.example.app02_login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    // View 들을 참조하기 위한 참조 변수 선언
    EditText accountEdit, passwordEdit;
    TextView alertText;
    Button submitButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // View 들을 참조
        accountEdit = findViewById(R.id.main_edit_account);
        passwordEdit = findViewById(R.id.main_edit_password);
        alertText = findViewById(R.id.main_text_errorAlert);
        submitButton = findViewById(R.id.main_button_submit);

        submitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() != R.id.main_button_submit) return;

        // 계정과 비밀번호가 입력이 됐는지 검사
        String account = accountEdit.getText().toString();
        String password = passwordEdit.getText().toString();

        if(account.isEmpty()) {
            alertText.setVisibility(View.VISIBLE);
            alertText.setText(getString(R.string.alert_no_account));
            return;
        }
        if(password.isEmpty()) {
            alertText.setVisibility(View.VISIBLE);
            alertText.setText(getString(R.string.alert_no_password));
            return;
        }

        // 정상적으로 입력됐으면 로그인 처리
        alertText.setVisibility(View.INVISIBLE);
    }
}