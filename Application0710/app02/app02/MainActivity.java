package com.example.app02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        // SimpleAdapter
        //  - 다수의 문자열 데이터를 하나의 항목으로 구성하는 어뎁터
        //  - 하나의 항목에 다수의 데이터가 들어가기 때문에
        //      한 항목에 들어갈 데이터들을 구분하여 저장
        // 다수의 항목을 저장하는 컬렉션
        ArrayList< HashMap<String, String> > datas = new ArrayList<>();

        // 하나의 항목을 구성할 데이터 집합
        HashMap<String, String> itemMap = new HashMap<>();
        itemMap.put("name", "홍길동");
        itemMap.put("profile", "Hello Android!");
//        itemMap.put("song_name", "song_file");
        datas.add(itemMap);

        itemMap = new HashMap<>();
        itemMap.put("name", "김철수");
        itemMap.put("profile", "Wonderful Day!");
//        itemMap.put("song_name", "song_file");
        datas.add(itemMap);


        SimpleAdapter adapter1 = new SimpleAdapter(
                // content 객체
                this,
                // 항목들을 저장하는 배열/컬렉션
                datas,
                // 하나의 항목을 구성할 레이아웃
                android.R.layout.simple_list_item_2,
                // 데이터를 추출하기 위한 key
                new String[] {"name", "profile"},
                // 추출된 데이터를 출력하기 위한 레이아웃 내의 View 의 id 들
                new int[] { android.R.id.text1, android.R.id.text2}
        );

        listView.setAdapter(adapter1);

    }
}








