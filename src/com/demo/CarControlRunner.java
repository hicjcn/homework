package com.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class CarControlRunner extends JFrame {

    private JButton btnUp, btnDown, btnLeft, btnRight, btnForward;

    KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();

    Socket socket;
    DataOutputStream out;


    CarControlRunner() {
        setTitle("汽车控制");
        setSize(280, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 窗口在屏幕中间显示
        setLocationRelativeTo(null);

        // 添加 显示的 panel
        JPanel panel = new JPanel();
        add(panel);
        init(panel);

        keyboardListen();

        try {
            socket = new Socket("127.0.0.1", 666);
            // 向服务器端发送信息的DataOutputStream
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 设置界面可见
        setVisible(true);

    }

    /**
     * 初始化组件
     * @param panel
     */
    private void init(JPanel panel) {

        panel.setLayout(null);

        // 显示 上下左右向前按钮
        btnForward = new JButton("向前");
        btnForward.setBounds(10,20,200,20);
        panel.add(btnForward);
        btnForward.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(0);
            }
        });

        btnLeft = new JButton("左");
        btnLeft.setBounds(10,40,200,20);
        panel.add(btnLeft);
        btnLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(1);
            }
        });

        btnRight = new JButton("右");
        btnRight.setBounds(10,60,200,20);
        panel.add(btnRight);
        btnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(2);
            }
        });

        btnUp = new JButton("上");
        btnUp.setBounds(10,80,200,20);
        panel.add(btnUp);
        btnUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(4);
            }
        });

        btnDown = new JButton("下");
        btnDown.setBounds(10,100,200,20);
        panel.add(btnDown);
        btnDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(3);
            }
        });

    }

    private void sendMessage(int code) {
        System.out.println("发送指令：" + code);

        try{
            //将客户端的信息传递给服务器
            out.writeUTF(String.valueOf(code));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                        sendMessage(4);
                        break;
                    case KeyEvent.VK_DOWN:
                        // 下键
                        sendMessage(3);
                        break;
                    case KeyEvent.VK_RIGHT:
                        // 右键 右转
                        sendMessage(2);
                        break;
                    case KeyEvent.VK_LEFT:
                        // 左键 左转
                        sendMessage(1);
                        break;
                    default:
                        sendMessage(0);
                        break;
                }
                return true;
            }
        });
    }

    public static void main(String[] args) {
        CarControlRunner runner = new CarControlRunner();
    }
}
