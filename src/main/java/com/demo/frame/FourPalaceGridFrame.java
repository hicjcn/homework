package com.demo.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 四宫格窗口 继承JFrame
 */
public class FourPalaceGridFrame extends JFrame {

    /**
     * 按钮状态 1表示为红 0表示为蓝
     */
    private int[][] buttonState = {
            {0,0,0,0},
            {0,1,0,0},
            {0,0,0,0},
            {0,0,0,0},
    };

    /**
     * 按钮实例
     */
    private JButton[][] buttons = new JButton[4][4];

    /**
     * 保存窗口实例以便刷新界面
     */
    private FourPalaceGridFrame thisFrame = this;

    FourPalaceGridFrame() {
        // 设置窗口标题
        setTitle("按钮红蓝4*4拼图");
        // 设置成400* 400的窗口大小
        setSize(400, 400);
        // 窗口在屏幕中间显示
        setLocationRelativeTo(null);
        // 点击关闭窗口时退出程序而不是隐藏
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // 设置为网格布局 4 * 4的 网格边距为 水平以及竖直 边距都为1
        setLayout(new GridLayout(4,4, 1, 1));

        // 绑添加颜色按钮到界面上
        bindBtnView();

        setVisible(true);
    }

    /**
     * 绑定按钮到界面上
     */
    private void bindBtnView(){
        // 循环添加按钮到界面上
        for (int i = 0; i < buttonState.length; i++) {
            int[] row = buttonState[i];
            for (int j = 0; j < row.length; j++) {
                // new一个按钮实例
                buttons[i][j] = new JButton();
                // 设置控件透明 来显示颜色
                buttons[i][j].setOpaque(true);
                // 去掉边框
                buttons[i][j].setBorderPainted(false);
                // 如果当前位置是1 则设置背景色为红色，不然就是蓝色
                if (1 == row[j]) {
                    // 设置背景色
                    buttons[i][j].setBackground(Color.RED);
                } else {
                    buttons[i][j].setBackground(Color.BLUE);
                }
                int finalI = i;
                int finalJ = j;
                // 按钮还需要设置监听事件
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("网格["+ finalI +","+ finalJ +"]被点击");
                        // 检查上下左右是否有红色按钮 有的话要交换值 并且刷新界面
                        // 上 如果上面有按钮并且为红色则交换数值
                        if (finalI - 1 >= 0 && 1 == buttonState[finalI - 1][finalJ]) {
                            System.out.println("红色方块向下移动");
                            buttonState[finalI - 1][finalJ] = 0;
                            buttons[finalI - 1][finalJ].setBackground(Color.BLUE);
                            buttonState[finalI][finalJ] = 1;
                            buttons[finalI][finalJ].setBackground(Color.RED);
                        }
                        // 下
                        else if (finalI + 1 < 4 && 1 == buttonState[finalI + 1][finalJ]) {
                            System.out.println("红色方块向上移动");
                            buttonState[finalI + 1][finalJ] = 0;
                            buttons[finalI + 1][finalJ].setBackground(Color.BLUE);
                            buttonState[finalI][finalJ] = 1;
                            buttons[finalI][finalJ].setBackground(Color.RED);
                        }
                        // 左
                        else if (finalJ - 1 >= 0 && 1 == buttonState[finalI][finalJ - 1]) {
                            System.out.println("红色方块向右移动");
                            buttonState[finalI][finalJ - 1] = 0;
                            buttons[finalI][finalJ - 1].setBackground(Color.BLUE);
                            buttonState[finalI][finalJ] = 1;
                            buttons[finalI][finalJ].setBackground(Color.RED);
                        }
                        // 右
                        else if (finalJ + 1 < 4 && 1 == buttonState[finalI][finalJ + 1]) {
                            System.out.println("红色方块向左移动");
                            buttonState[finalI][finalJ + 1] = 0;
                            buttons[finalI][finalJ + 1].setBackground(Color.BLUE);
                            buttonState[finalI][finalJ] = 1;
                            buttons[finalI][finalJ].setBackground(Color.RED);
                        }
                        // 调用窗体函数刷新界面
                        thisFrame.revalidate();
                    }
                });
                // 按钮添加到界面上
                add(buttons[i][j]);
            }
        }
    }
}
