package com.example.demo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demo.R;
import com.example.demo.model.AppContext;

public class ActionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_action);

        // 新建的Activity添加到列表以便退出时关闭
        AppContext.activityList.add(this);

        findViewById(R.id.actionGoodsList).setOnClickListener(view -> {
            // 商品列表
            Intent intent = new Intent(ActionActivity.this, GoodsListActivity.class);
            startActivity(intent);
        });
        findViewById(R.id.actionOrder).setOnClickListener(view -> {
            //  全部订单
            Intent intent = new Intent(ActionActivity.this, RecordListActivity.class);
            startActivity(intent);
        });
        findViewById(R.id.actionMyInfo).setOnClickListener(view -> {
            // TODO 个人信息

        });
    }
}
