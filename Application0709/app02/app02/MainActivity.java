package com.example.app02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

// ActionView
//  - ActionBar 에서 제공되는 View
//  - 가장 많이 사용되는 View 는 SearchView 이다.
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    SearchView searchView;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actionbar, menu);

        // SearchView 객체를 반환
        searchView = (SearchView)menu.findItem(R.id.menu_search).getActionView();
        searchView.setQueryHint("검색...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // 입력을 완료한 뒤 검색 버튼을 눌렀을 때
                Toast.makeText(MainActivity.this, "Search : " + query, Toast.LENGTH_SHORT).show();
                searchView.onActionViewCollapsed();
                // ↔ .onActionViewExtended() = 입력 모드
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // 입력된 값이 바뀔 때         
                //  = 입력이 될 때 마다
                //  = 입력된 문구를 지울 때 마다
                int length = newText.length();

                Toast.makeText(MainActivity.this, length + "/10", Toast.LENGTH_SHORT).show();

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}