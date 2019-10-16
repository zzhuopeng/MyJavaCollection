package com.A1_BiShi.P11_Tencent_XX.P02;

import java.util.*;

class Peo implements Comparable<Peo> {
    int a;
    int b;

    public Peo(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Peo o) {
        // TODO Auto-generated method stub
        if (this.a == o.a)
            return this.b - o.b;
        else
            return o.a - this.a;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Peo> list = new ArrayList();
        for (int i = 0; i < n; i++) {
            Peo peo = new Peo(sc.nextInt(), sc.nextInt());
            list.add(peo);
        }
        Collections.sort(list);
        long res = 0;
        for (int i = 0; i < list.size(); i++) {
            res += list.get(i).a * (i) + list.get(i).b * (list.size() - i - 1);
        }
        System.out.println(res);
    }
}