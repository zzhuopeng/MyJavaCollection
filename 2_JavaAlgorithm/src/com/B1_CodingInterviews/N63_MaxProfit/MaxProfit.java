package com.B1_CodingInterviews.N63_MaxProfit;

public class MaxProfit {
    public static void main(String[] args) {
        int[] array = new int[]{20, 23, 19, 15, 18, 20, 16, 21, 23, 16, 21};
        String[] dates = new String[]{"20190701", "20190702", "20190703", "20190704", "20190705",
                "20190706", "20190707", "20190708", "20190709", "20190710", "20190711"};

        System.out.println(maxProfit(array));

        System.out.print("最大买入卖出时间分别为：");
        int[] result = maxProfit2(array);
        for (int i = 0; i < result.length; i++) {
            System.out.print(dates[result[i]] + "  ");
        }
        System.out.print("最大利润为：" + (array[result[1]] - array[result[0]]));
    }

    //求股票最大利润（不需要记录下标）
    public static int maxProfit(int[] prices) {
        if (null == prices || prices.length <= 1)
            return -1;

        int min = prices[0];
        int maxProfit = prices[1] - prices[0];
        for (int i = 2; i < prices.length; i++) {
            if (min >= prices[i - 1]) { //时间近的，花时间少，时间利润高（相等也更新）
                min = prices[i - 1];
            }

            int currentProfit = prices[i] - min;
            if (currentProfit > maxProfit)
                maxProfit = currentProfit;
        }

        return maxProfit;
    }

    //求股票最大利润，并记录买卖时间
    public static int[] maxProfit2(int[] prices) {
        if (null == prices || prices.length <= 1)
            return null;

        int[] result = new int[2]; //记录买卖时间

        int min = prices[0];
        int maxProfit = prices[1] - prices[0];
        for (int i = 2; i < prices.length; i++) {
            if (min >= prices[i - 1]) {
                min = prices[i - 1];
                result[0] = i - 1;
            }

            int currentProfit = prices[i] - min;
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
                result[1] = i;
            }
        }

        return result;
    }
}
