package com.demo.panel.sale;

import com.demo.service.SaleService;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;

public class SaleTableModel extends AbstractTableModel {

    private Object[] columnNames = {"编号","名称","规格","数量","销售价","会员","会员联系电话","销售时间"};

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
            this.data = SaleService.listSaleRecord();
            fireTableDataChanged();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("销售数据加载失败");
        }
    }
}
