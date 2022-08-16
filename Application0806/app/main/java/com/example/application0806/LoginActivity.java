package com.example.application0806;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.application0806.VO.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    EditText emailEdit, passwordEdit;
    Button toSignupButton, submitButton;

    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDb;
    User currentUser = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDb = FirebaseDatabase.getInstance();

        toSignupButton = findViewById(R.id.login_button_signup);
        toSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
        //----------------------------------------------------------------
        emailEdit = findViewById(R.id.login_edit_email);
        passwordEdit = findViewById(R.id.login_edit_password);
        submitButton = findViewById(R.id.login_button_submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEdit.getText().toString();
                String password = passwordEdit.getText().toString();

                if(!isAvailable(email) || !isAvailable(password)) {
                    Toast.makeText(LoginActivity.this, "이메일 또는 비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()) {

                                    // 로그인을 성공한 경우
                                    firebaseDb.getReference("UserList/" + firebaseAuth.getUid())
                                            .addListenerForSingleValueEvent(new ValueEventListener() {
                                                // 딱 한번 데이터를 읽어오기 위한 이벤트
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                    // 경로에 지정된 하위 데이터들이 수정되면 호출

                                                    // String name = (String)snapshot.child("name").getValue();
                                                    currentUser = snapshot.getValue(User.class);

                                                    Toast.makeText(LoginActivity.this, currentUser.getName() + "님 환영합니다!", Toast.LENGTH_SHORT).show();
                                                    Intent intent = new Intent(LoginActivity.this, ContentActivity.class);
                                                    intent.putExtra("CurrentUser", currentUser);
                                                    startActivity(intent);
                                                    finish();
                                                }

                                                @Override
                                                public void onCancelled(@NonNull DatabaseError error) {

                                                }
                                            });


                                }else {
                                    // 로그인을 실패한 경우
                                    Toast.makeText(LoginActivity.this, "이메일 또는 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }

    // 유효한 문자열인지 검사
    private boolean isAvailable(String str) {
        // 유효하지 않은 경우
        // str == null || str.isEmpty()

        // 유효한 경우
        // !(str == null) || !(str.isEmpty())

        return !(str == null && str.isEmpty());
    }
}