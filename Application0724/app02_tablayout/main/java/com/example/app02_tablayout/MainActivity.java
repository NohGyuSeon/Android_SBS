package com.example.app02_tablayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.app02_tablayout.SubFragments.Sub01Fragment;
import com.example.app02_tablayout.SubFragments.Sub02Fragment;
import com.example.app02_tablayout.SubFragments.Sub03Fragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

class SubFragmentAdapter extends FragmentStateAdapter {

    public SubFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        position %= 3;
        if(position == 0) return new Sub01Fragment();
        else if(position == 1) return new Sub02Fragment();
        else if(position == 2) return new Sub03Fragment();

        return null;
    }

    @Override
    public int getItemCount() {
        return 30;
    }
}
public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager;
    TabLayout tabLayout;
    SubFragmentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new SubFragmentAdapter(this);
        tabLayout = findViewById(R.id.main_bottom_tab);
        viewPager = findViewById(R.id.main_viewpager);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(1);

        TabLayoutMediator mediator = new TabLayoutMediator(
                tabLayout,
                viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    int selectedColor = ContextCompat.getColor(
                            MainActivity.this,
                            R.color.selectedTabColor
                    );
                    int unselectedColor =ContextCompat.getColor(
                            MainActivity.this,
                            R.color.unselectedTabColor
                    );
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                // 탭 메뉴를 설정하기 위한 메서드
                // 맨 처음 단 한 번 호출
                // tab.setText("Sub0"+position);

                String tabText=null;
                int tabIcon = 0;
                int color = 0;
                position %= 3;
                if(position == 0) {
                    tabText = "Friends";
                    tabIcon = R.drawable.ic_baseline_people_24;
                    color = selectedColor;
                } else if(position == 1) {
                    tabText = "Favorite";
                    tabIcon = R.drawable.ic_baseline_favorite_24;
                    color = unselectedColor;
                } else if(position == 2) {
                    tabText = "Setting";
                    tabIcon = R.drawable.ic_baseline_settings_24;
                    color = unselectedColor;
                }

                tab.setText(tabText);
                tab.setIcon(tabIcon);
                // 아이콘의 색상
                tab.getIcon().setTint(color);
            }
        });
        // 적용
        mediator.attach();

        // 탭 메뉴를 터치했을 때 아이콘의 색상이 바뀌도록 하기 위해서는
        // 탭 메뉴의 선택에 따른 상황마다 설정을 해줘야한다.
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            int selectedColor = ContextCompat.getColor(
                    MainActivity.this,
                    R.color.selectedTabColor
            );
            int unselectedColor =ContextCompat.getColor(
                    MainActivity.this,
                    R.color.unselectedTabColor
            );
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // 다른 탭 메뉴에서 선택 됐을 때
                tab.getIcon().setTint(selectedColor);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // 다른 탭 메뉴가 선택 됐을 때
                tab.getIcon().setTint(unselectedColor);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // 활성화된 탭 메뉴를 다시 선택한 경우
            }
        });


    }
}











