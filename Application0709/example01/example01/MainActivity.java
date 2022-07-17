package com.example.example01;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


// ActionBar 에 메뉴를 추가
//  - Home Up
//  - Search        : ActionBar
//  - Person        : ActionBar
//  - Setting       : Overflow Menu
//  - Help          : Overflow Menu

public class MainActivity extends AppCompatActivity {
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    // 메뉴를 설정하기 위한 메서드
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // menu_actionbar.xml 을 메뉴 인플레이션
        getMenuInflater().inflate(R.menu.menu_actionbar, menu);

        try {
            Method method = menu
                    .getClass()
                    .getDeclaredMethod("setOptionalIconsVisible", boolean.class);

            method.setAccessible(true);
            method.invoke(menu, true);
        }catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return super.onCreateOptionsMenu(menu);
    }
}