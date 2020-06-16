package com.demo.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbQueryUtil {

    /**
     * 登录查询用户信息
     * @param username
     * @return
     * @throws SQLException
     */
    public static ResultSet login(String username) throws SQLException {

        MySqlUtil.Connect();
        Connection connection = MySqlUtil.getConn();

        // 使用PreparedStatement防止SQL注入
        PreparedStatement preparedStatement = connection.prepareStatement("select * from admin where username = ?");
        preparedStatement.setString(1, username);

        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            System.out.println("执行sql语句成功");
        }else {
            resultSet = null;
            System.out.println("没有查询到任何数据，请检查数据库");
        }

        return resultSet;
    }
}
