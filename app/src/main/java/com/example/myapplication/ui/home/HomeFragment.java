package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.Adapter.Adapter;
import com.example.myapplication.BlankFragment;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private CardView car;
    private List<Fragment> fragments;
    private List<String>tabs;
    private Adapter adapter;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        tabLayout = root.findViewById(R.id.tablayout);
        car = root.findViewById(R.id.car);
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "点击这里跳转搜索Activity", Toast.LENGTH_SHORT).show();
            }
        });
        viewPager = root.findViewById(R.id.viewpager);
        fragments = new ArrayList<>();
        tabs = new ArrayList<>();
        tabs.add("推片");
        tabs.add("奔跑吧");
        tabs.add("电视剧");
        tabs.add("电影");
        tabs.add("综艺");
        tabs.add("综艺");
        tabs.add("综艺");
        tabs.add("电影");
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment());
        tabLayout.setupWithViewPager(viewPager);
        adapter = new Adapter(getChildFragmentManager(),fragments,tabs);
        viewPager.setAdapter(adapter);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}