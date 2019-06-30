package com.devpro.weatherapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mListFragments;

    public ViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> mListFragments) {
        super(fm);
        this.mListFragments = mListFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.mListFragments.get(position);
    }

    @Override
    public int getCount() {
        return this.mListFragments.size();
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
    if(position == 0){
        return "Home Fragment";
    }else if(position ==1){
        return "Chart Fragment";
    }else if(position ==2){
        return "History Fragment";
    }else{
        return "";
    }

    }
}
