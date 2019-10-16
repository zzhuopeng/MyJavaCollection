package com.A2_MianShi.P05_XiaoMi;

/**
 * 小米二面：
 * 输入一个正整数数组Array和一个数字SUM，找到第一个连续子数组之和等于SUM的子数组并返回
 * 例：【1，3，7，2，5，9】，SUM = 14
 * 返回【7，2，5】
 * 注意考虑边界条件和特殊情况
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {1, 3, 7, 2, 5, 9};
        int sum = 14;
        int[] result = getSubArray(array, sum);
        if(null == result)
            return;
        for(int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] getSubArray(int[] array, int sum) {
        if(null == array || sum < 0)
            return null;
        int i = 0;
        int j = 0;
        int count = 0;
        while(i <= j && j < array.length) {
            if(count < sum) {
                j++;
                count += array[j];
            } else if(count > sum) {
                count -= array[i];
                i++;
            } else {
                break;
            }
        }
        if(count != sum)
            return null;
        int length = j-i+1;
        int[] result = new int[length];
        for(int z=0; z<length; z++) {
            result[z] = array[i+z];
        }
        return result;
    }
}