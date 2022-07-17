package com.example.example02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.example02.Adapters.ChattingRoomAdapter;
import com.example.example02.VO.ChattingRoom;

import java.util.ArrayList;

// 채팅방 리스트출력하기 위한 Activity
//  - 채팅방에 대한 정보(ChattingRoom)
//      - 채팅방 이름
//      - 마지막 채팅
//      - 마지막 채팅의 시간

public class MainActivity extends AppCompatActivity {
    ListView chattingList;
    ArrayList<ChattingRoom> rooms = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chattingList = findViewById(R.id.list_chattringrooms);

        rooms.add(new ChattingRoom("홍길동", "Hello Android!", "am 11:20"));
        rooms.add(new ChattingRoom("채팅방 A", "Have a nice day!", "am 11:00 "));
        rooms.add(new ChattingRoom("Plus App", "Hello Application!", "7월 9일"));

        ChattingRoomAdapter adapter = new ChattingRoomAdapter(this, rooms);
        chattingList.setAdapter(adapter);
    }
}