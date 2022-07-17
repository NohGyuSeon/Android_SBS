package com.example.application0716.Adapters;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.application0716.R;
import com.example.application0716.VO.Simple;

import java.util.ArrayList;

// BaseAdapter 클래스를 기반으로 
// 개발자만의 Adapter 클래스를 정의
public class MySimpleAdapter extends BaseAdapter {
    // ListView 에 출력할 데이터들의 저장소
    ArrayList<Simple> items;
    // 인플레이션을 하기 위한 Context 객체
    Context context;

    public MySimpleAdapter(Context context) {
        this(context, null);
    }

    public MySimpleAdapter(Context context, ArrayList<Simple> items) {
        if(items == null) items = new ArrayList<>();
        this.context = context;
        this.items = items;
    }

    //-----------------------------------------------------------
    // 새로운 항목을 추가하는 메서드
    public void addItem(Simple item) {
        // 새로운 항목을 저장소에 저장
        items.add(item);

        // 추가된 항목을 Adapter 에 반영
        notifyDataSetChanged();
    }
    //-----------------------------------------------------------


    @Override
    public int getCount() {
        // 출력할 항목의 수
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        // i 번째에 위치한 항목을 반환
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        // 하나의 항목을 Adapter 에 출력하기 위한 메서드

        // 커스텀 Adapter 를 만들 때 고려해야할 사항
        //  1. 레이아웃 초기화 성능 이슈
        //      문제점 : Adapter 가 항목을 구성하기 위해 레이아웃 xml 을 초기화를 하게 되는데
        //              더 이상 초기화를 하지 않아도 되는 경우에도 무조건 초기화를 하게 된다.
        //      해결   : 초기화(인플레이션)을 하기 전에는 null 이기 때문에
        //               convertView 객체가 null 인 경우에만 초기화를 해준다.
        //  2. View 탐색(반환) 시 성능 이슈
        //      문제점 : 항목 데이터를 View 에 설정해야하는 경우 매번 View 를 탐색
        //      해결   : 해당 convertView 에서 사용할 View 들을 한 번만 탐색하고
        //               탐색된 View 들을 묶어서 관리하기 위한 클래스(Holder class)를 정의
        //               Holder 클래스 내에서 View 들을 탐색하고 저장


        ItemHolder holder = null;

        // view 를 초기화(인플레이션)
        if(convertView == null) {
            // view 가 초기화되어있지 않다면 인플레이션을 해야하고
            // 이미 만들어져있는 경우에는 인플레이션 과정을 생략한다.
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_simple, viewGroup, false);
            
            // 인플레이션 과정을 거치면서 convertView 내에 정의된 View 들도 같이 탐색
            holder = new ItemHolder(convertView);

            // holder 객체를 convertView 내에 저장
            convertView.setTag(holder);
        } else { // 기존에 만들어진 convertView 를 재사용하는 경우

            // convertView 내에 저장된 holder 객체를 반환
            holder = (ItemHolder)convertView.getTag();
        }

        // View 객체를 반환
        // TextView simpleNameText = convertView.findViewById(R.id.item_name);
        // TextView simpleDataText = convertView.findViewById(R.id.item_data);

        // i 번째 항목 데이터를 반환
        Simple item = items.get(i);

        // 반환된 항목 데이터를 View 에 설정
        // simpleNameText.setText(item.getName());
        // simpleDataText.setText(item.getData() + "");

        holder.simpleNameText.setText(item.getName());
        holder.simpleDataText.setText(item.getData() + "");

        return convertView;
    }

    // convertView 에 정의된 View 들을 묶기 위한 Holder 클래스
    class ItemHolder {
        TextView simpleNameText;
        TextView simpleDataText;

        ItemHolder(View convertView) {
            // 항목 내에 정의된 View 들을 탐색 및 저장
            simpleNameText = convertView.findViewById(R.id.item_name);
            simpleDataText = convertView.findViewById(R.id.item_data);
        }
    }
}
