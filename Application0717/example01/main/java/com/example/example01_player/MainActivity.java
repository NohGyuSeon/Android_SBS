package com.example.example01_player;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.example01_player.Adapters.PlayerAdapter;
import com.example.example01_player.VO.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


// 30명 정도의 플레이어 점수를 화면에 출력
//  플레이어(Player) 정보
//   - 플레이어의 이름
//   - 점수
// + 점수 내림차순으로 정렬하여 출력
// + 버튼을 추가하여 플레이어 정보를 추가

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    EditText playerNameEdit;
    Button addButton;

    PlayerAdapter adapter;
    ArrayList<Player> players = new ArrayList<>();
    Random r = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0;i<3;i++) {
            String name = "Player"+i;
            // 800 <= score <= 1000
            int score = r.nextInt(201) + 800;
            players.add(new Player(name, score));
        }

        // ArrayList 객체를 정렬
        //  사용자 정의 클래스의 객체를 저장하고 있는 List 인 경우에는
        //  다른 객체들과 비교가 가능하도록 Comparable 인터페이스를 구현
        Collections.sort(players);

        //---------------------------------------------------
        adapter = new PlayerAdapter(players);
        //---------------------------------------------------
        recyclerView = findViewById(R.id.main_recyclerview_players);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //---------------------------------------------------
        playerNameEdit = findViewById(R.id.main_edit_player);
        addButton = findViewById(R.id.main_button_add);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = playerNameEdit.getText().toString();
                if(name.isEmpty()) return;

                int score = r.nextInt(101) + 900;

                adapter.addScore(new Player(name, score));
                playerNameEdit.setText("");
            }
        });



    }
}