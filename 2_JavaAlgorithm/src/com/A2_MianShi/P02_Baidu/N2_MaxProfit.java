package com.A2_MianShi.P02_Baidu;

import java.util.ArrayList;
import java.util.List;


// 商品价格趋势图，求最佳买入、卖出两个时间点
// {"20190701":20,"20190702":23,"20190703":19,"20190704":15,"20190705":18}

/**
 * 百度电话面 第二题
 * 求股票的买入卖出最大利润
 */
public class N2_MaxProfit {
    public static void main(String args[]) {
        List<Stock> stocks = new ArrayList<>();

        stocks.add(new Stock("20190701", 20));
        stocks.add(new Stock("20190702", 23));
        stocks.add(new Stock("20190703", 19));
        stocks.add(new Stock("20190704", 15));
        stocks.add(new Stock("20190705", 18));

        stocks.add(new Stock("20190706", 20));
        stocks.add(new Stock("20190707", 16));
        stocks.add(new Stock("20190708", 21));
        stocks.add(new Stock("20190709", 23));
        stocks.add(new Stock("20190710", 16));
        stocks.add(new Stock("20190711", 21));

        String[] result = getBestTimes(stocks);
        for (String s : result) {
            System.out.println(s);
        }
    }

    private static String[] getBestTimes(List<Stock> stocks) {
        int buy = 0, sell = 1;

        int min = stocks.get(0).getPrice();
        int maxProfit = stocks.get(1).getPrice() - min;

        for (int i = 2; i < stocks.size(); i++) {
            int mmin = min;
            int mbuy = buy;
            if (min > stocks.get(i - 1).getPrice()) {
                mmin = stocks.get(i - 1).getPrice();//伪最低价
                mbuy = i - 1;
            }

            int tmp = stocks.get(i).getPrice() - mmin;
            if (tmp > maxProfit) {
                maxProfit = tmp;
                sell = i;
                buy = mbuy;
                min = mmin;//真最低价
            }
        }

        return new String[]{stocks.get(buy).getTime(), stocks.get(sell).getTime()};
    }

    /**
     * 暴力求解
     */
    private static String[] getBestTimes1(List<Stock> stocks) {
        int profit = 1;
        int buyIndex = 0, sellIndex = 0;
        for (int i = 0; i < stocks.size(); i++) {
            for (int j = i + 1; j < stocks.size(); j++) {
                int tmp = stocks.get(i).getPrice() - stocks.get(j).getPrice();
                if (tmp < profit) {
                    profit = tmp;
                    buyIndex = i;
                    sellIndex = j;
                }
            }
        }
        return new String[]{stocks.get(buyIndex).getTime(), stocks.get(sellIndex).getTime()};
    }

    static class Stock {
        private String time;
        private int price;

        Stock(String time, int price) {
            this.time = time;
            this.price = price;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getTime() {
            return time;
        }

        public int getPrice() {
            return price;
        }
    }
}
