package com.demo;

import com.demo.entity.UserType;
import com.demo.frame.LoginFrame;
import com.demo.frame.MainFrame;

public class Context {

    /**
     * 登录窗体句柄
     */
    public static LoginFrame loginFrame;

    /**
     * 主窗口句柄
     */
    public static MainFrame mainFrame;

    /**
     * 当前登录用户名
     */
    public static String curUsername;

    /**
     * 当前登录用户类型
     * 0 管理员
     * 1 销售员
     * 2 采购员
     */
    public static UserType curUserType;

}
