package com.example.application0626;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

// 사용자 정의 클래스의 객체 전달
//  - Java 언어로 만들어진 객체를 Android System 에 전달에 전달되어야하기 때문에
//    이를 직렬화를 해야한다.
//       직렬화 : 데이터(객체)를 하나의 byte 형태로 변환
//  - Java 에서의 직렬화
//      - Serialization : 표준 Java 인터페이스
//      - Parcelable    : Android SDK 표준 인터페이스

class Simple implements Parcelable {
    private String name;
    private int data;

    public Simple(String name, int data) {
        this.name = name;
        this.data = data;
    }


    protected Simple(Parcel in) {
        name = in.readString();
        data = in.readInt();
    }

    public static final Creator<Simple> CREATOR = new Creator<Simple>() {
        @Override
        public Simple createFromParcel(Parcel in) {
            return new Simple(in);
        }

        @Override
        public Simple[] newArray(int size) {
            return new Simple[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        // Parcel 객체를 만들기 위한 메서드
        // Simple 객체 → Parcel 객체
        // 클래스의 정보를 Parcel 객체에 저장

        // Creator<Simple> 객체를 생성하면
        // 자동으로 코드를 완성되며, 저장되는 순서는 필드의 선언 순서와 동일하다.
        parcel.writeString(name);
        parcel.writeInt(data);
    }

    @Override
    public String toString() {
        return name+"("+data+")";
    }
}
public class MainActivity extends AppCompatActivity {
    Button toSubBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toSubBtn = findViewById(R.id.main_button);
        toSubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 다른 Activity 를 실행시키기 위해 Android System 에
                // 전달할 Intent 객체 생성
                Intent intent = new Intent(MainActivity.this, SubActivity.class);

                Simple obj = new Simple("Data1", 1000);
                // 사용자 정의 클래스인 Simple 클래스의 객체를 전달
                intent.putExtra("Simple", obj);


                // 생성된 Intent 객체를 전달
                startActivity(intent);
            }
        });
    }
}