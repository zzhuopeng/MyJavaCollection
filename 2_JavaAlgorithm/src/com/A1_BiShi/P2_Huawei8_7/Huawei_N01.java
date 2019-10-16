package com.A1_BiShi.P2_Huawei8_7;

import java.util.*;

/**
 * 华为笔试第一题：字符串处理
 */
public class Huawei_N01 {
    //测试用例：
    // a:3,b:5,c:2@a:3,b:5,c:2
    // a:3,b:5,c:2@
    // a:3,b:5,c:2@a:1,b:2
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            String[] tmp = string.split("@");
            //异常检测
            if (tmp.length <= 1) {
                System.out.println(tmp[0]);
                return;
            }
            String[] all = tmp[0].split(",");
            String[] use = tmp[1].split(",");

            //全量字符集
            List<Character> keysAll = new ArrayList<>();
            List<Integer> valuesAll = new ArrayList<>();
            for (int i = 0; i < all.length; i++) {
                String[] s = all[i].split(":");
                keysAll.add(s[0].charAt(0));
                valuesAll.add(Integer.parseInt(s[1]));
            }

            //已占用字符集
            List<Character> keysUse = new ArrayList<>();
            List<Integer> valuesUse = new ArrayList<>();
            for (int i = 0; i < use.length; i++) {
                String[] s = use[i].split(":");
                keysUse.add(s[0].charAt(0));
                valuesUse.add(Integer.parseInt(s[1]));
            }

            List<Character> keysRes = new ArrayList<>();
            List<Integer> valuesRes = new ArrayList<>();
            for (int i = 0; i < keysAll.size(); i++) {
                //有使用过的字符集的下标
                int index = -1;
                for (int j = 0; j < keysUse.size(); j++) {
                    //找出已经使用过的字符
                    if (keysAll.get(i) == keysUse.get(j)) {
                        int cha = valuesAll.get(i) - valuesUse.get(j);
                        //有剩余的字符保存起来
                        if (0 != cha) {
                            keysRes.add(keysAll.get(i));
                            valuesRes.add(cha);
                        }
                        //记录index
                        index = i;
                    }
                }
                //没被使用过，则全部添加进来
                if (-1 == index) {
                    keysRes.add(keysAll.get(i));
                    valuesRes.add(valuesAll.get(i));
                }
            }

            //输出结果
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < keysRes.size(); i++) {
                stringBuilder.append(keysRes.get(i));
                stringBuilder.append(':');
                stringBuilder.append(valuesRes.get(i));
                //最后一个键值对，不加逗号分隔
                if (i != keysRes.size() - 1)
                    stringBuilder.append(',');
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
