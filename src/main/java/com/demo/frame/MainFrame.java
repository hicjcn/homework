package com.demo.frame;

import com.demo.entity.MenuType;
import com.demo.panel.ContentPanel;
import com.demo.panel.MenuPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private MenuPanel menuPanel;

    private ContentPanel contentPanel;

    public MainFrame() {
        setTitle("药店管理系统");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 窗口在屏幕中间显示
        setLocationRelativeTo(null);

        // 设置为BorderLayout布局
        setLayout(new BorderLayout());

        // 左右结构
        // 左边是菜单按钮
        menuPanel = new MenuPanel();
        add(menuPanel, BorderLayout.WEST);

        // 右边是内容面板
        contentPanel = new ContentPanel();
        add(contentPanel, BorderLayout.CENTER);
    }

    public void changeMenu(MenuType menuType) {
        this.contentPanel.changeContent(menuType);
    }
}
