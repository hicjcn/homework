package com.example.demo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demo.R;
import com.example.demo.data.UserService;
import com.example.demo.model.AppContext;

import org.apache.commons.lang3.StringUtils;

public class InfoActivity extends AppCompatActivity {

    private EditText name;
    private EditText phone;
    private EditText password;

    private Button ok;
    private Button cancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_info);

        // 新建的Activity添加到列表以便退出时关闭
        AppContext.activityList.add(this);

        // 绑定视图
        name = findViewById(R.id.infoName);
        phone = findViewById(R.id.infoPhone);
        password = findViewById(R.id.infoPwd);
        ok = findViewById(R.id.infoOk);
        cancel = findViewById(R.id.infoCanel);

        // 设置数据
        name.setText(AppContext.curUser.name);
        password.setText(AppContext.curUser.password);
        phone.setText(AppContext.curUser.phone);

        // 监听事件
        ok.setOnClickListener(view -> {
            String pwdStr = String.valueOf(password.getText());
            String nameStr = String.valueOf(name.getText());
            String phoneStr = String.valueOf(phone.getText());
            AppContext.executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        UserService.update(pwdStr, nameStr, phoneStr, isSuccess -> {
                            runOnUiThread(() -> {
                                if (isSuccess) {
                                    // 切到登录界面
                                    Toast.makeText(InfoActivity.this, R.string.info_success, 3).show();
                                    AppContext.activityList.remove(AppContext.activityList.size() - 1);
                                    finish();
                                    return;
                                }
                                Toast.makeText(InfoActivity.this, R.string.info_fail, 3).show();
                            });
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                        runOnUiThread(() -> {
                            Toast.makeText(InfoActivity.this, R.string.db_error, 3).show();
                        });
                    }
                }
            });
        });
        cancel.setOnClickListener(view -> {
            // 关闭当前返回上一页
            AppContext.activityList.remove(AppContext.activityList.size() - 1);
            finish();
        });
    }
}
