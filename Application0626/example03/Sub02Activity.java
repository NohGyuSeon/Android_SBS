package com.example.example03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Sub02Activity extends AppCompatActivity {
    EditText numEdit;
    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub02);

        numEdit = findViewById(R.id.sub02_edit_decimal);
        submitButton = findViewById(R.id.sub02_button_submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numStr = numEdit.getText().toString();

                if(numStr.isEmpty()) numStr = "0";

                int num = Integer.parseInt(numStr);
                Intent data = new Intent();
                data.putExtra("num", num);

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