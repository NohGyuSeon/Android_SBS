package com.example.example01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.example01.VO.Product;

// 상품의 정보를 표현하는 클래스 Product 를 정의
//  필드
//      - 상품 명
//      - 가격
//  생성자
//  Getter&Setter

// MainActivity 에서 Pay 버튼을 클릭하면
// 3000원짜리 사과를 표현하는 Product 객체를
// PaymentActivity 전달하여 출력




public class MainActivity extends AppCompatActivity {
    Button paymentButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        paymentButton = findViewById(R.id.main_button_pay);

        paymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PaymentActivity.class);

                Product apple = new Product("Apple", 3000);
                intent.putExtra("product", apple);


                startActivity(intent);
            }
        });
    }
}