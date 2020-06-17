package com.demo.panel.sale;

import com.demo.util.DbUserUtil;

import javax.swing.*;
import java.sql.SQLException;

public class UserListModel extends AbstractListModel<String> {

    private Object[][] data = null;

    UserListModel() {
        refresh();
    }

    @Override
    public int getSize() {
        return null != data ? data.length : 0;
    }

    @Override
    public String getElementAt(int index) {
        // 显示 数据库数据的 name(phone) 也就是数组的1和2
        return null != data ? data[index][1] + "(" + data[index][2] + ")" : null;
    }

    /**
     * 获取选中行的数据
     * @param index
     * @return
     */
    public Object[] getIndex(int index) {
        return null != data ? data[index] : null;
    }

    /**
     * 搜索用户Id在数据的哪一行
     * @param goodId
     * @return
     */
    public int searchIndex(int goodId) {
        if (null == data) {
            return 0;
        }
        for (int i = 0; i < data.length; i++) {
            if (goodId == (int)data[i][0]) {
                return i;
            }
        }
        return 0;
    }

    public void refresh() {
        try {
            // 数据顺序 id name phone points
            this.data = DbUserUtil.listUser();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("用户数据加载失败");
        }
    }
}
