package com.example.application0619;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

// 하이어라키 이벤트 모델(Hierarchy Event Model)
//  - Activity 에서 발생하는 이벤트를 처리하는 방식
//  - 키보드 또는 볼륨과 같은 하드웨어서 발생하는 이벤트를
//    처리할 때 사용된다.
//  - Activity 내에서 이벤트 핸들러를 오버라이딩하여 구현

// 터치 이벤트(Touch Event)
//  - Activity 또는 View 를 터치했을 때 발생하는 이벤트
//      Activity 에서 발생하는 이벤트 : 메서드를 오버라이딩
//      View 에서 발생하는 이벤트 : 이벤트 리스너를 구현

public class MainActivity extends AppCompatActivity {
    TextView logText;
    TextView touchArea, gestureArea;

    // 제스처 이벤트를 처리하기 위한 클래스
    GestureDetector detector;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logText = findViewById(R.id.main_text_log);
        logText.setText("");

        touchArea = findViewById(R.id.main_touchArea);
        gestureArea = findViewById(R.id.main_gestureArea);

        touchArea.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                appendToLog("touchArea Touched!");
                return false;
            }
        });


        // 각 제스처를 취했을 때 수행할 핸들러들을 가진 클래스의 객체
        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                // 터치를 했을 때
                return true;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {
                // 짧게 터치 했을 때
            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                // 한 손가락으로 탭했을 때
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                // 터치한 상태에서 스크롤링할 때
                return true;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                // 길게 터치 했을 때
            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                // 가속도를 붙는 상태로 스크롤링할 때
                return true;
            }
        });

        gestureArea.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                // 이베트가 발생한 좌표
                //  - 이벤트가 발생한 객체를 기준으로 한 좌표
                double x = event.getX(), y = event.getY();
                //  - Activity 를 기준으로 한 좌표
                double rawX = event.getRawX(), rawY = event.getRawY();

                Log.i("Gesture Raw X", "rawX "+ event.getRawX());
                Log.i("Gesture  X", "x "+ event.getX());

                String pos = String.format("(%.2f, %.2f)", x, y);
                String rawPos = String.format("(%.2f, %.2f)", rawX, rawY);

                appendToLog("gestureArea Touched!");
                appendToLog("\t>>> " + pos + " / " + rawPos);
                //--------------------------------------------------------------
                // 제스처 이벤트를 처리하기 위해 터치 이벤트에 대한 정보를 넘긴다.
                if(detector.onTouchEvent(event))
                        return true; // 계속해서 이벤트를 받는다.

                return false; // 단 한 번만 수행
            }
        });
    }
    /*
    // Activity 를 터치했을 때 수행할 메서드
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // MotionEvent : 터치 모션에 대한 행동을 정의 및 구현한 클래스
        // MotionEvent 객체 : 터치했을 때의 정보를 담고 있는 객체
        
        // 터치 모션에 대한 정보
        int action = event.getAction();
        if(action == MotionEvent.ACTION_DOWN) { // 터치를 눌렀을 때
            appendToLog("Touch Down!");
        }else if(action == MotionEvent.ACTION_MOVE) { // 터치한 상태에서 움직일 때
            appendToLog("Touch Move!");
        }else if(action == MotionEvent.ACTION_UP) { // 터치를 땠을 때
            appendToLog("Touch Up!");
        }
        
        // 이베트가 발생한 좌표
        //  - 이벤트가 발생한 객체를 기준으로 한 좌표
        double x = event.getX(), y = event.getY();
        //  - Activity 를 기준으로 한 좌표
        double rawX = event.getRawX(), rawY = event.getRawY();

        String pos = String.format("(%.2f, %.2f)", x, y);
        String rawPos = String.format("(%.2f, %.2f)", rawX, rawY);
        appendToLog("\t>>> " + pos + " / " + rawPos);

        return super.onTouchEvent(event);
    }
    */
    private void appendToLog(String message) {
        logText.append(message + "\n");
    }

}



















