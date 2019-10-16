package com.A1_BiShi.P12_XiaoMi.N01;

import java.util.*;

/**
 * 1.分糖果
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String arrStr = scanner.nextLine();

        String tempStr = arrStr.substring(1, arrStr.length() - 1);
        String[] tempStrArr = tempStr.split(",");
        int[] ratings = new int[tempStrArr.length];
        for (int i = 0; i < tempStrArr.length; i++) {
            ratings[i] = Integer.parseInt(tempStrArr[i]);
        }

        int candynum = candy(ratings);
        System.out.println(candynum);

    }

    public static int candy(int[] ratings) {
        int[] nums = new int[ratings.length];
        nums[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                nums[i] = nums[i - 1] + 1;
            else
                nums[i] = 1;
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1] && nums[i - 1] <= nums[i]) { //未排序的部分，需要重新排序
                nums[i - 1] = nums[i] + 1;
            }
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result + nums[i];
        }
        return result;
    }
}

