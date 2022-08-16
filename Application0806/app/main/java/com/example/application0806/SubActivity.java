package com.example.application0806;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SubActivity extends AppCompatActivity {
    Button signoutButton;
    Button submitButton;
    EditText newNameEdit;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        firebaseAuth = FirebaseAuth.getInstance();

        signoutButton = findViewById(R.id.sub_button_signout);
        signoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut(); // 로그아웃 , 인증 해제
            }
        });

        newNameEdit = findViewById(R.id.sub_edit_newName);
        submitButton = findViewById(R.id.sub_button_submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName = newNameEdit.getText().toString();

                if(newName == null || newName.isEmpty()) return;

                firebaseDatabase.getReference("UserList/"+firebaseAuth.getUid())
                        .child("name").setValue(newName);
            }
        });
    }
}