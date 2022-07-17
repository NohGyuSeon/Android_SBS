package com.example.app02_recyclerview.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app02_recyclerview.R;
import com.example.app02_recyclerview.VO.Simple;

import java.util.ArrayList;

// RecyclerView 에 설정할 Adapter 를 정의할 때는
// RecyclerView 의 Adapter 클래스를 상속
public class MySimpleAdapter extends RecyclerView.Adapter< MySimpleAdapter.ItemViewHolder > {
    ArrayList<Simple> items;

    public MySimpleAdapter() {
        this(null);
    }


    public MySimpleAdapter(ArrayList<Simple> items) {
        if(items == null) items = new ArrayList<>();
        this.items = items;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 항목을 구성하기 위한 xml 파일을 인플레이션하는 메서드
        // VewHolder 클래스의 객체를 생성하는 메서드
        
        // 인플레이션
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_simple, parent,false);
        
        // ViewHolder 클래스의 객체 생성
        ItemViewHolder viewHolder = new ItemViewHolder(view);
        
        // ViewHolder 클래스의 객체 반환
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        // 항목을 RecyclerView 에 출력할 때마다 호출되는 메서드
        // onCreateViewHolder() 에서 생성된 holder 객체가 매개변수로 전달된다.

        // position 인덱스에 위치한 항목 데이터를 반환
        Simple item = items.get(position);

        // 항목 데이터를 holder 내의 View 에 설정
        holder.nameText.setText(item.getName());
        holder.dataText.setText(item.getData() + "");
    }

    @Override
    public int getItemCount() {
        // 출력할 항목의 수를 반환
        return items.size();
    }

    // 항목을 표시하기 위한 레이아웃 내의 구성 요소(View)를
    // 탐색하고 저장하기 위한 Holder 클래스
    //   - RecyclerView 클래스 내에 정의된 ViewHolder 클래스를 상속
    class ItemViewHolder extends RecyclerView.ViewHolder {
        // View 객체 참조할 레퍼런스 변수 선언
        TextView nameText;
        TextView dataText;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            
            // 항목 내 View 객체 탐색
            nameText = itemView.findViewById(R.id.item_name);
            dataText = itemView.findViewById(R.id.item_data);
        }
    }

}















