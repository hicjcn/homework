package com.example.demo.data;

import com.example.demo.data.callback.SuccessCallback;
import com.example.demo.util.MysqlUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        preparedStatement.setDate(5, new Date(System.currentTimeMillis()));

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

}
