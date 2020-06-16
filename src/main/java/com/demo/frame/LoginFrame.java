package com.demo.frame;

import com.demo.Context;
import com.demo.entity.UserType;
import com.demo.util.DbQueryUtil;
import com.demo.util.MySqlUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginFrame extends JFrame {


    private JFrame context = this;

    private JTextField userText;

    private JPasswordField passwordText;

    private JButton loginButton;

    public LoginFrame() {
        setTitle("登录");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 窗口在屏幕中间显示
        setLocationRelativeTo(null);

        // 添加 登录的 panel
        JPanel panel = new JPanel();
        add(panel);
        loginPanel(panel);

        // 设置界面可见
        setVisible(true);
    }

    private void loginPanel(JPanel panel) {
        panel.setLayout(null);

        // 创建 JLabel
        JLabel userLabel = new JLabel("用户名:");
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        /*
         * 创建文本域用于用户输入
         */
        userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        userText.setText("admin");
        panel.add(userText);

        // 输入密码的文本域
        JLabel passwordLabel = new JLabel("密码:");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        /*
         *这个类似用于输入的文本域
         * 但是输入的信息会以点号代替，用于包含密码的安全性
         */
        passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        passwordText.setText("123");
        panel.add(passwordText);

        // 创建登录按钮
        loginButton = new JButton("登录");
        loginButton.setBounds(10, 80, 255, 50);

        // 登录事件
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = userText.getText();
                String pwd = String.valueOf(passwordText.getPassword());
                try {
                    if (login(username, pwd)) {
                        // 登录成功 关闭此界面 开启main界面
                        setVisible(false);
                        Context.mainFrame.setVisible(true);
                        return;
                    }
                    JOptionPane.showMessageDialog(context, "用户名/密码错误", "错误", JOptionPane.PLAIN_MESSAGE);
                    return;
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(context, "查询数据库失败", "错误", JOptionPane.PLAIN_MESSAGE);
            }
        });

        panel.add(loginButton);
    }

    private boolean login(String username, String password) throws SQLException {

        ResultSet resultset = DbQueryUtil.login(username);

        if (null == resultset) {
            return false;
        }

        String pwd = resultset.getString("password");
        int type = resultset.getInt("type");

        resultset.getStatement().close();
        resultset.close();

        if (pwd.equals(password)) {
            Context.curUsername = username;
            if (0 == type) {
                Context.curUserType = UserType.Admin;
            } else if (1 == type) {
                Context.curUserType = UserType.Inventory;
            } else {
                Context.curUserType = UserType.Sale;
            }
            return true;
        }

        return false;
    }
}
