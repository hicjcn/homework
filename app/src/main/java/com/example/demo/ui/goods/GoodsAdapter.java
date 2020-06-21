package com.example.demo.ui.goods;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;
import com.example.demo.model.Goods;

import java.util.List;

public class GoodsAdapter extends RecyclerView.Adapter<GoodsViewHolder> {

    private Activity activity;
    private List<Goods> list;

    public GoodsAdapter(Activity activity, List<Goods> list) {
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public GoodsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(activity, R.layout.item_goods, null);
        return new GoodsViewHolder(activity, view);
    }

    @Override
    public void onBindViewHolder(@NonNull GoodsViewHolder holder, int position) {
        Goods goods = list.get(position);
        holder.goods = goods;
        holder.name.setText(goods.name);
        holder.price.setText("￥" + goods.price);
        holder.desc.setText(goods.description);
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }
}
