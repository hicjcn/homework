package com.demo.panel.self;

import com.demo.Context;
import com.demo.util.DbAdminUtil;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SelfPanel extends JPanel {

    private JPasswordField oldPwdText;
    private JPasswordField newPwdText;
    private JPasswordField newPwd1Text;

    private JButton okBtn;

    public SelfPanel() {
        setSize(600, 400);

        bindView();
        bindBtnAction();
    }

    private void bindView() {
        setLayout(null);

        // 原密码
        JLabel userLabel = new JLabel("原密码:");
        userLabel.setBounds(10,20,80,25);
        add(userLabel);
        oldPwdText = new JPasswordField(20);
        oldPwdText.setBounds(100,20,165,25);
        add(oldPwdText);

        // 新密码
        JLabel normsLabel = new JLabel("新密码:");
        normsLabel.setBounds(10,50,80,25);
        add(normsLabel);
        newPwdText = new JPasswordField(20);
        newPwdText.setBounds(100,50,165,25);
        add(newPwdText);

        // 确认密码
        JLabel unitPriceLabel = new JLabel("确认密码:");
        unitPriceLabel.setBounds(10,80,80,25);
        add(unitPriceLabel);
        newPwd1Text = new JPasswordField(20);
        newPwd1Text.setBounds(100,80,165,25);
        add(newPwd1Text);

        // 确认按钮
        okBtn = new JButton("确定");
        okBtn.setBounds(10, 110, 255, 50);

        add(okBtn);

    }

    private void bindBtnAction() {
        // 按钮事件
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetPwd();
            }
        });
    }

    private void reset() {
        oldPwdText.setText("");
        newPwdText.setText("");
        newPwd1Text.setText("");
    }

    private void resetPwd () {
        String oldPwd = String.valueOf(oldPwdText.getPassword());
        String newPwd = String.valueOf(newPwdText.getPassword());
        String newPwd1 = String.valueOf(newPwd1Text.getPassword());

        if (StringUtils.isAnyEmpty(oldPwd, newPwd, newPwd1)) {
            JOptionPane.showMessageDialog(Context.mainFrame, "请输入完整", "提示", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        if (!newPwd.equals(newPwd1)) {
            JOptionPane.showMessageDialog(Context.mainFrame, "新密码两次输入不一致", "提示", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        // TODO 更新密码
        try {
            if (DbAdminUtil.changePassword(oldPwd, newPwd)){
                JOptionPane.showMessageDialog(Context.mainFrame, "修改成功", "提示", JOptionPane.PLAIN_MESSAGE);
                // 更新完密码
                reset();
            } else {
                JOptionPane.showMessageDialog(Context.mainFrame, "旧密码错误", "提示", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(Context.mainFrame, "修改失败", "提示", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
