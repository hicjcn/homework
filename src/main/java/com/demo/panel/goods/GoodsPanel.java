package com.demo.panel.goods;

import com.demo.Context;
import com.demo.entity.EditType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoodsPanel extends JPanel {

    private JButton refreshBtn = new JButton("刷新");
    private JButton addBtn = new JButton("添加");
    private JButton editBtn = new JButton("修改");
    private JButton delBtn = new JButton("删除");

    private GoodsEditFrame editFrame = new GoodsEditFrame(this);

    /**
     * 数据表格
     */
    private JTable dataTable;
    private GoodsTableModel tableModel = new GoodsTableModel();

    public GoodsPanel() {
        setSize(600, 400);

        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setSize(600, 50);

        bindBtnAction();
        panel.add(refreshBtn);
        panel.add(addBtn);
        panel.add(editBtn);
        panel.add(delBtn);

        add(panel, BorderLayout.NORTH);

        // 数据表格
        dataTable = new JTable(tableModel);
        // 表格的修改事件

        /**
         * 用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看
         */
        add(new JScrollPane(dataTable), BorderLayout.CENTER);
    }

    private void bindBtnAction() {
        // 刷新按钮事件
        refreshBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refresh();
            }
        });

        // 添加按钮事件
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editFrame.show(EditType.add, null);
            }
        });

        // 更新按钮事件
        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取选中数据
                int selected = dataTable.getSelectedRow();
                if (selected < 0) {
                    JOptionPane.showMessageDialog(Context.mainFrame, "请选择一行进行修改", "提示", JOptionPane.PLAIN_MESSAGE);
                    return;
                }
                Object[] selectedData = tableModel.getRow(selected);
                editFrame.show(EditType.update, selectedData);
            }
        });

        // 删除按钮事件
        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取选中数据
                int selected = dataTable.getSelectedRow();
                if (selected < 0) {
                    JOptionPane.showMessageDialog(Context.mainFrame, "请选择一行进行删除", "提示", JOptionPane.PLAIN_MESSAGE);
                    return;
                }
                int i = JOptionPane.showConfirmDialog(Context.mainFrame, "确认删除这一行吗？");
                if (JOptionPane.YES_OPTION == i) {
                    // TODO 删除一行数据

                }
            }
        });
    }

    /**
     * 刷新数据
     */
    public void refresh() {
        tableModel.refresh();
    }
}
