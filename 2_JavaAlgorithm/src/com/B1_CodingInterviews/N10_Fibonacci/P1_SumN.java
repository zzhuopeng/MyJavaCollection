package com.B1_CodingInterviews.N10_Fibonacci;

import org.junit.Test;

/**
 * 剑指Offer P73
 * 功能：计算1+...+n之和
 */
public class P1_SumN {

    @Test
    public void test() {
        int test = 100000;
        //递归深度过深，如10000，就会出现StackOverflow
        System.out.println("递归:" + SumN(test));
        //压力测试中，没出现异常
        System.out.println("循环:" + SumN2(test));
    }

    /**
     * 递归实现
     */
    public int SumN(int n) {
        if (n < 0)
            System.out.println("Input number cannot be negative");
        return (n == 0) ? 0 : n + SumN(n - 1);
    }

    /**
     * 循环实现
     */
    public int SumN2(int n) {
        if (n < 0)
            System.out.println("Input number cannot be negative");

        int result = 0;
        for (int i = 0; i <= n; i++)
            result += i;
        return result;
    }
}
