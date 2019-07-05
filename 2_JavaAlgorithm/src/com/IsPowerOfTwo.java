package com;

import org.junit.Test;

/**
 * 笔记：数据结构与算法->a4.判断一个数是否是2的幂次方
 */
public class IsPowerOfTwo {

    @Test
    public void test() {
        if (isPowerOfTwo2(1073741824))
            System.out.println("true");
        else
            System.out.println("false");
    }

    /**
     * 判断num是否为2的幂次方
     * @param num 需要判断的数
     * @return 是否为2的幂次方
     */
    boolean isPowerOfTwo(int num) {
        int count = 0;
        if (0 == num)
            return false;
        while (0 != num) {
            if (1 == (1 & num)) {
                count++;
            }
            num = num >> 1;
        }
        return count == 1;
    }

    boolean isPowerOfTwo2(int num) {
        if(0 == num)
            return false;

        return 0 == (num & (num - 1));
    }
}
