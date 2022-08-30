package com.example.app02_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ListView;

import com.example.app02_recyclerview.Adapters.MySimpleAdapter;
import com.example.app02_recyclerview.VO.Simple;

import java.util.ArrayList;
import java.util.Random;

/*
1. 준비
        a. RecyclerView 출력할 데이터를 VO 클래스로 작성
        b. 하나의 항목을 표시할 XML 레이아웃을 작성
        c. Activity에 RecyclerView 배치

2. Adapter 작성
        a. Adater 클래스 작성
            i. 데이터 항목을 저장하기 위한 배열 또는 컬렉션을 선언
            ii. 생성자 작성
        b. Adapter 클래스에서 사용할 ViewHolder 클래스를 작성
            i. RecycleView.ViewHolder 를 상속
            ii. 1.b 에서 작성한 레이아웃에서 정의한 뷰들을 참조
            iii. 참조된 뷰에 데이터 항목을 설정하는 메서드를 작성 (선택)
        c. Adapter를 완성하기 위한 RecycleView.Adpater<ViewHolder>를 상속
        d. 오바리이딩된 메서드를 구현
            i. onCreateViewHolder구현 - ViewHolder를 생성하여 반환하는 메서드
            ii. onBindViewHolder 구현 - 생성된 ViewHolder에 데이터 항목을 설정하기 위한 메서드
            iii. getItemCount 구현

3. RecyclerView 설정
        a. RecyclerView에 LayoutManager를 통해서 레이아웃 구성을 설정
        b. RecyclerView에 Adapter를 설정

4. ItemDecoration, ItemAnimation 등을 통해 다양한 효과를 설정 (선택)
*/

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