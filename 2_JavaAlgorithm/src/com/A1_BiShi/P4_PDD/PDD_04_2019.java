package com.A1_BiShi.P4_PDD;

import java.util.Scanner;

/**
 * PDD牛客网2019真题第四题。
 * 计算杀死敌人的最小回合数
 */
public class PDD_04_2019 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int hp = scanner.nextInt();
            int normal = scanner.nextInt();
            int buffer = scanner.nextInt();

            int res = 0;
            if (normal * 2 >= buffer) {
                res = hp / normal;
                res = (hp % normal != 0) ? res + 1 : res;
            } else {
                res = (hp / buffer) * 2;
                if (hp % buffer == 0)
                    res = res;
                else if (hp % buffer <= normal)
                    res++;
                else
                    res += 2;
            }
            System.out.println(res);
        }
    }
}
