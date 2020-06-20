package com.example.demo.ui.goods;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

public class GoodsViewHoder extends RecyclerView.ViewHolder {

    public int id;

    public TextView name;
    public TextView price;
    public TextView desc;

    private Button buyBtn;

    public GoodsViewHoder(@NonNull View itemView) {
        super(itemView);
        //  绑定视图
        name = itemView.findViewById(R.id.itemGoodsName);
        price = itemView.findViewById(R.id.itemGoodsPrice);
        desc = itemView.findViewById(R.id.itemGoodsDesc);
        buyBtn = itemView.findViewById(R.id.itemGoodsBuy);

        buyBtn.setOnClickListener(view -> {
            // TODO 转到购买页

        });

        itemView.setOnClickListener(view -> {
            // TODO 转到详情页

        });
    }
}
