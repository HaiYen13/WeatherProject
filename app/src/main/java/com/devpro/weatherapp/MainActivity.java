package com.devpro.weatherapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager mViewPager;
    ViewPagerAdapter mPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.mViewPager);
        mPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),getListLayout());
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setCurrentItem(2, true);
    }

    private ArrayList<Fragment> getListLayout() {
        ArrayList<Fragment> listFragment = new ArrayList<>();
        listFragment.add(new HomeFragment());
        listFragment.add(new ChartFragment());
        listFragment.add(new HistoryFragment());
        return listFragment;


    }

}
