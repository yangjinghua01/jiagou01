package com.example.myapplication;

import androidx.annotation.RequiresApi;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.myapplication.Adapter.Adapter2;
import com.example.myapplication.Adapter.RecyclerAdapter;
import com.example.myapplication.Names;
import com.example.myapplication.R;


import java.util.ArrayList;
import java.util.List;

public class BlankFragment extends Fragment {
    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private RecyclerAdapter adapter;
    private Adapter2 adapter2;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ArrayList<Integer> list_path;
    private List<String>car;
    private RecyclerView recyclerView2;
    private List<Names>names = new ArrayList<>();
    public static BlankFragment newInstance() {
        return new BlankFragment();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.blank_fragment, container, false);
        car = new ArrayList<>();
        car.add("全部");
        car.add("黑灯影院");
        car.add("港片影厅");
        car.add("每日福利");
        car.add("全网热门");
        car.add("vip会员");
        car.add("在线购票");
        car.add("好片推荐");
        names.add(new Names("女演员严厉","20万+弹幕",R.drawable.ab));
        names.add(new Names("刘老根4","买票相亲",R.drawable.ac));
        names.add(new Names("逆天奇案","弹幕热议",R.drawable.ad));
        names.add(new Names("20岁爆笑预警","元气少年毕业之旅",R.drawable.ae));
        names.add(new Names("山河令","为新浪复仇却惨死人渣之手",R.drawable.ac));
        names.add(new Names("伙计超强大脑","欧阳震华演绎香港交警故事",R.drawable.bc));
        names.add(new Names("检查组幕后黑手","冯森设局",R.drawable.bd));
        names.add(new Names("小女正面开撕","废柴少女逆袭暴富气疯绿茶女",R.drawable.cd));
        names.add(new Names("贵州大山隐居","有山有水有房子",R.drawable.cf));
        names.add(new Names("逆天奇案","弹幕热议",R.drawable.ad));
        names.add(new Names("20岁爆笑预警","元气少年毕业之旅",R.drawable.ae));
        names.add(new Names("山河令","为新浪复仇却惨死人渣之手",R.drawable.ad));
        names.add(new Names("小女正面开撕","废柴少女逆袭暴富气疯绿茶女",R.drawable.cd));
        names.add(new Names("贵州大山隐居","有山有水有房子",R.drawable.cf));
        names.add(new Names("逆天奇案","弹幕热议",R.drawable.ad));
        list_path = new ArrayList<>();

        list_path.add(R.drawable.zc);
        list_path.add(R.drawable.zx);
        list_path.add(R.drawable.zc);
        list_path.add(R.drawable.zx);
        //设置内置样式，共有六种可以点入
//        mbanner = root.findViewById(R.id.mbanner);
//        for (int i = 0; i <list_path.size() ; i++) {
//            mbanner.setImageLoader(new ImageLoader() {
//                @Override
//                public void displayImage(Context context, Object path, ImageView imageView) {
//                    Glide.with(getContext()).load(path).into(imageView);
//                }
//            });
//        }
//        mbanner.setImages(list_path);
//        mbanner.isAutoPlay(true);
//        //设置图片切换时间
//        mbanner.setDelayTime(2000);
//        mbanner.start();
//        mbanner.setOnBannerListener(new OnBannerListener() {
//            @Override
//            public void OnBannerClick(int position) {
//                Toast.makeText(getContext(), "点击了图片"+position, Toast.LENGTH_SHORT).show();
//            }
//        });
        recyclerView2=root.findViewById(R.id.recyclerview2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        adapter2 = new Adapter2(car);
        recyclerView2.setAdapter(adapter2);
        swipeRefreshLayout = (SwipeRefreshLayout)root.findViewById(R.id.mSwipeRefreshLayout);
        //设置进度圈的大小;(这里面只有两个值SwipeRefreshLayout.LARGE和DEFAULT，后者是默认效果)
        swipeRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
        //设置进度圈的背景色。这里随便给他设置了一个颜色：浅绿色
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Color.CYAN);
        //设置进度动画的颜色。这里面最多可以指定四个颜色，我这也是随机设置的，大家知道怎么用就可以了
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_orange_dark);
        recyclerView = root.findViewById(R.id.recyclerview);
//        staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),4));
        adapter = new RecyclerAdapter(names);
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                //发送一个延时1秒的handler信息
                handler.sendEmptyMessageDelayed(199, 1000);
            }

        });

        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                switch (newState){
                    case  AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                        if(layoutManager.findLastCompletelyVisibleItemPosition()==(layoutManager.getItemCount()-1)){
                        names.add(new Names("检查组幕后黑手","冯森设局",R.drawable.bd));
                        names.add(new Names("小女正面开撕","废柴少女逆袭暴富气疯绿茶女",R.drawable.cd));
                        names.add(new Names("贵州大山隐居","有山有水有房子",R.drawable.cf));
                        names.add(new Names("逆天奇案","弹幕热议",R.drawable.ad));
                        names.add(new Names("20岁爆笑预警","元气少年毕业之旅",R.drawable.ae));
                        names.add(new Names("山河令","为新浪复仇却惨死人渣之手",R.drawable.ac));
                        names.add(new Names("小女正面开撕","废柴少女逆袭暴富气疯绿茶女",R.drawable.cd));
//                        names.add(new Names("贵州大山隐居","有山有水有房子",R.drawable.cf));
                        adapter.notifyDataSetChanged();
                    }
                    break;
                }
            }
        });


        return root;
    }
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==199){
                names.add(0,new Names("小女正面开撕","废柴少女逆袭暴富气疯绿茶女",R.drawable.cd));
                names.add(1,new Names("贵州大山隐居","有山有水有房子",R.drawable.cf));
                adapter.notifyDataSetChanged();
                //设置组件的刷洗状态；false代表关闭
                swipeRefreshLayout.setRefreshing(false);
            }
        }
    };

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }
}