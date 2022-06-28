package com.example.application0625;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.main_text);

        // showDialog();
        // showSingleDialog();
    }

    @Override
    public void onBackPressed() {
        // showSingleDialog();
        showMultiDialog();
    }

    String items[] = {"Apple", "Banana", "Candy", "Doll", "Egg"};
    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_baseline_format_list_bulleted_24)
                .setTitle("항목 선택")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        textView.setText("Selected Item = " + items[i]);
                    }
                })
                .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        textView.setText("Cancelled!");
                    }
                })
                .setCancelable(false)
                .create() // AlertDialog 객체로 생성
                .show();
    }

    int choice = 3;
    int tmpChoice = 0;
    private void showSingleDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_baseline_format_list_bulleted_24)
                .setTitle("항목 선택")
                .setSingleChoiceItems(items, choice, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "selected " + i, Toast.LENGTH_SHORT).show();
                        // 선택한 항목의 인덱스를 임시변수에 저장
                        tmpChoice = i;
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // 항목을 선택했을 때 적용하는 것이 아니라
                        // 선택하고 취소할 수 있기 때문에
                        // OK 버튼을 눌렀을 때 적용을 해야한다.
                        choice=tmpChoice;
                        textView.setText("Choice Item = " + items[choice]);
                    }
                })
                .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        textView.setText("Cancelled!");
                    }
                })
                .setCancelable(false)
                .create() // AlertDialog 객체로 생성
                .show();
    }


    boolean checked[] = new boolean[items.length];

    // 기존의 체크된 항목들
    boolean tmpChecked[] = new boolean[checked.length];

    private void showMultiDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_baseline_format_list_bulleted_24)
                .setTitle("항목 선택")
                .setMultiChoiceItems(items, checked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        Toast.makeText(MainActivity.this, "selected " + i + " > " + b, Toast.LENGTH_SHORT).show();

                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        textView.setText(System.identityHashCode(checked) +", " + System.identityHashCode(tmpChecked));
                        textView.append("\nChecked Items = ");
                        for(int idx = 0; idx < checked.length; idx++) {
                            if(!checked[idx]) continue;

                            textView.append(items[idx]+ " ");
                        }

                        // 최근 체크된 항목들을 임시 배열에 저장.
                        tmpChecked = Arrays.copyOf(checked, checked.length);
                    }
                })
                .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // 취소된 경우 임시 배열에 저장된 체크 상태를
                        // checked 배열에 복사하여 저장.
                        checked = Arrays.copyOf(tmpChecked, tmpChecked.length);
                    }
                })
                .setCancelable(false)
                .create() // AlertDialog 객체로 생성
                .show();
    }
}