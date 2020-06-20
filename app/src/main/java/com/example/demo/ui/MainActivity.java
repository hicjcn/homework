package com.example.demo.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demo.R;
import com.example.demo.model.AppContext;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 绑定视图
        setContentView(R.layout.activity_main);

        // 按钮绑定进入登录界面
        findViewById(R.id.mainEnter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 切到登录界面
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        // 添加 退出时统一关闭
        AppContext.activityList.add(this);
    }
}
