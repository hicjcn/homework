package com.example.demo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demo.R;
import com.example.demo.data.UserService;
import com.example.demo.model.AppContext;

import org.apache.commons.lang3.StringUtils;

public class LoginActivity extends AppCompatActivity {

    private TextView username;
    private TextView password;
    private Button login;
    private TextView toReg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // 新建的Activity添加到列表以便退出时关闭
        MainActivity.activityList.add(this);

        // 绑定视图
        username = findViewById(R.id.loginUsername);
        password = findViewById(R.id.loginPassword);
        login = findViewById(R.id.loginLogin);
        toReg = findViewById(R.id.loginToReg);

        // 监听事件
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameStr = String.valueOf(username.getText());
                String pwdStr = String.valueOf(password.getText());
                if (StringUtils.isAllEmpty(usernameStr, pwdStr)) {
                    Toast.makeText(LoginActivity.this, R.string.login_input, 3).show();
                    return;
                }
                AppContext.executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            UserService.login(usernameStr, pwdStr, isSuccess -> {
                                runOnUiThread(() -> {
                                    if (isSuccess) {
                                        // TODO 跳转主界面
                                        Toast.makeText(LoginActivity.this, R.string.welcome, 3).show();
                                        return;
                                    }
                                    Toast.makeText(LoginActivity.this, R.string.login_error, 3).show();
                                });
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            runOnUiThread(() -> {
                                Toast.makeText(LoginActivity.this, R.string.db_error, 3).show();
                            });
                        }
                    }
                });
            }
        });
        toReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 切到登录界面
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
