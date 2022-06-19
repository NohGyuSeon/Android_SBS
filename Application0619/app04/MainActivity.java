package com.example.app04_alert;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

// 사용자 알림
//  - 토스트(Toast)
//      - 화면에 간단히 뿌려지는 알림 창
//      - 디버깅 목적으로 사용하는 경우가 더 많다.
//  - 스낵바(Snack Bar)
//      - 토스트처럼 화면에 간단히 뿌려지는 알림 창
//      - 외부 라이브러리에 정의된 알림 창
//      - 버튼도 설정할 수 있다.
//  - 다이얼로그(Dialog)
//      - 사용자에게 메세지 또는 리스트와 같은 컨텐츠를 보여주고
//        다양한 기능을 제공하기 위한 알림 창
public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.main_text);
        // showToast();
        // showSnackBar();
        // showAlertDialog();
        showAlertDialog2();
    }

    @Override
    public void onBackPressed() {
        showAlertDialog();
    }

    String [] items = {"Apple", "Banana", "Candy", "Doll", "Egg"};
    private void showAlertDialog2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog dialog = builder
                .setIcon(R.drawable.ic_baseline_warning_24)
                .setTitle("선택")
                .setSingleChoiceItems(items,0,  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast
                            .makeText(MainActivity.this, "selected item = " + items[i], Toast.LENGTH_SHORT)
                            .show();
                    }
                })
                .setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("아니요", null)
                .setNeutralButton("취소", null)
                .setCancelable(false)
                .create();

        dialog.show();
    }

    private void showAlertDialog() {
        // 다이얼로그의 구성을 만들기 위한 클래스
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog dialog = builder
                .setIcon(R.drawable.ic_baseline_warning_24)
                .setTitle("종료")
                .setMessage("정말 종료하시겠습니까?")
                    .setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("아니요", null)
                .setNeutralButton("취소", null)
                .setCancelable(false)
                .create();

        dialog.show();
    }

    private void showSnackBar() {
        Snackbar
                .make(this, textView, "SnackBar Message", Snackbar.LENGTH_LONG)
                .setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                })
                .setActionTextColor(Color.YELLOW)
                .show();
    }

    private void showToast() {
        Toast
                .makeText(this, "Toast Message", Toast.LENGTH_LONG)
                .show(); // 토스트 메세지를 출력
        // Toast.LENGTH_SHORT : 2s
        // Toast.LENGTH_LONG  : 5s
    }
}