package com.example.app03.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.app03.R;
import com.example.app03.VO.Simple;

import java.util.ArrayList;

// 커스텀 Adapter
public class MySimpleAdapter extends BaseAdapter {
    // 항목들을 저장하는 저장소
    ArrayList<Simple> items;
    Context context;
    public MySimpleAdapter(Context context) {
        this(context, null);
    }

    public MySimpleAdapter(Context context, ArrayList<Simple> items) {
        if(items == null) items = new ArrayList<>();

        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        // AdapterView 에 출력할 항목의 수를 반환
        return items.size(); // 모든 항목을 출력
        // return 10;              // 최대 10개의 항목만 출력
    }

    @Override
    public Object getItem(int i) {
        // i 번째 데이터를 반환
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        // 데이터를 식별하기 위한 값을 반환
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // 한 항목을 AdapterView 에 출력하기 위한 메서드
        // 즉, 모든 항목을 한 번에 출력하는 것이 아닌
        // 출력할 항목의 수 만큼 메서드를 호출

        // 매개변수
        //  - i     : 출력할 항목의 인덱스
        //  - view  : AdapterView 에 출력할 항목을 표현한 View
        //          : 한 화면에 출력될 만큼 생성
        //          : 스크롤되면서 화면에 보이지 않는 View 는
        //            새롭게 화면에 보여지는 View 로 재사용된다.
        //  - viewGroup : view 를 포함할 상위 레이아웃
        //-----------------------------------------------------------
        // 수행해야할 과정
        //  1. view 를 초기화(인플레이션)
        //  2. View 객체를 반환
        //  3. 항목 데이터를 반환
        //  4. 반환된 View 에 데이터를 설정
        //  5. 알고리즘에 의한 데이터 설정
        //  6. 이벤트 연결
        //-----------------------------------------------------------
        //  1. view 를 초기화(인플레이션)
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.item_simple, viewGroup, false);
        //  2. View 객체를 반환
        TextView simpleText1 = view.findViewById(R.id.item_simple_text1);
        TextView simpleText2 = view.findViewById(R.id.item_simple_text2);
        //  3. 항목 데이터를 반환
        Simple item = items.get(i);
        //  4. 반환된 View 에 데이터를 설정
        simpleText1.setText(item.getName());
        simpleText2.setText(item.getMail());
        //  5. 알고리즘에 의한 데이터 설정
        //  6. 이벤트 연결

        return view;
    }
}
