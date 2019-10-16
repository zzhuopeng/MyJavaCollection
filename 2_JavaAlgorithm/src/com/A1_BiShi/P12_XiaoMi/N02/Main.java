package com.A1_BiShi.P12_XiaoMi.N02;

import java.util.*;

/**
 * 2.最大距离
 * https://blog.csdn.net/ccccc1997/article/details/81260508
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String arrStr = scanner.nextLine();

        String tempStr = arrStr.substring(1, arrStr.length() - 1);
        String[] tempStrArr = tempStr.split(",");
        int[] nums = new int[tempStrArr.length];
        for (int i = 0; i < tempStrArr.length; i++) {
            nums[i] = Integer.parseInt(tempStrArr[i]);
        }

        int len = maxDistToClosest(nums);
        System.out.println(len);
    }

    public static int maxDistToClosest(int[] seats) {
        //异常检测
        if (1 == seats.length)
            return 0;
        int num = 0;
        int result = 0;

        int i = 0;
        for (; i < seats.length && seats[i] == 0; i++) ++num;
        result = Math.max(num, result);

        num = 0;
        int j = seats.length - 1;
        for (; j >= 0 && seats[j] == 0; j--) ++num;
        result = Math.max(num, result);

        while (i < j) {
            for (; i < j && seats[i] == 1; i++) ;
            num = 0;
            for (; i < j && seats[i] == 0; i++) ++num;
            if (0 == num % 2)
                result = Math.max(num / 2, result);
            else
                result = Math.max(num / 2 + 1, result);
            i++;
        }
        return result;
    }
}
