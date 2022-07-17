package com.example.example02.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.example02.R;
import com.example.example02.VO.ChattingRoom;

import java.util.ArrayList;

public class ChattingRoomAdapter extends BaseAdapter {
    Context context;
    ArrayList<ChattingRoom> items;
    
    // @NonNull : null 이 올 수 없도록 설정
    public ChattingRoomAdapter(@NonNull Context context) {
        this.context = context;
    }

    public ChattingRoomAdapter(@NonNull Context context, ArrayList<ChattingRoom> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        
        // 인플레이션
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.item_chattingroom, viewGroup, false);

        TextView roomNameText = view.findViewById(R.id.item_chattingroom_name);
        TextView lastChatText = view.findViewById(R.id.item_chattingroom_lastChat);
        TextView lastTimeText = view.findViewById(R.id.item_chattingroom_time);

        ChattingRoom room = items.get(i);

        roomNameText.setText(room.getName());
        lastChatText.setText(room.getLastChat());
        lastTimeText.setText(room.getLastTime());

        return view;
    }
}
