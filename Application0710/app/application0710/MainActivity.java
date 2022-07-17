package com.example.application0710;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

// AdapterView
//  - 다수의 데이터를 나열하기 위한 View
//      ListView, GrideView, Spinner, RecycerView
//  - 다수의 데이터를 AdapterView 에 출력하기 위한
//    Adapter 클래스의 객체가 필요하다.
//      Activity -- Data --> Adapter -- Data --> AdapterView
//  - Adapter 종류
//      - BaseAdapter
//      - ArrayAdapter  : 항목에 하나의 문자열 데이터를 출력하기 위한 Adapter
//      - SimpleAdapter : 항목에 다수의 문자열 데이터를 출력하기 위한 Adapter

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        String data[] = {
                "apple",
                "banana",
                "candy",
                "doll",
                "egg"
        };
        String data2[] = getResources().getStringArray(R.array.items);

        // 배열 data 에 저장된 값들을
        // ListView 에 출력하기 위해
        // Adapter 클래스의 객체가 필요
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this, // context 객체
                android.R.layout.simple_list_item_1,
                // 항목을 구성하기 위한 레이아웃 xml 파일
                data2 // 항목을 구성할 데이터 배열(컬렉션)
        );
        listView.setAdapter(adapter);

        // 개발자가 작성한 item 레이아웃을 통해 항목을 출력
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(
                this,
                R.layout.item_list, // item 을 출력하기 위한 레이아웃
                R.id.item_text,     // 레이이웃 내에 데이터를 출력할 View
                data2
        );
        listView.setAdapter(adapter2);
        
        
        // 안드로이드에서 제공하는 기본 레이아웃
        //  - android.R.layout.simple_list_item_multiple_choice
        //      : 하나의 문자열과 체크 박스로 구성된 레이아웃
        //  - android.R.layout.simple_list_item_single_choice
        //      : 하나의 문자열과 라디오 버튼으로 구성된 레이아웃
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(
                this, // context 객체
                android.R.layout.simple_list_item_multiple_choice,
                // 항목을 구성하기 위한 레이아웃 xml 파일
                data2 // 항목을 구성할 데이터 배열(컬렉션)
        );
        listView.setAdapter(adapter3);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

        ArrayAdapter<String> adapter4 = new ArrayAdapter<>(
                this, // context 객체
                android.R.layout.simple_list_item_single_choice,
                // 항목을 구성하기 위한 레이아웃 xml 파일
                data2 // 항목을 구성할 데이터 배열(컬렉션)
        );
        listView.setAdapter(adapter4);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);

    }
}