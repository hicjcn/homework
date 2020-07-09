package com.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class CarRunner extends JFrame {

    private Car car;

    private JLabel jLenght, jWidth, jHeight, jWeight, jDirection, jPower;

    KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();

    CarRunner () {
        // 初始化车
        car = new Car(2000, 1200, 1100, 2000);

        setTitle("汽车");
        setSize(280, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 窗口在屏幕中间显示
        setLocationRelativeTo(null);

        // 添加 显示的 panel
        JPanel panel = new JPanel();
        add(panel);
        init(panel);

        refreshText();

        keyboardListen();

        // 设置界面可见
        setVisible(true);

    }

    /**
     * 初始化组件
     * @param panel
     */
    private void init(JPanel panel) {

        panel.setLayout(null);

        // 显示 长 宽 高 重量 方向 功率
        jLenght = new JLabel("长度:" + car.getLength() + "CM");
        jLenght.setBounds(10,20,200,20);
        panel.add(jLenght);

        jWidth = new JLabel("宽度:" + car.getWidth() + "CM");
        jWidth.setBounds(10,40,200,20);
        panel.add(jWidth);

        jHeight = new JLabel("高度:" + car.getHeight() + "CM");
        jHeight.setBounds(10,60,200,20);
        panel.add(jHeight);

        jWeight = new JLabel("重量:" + car.getWeight() + "KG");
        jWeight.setBounds(10,80,200,20);
        panel.add(jWeight);

        jDirection = new JLabel("方向:" + car.getDirection().getDesc());
        jDirection.setBounds(10,100,200,20);
        panel.add(jDirection);

        jPower = new JLabel("功率:" + car.getPower());
        jPower.setBounds(10,120,200,20);
        panel.add(jPower);

    }

    /**
     * 按键监听
     */
    private void keyboardListen() {
        manager.addKeyEventPostProcessor(new KeyEventPostProcessor() {
            @Override
            public boolean postProcessKeyEvent(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        // 上键 加功率
                        car.setPower(car.getPower() + 1);
                        break;
                    case KeyEvent.VK_DOWN:
                        // 下键 功率小于0要设置成0
                        car.setPower(car.getPower() - 10 > 0 ? car.getPower() - 10 : 0);
                        break;
                    case KeyEvent.VK_RIGHT:
                        // 右键 右转
                        car.turn(Direction.right);
                        break;
                    case KeyEvent.VK_LEFT:
                        // 左键 左转
                        car.turn(Direction.left);
                        break;
                    default:
                        car.turn(Direction.forward);
                        break;
                }
                // 刷新显示
                refreshText();
                return true;
            }
        });
    }

    /**
     * 刷新显示
     */
    private void refreshText() {
        jLenght.setText("长度:" + car.getLength() + "CM");
        jWidth.setText("宽度:" + car.getWidth() + "CM");
        jHeight.setText("高度:" + car.getHeight() + "CM");
        jWeight.setText("重量:" + car.getWeight() + "KG");
        jDirection.setText("方向:" + car.getDirection().getDesc());
        jPower.setText("功率:" + car.getPower());
    }

    public static void main(String[] args) {
        CarRunner runner = new CarRunner();
    }
}
