package com.example.myapplication.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Names;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerView.ViewHolder>{
    private List<Names>names =new ArrayList<>();
    private RecyclerView.ViewHolder holder;
    private ImageView imgs;
    private TextView namee;
    private TextView tit;
    public RecyclerAdapter(List<Names> names) {
        this.names = names;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyc,parent,false);
        holder =new RecyclerView.ViewHolder(view) {
        };
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
    final Names n=names.get(position);
    imgs = holder.itemView.findViewById(R.id.imgs);
    namee = holder.itemView.findViewById(R.id.names);
    tit =holder.itemView.findViewById(R.id.tit);
    imgs.setImageResource(n.getImg());
    namee.setText(n.getName());
    tit.setText(n.getTitle());
    imgs.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            Dialog dia = new Dialog(holder.itemView.getContext());
            dia.setContentView(R.layout.dialog);
            ImageView imageView = (ImageView) dia.findViewById(R.id.ivdialog);
            //可以set任何格式图片
            imageView.setImageResource(n.getImg());
            dia.show();
            //选择true的话点击其他地方可以使dialog消失，为false的话不会消失
            dia.setCanceledOnTouchOutside(true); // Sets whether this dialog is
            Window w = dia.getWindow();
            WindowManager.LayoutParams lp = w.getAttributes();
            lp.x = 0;
            lp.y = 40;
            dia.onWindowAttributesChanged(lp);
            return false;
        }
    });
    }

    @Override
    public int getItemCount() {
        return names.size();
    }


}
