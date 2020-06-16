package com.demo.util;

import java.sql.ResultSet;

public class DbQueryUtil {

    public static ResultSet login(String username) {

        MySqlUtil.Query("select * from admin where username = \'" + username + "\'");
        return MySqlUtil.getResultSet();
    }
}
