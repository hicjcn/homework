package com.demo.panel;

import com.demo.entity.MenuType;
import com.demo.panel.admin.AdminPanel;
import com.demo.panel.goods.GoodsPanel;
import com.demo.panel.self.SelfPanel;
import com.demo.panel.user.UserPanel;

import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {

    private JLabel welcomeLabel;

    /**
     * 库存管理 Panel
     */
    private GoodsPanel goodsPanel = new GoodsPanel();
    /**
     * 用户管理 Panel
     */
    private AdminPanel adminPanel = new AdminPanel();
    /**
     * 修改密码 Panel
     */
    private SelfPanel selfPanel = new SelfPanel();
    /**
     * 会员管理 Panel
     */
    private UserPanel userPanel = new UserPanel();


    public ContentPanel() {
        setSize(600, 400);

        setLayout(new BorderLayout());

        welcomeLabel = new JLabel("欢迎来到药店管理系统", JLabel.CENTER);
        add(welcomeLabel, BorderLayout.CENTER);
    }

    public void changeContent(MenuType menuType) {
        System.out.println("切换菜单内容：" + menuType);
        removeAll();
        validate();
        repaint();
        revalidate();
        if (MenuType.amount == menuType) {
            add(goodsPanel);
            goodsPanel.refresh();
        } else if (MenuType.admin == menuType) {
            add(adminPanel);
            adminPanel.refresh();
        } else if (MenuType.self == menuType) {
            add(selfPanel);
        } else if (MenuType.user == menuType) {
            add(userPanel);
            userPanel.refresh();
        }
    }
}
