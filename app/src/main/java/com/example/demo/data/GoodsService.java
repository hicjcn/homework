package com.example.demo.data;

import com.example.demo.data.callback.GoodsCallback;
import com.example.demo.model.Goods;
import com.example.demo.util.MysqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsService {

    public static void list(GoodsCallback goodsCallback) throws SQLException {
        MysqlUtil.Connect();
        Connection connection = MysqlUtil.getConn();

        // 使用PreparedStatement防止SQL注入
        PreparedStatement preparedStatement = connection.prepareStatement("select * from goods");

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Goods> goodsList = new ArrayList<>();
        while (resultSet.next()) {
            Goods goods = new Goods();
            goods.id = resultSet.getInt("id");
            goods.name = resultSet.getString("name");
            goods.price = resultSet.getFloat("price");
            goods.description = resultSet.getString("description");
            goodsList.add(goods);
        }

        goodsCallback.listGoods(goodsList);

        // 关闭资源
        preparedStatement.close();

    }

}
