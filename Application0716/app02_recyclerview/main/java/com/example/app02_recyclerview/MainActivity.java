package com.example.app02_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.example.app02_recyclerview.Adapters.MySimpleAdapter;
import com.example.app02_recyclerview.VO.Simple;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MySimpleAdapter adapter;
    ArrayList<Simple> items = new ArrayList<Simple>();

    Random r = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 데이터셋 설정
        for(int i = 0; i < 100; i++) {
            items.add(new Simple("Data"+i, r.nextInt(100)));
        }

        recyclerView = findViewById(R.id.main_recyclerview);

        // Adapter 객체 생성
        adapter = new MySimpleAdapter(items);
        // Adapter 설정
        recyclerView.setAdapter(adapter);
        // RecyclerView 에 항목들을 출력할 방식을 설정
        //  - LayoutManager 클래스의 객체를 통해서 출력할 레이아웃을 결정
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // → 세로 방향(정방향)
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        // → 세로 방향(정방향)
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, true));
        // → 세로 방향(역방향)
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        // → 가로 방향(정방향)
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, true));
        // → 가로 방향(역방향)
        
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4, RecyclerView.VERTICAL, false));
        // 4칸씩 세로 방향(정방향)
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4, RecyclerView.VERTICAL, true));
        // 4칸씩 세로 방향(역방향)
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4, RecyclerView.HORIZONTAL, false));
        // 4칸씩 가로 방향(정방향)
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4, RecyclerView.HORIZONTAL, true));
        // 4칸씩 가로 방향(역방향)

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        // 4칸씩 세로 방향(높이가 불규칙)
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL));
        // 4칸씩 가로 방향(높이가 불규칙)


    }
}