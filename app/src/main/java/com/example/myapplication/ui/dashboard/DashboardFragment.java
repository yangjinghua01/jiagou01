package com.example.myapplication.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.myapplication.Adapter.RecyclerAdapter;
import com.example.myapplication.Names;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentDashboardBinding;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private List<Names> names = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = root.findViewById(R.id.recyclerview);
//        staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        names.add(new Names("分类1","1",R.drawable.ab));
        names.add(new Names("分类1","2",R.drawable.ac));
        names.add(new Names("分类1","3",R.drawable.ad));
        names.add(new Names("分类1","4",R.drawable.ae));
        names.add(new Names("分类1","5",R.drawable.ac));
        names.add(new Names("分类1","6",R.drawable.bc));
        names.add(new Names("分类1","7",R.drawable.bd));
        names.add(new Names("分类1","8",R.drawable.cd));
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),4));
        adapter = new RecyclerAdapter(names);
        recyclerView.setAdapter(adapter);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}