package com.B1_CodingInterviews.N10_Fibonacci;

public class P3_JumpFloor {
    /**
     * 青蛙跳台阶
     */
    public int jumpFloor(int target) {
        if (target <= 2)
            return target;
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }

    /**
     * 疯狂青蛙跳台阶
     */
    public int jumpFloor2(int target) {
        if (target <= 2)
            return target;
        return 2 * jumpFloor2(target - 1);
    }
}
