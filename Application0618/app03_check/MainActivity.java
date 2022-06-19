package com.example.app03_check;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBox1;
    TextView textView;
    // ------------------------------------\
    // RadioButton 들을 한 번에 다루기 위한 View
    RadioGroup radioGroup;
    RadioButton redRadio, greenRadio, blueRadio, blackRadio;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.main_text1);
        checkBox1 = findViewById(R.id.main_check1);
        // View 를 클릭했을 때 발생하는 이벤트
        /*
        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox1.isChecked()) textView.setTextColor(Color.RED);
                else textView.setTextColor(Color.BLACK);
            }
        });
        */

        // View 의 체크 상태가 바뀌면 발생하는 이벤트
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) textView.setTextColor(Color.RED);
                else textView.setTextColor(Color.BLACK);
            }
        });
        //-----------------------------------------------------------------
        radioGroup  = findViewById(R.id.main_radioGroup);
        redRadio =findViewById(R.id.main_radio_red);
        greenRadio =findViewById(R.id.main_radio_green);
        blueRadio =findViewById(R.id.main_radio_blue);
        blackRadio =findViewById(R.id.main_radio_black);
        textView2 = findViewById(R.id.main_text2);
        // 다수의 항목 중 하나의 체크 상태가 되면 이벤트가 발생
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                // radioGroup : 이벤트가 발생한 RadioGroup 객체
                // id : check 된 radio 버튼의 id 속성 값이 전달된다.
                //  = radioGroup.getCheckedRadioButtonId();
                int color = 0;
                if(id == R.id.main_radio_red) color = Color.RED;
                else if(id == R.id.main_radio_green) color= Color.GREEN;
                else if(id == R.id.main_radio_blue) color= Color.BLUE;
                else if(id == R.id.main_radio_black) color= Color.BLACK;

                textView2.setTextColor(color);
            }
        });
    
        // 체크 상태가 바뀌면 발생하는 이벤트이므로
        // 다른 라디오 버튼이 체크되면서 해당 라디오 버튼이 '해제될 때도' 이벤트가 발생
        redRadio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) return;

                Toast.makeText(MainActivity.this, "Unchecked!", Toast.LENGTH_SHORT).show();
            }
        });



    }
}