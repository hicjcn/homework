package com.example.demo.data;

import com.example.demo.data.callback.LoginAndRegisterCallback;
import com.example.demo.model.AppContext;
import com.example.demo.model.User;
import com.example.demo.util.MysqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

    public static void login(String usernameStr, String pwdStr, LoginAndRegisterCallback loginAndRegisterCallback) throws Exception {

        MysqlUtil.Connect();
        Connection connection = MysqlUtil.getConn();

        // 使用PreparedStatement防止SQL注入
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user where username = ?");
        preparedStatement.setString(1, usernameStr);

        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            System.out.println("执行sql语句成功");
        }else {
            System.out.println("没有查询到任何数据，请检查数据库");
        }

        if (pwdStr.equals(resultSet.getString("password"))){
            // 存储当前用户信息
            AppContext.curUser = new User();
            AppContext.curUser.username = resultSet.getString("username");
            AppContext.curUser.password = resultSet.getString("password");
            AppContext.curUser.name = resultSet.getString("name");
            AppContext.curUser.phone = resultSet.getString("phone");

            loginAndRegisterCallback.success(true);
        } else {
            loginAndRegisterCallback.success(false);
        }

        // 关闭资源
        preparedStatement.close();
    }

    public static void register(String usernameStr, String pwdStr, String nameStr, String phoneStr, LoginAndRegisterCallback loginAndRegisterCallback) throws Exception {

        MysqlUtil.Connect();
        Connection connection = MysqlUtil.getConn();

        // 使用PreparedStatement防止SQL注入
        PreparedStatement preparedStatement = connection.prepareStatement("insert into user values(?,?,?,?)");
        preparedStatement.setString(1, usernameStr);
        preparedStatement.setString(2, pwdStr);
        preparedStatement.setString(3, nameStr);
        preparedStatement.setString(4, phoneStr);

        try {
            int i = preparedStatement.executeUpdate();
            if(i > 0){
                System.out.println("执行sql语句成功");
                loginAndRegisterCallback.success(true);
            }else {
                loginAndRegisterCallback.success(false);
                System.out.println("用户名密码重复");
            }
        }catch (SQLException e) {
            e.printStackTrace();
            loginAndRegisterCallback.success(false);
        }

        // 关闭资源
        preparedStatement.close();
    }
}
