package cn.jcera.core.util;

import java.util.UUID;

public class UUIDGenerator {
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 去掉"-"符号
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        return temp;
    }

    //获得指定数量的UUID　
    public static String getUUID(int length) {
        if (length < 1) {
            return null;
        }
        String str = getUUID();
        return str.substring(0, length);
    }

    public static void main(String[] args) {
        System.out.println(getUUID(6));
    }
}
