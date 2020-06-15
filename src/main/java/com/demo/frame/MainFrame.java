package com.demo.frame;

import com.demo.panel.MenuPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private MenuPanel menuPanel;

    public MainFrame() {
        setTitle("药店管理系统");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 设置为BorderLayout布局
        setLayout(new BorderLayout());

        // 左右结构
        // 左边是菜单按钮
        menuPanel = new MenuPanel();
        add(menuPanel, BorderLayout.WEST);

        // 右边是内容面板
    }
}
