package com.demo.adapter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NumberInput extends KeyAdapter {

    /**
     * 可以输入的字符 (char)8是指退格键
     */
    String canInputKey = "0123456789." + (char)8;

    @Override
    public void keyTyped(KeyEvent e) {
        if (canInputKey.indexOf(e.getKeyChar()) < 0) {
            e.consume();
        }
    }
}
