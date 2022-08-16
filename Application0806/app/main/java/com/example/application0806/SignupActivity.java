package com.example.application0806;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {
    EditText emailEdit, passwordEdit, nameEdit;
    Button submit;

    FirebaseAuth firebaseAuth;
    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        // DatabaseReference usersPath = database.getReference("Users");
        // usersPath.setValue("User01");

        //database
        //        .getReference("TestGroup/TestValues")
        //        .setValue("TestValue01");

        // userList 하위에 "uid0002"를 지정한 경로
        DatabaseReference userPath = database.getReference("userList/uid0004");

        // 지정된 경로 내에 email, password, name 노드를 생성하고
        // 각각 값을 설정
        //userPath.child("email").setValue("android02@android.org");
        //userPath.child("password").setValue("12312311123");
        //userPath.child("name").setValue("android02");

        // 객체를 저장하게 되면 하위 노드로 필드와 저장된 값이 저장된다.
        //User newUser = new User("android04@android.org", "123123", "android04", "Hello!!!");
        //userPath.setValue(newUser);



        emailEdit = findViewById(R.id.signup_edit_email);
        passwordEdit = findViewById(R.id.signup_edit_password);
        nameEdit = findViewById(R.id.signup_edit_name);
        submit = findViewById(R.id.signup_button_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                String name = nameEdit.getText().toString();

                if(!isAvailable(email) || !isAvailable(password) || !isAvailable(name)) {
                    Toast.makeText(SignupActivity.this, "입력되지 않은 값이 있습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()) {
                                    // 성공적으로 회원가입이 된 경우

                                    Toast.makeText(SignupActivity.this, "회원 가입을 축하합니다.", Toast.LENGTH_SHORT).show();

                                    User newUser = new User(email, password, name);

                                    database.getReference("UserList/"+firebaseAuth.getUid()) // 회원 가입한 유저의 정보를 저장하기 위한 경로(노드)
                                            .setValue(newUser);

                                    // 계정을 추가하면 추가된 계정으로 로그인 상태가 되어진다.
                                    // 따라서, 로그아웃 처리를 해야한다.
                                    firebaseAuth.signOut(); //

                                    // 회원가입을 완료했기 때문에 이전 페이지로 이동
                                    finish();
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






