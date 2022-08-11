package com.example.application0730;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBar actionBar;


    // DrawerLayout 과 ActionBar 를 연동하여
    // 서로 상호작용이 되어지는 토글 버튼
    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.main_drawer);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // toggle 버튼 생성
        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.string.nav_open,
                R.string.nav_close
        );

        // 연동
        drawerToggle.syncState();
        drawerLayout.addDrawerListener(drawerToggle);
        //-------------------------------------------------
        navigationView = findViewById(R.id.main_side_navigation);
        // NavigationView 의 메뉴 항목을 선택했을 때 이벤트가 발생
        // navigationView.setNavigationItemSelectedListener(new On); + 입력 후 자동 완성
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // 선택된 항목의 이름
                String title = item.getTitle().toString();

                Toast
                    .makeText(MainActivity.this, title+" clicked!", Toast.LENGTH_LONG)
                    .show();
                
                // 클릭한 다음 NavigationView 를 닫히도록 설정
                drawerLayout.closeDrawer(GravityCompat.START);

                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // ActionBar 내의 메뉴를 클릭했을 때
        if(drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        // 뒤로가기 버튼을 눌렀을 때

        // 현재 NavigationView 가 보여지고 있으면
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            // NavigationView 를 숨긴다.
            drawerLayout.closeDrawer(GravityCompat.START);

            // Activity 가 종료되지 않도록 메서드 종료
            return;
        }

        super.onBackPressed();
    }
}