package com.demo;

import java.util.Scanner;

/**
 * 鸡兔同笼问题
 *
 * 运用穷举算法，判断数量关系是否成立，并输出数值
 */
public class Jitutonlong {

    public static void main(String[] args) {

        // 设立 头的数据 腿的数量
        int heads = 0, legs = 0;
        // 输入
        Scanner scanner = new Scanner(System.in);

        System.out.println("鸡兔同笼问题（穷举法）");

        while (true) {
            System.out.print("请输入头的数量：");
            heads = input(scanner.nextLine());
            System.out.print("请输入腿的数量：");
            legs = input(scanner.nextLine());
            judge(heads, legs);
        }
    }

    private static int input(String input) {
        // 如果输入exit则退出
        if ("exit".equals(input)) {
            System.exit(0);
        }
        return Integer.parseInt(input);
    }

    private static void judge(int heads, int legs) {
        if (heads < 0 || legs < 0) {
            System.out.println("数量不能为负数");
            return;
        }
        // 腿的数量至少是头的两倍 最多是4倍 且为偶数
        if (legs < 2 * heads) {
            System.out.println("腿的数量至少是头的2倍");
            return;
        }
        if (legs > 4 * heads) {
            System.out.println("腿的数量最多是头的4倍");
            return;
        }
        if (legs % 2 == 1) {
            System.out.println("腿的数量必须为偶数");
            return;
        }

        int chickens, rabbits;
        for (chickens = 0; chickens < heads + 1; chickens++) {
            // 兔的数量 = 头 - 鸡的数量
            rabbits = heads - chickens;
            // 鸡兔同笼的数量关系是否成立
            if (legs == 2 * chickens + 4 * rabbits) {
                System.out.println("鸡的数数量：" + chickens + "，兔的数量：" + rabbits);
                break;
            }
        }
    }
}
