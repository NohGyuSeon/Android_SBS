package com.example.app02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// 기존의 ActionBar 대신 Toolbar 를 사용
// ActionBar 의 기능들을 그대로 유지해야한다면
// ActionBar 를 Toolbar 로 설정
public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ActionBar actionBar;

    RecyclerView recyclerView;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); 
        // ActionBar 를 toolbar 로 설정

        actionBar = getSupportActionBar();

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new MyAdapter();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ItemViewHolder> {

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(android.R.layout.simple_list_item_1, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.textView.setText("Item : " + (position+1));
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            // 안드로이드 내에서 미리 정의된 레이아웃의 View
            textView = itemView.findViewById(android.R.id.text1);
        }
    }
}