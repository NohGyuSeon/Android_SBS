package com.example.example01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.example01.VO.Product;

public class PaymentActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        textView = findViewById(R.id.payment_text_product);

        Intent extra = getIntent();
        if(extra != null) {
            Product product = extra.getParcelableExtra("product");
            textView.setText(product.toString());
        }


    }
}