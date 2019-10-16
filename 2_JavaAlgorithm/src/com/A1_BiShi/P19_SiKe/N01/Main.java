package com.A1_BiShi.P19_SiKe.N01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            if (s.startsWith("\"") || s.endsWith("\""))
                s = s.replace("\"", "");

            StringBuilder result = new StringBuilder();
            if (s.contains("<sip:10000@172.16.130.42>"))
                s = s.replaceAll("<sip:10000@172.16.130.42>", "");
            if (s.contains("<sip:10000@172.16.130.42>;"))
                s = s.replaceAll("<sip:10000@172.16.130.42>;", "");

            int i = 0;
            int j = s.length();
            if (s.startsWith("%22"))
                i = i + 3;
            if (s.endsWith("%22"))
                j = j - 3;
            for (; i < j; i++) {
                result.append(s.charAt(i));
            }
            System.out.println(result.toString());
        }
    }
}
