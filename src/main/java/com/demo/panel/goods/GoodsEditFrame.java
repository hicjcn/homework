package com.demo.panel.goods;

import com.demo.adapter.NumberInput;
import com.demo.entity.EditType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoodsEditFrame extends JFrame {

    private EditType editType;

    private JTextField nameText;
    private JTextField normsText;
    private JTextField unitPriceText;
    private JTextField salePriceText;
    private JTextField amountText;
    private JTextField manufacturerText;

    private JButton okBtn;

    private Object[] data;

    GoodsEditFrame() {
        setTitle("添加货物");
        setSize(300, 500);
        // 窗口在屏幕中间显示
        setLocationRelativeTo(null);

        // 绑定视图
        bindView();
    }

    private void bindView() {

        setLayout(null);

        // 名称
        JLabel userLabel = new JLabel("用户名:");
        userLabel.setBounds(10,20,80,25);
        add(userLabel);
        nameText = new JTextField(20);
        nameText.setBounds(100,20,165,25);
        add(nameText);

        // 规格
        JLabel normsLabel = new JLabel("规格:");
        normsLabel.setBounds(10,50,80,25);
        add(normsLabel);
        normsText = new JTextField(20);
        normsText.setBounds(100,50,165,25);
        add(normsText);

        // 单价
        JLabel unitPriceLabel = new JLabel("单价:");
        unitPriceLabel.setBounds(10,80,80,25);
        add(unitPriceLabel);
        unitPriceText = new JTextField(20);
        unitPriceText.setBounds(100,80,165,25);
        // 限制输入数字
        unitPriceText.addKeyListener(new NumberInput());
        add(unitPriceText);

        // 销售价
        JLabel saleLabel = new JLabel("销售价:");
        saleLabel.setBounds(10,110,80,25);
        add(saleLabel);
        salePriceText = new JTextField(20);
        salePriceText.setBounds(100,110,165,25);
        // 限制输入数字
        salePriceText.addKeyListener(new NumberInput());
        add(salePriceText);

        // 库存
        JLabel amountLabel = new JLabel("库存:");
        amountLabel.setBounds(10,140,80,25);
        add(amountLabel);
        amountText = new JTextField(20);
        amountText.setBounds(100,140,165,25);
        add(amountText);

        // 厂商
        JLabel manufacturerLabel = new JLabel("库存:");
        manufacturerLabel.setBounds(10,140,80,25);
        add(manufacturerLabel);
        manufacturerText = new JTextField(20);
        manufacturerText.setBounds(100,140,165,25);
        add(manufacturerText);

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
     * 处理新增或者更新
     */
    private void ok() {
        if (null == data) {
            data = new String[7];
        }
        data[1] = nameText.getText();
        data[2] = normsText.getText();
        data[3] = unitPriceText.getText();
        data[4] = salePriceText.getText();
        data[5] = amountText.getText();
        data[6] = manufacturerText.getText();

        if (EditType.add == editType) {
            // 新增

        } else if (EditType.update == editType) {
            // 更新

        }
    }
}
