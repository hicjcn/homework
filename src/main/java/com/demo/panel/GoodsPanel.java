package com.demo.panel;

import com.demo.table.GoodsTableModel;
import com.demo.util.DbQueryUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class GoodsPanel extends JPanel {

    private JButton refreshBtn = new JButton("刷新");
    private JButton addBtn = new JButton("添加");
    private JButton editBtn = new JButton("修改");
    private JButton delBtn = new JButton("删除");

    /**
     * 数据表格
     */
    private JTable dataTable;
    private GoodsTableModel tableModel = new GoodsTableModel();

    GoodsPanel() {
        setSize(600, 400);

        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setSize(600, 50);

        // 刷新按钮事件
        refreshBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.refresh();
            }
        });

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

    /**
     * 刷新数据
     */
    public void refresh() {
        tableModel.refresh();
    }
}
