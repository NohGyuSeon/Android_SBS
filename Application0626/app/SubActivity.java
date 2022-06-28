package com.example.application0626;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        textView = findViewById(R.id.sub_text);

        Intent extra = getIntent();
        if(extra != null) {
            Simple obj = extra.getParcelableExtra("Simple");
            textView.setText(obj.toString());
        }
    }
}