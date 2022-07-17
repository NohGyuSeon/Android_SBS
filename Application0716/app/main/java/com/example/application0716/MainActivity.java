package com.example.application0716;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.application0716.Adapters.MySimpleAdapter;
import com.example.application0716.VO.Simple;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView simpleListView;
    Button itemAddButton;

    // Simple 클래스의 객체들을 저장하기 위한 저장소
    ArrayList<Simple> items = new ArrayList<>();

    // 저장소 items 를 ListView 에 출력하기 위한 Adapter
    MySimpleAdapter adapter;

    Random r = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleListView = findViewById(R.id.main_listView);

        for(int i = 0; i < 30; i++) {
            items.add(new Simple("Name" + i, r.nextInt(100)));
        }

        Log.i("items", items.toString());
        
        // items 에 저장된 Simple 객체를
        // simpleListView 에 각 항목으로 출력
        
        // 이때 ListView 에 출력하기 위해서 Adapter 클래스가 필요
        // 개발자가 원하는 방식으로 출력하기 위해 Adapter 를 직업 구현

        // Adapter 객체 생성
        adapter = new MySimpleAdapter(this, items);
        
        // ListView 에 Adapter 를 설정
        simpleListView.setAdapter(adapter);
        //---------------------------------------------------
        itemAddButton = findViewById(R.id.main_button_addItem);
        itemAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ListView 에 새로운 항목을 추가하여 출력

                String name = "New Name" + (adapter.getCount());
                int data = r.nextInt(100);

                Simple item = new Simple(name, data);
                
                // Adapter 객체의 저장소에 새로운 항목을 추가
                adapter.addItem(item);

                // Adapter 객체는 AdapterView 에 추가될 때
                // 자신이 가진 저장소에 있는 항목들을 한 번 출력
                // 그 이후에는 출력이나 수정을 하지 않는다.

                // 저장소에 새로운 항목이 추가되거나
                // 기존 항목이 삭제되거나
                // 기존 항목의 내용이 수정되었을 때 이를 반영하기 위해
                // Adapter 의 notifyDataSetChanged() 메서드를 호출
                // adapter.notifyDataSetChanged(); // 수정된 데이터 저장소를 반영

                Log.i("items", items.toString());
            }
        });
    }
}