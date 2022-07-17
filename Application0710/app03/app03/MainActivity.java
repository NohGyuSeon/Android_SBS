package com.example.app03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.app03.Adapters.MySimpleAdapter;
import com.example.app03.VO.Simple;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView simpleList;
    ArrayList<Simple> simples = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleList = findViewById(R.id.list_simple);

        simples.add(new Simple("홍길동", "user01@noplay.com"));
        simples.add(new Simple("김철수", "user02@noplay.com"));
        simples.add(new Simple("이영희", "user03@noplay.com"));
        simples.add(new Simple("고길동", "user04@noplay.com"));
        simples.add(new Simple("황정식", "user05@noplay.com"));

        MySimpleAdapter adapter = new MySimpleAdapter(this, simples);
        simpleList.setAdapter(adapter);
    }
}