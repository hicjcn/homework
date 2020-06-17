package com.demo.util;

import com.demo.Context;
import com.google.common.collect.Lists;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DbSaleUtil {

    /**
     * 获取列表
     * @return
     * @throws SQLException
     */
    public static Object[][] listSaleRecord() throws SQLException {
        MySqlUtil.Connect();
        Connection connection = MySqlUtil.getConn();

        // 使用PreparedStatement防止SQL注入
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select " +
                        "s.id, g.name, g.norms, s.amount, s.sale_price, u.name, u.phone, s.sale_time, " +
                        "s. goods_id, s.user_id " +
                        "from sale_record s " +
                        "left join goods g on s.goods_id = g.id " +
                        "left join user u on s.user_id = u.id"
        );
        ResultSet resultSet = preparedStatement.executeQuery();

        // 循环获取数据
        List<Object[]> list = Lists.newArrayList();
        while (resultSet.next()) {
            Object[] row = new Object[10];
            for (int i = 0; i < row.length; i++) {
                row[i] = resultSet.getObject(i + 1);
            }
            list.add(row);
        }

        // 关闭资源
        resultSet.close();
        preparedStatement.close();

        // 转换结果
        Object[][] result = new Object[list.size()][10];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    /**
     * 新增
     *
     */
    public static boolean saveSaleRecord(Object[] data) throws SQLException {
        MySqlUtil.Connect();
        Connection connection = MySqlUtil.getConn();

        // 使用PreparedStatement防止SQL注入
        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into sale_record(goods_id, amount, sale_price, user_id, sale_time) values(?,?,?,?,?)"
        );
        preparedStatement.setObject(1, data[0]);
        preparedStatement.setObject(2, data[1]);
        preparedStatement.setObject(3, data[2]);
        preparedStatement.setObject(4, data[3]);
        preparedStatement.setObject(5, data[4]);

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
    public static boolean updateAdmin(Object[] data) throws SQLException {
        MySqlUtil.Connect();
        Connection connection = MySqlUtil.getConn();

        // 使用PreparedStatement防止SQL注入
        PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE admin SET username=?, name=?, phone=?, type=? WHERE username=?"
        );
        preparedStatement.setObject(1, data[0]);
        preparedStatement.setObject(2, data[1]);
        preparedStatement.setObject(3, data[2]);
        preparedStatement.setObject(4, data[3]);
        preparedStatement.setObject(5, data[0]);

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
    public static boolean deleteAdmin(String userName) throws SQLException {
        MySqlUtil.Connect();
        Connection connection = MySqlUtil.getConn();

        // 使用PreparedStatement防止SQL注入
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM admin WHERE username=?"
        );
        preparedStatement.setString(1, userName);

        int resultLink = preparedStatement.executeUpdate();
        if (resultLink > 0) {
            System.out.println("执行sql语句成功");
        }else {
            System.out.println("删除失败，请检查数据库");
        }

        return resultLink > 0;
    }

}
