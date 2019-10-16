package com.A1_BiShi.P8_HuiDing_ZT.N01;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;

public class Main {
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String pattern = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

        int mask = 63;
        mask = mask << (24-6);
        ArrayList<Integer> array = new ArrayList<>();
        int tmp = 0;
        tmp |= (s.charAt(0) & 0xff) << 24
                | (s.charAt(1) & 0xff) << 16
                | (s.charAt(2) & 0xff) << 8;

        for (int i = 0; i < 4; i++) {
            array.add((tmp & mask)>>(18-6*i));
            mask = mask >> 6;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.size(); i++) {
            stringBuilder.append(pattern.charAt(array.get(i)));
        }
        System.out.println(stringBuilder.toString());
    }

    /**
     * 直接调用Base64编码工具解题
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(new String(Base64.getEncoder().encode(scanner.nextLine().getBytes())));
    }

    /**
     * 网上代码：先转化为二进制的String，然后再每6个取出
     */
    public static void main3(String[] args) {
        String map = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if (str == null || str.equals("")) {
                System.out.println("输入有误，请重新输入");
                continue;
            }

            String last = "";
            if (str.length() % 3 == 1) {
                last += "==";
            } else if (str.length() % 3 == 2) {
                last += "=";
            }

            String binaryStr = "";
            for (int i = 0; i < str.length(); i++) {
                String binary = Integer.toBinaryString(str.charAt(i));
                binaryStr += String.format("%08d", Integer.valueOf(binary));
            }
            if (binaryStr.length() % 24 != 0) {
                binaryStr += String.format("%0" + (24 - binaryStr.length() % 24) + "d", 0);
            }

            String result = "";
            for (int i = 0; i < binaryStr.length() / 6; i++) {
                String tmp = binaryStr.substring(i * 6, (i + 1) * 6);
                Integer index = Integer.parseInt(tmp,2);
                result += map.charAt(index);
            }

            System.out.println(result.substring(0, result.length() - last.length()) + last);
        }
    }
}
