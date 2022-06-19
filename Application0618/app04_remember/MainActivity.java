package com.example.app04_remember;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    CheckBox rememberCheck;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.main_edit);
        textView = findViewById(R.id.main_text);
        rememberCheck = findViewById(R.id.check_remember);
        button = findViewById(R.id.main_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = editText.getText().toString();
                textView.setText(input);

                // 기억하지 않을거면 입력된 값을 삭제
                boolean isRemember = rememberCheck.isChecked();
                if(!isRemember) editText.setText("");
            }
        });
    }
}