package com.example.application0703;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Sub01Fragment extends Fragment {
    // fragment_sub01.xml 에 정의된 View
    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //  인플레이션 : xml 파일을 메모리에 객체화하는 과정
        //            : 객체화가 되어진 다음 화면에 출력될 수 있다.
        View root = inflater.inflate(R.layout.fragment_sub01, container, false);

        // fragment_sub01.xml 에 정의된 View 들을 참조
        textView = root.findViewById(R.id.sub01_frag_text);

        textView.setText("Hello Sub01 Fragment!!");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.append("\nClicked!!");
            }
        });

        return root;
    }
}