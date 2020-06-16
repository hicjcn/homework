package com.demo.panel.goods;

import com.demo.util.DbQueryUtil;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;

public class GoodsTableModel extends AbstractTableModel {

    private Object[] columnNames = {"编号","名称","规格","单价","销售价","厂家"};

    private Object[][] data = null;

    /**
     * Returns the number of rows in the model. A
     * <code>JTable</code> uses this method to determine how many rows it
     * should display.  This method should be quick, as it
     * is called frequently during rendering.
     *
     * @return the number of rows in the model
     * @see #getColumnCount
     */
    @Override
    public int getRowCount() {
        if (null == data) {
            return 0;
        }
        return data.length;
    }

    /**
     * Returns the number of columns in the model. A
     * <code>JTable</code> uses this method to determine how many columns it
     * should create and display by default.
     *
     * @return the number of columns in the model
     * @see #getRowCount
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * Returns the value for the cell at <code>columnIndex</code> and
     * <code>rowIndex</code>.
     *
     * @param rowIndex    the row whose value is to be queried
     * @param columnIndex the column whose value is to be queried
     * @return the value Object at the specified cell
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (null == data) {
            return null;
        }
        return data[rowIndex][columnIndex];
    }

    /**
     * 从数据库加载数
     */
    public void refresh() {
        try {
            this.data = DbQueryUtil.listGoods();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("货物库存数据加载失败");
        }
    }
}
