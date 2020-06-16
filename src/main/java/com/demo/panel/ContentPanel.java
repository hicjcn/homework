package com.demo.panel;

import com.demo.entity.MenuType;

import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {

    private JLabel welcomeLabel;

    /**
     * 库存管理 Panel
     */
    private GoodsPanel goodsPanel = new GoodsPanel();


    public ContentPanel() {
        setSize(600, 400);

        setLayout(new BorderLayout());

        welcomeLabel = new JLabel("欢迎来到药店管理系统", JLabel.CENTER);
        add(welcomeLabel, BorderLayout.CENTER);
    }

    public void changeContent(MenuType menuType) {
        System.out.println("切换菜单内容：" + menuType);
        removeAll();
        revalidate();
        if (MenuType.amount == menuType) {
            add(goodsPanel);
        }
    }
}
