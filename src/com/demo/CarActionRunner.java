package com.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CarActionRunner extends JFrame {

    private Car car;

    private JLabel jLenght, jWidth, jHeight, jWeight, jDirection, jPower;

    KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();

    CarActionRunner() {
        // 初始化车
        car = new Car(2000, 1200, 1100, 2000);

        setTitle("汽车动作");
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

        // 开启tcp监听
        Thread socketThread = new Thread(new Runnable() {
            @Override
            public void run() {
                startService();
            }
        });
        socketThread.start();

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
                System.out.println(e.getKeyCode());
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

    private void startService() {
        try {// 建立服务器连接
            ServerSocket server = new ServerSocket(666);//创建  ServerSocket类
            Socket socket = server.accept();// 等待客户连接
            try {
                DataInputStream in = new DataInputStream(socket.getInputStream());// 读取客户端传过来信息的DataInputStream
                while (true) {
                    int code = Integer.valueOf(in.readUTF());// 读取来自客户端的信息
                    System.out.println(code);//输出来自客户端的信息
                    switch (code) {
                        case 4:
                            // 上键 加功率
                            car.setPower(car.getPower() + 1);
                            break;
                        case 3:
                            // 下键 功率小于0要设置成0
                            car.setPower(car.getPower() - 10 > 0 ? car.getPower() - 10 : 0);
                            break;
                        case 2:
                            // 右键 右转
                            car.turn(Direction.right);
                            break;
                        case 1:
                            // 左键 左转
                            car.turn(Direction.left);
                            break;
                        default:
                            car.turn(Direction.forward);
                            break;
                    }
                    // 刷新显示
                    refreshText();
                }
            } finally {// 建立连接失败的话不会执行socket.close();
                socket.close();//关闭连接
                server.close();//关闭
            }
        } catch (Exception e) {//捕获异常
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CarActionRunner runner = new CarActionRunner();
    }
}
