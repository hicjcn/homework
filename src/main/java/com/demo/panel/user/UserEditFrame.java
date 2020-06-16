package com.demo.panel.user;

import com.demo.Context;
import com.demo.adapter.NumberInput;
import com.demo.entity.EditType;
import com.demo.util.DbUserUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserEditFrame extends JFrame {

    private UserPanel parentContext = null;

    private EditType editType = EditType.add;

    private JTextField nameText;
    private JTextField phoneText;
    private JTextField pointsText;

    private JButton okBtn;

    private Object[] data;

    UserEditFrame(UserPanel parentCtx) {
        // 保存父窗口的句柄以便更新表格
        this.parentContext = parentCtx;
        setTitle("编辑会员");
        setSize(300, 300);
        // 窗口在屏幕中间显示
        setLocationRelativeTo(null);

        // 绑定视图
        bindView();
    }

    private void bindView() {

        setLayout(null);

        // 姓名
        JLabel userLabel = new JLabel("姓名:");
        userLabel.setBounds(10,20,80,25);
        add(userLabel);
        nameText = new JTextField(20);
        nameText.setBounds(100,20,165,25);
        add(nameText);

        // 手机号
        JLabel unitPriceLabel = new JLabel("手机号:");
        unitPriceLabel.setBounds(10,50,80,25);
        add(unitPriceLabel);
        phoneText = new JTextField(20);
        phoneText.setBounds(100,50,165,25);
        // 限制输入数字
        phoneText.addKeyListener(new NumberInput());
        add(phoneText);

        // 积分
        JLabel saleLabel = new JLabel("积分:");
        saleLabel.setBounds(10,80,80,25);
        add(saleLabel);
        pointsText = new JTextField(20);
        pointsText.setBounds(100,80,165,25);
        // 限制输入数字
        pointsText.addKeyListener(new NumberInput());
        add(pointsText);

        // 创建登录按钮
        okBtn = new JButton("确定");
        okBtn.setBounds(10, 170, 255, 50);

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
            nameText.setText(String.valueOf(data[1]));
            phoneText.setText(String.valueOf(data[2]));
            pointsText.setText(String.valueOf(data[3]));
        } else {
            nameText.setText("");
            phoneText.setText("");
            pointsText.setText("");
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
        data[1] = nameText.getText();
        data[2] = phoneText.getText();
        data[3] = pointsText.getText();

        try {
            if (EditType.add == editType) {
                // 新增
                DbUserUtil.saveUser(data);
            } else if (EditType.update == editType) {
                // 更新
                DbUserUtil.updateUser(data);
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
