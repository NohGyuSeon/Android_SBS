package com.example.example02_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.example02_login.VO.User;

// 사용자 정보를 표현하기 위한 클래스 User 를 정의
//  필드
//    - ID
//    - 비밀번호
//    - 이름
//    - 나이
//  생성자
//    - ID, 비밀번호 초기화하는 생성자
//    - 모든 필드 초기화하는 생성자
//  Getter & Setter

// 계정과 비밀번호를 입력을 받고 로그인 버튼을 누르면
// 저장된 사용자 정보와 비교하여 일치하면
// 로그인한 User 의 정보를 MainActivity 를 실행과 함께 전달하여 출력
public class LoginActivity extends AppCompatActivity {
    // 사용자가 입력한 계정과 비밀번호를 비교할 User 객체
    User user = new User("account01", "1234", "홍길동", 20);

    EditText userIdEdit, userPasswordEdit;
    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userIdEdit = findViewById(R.id.login_edit_id);
        userPasswordEdit = findViewById(R.id.login_edit_password);
        submitButton = findViewById(R.id.login_button_submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userId = userIdEdit.getText().toString();
                String userPw = userPasswordEdit.getText().toString();

                if(userId.isEmpty() || userPw.isEmpty()) return;

                User u = new User(userId, userPw);
                // user 객체와 정보가 다르면 메서드를 종료
                if(!u.equals(user)) return;

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                
                // 사용자 정의 클래스인 User 객체를 넘기려면
                // 해당 클래스에 Parcelable 인터페이스를 반드시 구현
                intent.putExtra("currentUser", user);

                startActivity(intent);
            }
        });

    }
}