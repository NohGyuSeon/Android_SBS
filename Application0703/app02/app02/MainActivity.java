package com.example.app02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// Java/Kotlin 코드로 동적으로 추가/설정하는 방법
//  → FragmentManager 클래스
//  → FragmentTransaction 클래스
//      → 트랜젝션을 통해서 프래그먼트를 추가/수정/삭제를 할 수 있다.
//          추가 : add() 메서드
//          수정 : replace() 메서드
//          삭제 : remove() 메서드
public class MainActivity extends AppCompatActivity {
    // Java 코드로 프래그먼트 출력
    // 1. FragmentManager 클래스의 객체를 반환
    FragmentManager manager = getSupportFragmentManager();

    // 2. FragmentTransaction 클래스의 객체를 반환
    FragmentTransaction transaction = manager.beginTransaction();
    // Transaction : 변경 사항 or 명령어들의 집합

    Button sub01Frag, sub02Frag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 3. 프래그먼트를 출력
        //      > 출력할 프래그먼트의 객체
        Fragment sub01Fragment = new Sub01Fragment(); // 업캐스팅
        //      > 프래그먼트를 출력할 View 의 id
        int containerResId = R.id.main_fragment_container;

        // 첫번째 인자 : 출력할 View 의 ID
        // 두번째 인자 : 출력할 Fragment 의 객체
        transaction.add(containerResId, sub01Fragment);
        // add() 메서드 : 프래그먼트를 추가
        //transaction.replace(containerResId, sub01Fragment);
        // replace() 메서드 : 프래그먼트를 수정

        // 4. 트랜젝션을 적용
        transaction.commit();

        //---------------------------------------------
        sub01Frag = findViewById(R.id.main_button_sub01);
        sub02Frag = findViewById(R.id.main_button_sub02);

        sub01Frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = manager.beginTransaction();
                transaction.replace(
                        R.id.main_fragment_container,
                        new Sub01Fragment()
                ).commit();
            }
        });
        sub02Frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = manager.beginTransaction();
                transaction.replace(
                        R.id.main_fragment_container,
                        new Sub02Fragment()
                ).commit();
            }
        });

    }
}