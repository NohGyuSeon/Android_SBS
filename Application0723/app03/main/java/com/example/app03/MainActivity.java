package com.example.app03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.app03.Fragments.Sub01Fragment;
import com.example.app03.Fragments.Sub02Fragment;
import com.example.app03.Fragments.Sub03Fragment;

import java.util.ArrayList;

// ViewPager2
//   - View 뿐만 아니라 Fragment(부분 화면) 또한 전환이 가능하다.
//   - 이때는 FragmentStateAdapter 를 통해서 Adapter 를 구현
//   - TabLayout 과 연동


class SubFragmentAdapter extends FragmentStateAdapter {
    ArrayList<Fragment> fragments;
    public SubFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        fragments = new ArrayList<>();
        fragments.add(new Sub01Fragment());
        fragments.add(new Sub02Fragment());
        fragments.add(new Sub03Fragment());
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int p = position % fragments.size();

        Fragment fragment = null;
        if(p == 0) fragment = new Sub01Fragment();
        else if(p == 1) fragment = new Sub02Fragment();
        else if(p == 2) fragment = new Sub03Fragment();
        else return null;

        return fragment;
    }

    @Override
    public int getItemCount() {
        // return fragments.size();
        return Integer.MAX_VALUE;
    }
}
public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    SubFragmentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new SubFragmentAdapter(this);
        viewPager2 = findViewById(R.id.main_viewpager);
        viewPager2.setAdapter(adapter);
        viewPager2.setOffscreenPageLimit(1);
    }
}