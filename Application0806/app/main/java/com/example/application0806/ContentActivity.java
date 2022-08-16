package com.example.application0806;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.application0806.VO.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ContentActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    Button toSubButton;
    TextView welcomeText;
    User currentUser = null;

    @Override
    protected void onStart() {
        super.onStart();

        // 로그인한 상태가 아니면
        if(firebaseAuth.getCurrentUser() == null) {
            // 로그인 Activity 로 이동
            startActivity(new Intent(this, LoginActivity.class));
            Toast.makeText(this, "인증되지 않은 계정입니다.", Toast.LENGTH_SHORT).show();
            finish();
        }
        try {
            // 로그인한 상태이면 로그인된 계정을 반환
            Intent data = getIntent();
            currentUser = data.getParcelableExtra("CurrentUser");

            if(currentUser == null) {
                firebaseDatabase.getReference("UserList/" + firebaseAuth.getUid())
                        .addValueEventListener(new ValueEventListener() {
                            // 하위 데이터가 바뀔 때 마다 발생하는 이벤트
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                currentUser = snapshot.getValue(User.class);
                                welcomeText.setText(currentUser.getName() + "님 환영합니다.");
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });
            }

        }catch (NullPointerException e) {
            e.printStackTrace();
            firebaseAuth.signOut();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        firebaseAuth=FirebaseAuth.getInstance();

        welcomeText = findViewById(R.id.content_text_welcome);
        toSubButton = findViewById(R.id.content_button_sub);

        toSubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(ContentActivity.this, SubActivity.class));

            }
        });

    }


}