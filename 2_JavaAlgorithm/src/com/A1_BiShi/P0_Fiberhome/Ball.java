package com.A1_BiShi.P0_Fiberhome;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Fiberhome第一题：找出质量不同小球
 */
public class Ball {

    public static void main(String[] args) {
        List<Character> same = new ArrayList<>();
        List<Character> little = new ArrayList<>();
        List<Character> large = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            String str = scan.nextLine();
            String msg[] = str.split(" ");
            if (msg[2].equals("even")) {
                char[] tmp1 = msg[0].toCharArray();
                for (char c : tmp1) {
                    same.add(c);
                }
                char[] tmp2 = msg[1].toCharArray();
                for (char c : tmp2) {
                    same.add(c);
                }
            } else if (msg[2].equals("up")) {
                char[] tmp1 = msg[0].toCharArray();
                for (char c : tmp1) {
                    large.add(c);
                }
                char[] tmp2 = msg[1].toCharArray();
                for (char c : tmp2) {
                    little.add(c);
                }
            } else {
                char[] tmp1 = msg[0].toCharArray();
                for (char c : tmp1) {
                    little.add(c);
                }
                char[] tmp2 = msg[1].toCharArray();
                for (char c : tmp2) {
                    large.add(c);
                }
            }
        }
        List<Character> delete = new ArrayList<>();
        for (char s : same) {
            for (char l : little) {
                if(l == s) {
                    delete.add(l);
                }
            }
        }
        //删除相同的重量
        for (char s : delete) {
            little.remove(s);
        }
        delete.clear();
        for (char s : same) {
            for (char l : large) {
                if(l == s) {
                    delete.add(l);
                }
            }
        }
        for (char s : delete) {
            large.remove(s);
        }
        if(!little.isEmpty()) {
            System.out.println( little.get(0) +' '+0);
        }
        if(!large.isEmpty()) {
            System.out.println( large.get(0) +' '+0);
        }
    }
}
