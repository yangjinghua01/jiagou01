package com.example.myapplication.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends FragmentPagerAdapter {
      private List<Fragment> fragments=new ArrayList<>();
    private List<String>tabs=new ArrayList<>();
    public Adapter(@NonNull FragmentManager fm, List<Fragment> fragments, List<String> tabs) {
        super(fm);
        this.fragments = fragments;
        this.tabs = tabs;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position);
    }
}
