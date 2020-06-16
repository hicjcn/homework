package com.demo.panel.admin;

import com.demo.Context;
import com.demo.adapter.NumberInput;
import com.demo.entity.EditType;
import com.demo.entity.UserType;
import com.demo.util.DbAdminUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AdminEditFrame extends JFrame {

    private AdminPanel parentContext = null;

    private EditType editType = EditType.add;

    private JTextField usernameText;
    private JTextField nameText;
    private JTextField phoneText;
    private JList typeText;

    private JButton okBtn;

    private Object[] data;

    AdminEditFrame(AdminPanel parentCtx) {
        // 保存父窗口的句柄以便更新表格
        this.parentContext = parentCtx;
        setTitle("编辑用户");
        setSize(300, 300);
        // 窗口在屏幕中间显示
        setLocationRelativeTo(null);

        // 绑定视图
        bindView();
    }

    private void bindView() {

        setLayout(null);

        // 用户名
        JLabel userLabel = new JLabel("用户名:");
        userLabel.setBounds(10,20,80,25);
        add(userLabel);
        usernameText = new JTextField(20);
        usernameText.setBounds(100,20,165,25);
        add(usernameText);

        // 姓名
        JLabel normsLabel = new JLabel("姓名:");
        normsLabel.setBounds(10,50,80,25);
        add(normsLabel);
        nameText = new JTextField(20);
        nameText.setBounds(100,50,165,25);
        add(nameText);

        // 手机号
        JLabel unitPriceLabel = new JLabel("手机号:");
        unitPriceLabel.setBounds(10,80,80,25);
        add(unitPriceLabel);
        phoneText = new JTextField(20);
        phoneText.setBounds(100,80,165,25);
        // 限制输入数字
        phoneText.addKeyListener(new NumberInput());
        add(phoneText);

        // 用户类型
        JLabel saleLabel = new JLabel("用户类型:");
        saleLabel.setBounds(10,110,80,25);
        add(saleLabel);
        DefaultListModel<String> defaultListModel = new DefaultListModel<>();
        defaultListModel.addElement("管理员");
        defaultListModel.addElement("库存管理员");
        defaultListModel.addElement("销售管理员");
        typeText = new JList(defaultListModel);
        typeText.setBounds(100,110,165,70);
        add(typeText);

        // 提交按钮
        okBtn = new JButton("确定");
        okBtn.setBounds(10, 190, 255, 50);

        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ok();
            }
        });

        add(okBtn);
    }

    /**
     * 设置数据到组件中
     * @param data
     */
    private void setData(Object[] data) {
        if (null != data && data.length >= 4) {
            usernameText.setText(String.valueOf(data[0]));
            nameText.setText(String.valueOf(data[1]));
            phoneText.setText(String.valueOf(data[2]));
            typeText.setSelectedIndex((Integer) data[3]);
        } else {
            usernameText.setText("");
            nameText.setText("");
            phoneText.setText("");
            typeText.setSelectedIndex(0);
        }
    }

    /**
     * 显示窗口
     * @param type
     * @param data
     */
    public void show(EditType type, Object[] data) {
        this.editType = type;
        this.data = data;
        setData(data);
        setVisible(true);
    }

    /**
     * 处理新增或者更新 更新完父窗口的表格刷新
     */
    private void ok() {
        if (null == data) {
            data = new Object[4];
        }
        data[0] = usernameText.getText();
        data[1] = nameText.getText();
        data[2] = phoneText.getText();
        data[3] = typeText.getSelectedIndex();

        try {
            if (EditType.add == editType) {
                // 新增
                DbAdminUtil.saveAdmin(data);
            } else if (EditType.update == editType) {
                // 更新
                DbAdminUtil.updateAdmin(data);
            }
            // 更新完关闭窗口
            setVisible(false);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(Context.mainFrame, "更新失败", "提示", JOptionPane.PLAIN_MESSAGE);
            e.printStackTrace();
        } finally {
            parentContext.refresh();
        }

    }
}
