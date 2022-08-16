package com.example.application0806;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class MainActivity extends AppCompatActivity {
    FirebaseRemoteConfig remoteConfig;

    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 원격 구성 서비스를 사용하기 위한 객체를 반환
        remoteConfig = FirebaseRemoteConfig.getInstance();

        firebaseAuth = FirebaseAuth.getInstance();

        //String mail = firebaseAuth.getCurrentUser().getEmail();
        //Log.d("FireBase Test", "Current User's mail : " + mail);



        // 원격으로 구성하기 위한 데이터를 불러오는 시간을 설정
        // - 개발자 모드(디버깅용)
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setMinimumFetchIntervalInSeconds(0)
                .build();
        remoteConfig.setConfigSettingsAsync(configSettings);
    
        // xml 폴더의 remote_config_default.xml 을 기본 값으로 설정
        remoteConfig.setDefaultsAsync(R.xml.remote_config_default);

        // remoteConfig 객체에 서버에 설정된 구성들을 불러온다.
        remoteConfig.fetchAndActivate()
                .addOnCompleteListener(this, new OnCompleteListener<Boolean>() {
                    @Override
                    public void onComplete(@NonNull Task<Boolean> task) {
                        // 완료가 되어질때 발생하는 이벤트
                        // - 성공, 실패 여부 상관 없이 발생한다.

                        if(task.isSuccessful()) {
                            boolean updated = task.getResult();
                            Log.d("FireBase Test", "Config params updated: " + updated);
                            Toast.makeText(MainActivity.this, "Fetch and activate succeed!", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this, "Fetch and activate failed!", Toast.LENGTH_SHORT).show();
                        }

                        displayWelcomeMessage();
                    }
                });
    }

    private void displayWelcomeMessage() {
        // 서버에서 값을 반환
        boolean isCheck = remoteConfig.getBoolean("app_service_checking");
        String message = remoteConfig.getString("message_for_checking");

        if(isCheck) { // 앱을 점검하기 위한 조건문
            new AlertDialog.Builder(this)
                    .setMessage(message)
                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish(); // 앱을 종료
                        }
                    }).create().show();

            return;
        }

        // 점검을 하지 않는 경우에는
        // 다음 Activity 로 넘어가면 된다.
        Intent intent = null;
        if(firebaseAuth.getCurrentUser() == null)   // 현재 로그아웃 상태이면
            intent = new Intent(this, LoginActivity.class);
        else                                        // 현재 로그인 상태이면
            intent = new Intent(this, ContentActivity.class);

        startActivity(intent);

        // 스플래시화면(로딩 화면)은 맨 처음 보여지고
        // 다음 화면으로 넘어갈 때 종료시켜야한다.
        finish();

    }
}