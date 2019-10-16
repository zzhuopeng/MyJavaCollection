package com.B3_Huawei_NowCoder;

import java.util.Scanner;

/**
 * 牛客网 华为机试02 AC
 * 接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 */
public class N02_NumOfCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            String tmp = scanner.nextLine();

            if (!tmp.isEmpty() && !string.isEmpty()) {
                int res = 0;
                char target = tmp.charAt(0);
                //大小写字符之间相差32
                char target1 = (char) (target - 32);
                char target2 = (char) (target + 32);

                for (int i = 0; i < string.length(); i++) {
                    if (string.charAt(i) == target || string.charAt(i) == target1
                            || string.charAt(i) == target2) {
                        res++;
                    }
                }
                System.out.println(res);
            }

        }
    }
}
