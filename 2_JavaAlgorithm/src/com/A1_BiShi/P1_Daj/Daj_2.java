package com.A1_BiShi.P1_Daj;

import java.util.*;

/**
 * 大疆第二题（完成）
 */
public class Daj_2 {
    public static void main(String[] args) {
        Map<String, String> datas = new HashMap<>();
        List<String> ques = new ArrayList<>();
        List<String> ans = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] nums = scanner.nextLine().split(" ");
            int N = Integer.parseInt(nums[0]);
            int M = Integer.parseInt(nums[1]);

            //键值对
            for (int i = 0; i < N; i++) {
                String[] tmp = scanner.nextLine().split(" ");
                datas.put(tmp[0], tmp[1]);
            }
            //指令
            for (int i = 0; i < M; i++) {
                String tmp = scanner.nextLine();
                ques.add(tmp);
            }
        }
        //查询指令，找到答案
        for (int i = 0; i < ques.size(); i++) {
            ans.add(datas.get(ques.get(i)));
        }
        //输入答案
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
