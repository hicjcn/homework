package com.example.demo.data;

import com.example.demo.data.callback.GoodsCallback;
import com.example.demo.data.callback.RecordCallback;
import com.example.demo.data.callback.SuccessCallback;
import com.example.demo.model.AppContext;
import com.example.demo.model.Goods;
import com.example.demo.model.Record;
import com.example.demo.util.MysqlUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RecordService {

    /**
     * 保存购买订单
     * @param username
     * @param goodsId
     * @param goodsCnt
     * @param goodsAmount
     * @param callback
     */
    public static void shopping(String username, int goodsId, int goodsCnt, float goodsAmount, SuccessCallback callback) throws SQLException {

        MysqlUtil.Connect();
        Connection connection = MysqlUtil.getConn();

        // 使用PreparedStatement防止SQL注入
        PreparedStatement preparedStatement = connection.prepareStatement("insert into record(username, goods_id, count, amount, create_time) values(?,?,?,?,?)");
        preparedStatement.setString(1, username);
        preparedStatement.setInt(2, goodsId);
        preparedStatement.setInt(3, goodsCnt);
        preparedStatement.setFloat(4, goodsAmount);
        preparedStatement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));

        try {
            int i = preparedStatement.executeUpdate();
            if(i > 0){
                System.out.println("执行sql语句成功");
                callback.success(true);
            }else {
                callback.success(false);
                System.out.println("数据库添加失败");
            }
        }catch (SQLException e) {
            e.printStackTrace();
            callback.success(false);
        }

        // 关闭资源
        preparedStatement.close();

    }

    /**
     * 订单记录
     * @param recordCallback
     * @throws SQLException
     */
    public static void list(RecordCallback recordCallback) throws SQLException {
        MysqlUtil.Connect();
        Connection connection = MysqlUtil.getConn();

        // 使用PreparedStatement防止SQL注入
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT\n" +
                        "\tr.id id,\n" +
                        "\tg.name name,\n" +
                        "\tg.description description,\n" +
                        "\tg.price price,\n" +
                        "\tr.count count,\n" +
                        "\tr.amount amount,\n" +
                        "\tr.create_time time \n" +
                        "FROM\n" +
                        "\trecord r\n" +
                        "\tLEFT JOIN user u ON r.username = u.username\n" +
                        "\tLEFT JOIN goods g ON r.goods_id = g.id \n" +
                        "WHERE\n" +
                        "\tr.username = ?"
        );
        preparedStatement.setString(1, AppContext.curUser.username);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Record> recordList = new ArrayList<>();
        while (resultSet.next()) {
            Record record = new Record();
            record.id = resultSet.getInt("id");
            record.name = resultSet.getString("name");
            record.description = resultSet.getString("description");
            record.price = resultSet.getFloat("price");
            record.count = resultSet.getInt("count");
            record.amount = resultSet.getFloat("amount");
            record.time = resultSet.getTimestamp("time");
            recordList.add(record);
        }

        recordCallback.listRecord(recordList);

        // 关闭资源
        preparedStatement.close();

    }

}
