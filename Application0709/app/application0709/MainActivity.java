package com.example.application0709;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button actionToggle;

    // ActionBar 를 참조할 참조 변수
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ActionBar 객체를 반환
        actionBar = getSupportActionBar();
        
        // ActionBar 의 구성 관련 메서드
        actionBar.setTitle("Main Title!");
        actionBar.setSubtitle("Sub Title!");
        actionBar.setDisplayHomeAsUpEnabled(true);
        // = UP 아이콘 추가
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        // actionBar.setIcon(R.drawable.ic_baseline_ac_unit_24);
        actionBar.setLogo(R.drawable.ic_baseline_ac_unit_24);
    
        // ActionBar 내의 메뉴 구성

        //------------------------------------------------------------
        actionToggle = findViewById(R.id.main_button_toggle);
        actionToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ActionBar 가 보이고 있는 상태이면
                if(actionBar.isShowing())
                    actionBar.hide(); // ActionBar 숨기기
                else
                    actionBar.show(); // ActionBar 보이기
            }
        });
    }

    // 메뉴가 만들어질 때 최초 한 번 호출되는 메서드
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 메뉴에 구성될 항목들을 작성한 xml 이 있는 경우
        // 해당 xml 파일을 menu 객체에 인플레이션
        
        // MenuInflater 객체 반환
        MenuInflater menuInflater = getMenuInflater();
        // menu_actionbar.xml 인플레이션
        menuInflater.inflate(R.menu.menu_actiobar, menu);
        //---------------------------------------------------
        menu.add("MainMenu4");

        return super.onCreateOptionsMenu(menu);
    }

    // 메뉴의 아이템을 클릭했을 때 수행하는 메서드
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // item 객체 : 클릭된 메뉴의 항목
        if(item.getItemId() == android.R.id.home) { // UP 아이콘의 ID
            Toast.makeText(this, "HOME AS UP CLICK!", Toast.LENGTH_SHORT).show();
//            finish();
            return true;
        }
        else if(item.getItemId() == R.id.menu1) {
            Toast.makeText(this, "Menu01", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}