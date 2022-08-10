package com.example.application0717;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.application0717.Adapters.UserAdapter;
import com.example.application0717.VO.User;

import java.util.ArrayList;

// 사용자(User)의 정보를 나열하기 위한 Activity
//  사용자(User)의 정보
//    - ID
//    - 이름
//    - 메일주소

public class MainActivity extends AppCompatActivity {
    RecyclerView userRecyclerView;
    UserAdapter adapter;
    ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0; i < 30; i++) {
            String id = "user" + (i+1);
            String name = "userName" + (i+1);
            String mail = "userMail" + (i+1) + "@android.com";
            users.add(new User(id, name, mail));
        }
        //----------------------------------------------------------------
        adapter = new UserAdapter(users);
        //----------------------------------------------------------------
        userRecyclerView = findViewById(R.id.main_recyler_users);
        userRecyclerView.setAdapter(adapter);
        userRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 세로 방향 나열
        //----------------------------------------------------------------
        Button addButton = findViewById(R.id.main_button_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = adapter.getItemCount() + 1;
                String id = "user" + (num);
                String name = "userName" + (num);
                String mail = "userMail" + (num) + "@android.com";
                User user = new User(id, name, mail);

                adapter.addItem(user);
            }
        });





    }
}