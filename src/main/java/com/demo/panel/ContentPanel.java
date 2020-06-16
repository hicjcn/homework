package com.demo.panel;

import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {

    private JLabel welcomeLabel;

    public ContentPanel() {
        setSize(600, 400);

        setLayout(new BorderLayout());

        welcomeLabel = new JLabel("欢迎来到药店管理系统", JLabel.CENTER);
        add(welcomeLabel, BorderLayout.CENTER);
    }
}
