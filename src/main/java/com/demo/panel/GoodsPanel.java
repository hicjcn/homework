package com.demo.panel;

import javax.swing.*;
import java.awt.*;

public class GoodsPanel extends JPanel {

    private JButton addBtn = new JButton("添加");
    private JButton editBtn = new JButton("修改");
    private JButton delBtn = new JButton("删除");

    GoodsPanel() {
        setSize(600, 400);

        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setSize(600, 50);
        panel.add(addBtn);
        panel.add(editBtn);
        panel.add(delBtn);

        add(panel, BorderLayout.NORTH);
    }
}
