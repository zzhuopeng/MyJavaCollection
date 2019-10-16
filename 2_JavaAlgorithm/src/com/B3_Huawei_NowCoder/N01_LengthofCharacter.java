package com.B3_Huawei_NowCoder;

import java.util.Scanner;

/**
 * 牛客网 华为机试题01 AC
 * 字符串最后一个单词的长度
 */
public class N01_LengthofCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            String[] tmp = string.split(" ");
            if (tmp.length > 0) {
                String lastString = tmp[tmp.length - 1];
                System.out.println(lastString.length());
            }
        }
    }
}
