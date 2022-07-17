package com.example.example01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

// 채팅방 리스트출력하기 위한 Activity
//  - 채팅방에 대한 정보
//      - 채팅방 이름
//      - 마지막 채팅
//      - 마지막 채팅의 시간

public class MainActivity extends AppCompatActivity {
    ListView chattingRoomList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chattingRoomList = findViewById(R.id.listview);

        // 채팅방 정보를 가진  컬렉션
        ArrayList<HashMap<String, String>> chattingRooms = new ArrayList<>();
        // 첫번째 채팅방
        HashMap<String, String> room1 = new HashMap<>();
        room1.put("name", "홍길동");
        room1.put("last_chat", "Hello Android!");
        room1.put("last_time", "am 11:20");
        chattingRooms.add(room1);

        // 두 번째 채팅방
        HashMap<String, String> room2 = new HashMap<>();
        room2.put("name", "Android Group1");
        room2.put("last_chat", "Adapter Part 01");
        room2.put("last_time", "7월 9일");
        chattingRooms.add(room2);

        // 세 번째 채팅방
        HashMap<String, String> room3 = new HashMap<>();
        room3.put("name", "Ka Plus");
        room3.put("last_chat", "--");
        room3.put("last_time", "6월 10일");
        chattingRooms.add(room3);

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                chattingRooms,
                R.layout.item_chattingroom,
                new String[]{"name", "last_chat", "last_time"},
                new int[] {R.id.item_chattingroom_name, R.id.item_chattingroom_lastChat, R.id.item_chattingroom_time}
        );

        chattingRoomList.setAdapter(adapter);

    }
}












