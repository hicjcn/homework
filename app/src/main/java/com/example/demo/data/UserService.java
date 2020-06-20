package com.example.demo.data;

import com.example.demo.data.callback.LoginCallback;
import com.example.demo.model.AppContext;
import com.example.demo.model.User;
import com.example.demo.util.MysqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserService {

    public static void login(String usernameStr, String pwdStr, LoginCallback loginCallback) throws Exception {

        MysqlUtil.Connect();
        Connection connection = MysqlUtil.getConn();

        // 使用PreparedStatement防止SQL注入
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user where username = ?");
        preparedStatement.setString(1, usernameStr);

        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            System.out.println("执行sql语句成功");
        }else {
            resultSet = null;
            System.out.println("没有查询到任何数据，请检查数据库");
        }

        if (pwdStr.equals(resultSet.getString("password"))){
            // 存储当前用户信息
            AppContext.curUser = new User();
            AppContext.curUser.username = resultSet.getString("username");
            AppContext.curUser.password = resultSet.getString("password");
            AppContext.curUser.name = resultSet.getString("name");
            AppContext.curUser.phone = resultSet.getString("phone");

            loginCallback.loginSuccess(true);
        } else {
            loginCallback.loginSuccess(false);
        }

        // 关闭资源
        resultSet.close();
        preparedStatement.close();
    }
}
