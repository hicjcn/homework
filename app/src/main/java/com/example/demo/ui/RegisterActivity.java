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

public class RegisterActivity extends AppCompatActivity {

    private TextView username;
    private TextView password;
    private TextView password2;
    private TextView name;
    private TextView phone;
    private Button reg;
    private TextView toLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        // 新建的Activity添加到列表以便退出时关闭
        AppContext.activityList.add(this);

        // 绑定视图
        username = findViewById(R.id.regUsername);
        password = findViewById(R.id.regPassword);
        password2 = findViewById(R.id.regPassword2);
        name = findViewById(R.id.regName);
        phone = findViewById(R.id.regPhone);
        reg = findViewById(R.id.regReg);
        toLogin = findViewById(R.id.regToLogin);

        // 监听事件
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameStr = String.valueOf(username.getText());
                String pwdStr = String.valueOf(password.getText());
                String pwd2Str = String.valueOf(password2.getText());
                String nameStr = String.valueOf(name.getText());
                String phoneStr = String.valueOf(phone.getText());
                if (StringUtils.isAllEmpty(usernameStr, pwdStr, phoneStr, nameStr, pwd2Str)) {
                    Toast.makeText(RegisterActivity.this, R.string.hint_input_complete, 3).show();
                    return;
                }
                if (!pwdStr.equals(pwd2Str)) {
                    Toast.makeText(RegisterActivity.this, R.string.hint_input_twice_diff, 3).show();
                    return;
                }
                AppContext.executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            UserService.register(usernameStr, pwdStr, nameStr, phoneStr, isSuccess -> {
                                runOnUiThread(() -> {
                                    if (isSuccess) {
                                        // 切到登录界面
                                        Toast.makeText(RegisterActivity.this, R.string.reg_success, 3).show();
                                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                        startActivity(intent);
                                        return;
                                    }
                                    Toast.makeText(RegisterActivity.this, R.string.reg_username_exist, 3).show();
                                });
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            runOnUiThread(() -> {
                                Toast.makeText(RegisterActivity.this, R.string.db_error, 3).show();
                            });
                        }
                    }
                });
            }
        });
        toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 切到登录界面
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
