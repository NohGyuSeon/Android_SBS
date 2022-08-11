package com.example.example01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.example01.Fragments.ContactsFragment;
import com.example.example01.Fragments.FavoriteFragment;
import com.example.example01.Fragments.RecentsFragment;
import com.example.example01.Fragments.VoicemailFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

// 다수의 Fragment 를 ViewPager2 에 출력하기 위한 Adapter
class SubFragmentStateAdapter extends FragmentStateAdapter {
    public SubFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 0) return new FavoriteFragment();
        if(position == 1) return new RecentsFragment();
        if(position == 2) return new ContactsFragment();
        if(position == 3) return new VoicemailFragment();

        return null;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    SubFragmentStateAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new SubFragmentStateAdapter(this);

        tabLayout = findViewById(R.id.main_layout_tab);
        viewPager2 = findViewById(R.id.main_viewpager);
        viewPager2.setAdapter(adapter);
        viewPager2.setOffscreenPageLimit(1);

        // TabLayout 과 ViewPager2 를 연동
        TabLayoutMediator mediator = new TabLayoutMediator(
                tabLayout,
                viewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    int selectedColor = ContextCompat.getColor(
                            MainActivity.this,
                            R.color.selectedTabColor
                    );
                    int unselectedColor = ContextCompat.getColor(
                            MainActivity.this,
                            R.color.unselectedTabColor
                    );

                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        // ViewPager2 에 출력되는 Fragment 의 수에 맞춰
                        // TabLayout 의 TabItem 을 생성
                        if(position == 0) {
                            tab.setText("Favorites");
                            tab.setIcon(R.drawable.ic_baseline_favorite_24);
                            tab.getIcon().setTint(selectedColor);
                        }else if(position == 1) {
                            tab.setText("Recent");
                            tab.setIcon(R.drawable.ic_baseline_access_time_24);
                            tab.getIcon().setTint(unselectedColor);
                        }else if(position == 2) {
                            tab.setText("Contacts");
                            tab.setIcon(R.drawable.ic_baseline_people_24);
                            tab.getIcon().setTint(unselectedColor);
                        }else if(position == 3) {
                            tab.setText("Voicemail");
                            tab.setIcon(R.drawable.ic_baseline_voicemail_24);
                            tab.getIcon().setTint(unselectedColor);
                        }
                    }
                }
        );
        // 적용
        mediator.attach();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            int selectedColor = ContextCompat.getColor(
                    MainActivity.this,
                    R.color.selectedTabColor
            );
            int unselectedColor = ContextCompat.getColor(
                    MainActivity.this,
                    R.color.unselectedTabColor
            );
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setTint(selectedColor);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setTint(unselectedColor);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}