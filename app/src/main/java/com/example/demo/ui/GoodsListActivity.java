package com.example.demo.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;
import com.example.demo.data.GoodsService;
import com.example.demo.data.callback.GoodsCallback;
import com.example.demo.model.AppContext;
import com.example.demo.model.Goods;
import com.example.demo.ui.goods.GoodsAdapter;

import java.sql.SQLException;
import java.util.List;

public class GoodsListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_list);

        // 新建的Activity添加到列表以便退出时关闭
        AppContext.activityList.add(this);

        recyclerView = findViewById(R.id.goodsList);

        AppContext.executor.execute(() -> {
            try {
                GoodsService.list(new GoodsCallback() {
                    @Override
                    public void listGoods(List<Goods> goods) {
                        runOnUiThread(() -> {
                            // 设置显示适配器
                            GoodsAdapter goodsAdapter = new GoodsAdapter(GoodsListActivity.this, goods);
                            recyclerView.setAdapter(goodsAdapter);
                            // 设置成线性布局
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(GoodsListActivity.this);
                            recyclerView.setLayoutManager(linearLayoutManager);
                            // 设置分隔线
                            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(GoodsListActivity.this, DividerItemDecoration.VERTICAL);
                            recyclerView.addItemDecoration(dividerItemDecoration);
                        });
                    }
                });
            } catch (SQLException e) {
                e.printStackTrace();
                runOnUiThread(() -> {
                    Toast.makeText(GoodsListActivity.this, R.string.db_error, 3).show();
                });
            }
        });
    }

}
