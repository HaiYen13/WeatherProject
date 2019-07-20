package com.example.weatherappproject.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.weatherappproject.R;
import com.example.weatherappproject.adapter.ViewPageAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPage;
    private ViewPageAdapter mPageAdapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Weather");
        mViewPage = findViewById(R.id.mViewPager);
        mPageAdapter = new ViewPageAdapter
                (getSupportFragmentManager(), getListLayout());
        mViewPage.setAdapter(mPageAdapter);
        mViewPage.setCurrentItem(0, true);
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(mViewPage);
    }


    private ArrayList<Fragment> getListLayout(){
        ArrayList<Fragment> listFragment = new ArrayList<>();


        listFragment.add(new HomeFragment());
        listFragment.add(new EmptyFragment());
        listFragment.add(new ForecastFragment());
        listFragment.add(new HistoryFragment());
        //listFragment.add(new MapFragment());


        return listFragment;
    }

}

