package com.example.application0605;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

// Java 파일에서 View 를 조작
//  - Java 파일에서 Resource 에 있는 View 또는 그 외 자원(데이터)를
//    사용하기 위해서는 각 요소들의 식별자나 이름이 필요하다.
//  - 이름 또는 식별자가 있어야 Java 파일에서 불러와서 사용할 수 있다.
//  - onCreate() 메서드에서 조작할 View 들을 참조(탐색)
//      - 클래스 내에서 사용하려면 View 를 참조하는 변수를 필드로 선언
public class MainActivity extends AppCompatActivity {
    // Activity 에서 조작할 TextView 를 참조하는 참조 변수
    TextView countText;
    // 버튼을 누른 횟수를 저장하는 변수
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView() : 지정된 레이아웃을 화면에 출력
        //                  : 정의된 View 들도 객체로 생성 → 인플레이션(Inflation)
        setContentView(R.layout.activity_main);

        // setContentView() 메서드 이후부터 View 들을 탐색할 수 있다.
        // View 를 탐색하기 위한 메서드
        //  - findViewById(int resId)
        countText = findViewById(R.id.textView_count);

        // colors.xml 파일에 정의된 색상으로 적용
        countText.setBackgroundResource(R.color.purple_700);
        // Color 클래스에 정의된 색상으로 적용
        countText.setTextColor(Color.WHITE);
    }

    // 클릭 이벤트가 발생했을 때 수행할 메서드
    public void onClickedCountButton(View v) {
        count++;
        countText.setText("count : " + count);
    }

    public void onClickedClearButton(View v) {
        count = 0;
        countText.setText("count : " + count);
    }
}