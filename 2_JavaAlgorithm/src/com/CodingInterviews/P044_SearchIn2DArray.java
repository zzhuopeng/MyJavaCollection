package com.CodingInterviews;

import org.junit.Test;

/**
 * Page44.二维数组中的查找
 *
 * 题目描述：在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class P044_SearchIn2DArray {

    @Test
    public void testFind() {
        int target = 1;
        int[][] array = {{1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}};

        if (findStandard(target, array)) {
            System.out.println("查找到该目标");
        } else {
            System.out.println("未找到该目标");
        }
    }

    /**
     * 我的方案
     *
     * @param target 目标点
     * @param array  二维数组
     * @return 查找结果
     */
    public boolean find(int target, int[][] array) {

        //记录二维数组的行列数
        int arrayRow = array.length;
        int arrayColum = array[0].length;

        int maxColum = -1;
        int minColum = -1;

        for (int i = 0; i < arrayColum; i++) {
            if (target < array[0][i]) {
                maxColum = i;
                break;
            }
        }
        for (int i = 0; i < arrayColum; i++) {
            if (target > array[arrayRow - 1][i]) {
                minColum = i;
                break;
            }
        }
        if (maxColum < 0)
            maxColum = arrayColum;
        if (minColum < 0)
            minColum = -1;
        //上面找到了target所在的列的范围（目前打算遍历该范围）
        for (int i = minColum + 1; i < maxColum; i++) {
            for (int j = 0; j < arrayRow; j++) {
                if (target == array[j][i]) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 书本的方案
     *
     * @param target 目标点
     * @param array  二维数组
     * @return 查找结果
     */
    public boolean findStandard(int target, int[][] array) {

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
