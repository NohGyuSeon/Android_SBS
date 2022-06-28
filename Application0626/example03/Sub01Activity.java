package com.example.example03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Sub01Activity extends AppCompatActivity {
    EditText strEdit;
    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub01);
        strEdit = findViewById(R.id.sub01_edit_string);
        submitButton = findViewById(R.id.sub01_button_submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = strEdit.getText().toString();

                if(str.isEmpty()) str = "No String";

                Intent data = new Intent();
                data.putExtra("str", str);


                setResult(RESULT_OK, data);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
    }
}