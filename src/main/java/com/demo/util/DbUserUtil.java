package com.demo.util;

import com.google.common.collect.Lists;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DbUserUtil {
    /**
     * 获取列表
     * @return
     * @throws SQLException
     */
    public static Object[][] listUser() throws SQLException {
        MySqlUtil.Connect();
        Connection connection = MySqlUtil.getConn();

        // 使用PreparedStatement防止SQL注入
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user");
        ResultSet resultSet = preparedStatement.executeQuery();

        // 循环获取数据
        List<Object[]> list = Lists.newArrayList();
        while (resultSet.next()) {
            Object[] row = new Object[4];
            for (int i = 0; i < row.length; i++) {
                row[i] = resultSet.getObject(i + 1);
            }
            list.add(row);
        }

        // 关闭资源
        resultSet.close();
        preparedStatement.close();

        // 转换结果
        Object[][] result = new Object[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    /**
     * 新增
     *
     */
    public static boolean saveUser(Object[] data) throws SQLException {
        MySqlUtil.Connect();
        Connection connection = MySqlUtil.getConn();

        // 使用PreparedStatement防止SQL注入
        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into user(name, phone, points) values(?,?,?)"
        );
        preparedStatement.setObject(1, data[1]);
        preparedStatement.setObject(2, data[2]);
        preparedStatement.setObject(3, data[3]);

        int resultLink = preparedStatement.executeUpdate();
        if (resultLink > 0) {
            System.out.println("执行sql语句成功");
        }else {
            System.out.println("新增失败，请检查数据库");
        }

        return resultLink > 0;
    }

    /**
     * 更新
     *
     * @param data
     * @return
     * @throws SQLException
     */
    public static boolean updateUser(Object[] data) throws SQLException {
        MySqlUtil.Connect();
        Connection connection = MySqlUtil.getConn();

        // 使用PreparedStatement防止SQL注入
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE user SET name=?, phone=?, points=? WHERE id=?"
        );
        preparedStatement.setObject(1, data[1]);
        preparedStatement.setObject(2, data[2]);
        preparedStatement.setObject(3, data[3]);
        preparedStatement.setObject(4, data[0]);

        int resultLink = preparedStatement.executeUpdate();
        if (resultLink > 0) {
            System.out.println("执行sql语句成功");
        }else {
            System.out.println("更新失败，请检查数据库");
        }

        return resultLink > 0;
    }

    /**
     * 删除
     */
    public static boolean deleteUser(int id) throws SQLException {
        MySqlUtil.Connect();
        Connection connection = MySqlUtil.getConn();

        // 使用PreparedStatement防止SQL注入
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM user WHERE id=?"
        );
        preparedStatement.setInt(1, id);

        int resultLink = preparedStatement.executeUpdate();
        if (resultLink > 0) {
            System.out.println("执行sql语句成功");
        }else {
            System.out.println("删除失败，请检查数据库");
        }

        return resultLink > 0;
    }
}
