package com.example.demo.ui.goods;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;
import com.example.demo.model.Goods;
import com.example.demo.ui.ActionActivity;
import com.example.demo.ui.GoodsListActivity;
import com.example.demo.ui.GoodsShoppingActivity;

public class GoodsViewHolder extends RecyclerView.ViewHolder {

    public Activity activity;

    public Goods goods;

    public TextView name;
    public TextView price;
    public TextView desc;

    private Button buyBtn;

    public GoodsViewHolder(Activity activity, @NonNull View itemView) {
        super(itemView);
        this.activity = activity;
        //  绑定视图
        name = itemView.findViewById(R.id.itemGoodsName);
        price = itemView.findViewById(R.id.itemGoodsPrice);
        desc = itemView.findViewById(R.id.itemGoodsDesc);
        buyBtn = itemView.findViewById(R.id.itemGoodsBuy);

        buyBtn.setOnClickListener(view -> {
            // 点击立即购买 转到购买页
            Intent intent = new Intent(activity, GoodsShoppingActivity.class);
            intent.putExtra("id", goods.id);
            intent.putExtra("name", goods.name);
            intent.putExtra("price", goods.price);
            intent.putExtra("description", goods.description);
            activity.startActivity(intent);
        });

    }
}
