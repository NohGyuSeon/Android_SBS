package com.example.app02_viewpager2;

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

// ViewPager2 에서 사용할 Adapter
class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ItemViewHolder> {
    ArrayList<String> items;

    public ViewPagerAdapter(ArrayList<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.textView.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_textView);
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

        for(int i = 0; i < 5; i++) {
            items.add("String Data : " + i);
        }
        adapter = new ViewPagerAdapter(items);

        viewPager = findViewById(R.id.main_viewpager);
        viewPager.setAdapter(adapter);
        // 화면에 출력활 최대 페이지 수
        viewPager.setOffscreenPageLimit(2);
    }
}