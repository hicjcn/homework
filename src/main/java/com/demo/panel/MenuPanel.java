package com.demo.panel;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private JButton amountBtn = new JButton("库存管理");
    private JButton saleBtn = new JButton("销售管理");
    private JButton userBtn = new JButton("会员管理");
    private JButton selfBtn = new JButton("个人信息");

    public MenuPanel() {

        setSize(200, 400);

        // 设置为Card布局
        setLayout(new GridLayout(4,1,0,0));

        add(amountBtn);
        add(saleBtn);
        add(userBtn);
        add(selfBtn);
    }
}
