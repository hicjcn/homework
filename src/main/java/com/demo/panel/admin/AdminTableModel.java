package com.demo.panel.admin;

import com.demo.util.DbAdminUtil;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;

public class AdminTableModel extends AbstractTableModel {

    private Object[] columnNames = {"用户名","姓名","手机号","用户类型"};

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
        // 用户类型转换成中文
        if (3 == columnIndex) {
            switch ((int)data[rowIndex][columnIndex]) {
                case 0:
                    return "管理员";
                case 1:
                    return "库存管理员";
                case 2:
                    return "销售管理员";
            }
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
            this.data = DbAdminUtil.listAdmin();
            fireTableDataChanged();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("用户数据加载失败");
        }
    }
}
