package com.example.application0723;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

// ViewPage2
//  - 한 Activity 내에 View 또는 Fragment 간의 전환을 위한 View
//  - 기존의 ViewPage 를 개선한 View
//  - 개선된 점
//      - 수직 이동과 수평 이동 지원
//      - RecyclerView 기반으로 작성
//      - notifyDataSEtChanged 메서드 지원
//      - offscreenPageLimit 메서드를 통한 뷰 계층 제어
//      - RecyclerView.Adapter 와 FragmentStateAdapter 를 이용

//  - View 전환
//      RecyclerView.Adapter 를 이용하여 뷰의 항목을 나열 및 전환
//  - Fragment 전환(부분 화면)
//      FragmentStateAdapter 를 이용하여 Fragment 를 전환
//      FragmentStatePageAdapter 는 이전 ViewPager 에서 사용하는 Adapter 이므로
//      지금은 사용되지 않는다.

class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ItemViewHolder>{
    ArrayList<String> items;
    private static final int [] COLORS = {
        R.color.color1,
        R.color.color2,
        R.color.color3,
        R.color.color4,
        R.color.color5,
    };

    public ViewPagerAdapter() {
        this(null);
    }

    public ViewPagerAdapter(ArrayList<String> items) {
        if(items == null) items = new ArrayList<>();
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // item_view.xml 을 인플레이션

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);

        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        // ViewHolder 데이터를 설정
        String data = items.get(position);
        holder.textView.setText(data);
        int colorResIdx = position % COLORS.length;
        holder.textView.setBackgroundResource(COLORS[colorResIdx]);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        // item_view.xml 에 정의된 View 를 참조할 참조 변수
        TextView textView;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_text);
        }
    }
}


public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager;
    ViewPagerAdapter adapter;
    ArrayList<String> items = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0; i < 10; i++) {
            items.add("Item " + i);
        }

        adapter = new ViewPagerAdapter(items);


        viewPager = findViewById(R.id.main_viewPager);
        viewPager.setAdapter(adapter);
        // 좌우 여분 페이지 제한
        viewPager.setOffscreenPageLimit(1);
        // 슬라이드 방향
        viewPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        // 페이지 변환
        //  - 각 페이지마다 변화를 주기 위한 메서드
        //  - 페이지가 전환 될 때의 애니메이션을 만들 때도 사용
        viewPager.setPageTransformer(new ZoomOutPageTransformer());
    }
}


class ZoomOutPageTransformer implements ViewPager2.PageTransformer{
    // scale     : 배율(크기), 1 = 1배율, 1.5 = 1.5배, 0.75 = 0.75배
    // alpha     : 투명도(0~1), 낮을 수록 투명해진다.
    // translate : 위치

    // 최소 배율
    private static final float MIN_SCALE = 0.85F; // 0.85배
    // 최소 투명도
    private static final float MIN_ALPHA = 0.5F;  // 반투명

    @Override
    public void transformPage(@NonNull View page, float position) {
        if(position < -1) {
            // 왼쪽으로 이동하는 경우
            page.setAlpha(0);
        }else if(position <= 1) { // -1 <= position < 1

            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            // Math.abs() : 절대 값을 반환하는 메서드
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);

            float alphaFactor = Math.max(MIN_ALPHA, 1 - Math.abs(position));
            page.setAlpha(alphaFactor);
        }else { // position >= 1
            page.setAlpha(0);
        }
    }
}











