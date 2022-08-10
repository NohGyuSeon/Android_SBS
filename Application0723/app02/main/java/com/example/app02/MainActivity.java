package com.example.app02;

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


class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ItemViewHolder>{
    ArrayList<String> items;

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

        for(int i = 0; i < 20; i++) {
            items.add("Item "+i);
        }

        adapter = new ViewPagerAdapter(items);

        viewPager = findViewById(R.id.main_viewpager);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        viewPager.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float pageMargin = getResources().getDimensionPixelOffset(R.dimen.pageMargin);
                float pageOffset = getResources().getDimensionPixelOffset(R.dimen.pageOffset);

                float moveTo = -(pageMargin + pageOffset*2)*position;

                page.setTranslationX(moveTo);
            }
        });
    }
}











