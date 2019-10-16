package com.B1_CodingInterviews.N04_FindMatrix;

import org.junit.Test;

/**
 * 04题：二维数组中的查找（P44）
 *
 * 题目描述：在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindMatrix {

    @Test
    public void testFind() {
        int target = 5;
        int[][] array = {{1, 2, 8, 9},
                        {2, 4, 9, 12},
                        {4, 7, 10, 13},
                        {6, 8, 11, 15}};

        if (findMatrix(target, array)) {
            System.out.println("查找到该目标");
        } else {
            System.out.println("未找到该目标");
        }
    }

    public boolean findMatrix(int target, int[][] array) {

        //记录二维数组的行列数
        int arrayRow = 0;
        int arrayColum = array[0].length - 1;

        while (arrayColum >= 0 && arrayRow <= array.length - 1) {
            if (target < array[arrayRow][arrayColum]) {
                arrayColum--;
            } else if (target > array[arrayRow][arrayColum]) {
                arrayRow++;
            } else {
                return true;
            }
        }

        return false;
    }
}
