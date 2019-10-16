package com.B1_CodingInterviews.N53_GetNumberOfK;

import org.junit.Test;

/**
 * 53题：数字K在排序数组中出现的次数。（法2牛客上没通过）
 * <p>
 * 1.顺序查找：O(N)，且没有利用排序条件
 * 2.二分查找，前后线性探测：O(N)，虽然使用了排序条件，但是当数组中全部都是查找数k时，线性探测会变成O(N)
 * 3.二分查找第一个K，二分查找最后一个K：O(lgN)
 */
public class Main {

    @Test
    public void test() {
//        int[] array = new int[]{1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 6, 7, 8, 8, 8, 8, 8, 9};
//        System.out.println(GetNumberOfK(array, 6)); //4
        int[] array = new int[]{1, 2, 3, 3, 3, 4, 6, 6, 6, 6, 7, 8, 8, 8, 8, 8, 9};
        System.out.println(GetNumberOfK(array, 5)); //0
    }

    //3.二分查找第一个K，二分查找最后一个K：O(lgN)
    private int GetNumberOfK(int[] array, int k) {

        return 0;
    }

    //2.二分查找，顺序探测
    public int GetNumberOfK2(int[] array, int k) {
        if (null == array || 0 == array.length)
            return 0;
        int res = GetIndexOfK(array, k);
        //没找到k
        if (-1 == res)
            return 0;
        int sum = 1;
        int left = res - 1;
        int right = res + 1;
        while (left > 0 || right < array.length) {
            //left--不要写在满足条件里面，否则会死循环
            if (left > 0 && array[left--] == k) {
                sum++;
            }
            if (right < array.length && array[right++] == k) {
                sum++;
            }
        }
        return sum;
    }

    public int GetIndexOfK(int[] array, int k) {
        int lo = 0;
        int hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int c = k - array[mid];
            if (c > 0)
                lo = mid + 1;
            else if (c < 0)
                hi = mid - 1;
            else {
                return mid;
            }
        }
        //没找到
        return -1;
    }

    //1.顺序查找（不推荐使用）
    public int GetNumberOfK1(int[] array, int k) {
        //这个要用二分查找来做，不然排序给出的规律没用上
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            if (k == array[i])
                res++;
        }
        return res;
    }
}