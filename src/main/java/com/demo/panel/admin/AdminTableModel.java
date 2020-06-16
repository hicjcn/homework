package com.demo.panel.admin;

import com.demo.util.DbGoodsUtil;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;

public class AdminTableModel extends AbstractTableModel {

    private Object[] columnNames = {"编号","名称","规格","单价","销售价","库存","厂家"};

    private Object[][] data = null;

    @Override
    public int getRowCount() {
        if (null == data) {
            return 0;
        }
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (null == data) {
            return null;
        }
        return data[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column].toString();
    }

    /**
     * 获取一行数据
     * @param rowIndex
     * @return
     */
    public Object[] getRow(int rowIndex) {
        if (null == data) {
            return null;
        }
        return data[rowIndex];
    }

    /**
     * 从数据库加载数
     */
    public void refresh() {
        try {
            this.data = DbGoodsUtil.listGoods();
            fireTableDataChanged();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("货物库存数据加载失败");
        }
    }
}
