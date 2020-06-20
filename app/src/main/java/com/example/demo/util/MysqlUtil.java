package com.example.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlUtil {


    private static String MYSQL_URL = "jdbc:mysql://106.13.10.5:32767/market?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
    //MySQL配置时的用户名
    private static String MYSQL_USER = "root";
    //MySQL配置时的密码
    private static String MYSQL_PASSWORD = "VI0AyPt9lq";
    private static Connection conn = null;
    private static Statement statement = null;
    private static ResultSet  resultSet = null;

    public static void main(String[] args) throws SQLException {

        Connect();
        Query( "select * from user where uaername = 'admin'");
        System.out.println(get("name"));

    }

    public static Connection getConn() {
        return conn;
    }

    public static boolean next() {
        if(resultSet == null){
            System.err.println("还没有执行过sql查询");
            return false;
        }else {
            try {
                if(resultSet.next()){
                    System.out.println("结果集下一行");
                    return true;
                }else {
                    System.out.println("结果集已到底，无法进行下一行");
                    return false;
                }
            } catch (Exception e) {
                System.err.println("结果集下一行出错");
                return false;
            }
        }
    }

    public static String get(String column) {
        if(resultSet == null){
            System.err.println("还没有执行过sql查询");
            return null;
        }else {
            try {
                return resultSet.getString(column);
            } catch (Exception e) {
                // TODO: handle exception
                System.err.println(e.getMessage());
            }
            return null;
        }

    }

    public static ResultSet getResultSet() {
        if(resultSet == null){
            System.err.println("还没有执行过sql查询");
        }
        return resultSet;
    }

    public static int Update(String sql) throws SQLException {   //执行错误返回-1
        Connect();
        if(statement != null){
            try {
                System.out.println("开始执行sql语句:"+sql);
                int i = statement.executeUpdate(sql);
                System.out.println("执行sql语句成功,影响"+i+"行");
                return i;
            } catch (Exception e) {
                System.err.println("执行sql语句错误,请检查sql语句"+sql);
                return -1;
            }
        }else {
            System.err.println("数据库还未连接，请先连接数据库");
            return -1;
        }
    }

    public static void Query(String sql) throws SQLException {
        Connect();
        if(statement != null){
            try {
                resultSet = null;
                System.out.println("开始执行sql语句:"+sql);
                resultSet = statement.executeQuery(sql);
                if(resultSet.next()){
                    System.out.println("执行sql语句成功");
                }else {
                    resultSet = null;
                    System.out.println("没有查询到任何数据，请检查sql语句"+sql);
                }

            } catch (Exception e) {
                resultSet = null;
                System.err.println("执行sql语句错误,请检查sql语句"+sql);
            }
        }else {
            System.err.println("数据库还未连接，请先连接数据库");
        }
    }


    public static void Connect() throws SQLException {
        if(statement == null || conn.isClosed()){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD);
                statement = conn.createStatement();
                System.out.println("数据库连接成功");
            } catch (ClassNotFoundException e) {
                System.err.println("MySQL连接的包没有导入");
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("MySQL连接失败，请检查MySQL地址及其用户名密码");
            }
        }else {
            System.out.println("数据库已连接");
        }
    }

}
