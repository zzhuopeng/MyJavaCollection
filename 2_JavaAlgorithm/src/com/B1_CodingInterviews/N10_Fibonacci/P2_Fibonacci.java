package com.B1_CodingInterviews.N10_Fibonacci;

/**
 * 0,1,1,2,3,5,8,13,21,34,55
 */
public class P2_Fibonacci {
    public static void main(String[] args) {
        int n = 9;
        System.out.println(fibonacci1(n));
        System.out.println(fibonacci2(n));
    }

    //递归
    public static int fibonacci1(int n) {
        if (0 == n || 1 == n)
            return n;

        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }

    //循环
    public static int fibonacci2(int n) {
        if(n <= 1)
            return n;
        int temp1 = 0;
        int temp2 = 1;

        int result = 0;
        for(int i=2; i<=n; i++) {
            result = temp1 + temp2; //前两项相加
            temp1 = temp2;
            temp2 = result;
        }

        return result;
    }
}
