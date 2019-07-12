package com.DataStructureAndAlgorithmAnalysisInC;

import org.junit.Test;

/**
 * P001:选择问题。
 *
 * 题目描述：假设有一个长度为N的数组，找出其中第k个最大值。
 */
public class P001_SelectionProbelm {

    @Test
    public void testSolve() {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 34, 56, 78, 43};
        int k = 5;

        System.out.println("第k个数为" + mySolveBubble(array1, k));
    }


    /**
     * 我的算法实现函数:首先通过简单的冒泡排序，然后返回第k个元素。
     *
     * @param array
     * @param k
     * @return
     */
    public int mySolveBubble(int[] array, int k) {
        //冒泡排序进行排序
        array = bubbleSort(array);
        //输出一下看看排序结果
        for (int i : array) {
            System.out.print(i + "  ");
        }

        return array[k - 1];
    }

    /**
     * 冒泡排序
     *
     * @return
     */
    public int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {

        }

        return array;
    }
}
