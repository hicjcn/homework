package com.demo.panel.sale;

import com.demo.Context;
import com.demo.adapter.NumberInput;
import com.demo.entity.EditType;
import com.demo.service.SaleService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class SaleEditFrame extends JFrame {

    private SalePanel parentContext = null;

    private EditType editType = EditType.add;

    /**
     * 药品选择框及其数据Model
     */
    private JList<String> nameText;
    private GoodsListModel goodsListModel;

    private JTextField amountText;

    /**
     * 会员选择框及其数据Model
     */
    private JList<String> userText;
    private UserListModel userListModel;

    private JButton okBtn;

    private Object[] data;

    SaleEditFrame(SalePanel parentCtx) {
        // 保存父窗口的句柄以便更新表格
        this.parentContext = parentCtx;
        setTitle("编辑货物");
        setSize(300, 380);
        // 窗口在屏幕中间显示
        setLocationRelativeTo(null);

        // 绑定视图
        bindView();
    }

    private void bindView() {

        setLayout(null);

        // 名称
        JLabel nameLabel = new JLabel("药品:");
        nameLabel.setBounds(10,20,80,25);
        add(nameLabel);
        goodsListModel = new GoodsListModel();
        nameText = new JList<>(goodsListModel);
        nameText.setBounds(100,20,165,100);
        add(nameText);

        // 数量
        JLabel unitPriceLabel = new JLabel("数量:");
        unitPriceLabel.setBounds(10,130,80,25);
        add(unitPriceLabel);
        amountText = new JTextField(20);
        amountText.setBounds(100,130,165,25);
        // 限制输入数字
        amountText.addKeyListener(new NumberInput());
        add(amountText);

        // 会员
        JLabel userLabel = new JLabel("会员:");
        userLabel.setBounds(10,160,80,100);
        add(userLabel);
        userListModel = new UserListModel();
        userText = new JList<>(userListModel);
        userText.setBounds(100,160,165,100);
        add(userText);

        // 创建登录按钮
        okBtn = new JButton("确定");
        okBtn.setBounds(10, 270, 255, 50);

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
        if (null != data && data.length >= 7) {
            nameText.setSelectedIndex(goodsListModel.searchIndex((Integer) data[8]));
            amountText.setText(String.valueOf(data[3]));
            userText.setSelectedIndex(userListModel.searchIndex((Integer) data[9]));
        } else {
            nameText.setSelectedIndex(0);
            amountText.setText("");
            userText.setSelectedIndex(0);
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
        userListModel.refresh();
        goodsListModel.refresh();
        setVisible(true);
    }

    /**
     * 处理新增或者更新 更新完父窗口的表格刷新
     */
    private void ok() {
        if (null == data) {
            data = new Object[7];
        }
        // 药品ID
        data[1] = goodsListModel.getIndex(nameText.getSelectedIndex())[0];
        data[2] = amountText.getText();
        // 销售价 内部SQL处理
        data[3] = null;
        // 会员ID
        data[4] = userListModel.getIndex(userText.getSelectedIndex())[0];
        // 时间
        data[5] = new Date(System.currentTimeMillis());

        if (null == data[1] || null == data[4] || "".equals(data[2])) {
            JOptionPane.showMessageDialog(Context.mainFrame, "请输入完整", "提示", JOptionPane.PLAIN_MESSAGE);
            return;
        }

        try {
            if (EditType.add == editType) {
                // 新增
                SaleService.saveSaleRecord(data);
            } else if (EditType.update == editType) {
                // 更新
                int i = JOptionPane.showConfirmDialog(Context.mainFrame, "确认更新这一行吗？原则上不允许更新销售记录，系统不处理已发放积分！！");
                if (JOptionPane.YES_OPTION == i) {
                    SaleService.updateSaleRecord(data);
                }
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
